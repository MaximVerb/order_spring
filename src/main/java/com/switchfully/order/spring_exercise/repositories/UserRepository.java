package com.switchfully.order.spring_exercise.repositories;

import com.switchfully.order.spring_exercise.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    @Query(value = "select * from users u where u.username =:username",
    nativeQuery = true)
    Optional<User> findUserByUsername(@Param("username") String username);

}
