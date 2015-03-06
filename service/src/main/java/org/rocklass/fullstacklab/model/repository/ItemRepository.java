package org.rocklass.fullstacklab.model.repository;

import org.rocklass.fullstacklab.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

}