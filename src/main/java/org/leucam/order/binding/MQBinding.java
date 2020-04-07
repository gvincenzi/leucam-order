package org.leucam.order.binding;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MQBinding {
    String USER_REGISTRATION = "userRegistrationChannel";
    String USER_CANCELLATION = "userCancellationChannel";

    @Output(USER_REGISTRATION)
    MessageChannel userRegistrationChannel();

    @Output(USER_CANCELLATION)
    MessageChannel userCancellationChannel();
}
