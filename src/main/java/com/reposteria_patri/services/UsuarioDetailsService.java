package com.reposteria_patri.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UsuarioDetailsService {
    
    public UserDetails 
        loadUserByUsername(
        String username)
                throws UsernameNotFoundException;
    
}
