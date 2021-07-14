package com.jforce.lms.security;

import com.jforce.lms.jwt.JwtConfig;
import com.jforce.lms.jwt.JwtToken;
import com.jforce.lms.jwt.JwtTokenVerifier;
import com.jforce.lms.jwt.JwtUsernameAndPasswordAuthenticationFilter;
import com.jforce.lms.user.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.SecretKey;

@Configuration//Properties("application.jwt")
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsServiceImpl userDetailsServiceImpl;
    private final JwtConfig jwtConfig;
    private final SecretKey secretKey;
    private final JwtToken jwtToken;

    @Autowired //This is from OUR PasswordConfig class
    public AppSecurityConfig(PasswordEncoder passwordEncoder,
                             UserDetailsServiceImpl userDetailsServiceImpl,
                             JwtConfig jwtConfig,
                             SecretKey secretKey, JwtToken jwtToken) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.jwtConfig = jwtConfig;
        this.secretKey = secretKey;
        this.jwtToken = jwtToken;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                //.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                //.and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                //.addFilterBefore(new SimpleCorsFilter(), JwtUsernameAndPasswordAuthenticationFilter.class)
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig, secretKey, jwtToken))
                .addFilterAfter(new JwtTokenVerifier(secretKey, jwtConfig, userDetailsServiceImpl), JwtUsernameAndPasswordAuthenticationFilter.class)
                .authorizeRequests()
                //.antMatchers("/favicon.ico/**").anonymous()
                .antMatchers("/", "index", "/css/*", "/js/*", "/ico/*","/png/*","/registration/**","/payment/**","/static/**","/signin","/signup","/sap_registration",
                		"/changePassword", "/changeUserPassword","/changingUserPassword","/create-new-password","signin?msg=error","/login"
                )
                .permitAll()
                .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                .antMatchers("/faculty/**").hasAuthority("ROLE_FACULTY")
                .antMatchers("/student/**").hasAuthority("ROLE_STUDENT")
                .anyRequest()
                .authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder); //Allows passwords to be decoded
        provider.setUserDetailsService(userDetailsServiceImpl);
        return provider;
    }


}
