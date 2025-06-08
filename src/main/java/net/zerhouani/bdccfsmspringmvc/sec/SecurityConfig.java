package net.zerhouani.bdccfsmspringmvc.sec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        return new InMemoryUserDetailsManager(
                User.withUsername("user1").password(passwordEncoder().encode("123")).roles("USER").build(),
                User.withUsername("user2").password(passwordEncoder().encode("123")).roles("USER").build(),
                User.withUsername("admin").password(passwordEncoder().encode("123")).roles("USER","ADMIN").build()
        );
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //Permet de spécifier les resources à protéger
        return http
                //Pour suggérer un formulaire d'auth par défaut
                .formLogin(Customizer.withDefaults())
                //Sinon on crée le notre
                    //.formLogin(fl -> fl.loginPage("/login"))
                // Détermine le role nécessaire pour accéder à une resource
                .authorizeHttpRequests(ar->ar.requestMatchers("/index/**").hasRole("USER"))
                .authorizeHttpRequests(ar->ar.requestMatchers("/save/**", "/delete/**").hasRole("ADMIN"))
                .authorizeHttpRequests(ar -> ar.anyRequest().authenticated())
                .build();
    }
}
