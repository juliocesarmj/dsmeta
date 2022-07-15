package com.juliomoraes.dsmeta;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juliomoraes.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
