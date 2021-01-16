package com.htne.helpthehomeless.configuration;

import com.htne.helpthehomeless.converters.dto2entity.RegistrationDTOToUserConverter;
import com.htne.helpthehomeless.converters.dto2entity.ReservationDTOToReservationConverter;
import com.htne.helpthehomeless.converters.dto2entity.ShelterDTOToShelterConverter;
import com.htne.helpthehomeless.converters.dto2entity.UserDTOToUserConverter;
import com.htne.helpthehomeless.converters.entity2dto.ReservationToReservationDTOConverter;
import com.htne.helpthehomeless.converters.entity2dto.ShelterToShelterDTOConverter;
import com.htne.helpthehomeless.converters.entity2dto.UserToUserDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

    private final        HTHUserDetailsService userDetailsService;
    private static final String                FRONTEND_URL = "http://localhost:3000";

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.cors()
            .and()
            .authorizeRequests()
//            .antMatchers("/admin/**").hasRole(Role.ADMIN.name())
            .antMatchers("/shelter/admin/create").permitAll()
            .antMatchers("/register").permitAll()
            .antMatchers("/rsvp").permitAll()
            .antMatchers("/login").permitAll()
            .antMatchers("/api").permitAll()
            .and()
            .formLogin().disable()
            .logout()
            .permitAll()
            .logoutUrl("/logout")
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID")
            .and()
            .csrf().disable();
    }

    // Beans
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(encoder());
        authProvider.setUserDetailsService(userDetailsService);
        return authProvider;
    }

    @Override
    public void addFormatters(final FormatterRegistry mvcConversionService) {
        mvcConversionService.addConverter(new RegistrationDTOToUserConverter());
        mvcConversionService.addConverter(new UserToUserDTOConverter());
        mvcConversionService.addConverter(new ShelterDTOToShelterConverter());
        mvcConversionService.addConverter(new UserDTOToUserConverter());
        mvcConversionService.addConverter(new ReservationDTOToReservationConverter());
        mvcConversionService.addConverter(new ShelterToShelterDTOConverter());
        mvcConversionService.addConverter(new ReservationToReservationDTOConverter());
    }

    @Bean
    static CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Collections.singletonList(FRONTEND_URL));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "DELETE", "PUT", "PATCH"));
        configuration.setExposedHeaders(Arrays.asList("Authorization", "content-type"));
        configuration.setAllowedHeaders(Arrays.asList("X-Requested-With", "Origin", "Content-Type", "Accept", "Authorization"));
        configuration.setAllowCredentials(true);
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}