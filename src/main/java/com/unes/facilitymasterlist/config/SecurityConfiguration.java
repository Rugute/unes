package com.unes.facilitymasterlist.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import javax.sql.DataSource;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true)

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService customUserDetailsService;

    //@Value("${spring.queries.users-query}")
    private String usersQuery ="select email, password, active,cid, username from user where email=?";

    // @Value("${spring.queries.roles-query}")
    private String rolesQuery ="select u.username, u.email, u.cid, r.role from user u inner join user_role ur on(u.user_id=ur.user_id) inner join role r on(ur.role_id=r.role_id) where u.email=?";

    private static final String[] AUTH_WHITELIST = {
            // -- swagger ui
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/api.html",
            "/swagger-ui.html",
            "/webjars/**"
            // other public endpoints of your API may be appended to this array
    };

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(customUserDetailsService)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();
        tokenRepositoryImpl.setDataSource(dataSource);
        return tokenRepositoryImpl;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                headers().frameOptions().sameOrigin();

        http.

                authorizeRequests()

                .antMatchers("/vacancy/createaccount").permitAll()
                .antMatchers("/vacancy/application").permitAll()
                .antMatchers("/vacancy/apply").permitAll()
                .antMatchers("/vacancy/apply/**").permitAll()
                .antMatchers("/vacancy/openings").permitAll()
                .antMatchers("/vacancy/download/**").permitAll()
                .antMatchers("/rest/v1/api/**").permitAll()
                .antMatchers("/rest/documentation").permitAll()
                .antMatchers("/rest/resetpassword").permitAll()
                .antMatchers("/rest/doc").permitAll()
                .antMatchers("/api.html").permitAll()
                .antMatchers(AUTH_WHITELIST).permitAll()

                // .antMatchers("/rest/v1/api/token").permitAll()
                // .antMatchers("/rest/v1/api/checkin").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/setup").permitAll()
                .antMatchers("/auth/activate").permitAll()
                .antMatchers("/auth/login").permitAll()
                .antMatchers("/auth/cresetpassword").permitAll()
                .antMatchers("/auth/registration").permitAll()
                .antMatchers("/auth/admin/**").hasAuthority("SUPERADMIN").anyRequest()
                .authenticated().and().csrf().disable().formLogin()
                .loginPage("/auth/login").failureUrl("/auth/login?error=true")
                .defaultSuccessUrl("/router/process")
                .usernameParameter("email")
                .passwordParameter("password")
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .deleteCookies("my-remember-me-cookie")
                .permitAll()
                .and()
                .rememberMe()
                //.key("my-secure-key")
                .rememberMeCookieName("my-remember-me-cookie")
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(24 * 60 * 60)
                .and()
                .exceptionHandling()
        ;

    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**",
                        "/reportstemplates/**",
                        "/static/**",
                        "/themes/**",
                        "/themes/css/**",
                        "/themes/kichwen/css/**",
                        "/uploads/**",
                        "/themes/js/**",
                        "/themes/img/**",
                        "/themes/fonts/**",
                        "/swagger-resources/**",
                        "/swagger-ui.html",
                        "/api.html",
                        "/themes/jtoaster/**");
        //   web.httpFirewall(allowUrlEncodedSlashHttpFirewall);

    }





}
