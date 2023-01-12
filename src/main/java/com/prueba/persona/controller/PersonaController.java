
package com.prueba.persona.controller;

import com.prueba.persona.entity.Persona;
import com.prueba.persona.service.ISPersona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    
    @Autowired
    private ISPersona interPersona;
    
    @GetMapping("/personas/traer")
    public List<Persona>getPersonas(){
        return interPersona.getPersona();
    }
    
    @PostMapping("/personas/crear")
    public String crearPersona(@RequestBody Persona perso){
        interPersona.savePersona(perso);
        return "la persona fue creada";
    }
    
    @DeleteMapping("/personas/borrar/{id}")
    public String borrarPersona(@PathVariable Long id){
        interPersona.deletePersona(id);
        return "la persona fue borrada";
    }
    
    @PutMapping("/personas/modificar/{id}")
    public Persona editPersona(@PathVariable Long id,
                                @RequestParam ("nombre") String nuevoNombre,
                                @RequestParam ("apellido") String nuevoApellido,
                                @RequestParam ("edad") int nuevaEdad){
        Persona perso=interPersona.findPersona(id);
        
        perso.setNombre(nuevoNombre);
        perso.setApellido(nuevoApellido);
        perso.setEdad(nuevaEdad);
        
        interPersona.savePersona(perso);
        return perso;
    }
    

}
