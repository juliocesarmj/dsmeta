package com.juliomoraes.dsmeta.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juliomoraes.dsmeta.repository.SaleRepository;
import com.juliomoraes.dsmeta.sale.dto.SaleDTO;

@Service
public class SaleService {

	@Autowired
	private SaleRepository saleRepository;

	@Transactional(readOnly = true)
	public Page<SaleDTO> allSales(Pageable pageable) {
		return this.saleRepository.findAll(pageable).map(SaleDTO::new);
	}

	@Transactional(readOnly = true)
	public Page<SaleDTO> salesByDate(String minDate, String maxDate, Pageable pageable) {

		LocalDate min = minDate.equals("") ? LocalDate.now().minusYears(1) : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault()) : LocalDate.parse(maxDate);

		return this.saleRepository.findSalesByDate(min, max, pageable).map(SaleDTO::new);
	}
}
