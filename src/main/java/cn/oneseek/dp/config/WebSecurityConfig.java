package cn.oneseek.dp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/static/404.html").permitAll()
                .antMatchers("/static/images/**").permitAll()
                .antMatchers("/static/**").hasRole("USER")
                .antMatchers("/").hasRole("USER")
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/index")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // withDefaultPasswordEncoder被弃用，用以下方式
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
//                .withUser(User.withDefaultPasswordEncoder().username("admin")
                .withUser("admin")
                .password(encoder.encode("admin")).roles("USER");
    }
}
