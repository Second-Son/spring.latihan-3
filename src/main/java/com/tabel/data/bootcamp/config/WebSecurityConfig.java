package com.tabel.data.bootcamp.config;

import com.tabel.data.bootcamp.serices.UserServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/admin/**").hasRole("SEKRETARIS")
                .antMatchers("/mentor/**").hasRole("MENTOR")
                .antMatchers("/peserta/**").hasRole("PESERTA")
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login-form").defaultSuccessUrl("/home").permitAll()
                .and().logout().logoutSuccessUrl("/home").permitAll();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder(11);
    }

    @Bean
    public DaoAuthenticationProvider autoAuthenticationProvider(UserServices userServices, PasswordEncoder passwordEncoder){
        DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
        dao.setUserDetailsService(userServices);
        dao.setPasswordEncoder(passwordEncoder);
        return dao;
    }

}
