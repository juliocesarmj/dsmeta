package com.juliomoraes.dsmeta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juliomoraes.dsmeta.sale.dto.SaleDTO;
import com.juliomoraes.dsmeta.service.SaleService;
import com.juliomoraes.dsmeta.service.SmsService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@Autowired
	private SmsService smsService;
	
	@GetMapping
	public Page<SaleDTO> allSales(Pageable pageable) {
		return this.service.allSales(pageable);
	}
	
	@GetMapping("/salesperdate")
	public Page<SaleDTO> salesByDate(
			@RequestParam(value = "min" ,defaultValue = "") String min,
			@RequestParam(value = "max" ,defaultValue = "") String max,
			Pageable pageable) {
		return this.service.salesByDate(min, max, pageable);
	}
	
	@GetMapping("/{id}/notification")
	public void notifySms(@PathVariable Long id) {
		this.smsService.sendSms(id);
	}

}
