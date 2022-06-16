package com.proyecto.test.app.dao;

import com.proyecto.test.app.model.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long> {
    public Cliente findByUsername(String username);
}
