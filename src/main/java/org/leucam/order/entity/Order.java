package org.leucam.order.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.leucam.order.entity.type.ActionType;
import org.leucam.order.entity.type.ColorType;
import org.leucam.order.entity.type.FrontBackType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "leucam_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    @Column
    private ActionType actionType;
    @Column
    private FrontBackType frontBackType;
    @Column
    private ColorType colorType;
    @Column
    private Integer numberOfCopies;
    @Column
    private Integer pagesPerSheet;
    @Column(nullable = false)
    private Boolean paid = Boolean.FALSE;
    @Column
    private Boolean paymentReminder = Boolean.FALSE;
    @Column
    private Boolean deliveryReminder = Boolean.FALSE;
    @Column
    private String paymentExternalReference;
    @Column
    private LocalDateTime paymentExternalDateTime;
    @Column
    private BigDecimal amount;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="productId", nullable = false)
    private Product product;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id", nullable = false)
    private User user;
    @Column
    private LocalDateTime orderPreparationDate;
    @Column
    private LocalDateTime orderDeliveryDate;
}
