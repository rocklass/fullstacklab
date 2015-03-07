package org.rocklass.fullstacklab.service;

import org.rocklass.fullstacklab.model.Item;
import org.rocklass.fullstacklab.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemRepositoryService extends GenericRepositoryService<Item> implements ItemService {
	
	@Autowired
	private ItemRepository repository;
	
	@Override
	protected JpaRepository<Item, Long> getRepository() {
		return repository;
	}

	@Override
	protected String getEntityName() {
		return "item";
	}
}
