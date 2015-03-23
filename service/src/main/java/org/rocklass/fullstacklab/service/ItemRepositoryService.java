package org.rocklass.fullstacklab.service;

import org.rocklass.fullstacklab.model.Item;
import org.rocklass.fullstacklab.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemRepositoryService extends GenericRepositoryService<Item> implements ItemService {

    private ItemRepository repository;

    @Override
    public JpaRepository<Item, Long> getRepository() {
        return repository;
    }

    @Autowired
    @Override
    public void setRepository(JpaRepository<Item, Long> repository) {
        this.repository = (ItemRepository) repository;
    }

    @Override
    protected String getEntityName() {
        return "item";
    }
}
