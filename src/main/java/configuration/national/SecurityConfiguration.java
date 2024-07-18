package configuration.national;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .authorizeHttpRequests((authorize) -> authorize
                                                .requestMatchers("/").permitAll()
                                                .requestMatchers(HttpMethod.POST, "/login").permitAll()
                                                .requestMatchers("/managers").hasAnyRole("MANAGERS")
                                                .requestMatchers("/users").hasAnyRole("USERS")
                                                .anyRequest().authenticated())
                                                
                                .httpBasic(withDefaults());

                return http.build();
        }

       /*  @Bean
        public UserDetailsService userDetailsService() throws Exception {
                // ensure the passwords are encoded properly
                @SuppressWarnings("deprecation")
                UserBuilder users = User.withDefaultPasswordEncoder();
                InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
                manager.createUser(users.username("user").password("password").roles("USER").build());
                manager.createUser(users.username("admin").password("password").roles(  "ADMIN").build());
                return manager;
        }*/
}
