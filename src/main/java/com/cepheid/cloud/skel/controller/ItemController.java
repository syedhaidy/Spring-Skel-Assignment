package com.cepheid.cloud.skel.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.cepheid.cloud.skel.bean.ItemSO;
import com.cepheid.cloud.skel.model.Item;
import com.cepheid.cloud.skel.repository.ItemRepository;

import io.swagger.annotations.Api;

// curl http:/localhost:9443/app/api/1.0/items

@Component
@Path("/api/1.0/items")
@Api()
public class ItemController {

	private final ItemRepository mItemRepository;


	@Autowired
	public ItemController(ItemRepository itemRepository) {
		mItemRepository = itemRepository;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public Collection<Item> getItems() {
		return mItemRepository.findAll();
	}
	
	

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String createItem(@Valid @RequestBody ItemSO itemSO) {
		Item item = new Item();
		BeanUtils.copyProperties(itemSO, item);
		mItemRepository.save(item);
		long  count =  mItemRepository.count();
		return "Item  added successfully with id:" + Long.toString(count);
	}
	
	 @GET
	 @Produces("application/json")
	 @Path("/{id}")
	 public ResponseEntity<Optional<Item>> getItemById(@PathParam(value = "id") Long itemId) {
		 Optional<Item> item  = mItemRepository.findById(itemId);
	  return ResponseEntity.ok().body(item);
	 }
	 
	 @PUT
	 @Consumes("application/json")
	 @Path("/{id}")
	 public ResponseEntity<Item> updateItem(@PathParam(value = "id") Long itemId,
	   @Valid @RequestBody ItemSO itemSO) {
		 Item item =  mItemRepository.findById(itemId).orElse(null);
		 item.setName(itemSO.getName());
		 item.setState(itemSO.getState());
	  final Item updatedItem = mItemRepository.save(item);
	  return ResponseEntity.ok(updatedItem);
	 }
	 
	 @DELETE
	 @Path("/{id}")
	 public Map<String, Boolean> deleteItem(@PathParam(value = "id") Long itemId) throws Exception{
		 Item item = mItemRepository.findById(itemId).orElse(null);
		 mItemRepository.delete(item);
	  Map<String, Boolean> response = new HashMap<>();
	  response.put("deleted", Boolean.TRUE);
	  return response;
	 }
	 
	 
	 	@POST
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		@Path("/pattern/search/{pattern}")
		public List<Item> getAllItemByName(@PathParam(value = "pattern") String pattern) {
			return mItemRepository.getAllByPattern(pattern);
		}

}
