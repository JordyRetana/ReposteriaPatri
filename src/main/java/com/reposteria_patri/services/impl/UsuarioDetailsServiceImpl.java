/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reposteria_patri.services.impl;


import com.reposteria_patri.dao.UsuarioDao;
import com.reposteria_patri.domain.Rol;
import com.reposteria_patri.domain.Usuario;
import com.reposteria_patri.services.UsuarioDetailsService;

import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author josuemendezcalderon
 */
@Service("UserDetailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService,
        UserDetailsService{

    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired HttpSession session;
    
    
    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Usuario usuario = usuarioDao.findByUsername(username);
        
        if(usuario==null){
            throw new UsernameNotFoundException(username);
        }
        
        
        session.removeAttribute("usuarioImagen");
        session.setAttribute("usuarioImagen",usuario.getRutaImagen());
        var roles = new ArrayList<GrantedAuthority>();
        
        for(Rol r: usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority (r.getNombre()));
        }
        
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
        
                
    }
    
}
