package com.finalproject.hohoho.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.finalproject.hohoho.security.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class MySecurityConfig {
	
	private static final String[] USER_SECURED_URLs = {
			"/api/user/favouriteHotels/{userId}", 
			"/api/addFavourites", "/api/addFavourite/add", 
			"/api/addFavourite/{id}", 
			"/api/addFavourite/update/{id}", 
			"/api/addFavourite/delete/{id}"
			};
	
	private static final String[] HOTEL_SECURED_URLs = {
			"/api/user/hotels/{idUser}",
			"/api/user/events/{idHotel}", 
			"/api/event/add}",
			"/api/event/update/{id}",
			"/api/event/delete/{id}",
			"/api/hotel/add",
			"/api/hotel/update/{id}",
			"/api/hotel/delete/{id}",
			"/api/hotelService/add",
			"/api/hotelService/update/{id}",
			"/api/hotelService/delete/{id}"
			};
	
	private static final String[] ADMIN_SECURED_URLs = {
			"/api/users", 
			"/api/user/add", 
			"/api/user/{id}", 
			"/api/user/update/{id}",
			"/api/roles",
			"/api/role/add",
			"/api/role/{id}",
			"/api/role/update/{id}",
			"/api/role/delete/{id}",
			"/api/service/add",
			"/api/service/update/{id}",
			"/api/service/delete/{id}",
			"/api/towns",
			"/api/town/add",
			"/api/town/{id}",
			"/api/town/update/{id}",
			"/api/town/delete/{id}",
    		"/api/user/delete/{id}"
			};

    private static final String[] ALLOW_GET_URLs = {
            "/api/hotels/{page}{size}{idTown}{search}{minStarRatingAvg}{minNumberRooms}{minPrice}{maxPrice}{idServices}",
            "/api/hotel/{id}",
            "/api/hotel/starRatingAvg/{hotelId}",
            "/api/events",
            "/api/events-private/{idHotel}",
            "/api/events-public/{idTown}",
            "/api/event/{id}",
            "/api/hotelServices",
            "/api/hotelServices/{id}",         
            "/api/swagger-ui/**",
            "/api/swagger-resources/*",
            "/api/v3/api-docs/**",
            "/api/services",
            "/api/service/{id}"
    };

    public static final String[] ALLOW_POST_URLs = {"/login" ,"/register"};

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    
    @Autowired
	private JwtAuthenticationEntryPoint unauthorizedHandler;

	@Bean
	JwtAuthenticationFilter authorizationJwtTokenFilter() {
		return new JwtAuthenticationFilter();
	}

    @Bean
    AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authConfig) throws Exception {
    	return authConfig.getAuthenticationManager();
    }

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	AuthenticationProvider authenticationProvider() {
	DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	authProvider.setUserDetailsService(userDetailsService);
	authProvider.setPasswordEncoder(passwordEncoder());
	return authProvider;	
    }
    
    private final String AUTH_ORIGINS = Arrays.asList(
	        "http://myfood.up.railway.app/",
	        "https://myfood.up.railway.app/",
	        "http://localhost:4200",
	        "http://localhost:3000"
	        
	).toString();
	
	
	
	@Bean
	WebMvcConfigurer corsConfig() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedHeaders("*").allowedMethods("*");

			}
		};
	}
    

    // Security Filter Chain
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http ,  AuthenticationManager authenticationManager) throws Exception {

      return  http.cors(cors -> corsConfig())                            
        .csrf(csrf -> csrf.disable())                                                            
        .exceptionHandling(handling -> handling.authenticationEntryPoint(unauthorizedHandler))
        .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests( auth -> auth
        	
        	.requestMatchers(AUTH_WHITELIST)
        	.permitAll()
        	.anyRequest().authenticated()
        )
        	.authenticationProvider(authenticationProvider())
            .addFilterBefore(authorizationJwtTokenFilter(),UsernamePasswordAuthenticationFilter.class)
            .build();
	}
	

	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication()
	                .withUser("Victor")
	                .password(passwordEncoder().encode("password"))
	                .authorities("ADMIN");
	    }
	
	private final String[] AUTH_WHITELIST = {
			"/auth/**",
	        "/swagger-resources",
	        "/swagger-resources/**",
	        "/configuration/ui",
	        "/configuration/security",
	        "/swagger-ui.html",
	        "/v3/api-docs/**",
	        "/swagger-ui/**",
	        "/sru-abi-rlm-project-backend-production.up.railway.app/"        
	};
	
	
	
	
    
    
}