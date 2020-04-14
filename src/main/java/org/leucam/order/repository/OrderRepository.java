package org.leucam.order.repository;

import org.leucam.order.entity.Order;
import org.leucam.order.entity.Product;
import org.leucam.order.entity.User;
import org.leucam.order.entity.type.ActionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByProduct(Product product);
    List<Order> findAllByPaidFalse();
    List<Order> findByUser(User user);
    List<Order> findByUserAndOrderDeliveryDateIsNull(User user);
    List<Order> findByActionType(ActionType actionType);
    List<Order> findByActionTypeAndOrderDeliveryDateIsNull(ActionType actionType);
}
