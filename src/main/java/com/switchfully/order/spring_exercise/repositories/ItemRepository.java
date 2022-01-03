package com.switchfully.order.spring_exercise.repositories;

import com.switchfully.order.spring_exercise.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
@Query(value = "select * from Item where name =:name and description =:description",
nativeQuery = true)
    Item getItemByNameAndDescription(@Param("name") String name,
                                     @Param("description") String description);
}
