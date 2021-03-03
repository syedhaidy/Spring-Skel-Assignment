package com.cepheid.cloud.skel.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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

import com.cepheid.cloud.skel.bean.DescriptionSO;
import com.cepheid.cloud.skel.model.Description;
import com.cepheid.cloud.skel.model.Item;
import com.cepheid.cloud.skel.repository.DescriptionRepository;
import com.cepheid.cloud.skel.repository.ItemRepository;

import io.swagger.annotations.Api;

// curl http:/localhost:9443/app/api/1.0/items

@Component
@Path("/api/1.0/description")
@Api()
public class DescriptionController {

	private final DescriptionRepository mdescRepository;
	
	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	public DescriptionController(DescriptionRepository descriptionRepository) {
		mdescRepository = descriptionRepository;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public List<Description> getDescription() {
		return mdescRepository.findAll();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Description addDescription(Description description) {
		 
        Item item = itemRepository.findById(description.getItem().getId()).orElse(null);
        if (null == item) {
        	item = new Item();
        }
        item.setName(description.getItem().getName());
        item.setState(description.getItem().getState());
        description.setItem(item);
        return mdescRepository.save(description);
    }
	
	
	
}
