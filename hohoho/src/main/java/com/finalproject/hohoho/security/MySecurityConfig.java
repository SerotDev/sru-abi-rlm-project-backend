package com.finalproject.hohoho.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.finalproject.hohoho.jwt.JwtAuthenticationFilter;
import com.finalproject.hohoho.security.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class MySecurityConfig {
	
	private static final String[] USER_SECURED_URLs = {
			"/api/user/favouriteHotels/**", 
			"/api/addFavourites", 
			"/api/addFavourite/add", 
			"/api/addFavourite/**", 
			"/api/addFavourite/update/**", 
			"/api/addFavourite/delete/**"
			};
	
	private static final String[] HOTEL_SECURED_URLs = {
			"/api/user/hotels/**",
			"/api/user/events/**", 
			"/api/event/add",
			"/api/event/update/**",
			"/api/event/delete/**",
			"/api/hotel/add",
			"/api/hotel/update/**",
			"/api/hotel/delete/**",
			"/api/hotelService/add",
			"/api/hotelService/update/**",
			"/api/hotelService/delete/**"
			};
	
	private static final String[] ADMIN_SECURED_URLs = {
			"/api/users", 
			"/api/user/add", 
			"/api/user/**", 
			"/api/user/update/**",
			"/api/roles",
			"/api/role/add",
			"/api/role/**",
			"/api/role/update/**",
			"/api/role/delete/**",
			"/api/service/add",
			"/api/service/update/**",
			"/api/service/delete/**",
			"/api/town/add",
			"/api/town/update/**",
			"/api/town/delete/**",
    		"/api/user/delete/**"
			};

    private static final String[] ALLOW_GET_URLs = {
            "/api/hotels/*",
            "/api/hotel/**",
            "/api/hotel/starRatingAvg/**",
            "/api/events",
            "/api/events-private/**",
            "/api/events-public/**",
            "/api/event/**",
            "/api/towns",
            "/api/town/**",
            "/api/hotelServices",
            "/api/hotelServices/**",         
            "/swagger-ui/**",
            "/swagger-resources/*",
            "/v3/api-docs/**",
            "/api/services",
            "/api/service/**"
    };

    public static final String[] ALLOW_POST_URLs = {"/login" ,"/register"};

    @Autowired
    private JwtAuthenticationFilter authenticationFilter;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        var authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
       return authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable())
        		.cors(cors -> cors.configurationSource(corsConfigurationSource())).authorizeHttpRequests(auth-> auth
        				.requestMatchers(HttpMethod.GET, ALLOW_GET_URLs).permitAll()
                        .requestMatchers(HttpMethod.POST,ALLOW_POST_URLs).permitAll()
                        .requestMatchers(USER_SECURED_URLs).hasAnyAuthority("ADMIN", "VISITOR")
                        .requestMatchers(HOTEL_SECURED_URLs).hasAnyAuthority("ADMIN", "HOTEL")
                        .requestMatchers(ADMIN_SECURED_URLs).hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.POST).hasAuthority("ADMIN")
                        )
                .sessionManagement(management -> management
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
    
    
 // CORS Configuration Bean
    @Bean
    CorsConfigurationSource corsConfigurationSource() {

    	CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
     }
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

}