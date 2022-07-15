package com.juliomoraes.dsmeta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juliomoraes.dsmeta.sale.dto.SaleDTO;
import com.juliomoraes.dsmeta.service.SaleService;

@RestController
@RequestMapping(value = "/sale")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> allSales(Pageable pageable) {
		return ResponseEntity.ok().body(this.service.allSales(pageable));
	}

}
