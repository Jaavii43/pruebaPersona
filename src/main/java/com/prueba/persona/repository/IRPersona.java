 
package com.prueba.persona.repository;

import com.prueba.persona.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRPersona extends JpaRepository <Persona, Long> {
    
}
