package com.juliomoraes.dsmeta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.juliomoraes.dsmeta.entities.Sale;
import com.juliomoraes.dsmeta.repository.SaleRepository;
import com.juliomoraes.dsmeta.service.exceptions.SaleExceptionNotFound;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {
	
	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;
	
	@Autowired
	private SaleRepository saleRepository;
	
	public void sendSms(Long saleId) {
		
		Sale sale = this.saleRepository.findById(saleId).orElseThrow(() -> new SaleExceptionNotFound("Venda não encontrada."));
		
		String dateFormatMsg = sale.getDate().getMonthValue() + "/" + sale.getDate().getYear();
				
		String msg = "O Vendedor: " + sale.getSellerName() + " foi destaque em " + dateFormatMsg +
				" com um total de R$ " + String.format("%.2f", sale.getAmount());
		Twilio.init(twilioSid, twilioKey);

		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);
		
		Message.creator(to, from, msg).create();
	}
}
