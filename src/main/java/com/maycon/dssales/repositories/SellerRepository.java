package com.maycon.dssales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maycon.dssales.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

}
