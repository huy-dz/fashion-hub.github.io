//package com.example.shopweb.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//import javax.sql.DataSource;
//
//
//@Configuration
//@EnableWebSecurity
//public class AccountSecurityConfig extends WebSecurityConfigurerAdapter {
//
//
//    @Autowired
//    protected void configureGlobal(AuthenticationManagerBuilder auth) {
//        try {
//            auth.inMemoryAuthentication()
//                    .withUser("user").password("1").roles("USER");
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http
//                .authorizeRequests()
//                    .antMatchers("/**").permitAll()
//                    .anyRequest().authenticated()
//                .and()
//                .formLogin().permitAll();
////                    .loginPage("/")
////                .loginProcessingUrl("/")
////                .permitAll()
////                .and()
////                .exceptionHandling().accessDeniedPage("/");
//
//    }
//}
