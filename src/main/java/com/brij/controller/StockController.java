package com.brij.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.brij.helper.FileHelper;
import com.brij.model.Stock;
import com.brij.service.StockService;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class StockController {

	@Autowired
	StockService stockService;
	
	/**
	 * 
	 * @param stock
	 * @return
	 * @throws Exception
	 */
	@GetMapping(path = "/stock-data/{stock}") 
	public CompletableFuture<ResponseEntity<?>> getStockDetails(@PathVariable(name = "stock", required = true) final String stock) throws Exception {
		return stockService.getAllStocksByName(stock);
	}
	
	/**
	 * 
	 * @param stock
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/addRecord")
	public CompletableFuture<ResponseEntity<?>> addNewRecord(@RequestBody final Stock stock) throws Exception {

		return stockService.addNewRecord(stock);
		
	}

	/**
	 * 
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/stock-data/bulk-insert")
	public CompletableFuture<ResponseEntity<?>> uploadFile(@RequestParam("file") final MultipartFile file) throws Exception{
		String message = "";

		if (FileHelper.hasCSVFormat(file)) {
			try {
				stockService.save(file);
				message = "File Uploaded Successfully: " + file.getOriginalFilename();
				return CompletableFuture.completedFuture(ResponseEntity.status(HttpStatus.OK).body(message));
			} catch (Exception ex) {
				message = "File Could Not Be Upload: " + file.getOriginalFilename();
				return CompletableFuture.completedFuture(ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message));
			}
		}

		message = "Please upload csv file";
		return CompletableFuture.completedFuture(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message));
	}

}
