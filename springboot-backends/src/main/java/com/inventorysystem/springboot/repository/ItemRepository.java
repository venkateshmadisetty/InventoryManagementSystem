package com.inventorysystem.springboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventorysystem.springboot.model.Item;


@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

}
