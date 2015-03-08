package org.rocklass.fullstacklab.controller;

import java.util.List;

import org.rocklass.fullstacklab.exception.EntityNotFoundException;
import org.rocklass.fullstacklab.model.Item;
import org.rocklass.fullstacklab.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController {
	
	private ItemService service;

	public ItemService getService() {
		return service;
	}
	
	@Autowired
	public void setService(ItemService service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Item> findItems() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Item addItem(@RequestBody Item item) {
		item.setId(null);
		return service.add(item);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Item updateItem(@RequestBody Item updatedItem,
			@PathVariable Long id) throws EntityNotFoundException {
		updatedItem.setId(id);
		return service.update(updatedItem);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteItem(@PathVariable Long id) throws EntityNotFoundException {
		service.delete(id);
	}
}
