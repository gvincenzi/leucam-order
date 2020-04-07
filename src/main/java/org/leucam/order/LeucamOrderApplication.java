package org.leucam.order;

import org.leucam.order.binding.MQBinding;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(MQBinding.class)
@EnableEurekaClient
@SpringBootApplication
public class LeucamOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeucamOrderApplication.class, args);
    }

}
