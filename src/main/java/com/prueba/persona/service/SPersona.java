
package com.prueba.persona.service;

import com.prueba.persona.entity.Persona;
import com.prueba.persona.repository.IRPersona;
import com.prueba.persona.repository.RPersona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SPersona implements ISPersona{
    @Autowired
    private IRPersona persoRepository;

    @Override
    public List<Persona> getPersona() {
        List<Persona> listaPersonas = persoRepository.findAll();
        return listaPersonas;
    }

    @Override
    public void savePersona(Persona perso) {
        persoRepository.save(perso);
    }

    @Override
    public void deletePersona(Long id) {
        persoRepository.deleteById(id);        
    }

    @Override
    public Persona findPersona(Long id) {
        Persona perso = persoRepository.findById(id).orElse(null);
        return perso;
    }
}
