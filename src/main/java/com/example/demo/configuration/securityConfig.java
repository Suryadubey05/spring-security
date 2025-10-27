package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.security.AuthProvider;

@Configuration
public class securityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/home").permitAll()
                .requestMatchers("/signup").permitAll()
                .requestMatchers("/student").hasRole("STUDENT")
                .requestMatchers("/admin").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

//                .formLogin();
//                .httpBasic();

        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
//        UserDetails user1 = User.builder()
//                .username("surya")
//                .password(passwordEncoder().encode("surya123"))
//                .roles("STUDENT")
//                .build();
//
//        UserDetails user2 = User.builder()
//                .username("Raju")
//                .password(passwordEncoder().encode("raju123"))
//                .roles("STUDENT")
//                .build();
//
//        UserDetails user3 = User.builder()
//                .username("kamlesh")
//                .password(passwordEncoder().encode("kamy123"))
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user1, user2, user3);

        return new CustomUserDetailsService();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
