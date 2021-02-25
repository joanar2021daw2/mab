/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.service.impl;

import cat.xtec.ioc.domain.Instalacio;
import cat.xtec.ioc.repository.InstalacioRepository;
import cat.xtec.ioc.service.InstalacioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JoseAndrade
 */
@Service
public class InstalacioServiceImpl implements InstalacioService{
    
    @Autowired
    private InstalacioRepository instalacioRepository;

    @Override
    public Instalacio getInstalacioById(int id) {
        return instalacioRepository.getInstalacioById(id);
    }

    @Override
    public List<Instalacio> getAllInstalacions() {
        return instalacioRepository.getAllInstalacions();
    }

    @Override
    public List<Instalacio> getInstalacionsBySeccio(int idSeccio) {
        return instalacioRepository.getInstalacionsBySeccio(idSeccio);
    }

    @Override
    public void addInstalacio(Instalacio instalacio) {
        instalacioRepository.addInstalacio(instalacio);;
    }

    @Override
    public void updateInstalacio(Instalacio instalacio) {
        instalacioRepository.updateInstalacio(instalacio);
    }
    
}
