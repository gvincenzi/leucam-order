package org.leucam.order.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
@Table(name = "leucam_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String fileId;
    @Column
    private Boolean active = Boolean.TRUE;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId.equals(product.productId) &&
                name.equals(product.name) &&
                description.equals(product.description) &&
                fileId.equals(product.fileId) &&
                active.equals(product.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, name, description, fileId, active);
    }
}
