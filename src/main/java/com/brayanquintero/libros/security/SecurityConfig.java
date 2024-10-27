package com.brayanquintero.libros.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "SELECT nombre, contra, estado FROM usuarios WHERE id = ?"
        );

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                """
                   SELECT u.nombre, r.rol FROM usuarios u 
                   INNER JOIN usuario_rol ur ON u.id = ur.id_usuario 
                   INNER JOIN roles r ON r.id = ur.id_rol         
                        """
        );

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/libro").hasAnyRole("USUARIO", "BIBLIOTECARIO", "ADMIN")
                        .requestMatchers(HttpMethod.GET,"/api/libros/{id}").hasAnyRole("USUARIO", "BIBLIOTECARIO", "ADMIN")
                        .requestMatchers(HttpMethod.POST,"/api/libros").hasAnyRole("BIBLIOTECARIO", "ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/api/libros").hasAnyRole( "BIBLIOTECARIO", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/api/libros/{id}").hasAnyRole("ADMIN")
        );

        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.csrf(csrf -> csrf.disable());

        return httpSecurity.build();
    }
}
