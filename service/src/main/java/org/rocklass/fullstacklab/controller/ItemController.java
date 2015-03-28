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

/**
 * Item REST Controller
 * 
 * @author rocklass
 *
 */
@RestController
@RequestMapping("/items")
public class ItemController {

    /**
     * Item service
     */
    private ItemService service;

    /**
     * Get item service
     * 
     * @return item service
     */
    public ItemService getService() {
        return service;
    }

    /**
     * Set item service
     * 
     * @param service
     *            item service
     */
    @Autowired
    public void setService(final ItemService service) {
        this.service = service;
    }

    /**
     * Get all items
     * 
     * @return all items
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Item> findItems() {
        return service.findAll();
    }

    /**
     * Post item
     * 
     * @param item
     *            item to add
     * @return added item
     */
    @RequestMapping(method = RequestMethod.POST)
    public Item addItem(@RequestBody final Item item) {
        item.setId(null);
        return service.add(item);
    }

    /**
     * Put item
     * 
     * @param item
     *            updated item
     * @param id
     *            id of item to update
     * @return updated item
     * @throws EntityNotFoundException
     *             when item with given id does not exist
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Item updateItem(@RequestBody final Item item, @PathVariable final Long id) throws EntityNotFoundException {
        item.setId(id);
        return service.update(item);
    }

    /**
     * Delete item
     * 
     * @param id
     *            id of item to delete
     * @throws EntityNotFoundException
     *             when item with given id does not exist
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable final Long id) throws EntityNotFoundException {
        service.delete(id);
    }
}
