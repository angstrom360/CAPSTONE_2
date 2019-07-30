package com.trilogyed.AdminAPI.sercurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder authBuilder) throws Exception {

        PasswordEncoder encoder = new BCryptPasswordEncoder();

        authBuilder.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username, password, enabled from users where username = ?")
                .authoritiesByUsernameQuery(
                        "select username, authority from authorities where username = ?")
                .passwordEncoder(encoder);

    }

    public void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.httpBasic();

        httpSecurity.authorizeRequests()
                .mvcMatchers("/loggedin").authenticated()
                .mvcMatchers(HttpMethod.POST, "/customer").hasAuthority("role_teamlead")
                .mvcMatchers(HttpMethod.GET, "/customer/{id}").hasAuthority("role_employee")
                .mvcMatchers(HttpMethod.GET, "/customer").hasAuthority("role_employee")
                .mvcMatchers(HttpMethod.PUT, "/customer/{id}").hasAuthority("role_teamlead")
                .mvcMatchers(HttpMethod.DELETE, "/customer/{id}").hasAuthority("role_admin")

                .mvcMatchers(HttpMethod.POST, "/inventory").hasAuthority("role_manager")
                .mvcMatchers(HttpMethod.GET, "/inventory/{id}").hasAuthority("role_employee")
                .mvcMatchers(HttpMethod.GET, "/inventory").hasAuthority("role_employee")
                .mvcMatchers(HttpMethod.PUT, "/inventory/{id}").hasAuthority("role_employee")
                .mvcMatchers(HttpMethod.DELETE, "/inventory/{id}").hasAuthority("role_admin")

                .mvcMatchers(HttpMethod.POST, "/invoice").hasAuthority("role_manager")
                .mvcMatchers(HttpMethod.GET, "/invoice/{id}").hasAuthority("role_employee")
                .mvcMatchers(HttpMethod.GET, "/invoice").hasAuthority("role_employee")
                .mvcMatchers(HttpMethod.PUT, "/invoice/{id}").hasAuthority("role_teamlead")
                .mvcMatchers(HttpMethod.DELETE, "/invoice/{id}").hasAuthority("role_admin")

                .mvcMatchers(HttpMethod.POST, "/invoiceItem").hasAuthority("role_manager")
                .mvcMatchers(HttpMethod.GET, "/invoiceItem/{id}").hasAuthority("role_employee")
                .mvcMatchers(HttpMethod.GET, "/invoiceItem/all").hasAuthority("role_employee")
                .mvcMatchers(HttpMethod.PUT, "/invoiceItem/{id}").hasAuthority("role_teamlead")
                .mvcMatchers(HttpMethod.DELETE, "/invoiceItem/{id}").hasAuthority("role_admin")

                .mvcMatchers(HttpMethod.POST, "/levelup").hasAuthority("role_manager")
                .mvcMatchers(HttpMethod.GET, "/levelup/{id}").hasAuthority("role_employee")
                .mvcMatchers(HttpMethod.GET, "/levelup").hasAuthority("role_employee")
                .mvcMatchers(HttpMethod.PUT, "/levelup/{id}").hasAuthority("role_teamlead")
                .mvcMatchers(HttpMethod.DELETE, "/levelup/{id}").hasAuthority("role_admin")

                .mvcMatchers(HttpMethod.POST, "/product").hasAuthority("role_manager")
                .mvcMatchers(HttpMethod.GET, "/product/{id}").hasAuthority("role_employee")
                .mvcMatchers(HttpMethod.GET, "/product").hasAuthority("role_employee")
                .mvcMatchers(HttpMethod.PUT, "/product/{id}").hasAuthority("role_teamlead")
                .mvcMatchers(HttpMethod.DELETE, "/product/{id}").hasAuthority("role_admin")

                .anyRequest().permitAll();

        httpSecurity
                .logout()
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/allDone")
                .deleteCookies("JSESSIONID")
                .deleteCookies("XSRF-TOKEN")
                .invalidateHttpSession(true);

        httpSecurity
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }
}
