package com.brij.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.brij.model.Stock;

public interface StockRepository extends JpaRepository<Stock,Integer> {
	
	List<Stock> findAllByStock(String name);

}
