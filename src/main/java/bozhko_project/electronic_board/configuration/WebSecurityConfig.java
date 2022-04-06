package bozhko_project.electronic_board.configuration;

import bozhko_project.electronic_board.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserServiceImpl userServiceImpl;

	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}*/

	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userServiceImpl).passwordEncoder(passwordEncoder);
	}

//	@Bean
//	public BCryptPasswordEncoder bCryptPasswordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

//	@Override
//	protected void configure(@Autowired AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService)
//				.passwordEncoder(bCryptPasswordEncoder());
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
				.authorizeRequests()
				.antMatchers("/","/create-user", "*.html","/oauth/**",
						"/v3/api-docs.yaml", "/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**").permitAll()
				.antMatchers("/user").authenticated()
				.antMatchers("/user/**").hasAnyAuthority("ADMIN")
				.and()
				.formLogin()
				.loginPage("/login.html")
				.defaultSuccessUrl("/user")
				.usernameParameter("login")
				.passwordParameter("password")
				.permitAll()
				.and()
				.httpBasic().and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);;

	}

}

