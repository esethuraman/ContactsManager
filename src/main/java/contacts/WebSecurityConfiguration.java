package contacts;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMethod;

//
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/contacts").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .and()
                .httpBasic();

//        http
//                .authorizeRequests()
//                .antMatchers("/xyz").authenticated()
//                .and()
//                .formLogin().and()
//                .httpBasic();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // {noop} prefix directs DelegatingPasswordEncoder to use NoOpPasswordEncoder
        auth
                .inMemoryAuthentication()
                .withUser("admin").password("{noop}password").roles("USER");
    }

}
