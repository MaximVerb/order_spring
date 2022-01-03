package com.switchfully.order.spring_exercise.repositories;

import com.switchfully.order.spring_exercise.domain.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository <Order, Long> {
    @Query(value = "select * from Order where order_id =:id",
    nativeQuery = true)
    Optional<Order> getOrderByOrderId(@Param("id") String id);

    @Query(value = "select * from Order where user_fk =:userId",
            nativeQuery = true)
    List<Order> getOrdersByUserId(String userId);
}
