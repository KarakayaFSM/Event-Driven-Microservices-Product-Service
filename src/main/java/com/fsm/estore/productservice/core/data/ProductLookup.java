package com.fsm.estore.productservice.core.data;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@Table(name = "PRODUCT_LOOKUP")
@NoArgsConstructor
@AllArgsConstructor
public class ProductLookup implements Serializable {

    private static final long serialVersionUID = -1326983553234197413L;

    @Id
    @Column(unique = true)
    private String productId;

    @Column(unique = true)
    private String title;
}
