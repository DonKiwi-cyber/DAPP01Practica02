package org.uv.dapp02practica2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DAPP02Practica2 {

    public static void main(String[] args) {
        SpringApplication.run(DAPP02Practica2.class, args);
    }

    @RestController
    public static class HelloWorldController {
 
        
     @GetMapping("/")
        public String helloWorld() {
            return "Hello World!";
        }

        @GetMapping("/msg")
        public DTOUsuario msg() {
            return new DTOUsuario("francisco", "calle 1");
        }

        @GetMapping("/msg/{id}")
        public DTOUsuario msg(@PathVariable("id") Long id) {
            return new DTOUsuario("francisco" + id, "calle 1" + id);
        }

        @PostMapping("/msg")
        public String msg2(@RequestBody DTOUsuario usr) {
            String msg = "se recibio " + usr.getNombre() + "--" + usr.getDireccion() + "--" + usr.getTelefono();
            return "{ \"msg\": \"" + msg + "\" }";
        }

        @PutMapping("/msg")
        public String msg3(@RequestBody DTOUsuario usr) {
            String msg = "se editó " + usr.getNombre() + "--" + usr.getDireccion() + "--" + usr.getTelefono();
            return "{ \"msg\": \"" + msg + "\" }";
        }

        @DeleteMapping("/msg/{id}")
        public String msg4(@PathVariable Long id) {
            String msg = "se eliminó el empleado con ID: " + id;
            return "{ \"msg\": \"" + msg + "\", \"id\": " + id + " }";
        }

    }
}
