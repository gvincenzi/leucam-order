package org.leucam.order.listener;

import org.leucam.order.binding.MQBinding;
import org.leucam.order.dto.PaymentDTO;
import org.leucam.order.entity.Order;
import org.leucam.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Optional;

@EnableBinding(MQBinding.class)
public class MQListener {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    private MessageChannel orderPaymentConfirmationChannel;

    @StreamListener(target = MQBinding.ORDER_PAYMENT)
    public void processUserOrder(PaymentDTO msg) {
        Optional<Order> orderPersisted = orderRepository.findById(msg.getOrderId());
        if(orderPersisted.isPresent()){
            orderPersisted.get().setPaid(Boolean.TRUE);
            orderPersisted.get().setPaymentExternalReference(msg.getPaymentId());
            orderPersisted.get().setPaymentExternalDateTime(msg.getPaymentDateTime());
            orderPersisted.get().setAmount(msg.getAmount());
            orderRepository.save(orderPersisted.get());
            Message<Order> msgToSend = MessageBuilder.withPayload(orderPersisted.get()).build();
            orderPaymentConfirmationChannel.send(msgToSend);
        }
    }
}
