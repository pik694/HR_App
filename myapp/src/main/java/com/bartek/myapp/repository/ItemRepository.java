package com.bartek.myapp.repository;

import com.bartek.myapp.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
