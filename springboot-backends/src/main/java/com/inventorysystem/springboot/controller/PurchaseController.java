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
import com.inventorysystem.springboot.model.Purchase;
import com.inventorysystem.springboot.repository.PurchaseRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class PurchaseController {


	@Autowired
	private PurchaseRepository purchaseRepository;
	
	// get all Purchase
	@GetMapping("/Purchase")
	public List<Purchase> getAllPurchase(){
		return purchaseRepository.findAll();
	}		
	
	// create Purchase rest api
	@PostMapping("/Purchase")
	public Purchase createPurchase(@RequestBody Purchase Purchase) {
		return purchaseRepository.save(Purchase);
	}
	
	// get Purchase by id rest api
	@GetMapping("/Purchase/{id}")
	public ResponseEntity<Purchase> getPurchaseById(@PathVariable Long id) {
		Purchase Purchase = purchaseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Purchase not exist with id :" + id));
		return ResponseEntity.ok(Purchase);
	}
	
	// update Purchase rest api
	
	@PutMapping("/Purchase/{id}")
	public ResponseEntity<Purchase> PurchasePurchase(@PathVariable Long id, @RequestBody Purchase PurchaseDetails){
		Purchase Purchase = purchaseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Purchase not exist with id :" + id));
		
		Purchase.setItemName(PurchaseDetails.getItemName());
		Purchase.setVendorName(PurchaseDetails.getVendorName());
		Purchase.setItemNumber(PurchaseDetails.getItemNumber());
		Purchase.setCurrentStock(PurchaseDetails.getCurrentStock());
		Purchase.setQuantity(PurchaseDetails.getQuantity());
		Purchase.setUnityPrice(PurchaseDetails.getUnityPrice());
		Purchase.setSaleDate(PurchaseDetails.getSaleDate());
		Purchase updatedPurchase = purchaseRepository.save(Purchase);
		return ResponseEntity.ok(updatedPurchase);
	}
}

	
	
	