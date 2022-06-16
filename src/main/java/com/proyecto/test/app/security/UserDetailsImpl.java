package com.proyecto.test.app.security;

import com.fasterxml.jackson.databind.type.LogicalType;
import com.proyecto.test.app.model.Cliente;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import static org.springframework.security.config.http.MatcherType.regex;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails{
    private Cliente cliente;

    public UserDetailsImpl(Cliente cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(null!=cliente.getRoles() && !cliente.getRoles().isEmpty()){
            return Arrays.stream(cliente.getRoles().split(",")).map(role -> new SimpleGrantedAuthority("ROLE_"+role)).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return cliente.getPasswd();
    }

    @Override
    public String getUsername() {
        return cliente.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
