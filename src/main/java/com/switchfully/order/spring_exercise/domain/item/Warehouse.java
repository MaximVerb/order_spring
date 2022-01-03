package com.switchfully.order.spring_exercise.domain.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public final class Warehouse {

    @Column(name = "warehouse_name", nullable = false)
    private String warehouseName;

    @Column(name = "stock_available", nullable = false)
    private Long stockAvailable;


}
