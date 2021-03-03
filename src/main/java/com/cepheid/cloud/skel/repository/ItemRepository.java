package com.cepheid.cloud.skel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cepheid.cloud.skel.model.Item;


public interface ItemRepository extends JpaRepository<Item, Long> {
	
	@Query("select k from Item k where k.name like %:name%")
	List<Item> getAllByPattern(@Param("name") String name);

}
