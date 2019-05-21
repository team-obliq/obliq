package com.obliq.obliq;

import com.obliq.obliq.security.UserDetailsLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserDetailsLoader userLoader;

    public SecurityConfiguration(UserDetailsLoader userLoader) {
        this.userLoader = userLoader;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .userDetailsService(userLoader)
                .passwordEncoder(passwordEncoder())
            ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
//                login configuration
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/profile")
                .permitAll()
//
//                logout configuration

                .and()
                .logout()
                .logoutSuccessUrl("/login?logout")

//                pages that can be viewed without login
                .and()
                .authorizeRequests()
                .antMatchers("/", "/posts/{id}")
                .permitAll()

//                pages that can only be viewed when logged in
                .and()
                .authorizeRequests()
                .antMatchers(
                        "/profile",
                        "/edit",
                        "/delete"
                )
                .authenticated()
                ;
    }
}
