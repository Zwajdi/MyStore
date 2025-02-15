package com.Project.MyStore.services;


import com.Project.MyStore.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product,Integer> {

}