package com.inventorysystem.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventorysystem.springboot.exception.ResourceNotFoundException;
import com.inventorysystem.springboot.model.Sales;
import com.inventorysystem.springboot.repository.SalesRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class SalesController {

	@Autowired
	private SalesRepository salesRepository;
	
	// get all Sales
	@GetMapping("/Sales")
	public List<Sales> getAllSales(){
		return salesRepository.findAll();
	}		
	
	// create Sales rest api
	@PostMapping("/Sales")
	public Sales createSales(@RequestBody Sales Sales) {
		return salesRepository.save(Sales);
	}
	
	// get Sales by id rest api
	@GetMapping("/Sales/{id}")
	public ResponseEntity<Sales> getSalesById(@PathVariable Long id) {
		Sales Sales = salesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Sales not exist with id :" + id));
		return ResponseEntity.ok(Sales);
	}
	
	// update Sales rest api
	
	@PutMapping("/Sales/{id}")
	public ResponseEntity<Sales> SalesSales(@PathVariable Long id, @RequestBody Sales SalesDetails){
		Sales Sales = salesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Sales not exist with id :" + id));
		
		Sales.setItemName(SalesDetails.getItemName());
		Sales.setItemNumber(SalesDetails.getItemNumber());
		Sales.setQuantity(SalesDetails.getQuantity());
		Sales.setCustomerName(SalesDetails.getCustomerName());
		Sales.setCustomerId(SalesDetails.getCustomerId());
		Sales.setUnityPrice(SalesDetails.getUnityPrice());
		Sales.setTotalStock(SalesDetails.getTotalStock());
		Sales.setSaleId(SalesDetails.getSaleId());
		Sales.setDiscount(SalesDetails.getDiscount());
		Sales.setSaleDate(SalesDetails.getSaleDate());
		Sales.setTotal(SalesDetails. getTotal());
		Sales updatedSales = salesRepository.save(Sales);
		return ResponseEntity.ok(updatedSales);
	}

	
	
	
	
	// delete Sales rest api
	@DeleteMapping("/Sales/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteSales(@PathVariable Long id){
		Sales Sales = salesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Sales not exist with id :" + id));
		
		salesRepository.delete(Sales);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}