/*
package br.com.gerenciadorescolar.ge.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {

    @Bean
	@Override
    protected UserDetailsService userDetailsService(){

        UserDetails user1 = User.withDefaultPasswordEncoder()
                                .username("rebecca")
                                .password("rebecca")
                                .roles("SERV")
                                .build();

        UserDetails user2 = User.withDefaultPasswordEncoder()
                                .username("dulcineia")
                                .password("dulcineia")
                                .roles("ALUNO")
                                .build();

        UserDetails user3 = User.withDefaultPasswordEncoder()
                                .username("edvaldo")
                                .password("edvaldo")
                                .roles("PROFESSOR")
                                .build();

        return new InMemoryUserDetailsManager(user1, user2, user3);
        
    }

    public static class ServSecurityConfigurationAdapter{

        protected void configure(HttpSecurity http) throws Exception{
            http
                .antMatcher("/prinServ")
                .authorizeRequests()
                    .anyRequest().hasRole("SERV")
                    .and()
                .httpBasic();
        }
    }

    public static class AlunoSecurityConfigurationAdapter{

        protected void configure(HttpSecurity http) throws Exception{
            http
                .antMatcher("/prinAluno")
                .authorizeRequests()
                    .anyRequest().hasRole("ALUNO")
                    .and()
                .httpBasic();
        }
    }

    public static class ProfSecurityConfigurationAdapter{

        protected void configure(HttpSecurity http) throws Exception{
            http
                .antMatcher("/prinProf")
                .authorizeRequests()
                    .anyRequest().hasRole("PROFESSOR")
                    .and()
                .httpBasic();
        }
    }
    
}
*/

/*
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .permitAll()
                .and()
            .logout()
                .permitAll();
    } */

