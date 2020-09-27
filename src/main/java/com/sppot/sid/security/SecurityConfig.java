package com.sppot.sid.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
    private SimpleAuthenticationSuccess success;
    @Autowired
    private BCryptPasswordEncoder encoder;
   
    @Autowired
    public void globalConfig(AuthenticationManagerBuilder builder, DataSource dataSource)throws Exception{
        //builder.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("SUPERVISEUR");
        //builder.inMemoryAuthentication().withUser("prof1").password("{noop}1234").roles("ELECTEUR");

    	 builder.jdbcAuthentication()
         .dataSource(dataSource)
         .usersByUsernameQuery("select username as principal, password as credentials, true from user where username= ?")
         .authoritiesByUsernameQuery("select user.username as principal, roles.nom as role from user_roles,user,roles where user_id = user.id and roles_id = roles.id  and user.username= ?")
         .rolePrefix("ROLE_")
         .passwordEncoder(encoder);

    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable()
        .authorizeRequests()
        .antMatchers("/css/**","/build/**","/scss/**","/vendor/**","/vendor1/**","/img/**","/register","/**","/saveUser").permitAll()
        .antMatchers("/menu_user").hasRole("USER")
        .antMatchers("/admin").hasRole("ADMIN")
        .and()
        .formLogin().successHandler(success)
        .loginPage("/login")
        .permitAll()
        .and()
        .sessionManagement()
        .invalidSessionUrl("/login");
    }

    

}
