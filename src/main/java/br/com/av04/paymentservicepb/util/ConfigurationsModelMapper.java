package br.com.av04.paymentservicepb.util;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationsModelMapper {
    @Bean
    public ModelMapper getModelMapper(){

        return new ModelMapper();
    }
}
