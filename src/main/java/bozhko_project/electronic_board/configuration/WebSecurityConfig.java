package bozhko_project.electronic_board.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
	}
		/*http.authorizeRequests()
				//.antMatchers("/oauth/**", "/v3/api-docs.yaml", "/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**").permitAll()
				/*.antMatchers("/registration").not().fullyAuthenticated()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/news").hasRole("USER")
				.antMatchers("/", "/resources/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/")
				.defaultSuccessUrl("/signIn")
				.failureUrl("/signIn?error")
				.usernameParameter("login")
				.passwordParameter("password")
				.permitAll();
	}*/

}

