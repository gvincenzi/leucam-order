package org.leucam.order.binding;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MQBinding {
    String USER_REGISTRATION = "userRegistrationChannel";
    String USER_CANCELLATION = "userCancellationChannel";
    String USER_ORDER = "userOrderChannel";
    String ORDER_CANCELLATION = "orderCancellationChannel";
    String ORDER_PAYMENT = "orderPaymentChannel";
    String ORDER_PAYMENT_CONFIRMATION = "orderPaymentConfirmationChannel";

    @Output(USER_REGISTRATION)
    MessageChannel userRegistrationChannel();

    @Output(USER_CANCELLATION)
    MessageChannel userCancellationChannel();

    @Output(USER_ORDER)
    MessageChannel userOrderChannel();

    @Output(ORDER_CANCELLATION)
    MessageChannel orderCancellationChannel();

    @Input(ORDER_PAYMENT)
    SubscribableChannel orderPaymentChannel();

    @Output(ORDER_PAYMENT_CONFIRMATION)
    MessageChannel userOrderPaymentConfirmationChannel();
}
