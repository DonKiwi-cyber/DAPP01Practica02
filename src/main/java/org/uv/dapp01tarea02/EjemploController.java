/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.dapp01tarea02;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ian
 */
@RestController
public class EjemploController {
    
    @GetMapping(path = "/saludo", produces = {"application/json"})
    public String saludo(){
        return "hola mundo";
    }
    
    @GetMapping(path = "/data/{id}", produces = {"application/json"})
    public Data getData(@PathVariable("id") int id){
        Data d = null;
        if (id==1){
            d = new Data("01", "jabon", "Doble");
        }
        return d;
    }
    
    @Autowired
    private RepositoryEmpleado repo;
    
    @GetMapping(path = "/empleado/get/{id}", produces = {"application/json"})
    public Empleado getEmpleado(@PathVariable("id") Long id){
        Optional<Empleado> res = repo.findById(id);
        if (res.isPresent()){
            return res.get();
        }
        else{
            return null;
        }
    }
    
    @PostMapping(path = "/empleado/post")
    public ResponseEntity<String> postEmpleado(@RequestBody Empleado emp){
        repo.save(emp);
        return new ResponseEntity<>("Empleado registrado correctamente", HttpStatus.CREATED);
    }
    
    @PutMapping(path = "/empleado/put/{id}")
    public ResponseEntity<String> putEmpleado(@PathVariable("id") Long id, @RequestBody Empleado emp){
        Optional<Empleado> oldEmp = repo.findById(id);
        if(oldEmp.isPresent()){
            repo.save(emp);
            return new ResponseEntity<>("Empleado actualizado correctamente", HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>("Error al actualizar el empleado", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping(path = "/empleado/delete/{id}")
    public ResponseEntity<String> deleteEmpleado(@PathVariable("id") Long id){
        if(repo.findById(id).isPresent()){
            repo.deleteById(id);
            return new ResponseEntity<>("Empleado eliminado correctamente", HttpStatus.ACCEPTED);
        }
        else{
            return new ResponseEntity<>("No existe el empleado con el ID elegido", HttpStatus.NOT_FOUND);
        }
    }
}
