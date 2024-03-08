package org.uv.dapp02practica2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
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
            return "¡Hola Mundo!";
        }
    }
}
