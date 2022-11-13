package application.rental_movie.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public WebSecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    // configureaza partea de autorizare pentru acces la pagini/resurse/url
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest()
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .cors()
                .and()
                .csrf()
                .disable();
    }

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                // ca să putem face si call-uri de POST din frontend
//                .csrf().disable()
//                // ce request-uri să fie accesibilie (autorizate)
//                .authorizeRequests()
//                // request-urile care vin pe path-urile de mai jos au permisiunea de a fi accesate fără ca un user să fie logat
//                .antMatchers("/api/employees").permitAll()

//                // orice alt request
//                .anyRequest()
//                // va trebui să fie un user autentificat
//                .authenticated()
//                // prin autentificare de httpBasic (adică cu username și parolă)
//                .and().httpBasic();
//
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//
//        authenticationProvider.setPasswordEncoder(passwordEncoder);
//        authenticationProvider.setUserDetailsService(userDetailsService);
//
//        // foloseste AuthenticationProvider-ul creat de mine, care e customizat cu clasele de care are nevoie aplicatia mea
//        authenticationManagerBuilder.authenticationProvider(authenticationProvider);
//
//    }
}
