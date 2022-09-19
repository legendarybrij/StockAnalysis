package com.brij.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import com.brij.dao.StockRepository;
import com.brij.helper.FileHelper;
import com.brij.model.Stock;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class StockService {
	@Autowired
	StockRepository repo;

	private static final Logger log = LogManager.getLogger(StockService.class);
	
	/**
	 * 
	 * @param stock
	 * @return
	 * @throws Exception
	 */
	@Async
	public CompletableFuture <ResponseEntity<?>> addNewRecord(final Stock stock) throws Exception {
		String message = "";
		try {
			if (StringUtils.isNotBlank(stock.getStock())) {
				repo.save(stock);
				message = "Record Added Successfully: " +"\n"+ stock;
				return CompletableFuture.completedFuture(ResponseEntity.status(HttpStatus.OK).body(message));
			} else {
				log.error(
						"Error occured while adding new record in service class: Stock name is missing from the request {}",
						stock.toString());
				message = "Please upload valid request body";
				return CompletableFuture.completedFuture(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message));
			}

		} catch (Exception ex) {
			log.error("Exception Occurred while adding new record in service class for stock {} ", stock.getStock(),
					ex);
			return CompletableFuture.completedFuture(ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(ex));
		}

	}

	/**
	 * 
	 * @param file
	 * @throws Exception
	 */
	@Async
	public void save(final MultipartFile file) throws Exception {
		String message = "File Uploaded Successfully: " + file.getOriginalFilename();
		try {
			List<Stock> stocks = FileHelper.csvToStocks(file.getInputStream());
			repo.saveAll(stocks);
		} catch (IOException ex) {
			throw new RuntimeException("Exception occured in save method in service class: " + ex.getMessage());
		}
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	@Async
	public CompletableFuture<List<Stock>> getAllstocks() throws Exception {
		return CompletableFuture.completedFuture(repo.findAll());
	}

	/**
	 * 
	 * @param stockName
	 * @return
	 * @throws Exception
	 */
	@Async
	public CompletableFuture<ResponseEntity<?>> getAllStocksByName(final String stockName) throws Exception {
		List<Stock> response = new ArrayList<Stock>();
		String message = "";
		try {
			if(StringUtils.isNotBlank(stockName)) {
				response = repo.findAllByStock(stockName);
			}else {
				log.error(
						"Error occured while retrieving all stock records in service class for stock {}",
						stockName);
				message = "Please write valid name";
				return CompletableFuture.completedFuture(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message));
			}
			
		} catch (Exception ex) {
		log.error("Exception Occurred while retrieving all stock records in service class for stock {} ", stockName,
					ex);
		}
		
		return CompletableFuture.completedFuture(ResponseEntity.status(HttpStatus.OK).body(response));
	}

}
