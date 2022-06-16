package com.proyecto.test.app.dao;

import com.proyecto.test.app.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class DbInitializer implements CommandLineRunner{
    
    private static final Logger logger = LoggerFactory.getLogger(DbInitializer.class);

    @Autowired
    private  IClienteDao clienteDao;

    @Autowired
    private PasswordEncoder passwordEncoder; 
    
    @Override
    public void run(String... args) throws Exception {
        logger.info("Inside the DbInitializer");
        clienteDao.deleteAll();
        List<Cliente> userList = new ArrayList<>();
        userList.add(new Cliente("Caleb","Loria","caleb@gmail.com",      "user1", passwordEncoder.encode("123"),"USER"));
        userList.add(new Cliente("user2","2","user2@gmail.com",          "user2", passwordEncoder.encode("pass2"),"USER"));
        userList.add(new Cliente("admin","prinicipal","admin@gmail.com", "admin1", passwordEncoder.encode("admin1"),"ADMIN"));
        userList.add(new Cliente("admin2","2","admin2@gmail.com",        "admin2", passwordEncoder.encode("admin2"),""));
        clienteDao.saveAll(userList);
        logger.info("Successfully inserted records inside user table!");
    }
    
}
