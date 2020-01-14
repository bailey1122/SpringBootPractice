package com.sprboot.springboot_practice.services;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.remoting.support.RemoteExporter;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Server {

    @Bean(name = "/booking")
    RemoteExporter bookingService() {
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(new FlightBookingServiceImpl());
        exporter.setServiceInterface( FlightBookingService.class );
        return exporter;
    }


//    @Bean(name = "/booking")
//    HttpInvokerServiceExporter accountService() {
//        HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
//        exporter.setService( new FlightBookingServiceImpl() );
//        exporter.setServiceInterface( FlightBookingService.class );
//        return exporter;
//    }

//    @Bean
//    FlightBookingService bookingService() {
//        return new FlightBookingServiceImpl();
//    }
//
//    @Bean
//    RmiServiceExporter exporter(FlightBookingService implementation) {
//        Class<FlightBookingService> serviceInterface = FlightBookingService.class;
//        RmiServiceExporter exporter = new RmiServiceExporter();
//        exporter.setServiceInterface(serviceInterface);
//        exporter.setService(implementation);
//        exporter.setServiceName(serviceInterface.getSimpleName());
//        exporter.setRegistryPort(1099);
//        return exporter;
//    }
}
