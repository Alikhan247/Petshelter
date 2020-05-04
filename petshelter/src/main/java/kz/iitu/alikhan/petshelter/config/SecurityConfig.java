package kz.iitu.alikhan.petshelter.config;

import kz.iitu.alikhan.petshelter.config.JwtTokenAuthenticationFilter;
import kz.iitu.alikhan.petshelter.config.JwtTokenGeneratorFilter;
import kz.iitu.alikhan.petshelter.service.PetService;
import kz.iitu.alikhan.petshelter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/auth/**").permitAll()

                .antMatchers(HttpMethod.POST, "/pet/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/pet/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/pet/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/pet/**").hasAnyAuthority("ADMIN", "USER")
//                .antMatchers("/pet/**").hasAuthority("ADMIN")

                .antMatchers("/user/adopt").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/auth/**", "/users/register",
                        "/swagger-ui.html", "/webjars/**", "/swagger-resources/**", "/v2/**").permitAll()

                .anyRequest().authenticated()
                .and()
                .addFilter(new JwtTokenGeneratorFilter(authenticationManager()))
                .addFilterAfter(new JwtTokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(passwordEncoder());
    }
}
