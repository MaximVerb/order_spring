package com.switchfully.order.spring_exercise.domain.user;

import com.switchfully.order.spring_exercise.domain.order.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",  nullable = false)
    private Long id;

    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "lastname", nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<Order> orderList = new ArrayList<>();

    @Embedded
    private AddressInformation addressInformation;

    @Embedded
    private ContactInformation contactInformation;

    @Embedded
    private SecurityInformation securityInformation;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void addToOrderList(Order order) {
        if(this.orderList == null) {
            this.orderList = new ArrayList<>();
        } orderList.add(order);
    }
}
