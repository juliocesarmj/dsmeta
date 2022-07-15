package com.juliomoraes.dsmeta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juliomoraes.dsmeta.SaleRepository;
import com.juliomoraes.dsmeta.sale.dto.SaleDTO;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository saleRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> allSales(Pageable pageable) {
		return this.saleRepository.findAll(pageable).map(SaleDTO::new);
	}
}
