package Application.Config;

import Application.DataBase.Entities.Auth.BaseRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{

        auth.jdbcAuthentication().dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery(
                        "select email,password,enabled from credential where email=?"
                )
                .authoritiesByUsernameQuery(
                        "select email,role from credential natural join roles where email=?"
                );
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(final HttpSecurity http) throws Exception{
        System.setProperty("https.protocols", "TLSv1.2");
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);

        http.addFilterBefore(filter, CsrfFilter.class);
        http.
                httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/customer/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/customer/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/auth/login").permitAll()
                .antMatchers(HttpMethod.POST, "/api/auth/logout").permitAll()
                .antMatchers(HttpMethod.GET, "/api/admin/**").hasAnyAuthority(BaseRole.SUPER_USER.getRole())
                .antMatchers(HttpMethod.POST, "/api/admin/**").hasAnyAuthority(BaseRole.SUPER_USER.getRole())
                .antMatchers(HttpMethod.PUT, "/api/admin/**").hasAnyAuthority(BaseRole.SUPER_USER.getRole())
                .antMatchers(HttpMethod.DELETE, "/api/admin/**").hasAnyAuthority(BaseRole.SUPER_USER.getRole())
                .antMatchers(HttpMethod.GET, "/api/manager/**").hasAnyAuthority(BaseRole.MANAGER.getRole())
                .antMatchers(HttpMethod.POST, "/api/manager/**").hasAnyAuthority(BaseRole.MANAGER.getRole())
                .antMatchers(HttpMethod.PUT, "/api/manager/**").hasAnyAuthority(BaseRole.MANAGER.getRole())
                .antMatchers(HttpMethod.DELETE, "/api/manager/**").hasAnyAuthority(BaseRole.MANAGER.getRole())
                .antMatchers(HttpMethod.GET, "/api/worker/**").hasAnyAuthority(BaseRole.WORKER.getRole())
                .antMatchers(HttpMethod.PUT, "/api/worker/**").hasAnyAuthority(BaseRole.WORKER.getRole())
                .antMatchers(HttpMethod.POST, "/api/customer/create").hasAnyAuthority(BaseRole.CUSTOMER.getRole())
                .antMatchers(HttpMethod.GET, "/api/customer/name").hasAnyAuthority(BaseRole.CUSTOMER.getRole())
                .antMatchers(HttpMethod.PUT, "/api/order/**").hasAnyAuthority(
                        BaseRole.WORKER.getRole(),
                        BaseRole.SUPER_USER.getRole(),
                        BaseRole.MANAGER.getRole())
                .antMatchers(HttpMethod.PUT,
                        "/api/order/freeze",
                        "/api/order/active",
                        "api/order/delete").hasAnyAuthority(
                        BaseRole.SUPER_USER.getRole(),
                        BaseRole.MANAGER.getRole())
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .and()
                .csrf().disable();
        http.cors().disable();
    }
}