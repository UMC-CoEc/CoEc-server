package com.umc.coec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class UtilConfig {

      @Bean
      public BCryptPasswordEncoder getPasswordEncoder(){
            return new BCryptPasswordEncoder();
      }
}
