package com.switchfully.order.spring_exercise.repositories;

import com.switchfully.order.spring_exercise.domain.order.OrderedItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderedItemRepository extends JpaRepository <OrderedItem, Long> {
}
