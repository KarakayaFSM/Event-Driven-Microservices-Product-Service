package com.fsm.estore.productservice.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Entity
@Table(name = "PRODUCT")
@RequiredArgsConstructor
public class Product implements Serializable {

    private static final long serialVersionUID = 8292132924446708196L;

    @Id
    @Column(unique = true)
    private String productId;

    @Column(unique = true)
    private String title;

    private BigDecimal price;
    private Integer quantity;

}
