/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.config;

import cat.xtec.ioc.repository.ResultatRepository;
import cat.xtec.ioc.repository.SeccioRepository;
import cat.xtec.ioc.repository.UserRepository;
import cat.xtec.ioc.repository.impl.ResultatRepositoryImpl;
import cat.xtec.ioc.repository.impl.SeccioRepositoryImpl;
import cat.xtec.ioc.repository.impl.UserRepositoryImpl;
import cat.xtec.ioc.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author JoseAndrade
 */
@Configuration
class DAOConfig {

    @Bean
    public UserRepository userDAO() {
        return new UserRepositoryImpl();
    }

    @Bean
    public SeccioRepository seccioDAO() {
        return new SeccioRepositoryImpl();
    }

    @Bean
    public ResultatRepository resultatDAO() {
        return new ResultatRepositoryImpl();
    }

    @Bean
    public UserServiceImpl userService() {
        return new UserServiceImpl();
    }
}
