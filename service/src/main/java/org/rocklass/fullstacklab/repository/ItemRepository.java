package org.rocklass.fullstacklab.repository;

import org.rocklass.fullstacklab.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA repository for items
 * 
 * @author rocklass
 *
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
