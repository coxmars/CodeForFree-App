package com.proyecto.test.app.security;

import com.proyecto.test.app.dao.IClienteDao;
import com.proyecto.test.app.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private IClienteDao clienteDao;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Cliente cliente = clienteDao.findByUsername(username);
        if(cliente == null){
            
        }
        
        return new UserDetailsImpl(cliente);
    }
    
}

//
//Cliente cliente = clienteDao.findByUsername(username);
//        UserBuilder builder = null;
//        if (cliente != null) {
//            builder = User.withUsername(username);
//            builder.disabled(false);
//            builder.password(cliente.getPasswd());
//            builder.authorities(new SimpleGrantedAuthority("ROLE_USER"));
//        }
//        else {
//            throw new UsernameNotFoundException("Usuario no encontrado");
//        }
//        return builder.build();