package org.tokmak.pinguin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tokmak.pinguin.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>
{

}
