package com.github.kokecena.gestioncontactos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class DBConstraintsConfig {

    @Bean
    public Map<String, String> constraintsMap() {
        Map<String, String> constraints = new ConcurrentHashMap<>();
        constraints.put("UK_H8MUHGTB0DML3BDVGP3YDFP7Q", "Telefono en uso");
        return constraints;
    }

}