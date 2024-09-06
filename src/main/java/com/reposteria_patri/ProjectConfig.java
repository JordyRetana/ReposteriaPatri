/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reposteria_patri;


import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class ProjectConfig implements WebMvcConfigurer{
    /* 
    */
    @Bean
    public LocaleResolver localeResolver(){
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.getDefault());
        slr.setLocaleAttributeName("session.current.locale");
        slr.setTimeZoneAttributeName("session.current.timezone");        
        return slr;
    }
    
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registro){
        registro.addInterceptor(localeChangeInterceptor());
    }
    
    @Bean("messageSource")
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/registro/nuevo").setViewName("/registro/nuevo");
 }

@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests((request) -> request
            .requestMatchers("/", "/index", "/errores/**", "/img/**",
                             "/carrito/**", "/pruebas/**", "/reportes/**",
                             "/registro/**", "/js/**", "/webjars/**","/contacto/**","/galeria/**","/productos/listado","/productos/listadoTortasPostres",
                             "/productos/listadoPanaderia","/productos/detalles/**","/contacto/formulario","/contacto/guardar","/contacto/listado",
                             "/comentarios/listado","/comprar/**","/usuario/nuevo","/usuario/guardar","/nosotros/**",
                        "/usuario/modificar/**","/usuario/eliminar/**","/usuario/**","/carrito/modificar/**","/comentarios/submitTestimonio")
            .permitAll()              
            .requestMatchers("/productos/**", "/categoria/**", "/usuario/**","/usuario/nuevo","/usuario/guardar",
                        "/usuario/modificar/**","/usuario/eliminar/**","/usuario/**","/carrito/**","/facturar/carrito","/facturar/**","/comentarios/**","/contacto/**",
                    "/galeria/**","/layout/**","/registros/**","carrito/modificar/**","/comprar/**","/nosotros/**","/usuario/listado","/usuario/**")
            .hasRole("ADMIN")
            .requestMatchers(
                "/productos/listado",
                "/productos/listado_1",
                "/productos/listado_2",
                "/productos/modifica/**",
                "/productos/eliminar/**",
                "/categoria/listado",
                "/usuario/listado","/comprar/**",
                "/facturar/carrito","/carrito/guardar","/nosotros/**"
            )
            .hasAnyRole("ADMIN", "VENDEDOR") 
            .requestMatchers("/usuario/nuevo", "/usuario/guardar","carrito/modificar/**","/comprar/**","/nosotros/**","/facturar/carrito","/comprar/**","/facturar/**")
            .hasRole("USER")
            .requestMatchers("/carrito/**","facturar/**").hasAnyRole("USER", "VENDEDOR").anyRequest().authenticated()
        )
        .formLogin((form) -> form
            .loginPage("/login").permitAll())
        .logout((logout) -> logout.permitAll());
    return http.build();
}


    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build)
            throws Exception{
        build.userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }
}
