package com.switchfully.order.spring_exercise.domain.order;

import com.switchfully.order.spring_exercise.domain.item.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ordered_item")
public class OrderedItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ordered_item_id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "item_fk")
    private Item item;

    @Column(name = "amount_ordered", nullable = false)
    private Long amountOrdered;

    @Column(name = "shipping_date", nullable = false)
    private LocalDateTime shippingDate;

    @Column(name = "total_cost_ordered_item", nullable = false)
    private BigDecimal totalCostOrderedItems;

    public void setTotalCostOrderedItems(BigDecimal totalCostOrderedItems) {
        this.totalCostOrderedItems = totalCostOrderedItems;
    }
}
