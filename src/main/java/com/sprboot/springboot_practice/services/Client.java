package com.sprboot.springboot_practice.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import static java.lang.System.out;

@Configuration
@SpringBootApplication
public class Client {

    @Bean
    public HessianProxyFactoryBean hessianInvoker() {
        HessianProxyFactoryBean invoker = new HessianProxyFactoryBean();
        invoker.setServiceUrl("http://localhost:8080/booking");
        invoker.setServiceInterface(FlightBookingService.class);
        return invoker;
    }


//    @Bean
//    public HttpInvokerProxyFactoryBean invoker() {
//        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
//        invoker.setServiceUrl("http://localhost:8080/booking");
//        invoker.setServiceInterface(FlightBookingService.class);
//        return invoker;
//    }

//    @Bean
//    RmiProxyFactoryBean service() {
//        RmiProxyFactoryBean rmiProxyFactory = new RmiProxyFactoryBean();
//        rmiProxyFactory.setServiceUrl("rmi://localhost:1099/CabBookingService");
//        rmiProxyFactory.setServiceInterface(FlightBookingService.class);
//        return rmiProxyFactory;
//    }

    public static void main(String[] args) throws BookingException {
        FlightBookingService service = SpringApplication
                .run(Client.class, args)
                .getBean(FlightBookingService.class);
        out.println(service.bookFlight("NYC"));
    }
}
