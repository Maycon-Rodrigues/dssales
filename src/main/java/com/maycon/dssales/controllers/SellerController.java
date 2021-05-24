package com.maycon.dssales.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.maycon.dssales.DTO.SellerDTO;
import com.maycon.dssales.services.SellerService;

@RestController
@RequestMapping(value = "/sellers")
public class SellerController {

	@Autowired
	private SellerService service;

	@GetMapping
	public ResponseEntity<List<SellerDTO>> findAll() {
		List<SellerDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<SellerDTO> findById(@PathVariable Long id) {
		SellerDTO seller = new SellerDTO();
		try {
			seller = service.findByID(id);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}	
		
		return ResponseEntity.ok(seller);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public SellerDTO create(@RequestBody SellerDTO seller) {
		SellerDTO create = service.create(seller);
		return create;
	}
	
	@PutMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<SellerDTO> update(@PathVariable Long id, @RequestBody SellerDTO sellerDTO) {
		SellerDTO update = service.update(id, sellerDTO);
		return ResponseEntity.ok(update);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable Long id) {
		service.remove(id);
	}
}
