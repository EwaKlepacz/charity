package pl.coderslab.charity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.coderslab.charity.model.services.SpringDataUserDetailsService;

import javax.sql.DataSource;

import static org.hibernate.hql.internal.antlr.SqlTokenTypes.WHERE;
import static org.springframework.http.HttpHeaders.FROM;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private DataSource dataSource;
    public SecurityConfig(DataSource dataSource){
        this.dataSource=dataSource;
    }
  @Bean
  public BCryptPasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
  }

  @Bean
  public SpringDataUserDetailsService customUserDetailsService () {
        return new SpringDataUserDetailsService ();
  }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .passwordEncoder(passwordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT username, password, true FROM users WHERE username = ?")
                .authoritiesByUsernameQuery("SELECT username, name FROM users join user_role on users.id = user_role.user_id "
                        +"join role on user_role.role_id = role.id where username=?");
    }


    @Override
    protected void configure (HttpSecurity http) throws Exception {
      http
      .authorizeRequests()
      .antMatchers("/").permitAll()
      .antMatchers("/form").authenticated()
      .antMatchers("/resources/**").permitAll()
       .antMatchers("/registration").permitAll()
      .anyRequest().authenticated()
      .and().formLogin().loginPage("/login").permitAll()
      .defaultSuccessUrl("/admin")
      .and().logout().logoutSuccessUrl("/")
      .and()
      .csrf().disable();

          }
}
