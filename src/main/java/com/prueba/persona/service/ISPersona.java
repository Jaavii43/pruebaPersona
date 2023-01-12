
package com.prueba.persona.service;

import com.prueba.persona.entity.Persona;
import java.util.List;


public interface ISPersona {
    
    public List<Persona>getPersona();
    public void savePersona(Persona perso);
    public void deletePersona(Long id);
    public Persona findPersona(Long id);  
}
