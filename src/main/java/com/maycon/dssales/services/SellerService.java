package com.maycon.dssales.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maycon.dssales.DTO.SellerDTO;
import com.maycon.dssales.entities.Seller;
import com.maycon.dssales.repositories.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository repository;

	public List<SellerDTO> findAll() {
		List<Seller> result = repository.findAll();
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}
	
	public SellerDTO findByID(Long id) {
		SellerDTO sellerDTO = repository.findById(id).map(x -> new SellerDTO(x)).get();
		return sellerDTO;
	}
	
	public SellerDTO create(SellerDTO sellerDTO) {
		Seller seller = new Seller(null, sellerDTO.getName());
		return new SellerDTO(repository.save(seller));
	}
	
	public SellerDTO update(Long id, SellerDTO sellerDTO) {
		Seller seller = repository.findById(id).get();
		seller.setName(sellerDTO.getName());
		repository.save(seller);
		
		return new SellerDTO(seller);
	}
	
	public void remove(Long id) {
		repository.deleteById(id);
	}

}
