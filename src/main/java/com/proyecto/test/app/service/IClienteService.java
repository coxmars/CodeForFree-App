package com.proyecto.test.app.service;

import com.proyecto.test.app.model.Cliente;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IClienteService {

	public List<Cliente> findAll();
	
	public Page<Cliente> findAll(Pageable pageable);

	public void save(Cliente cliente);
	
	public Cliente findOne(Long id);
	
	public void delete(Long id);
        
        public Cliente findByUsername(String username);
        
        public Cliente registrar (Cliente cliente);

}
