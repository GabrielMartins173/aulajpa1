package com.example.demo.alo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/alo")
public class AloController {

    @GetMapping
    public String alo() {
        return "hello";
    }

    @GetMapping("/{nome}")
    public String alo(@PathVariable String nome){
        return "alo " + nome;
    }

    @GetMapping("/query")
    public String aloQuery(@RequestParam String nome, @RequestParam(defaultValue = "1") int idade){
        return "alo " + nome + "\n" + "Idade: "+ idade + " anos";
    }

    @GetMapping("/testeInt")
    public int retornaInt(){

        return -1;
    }

    @GetMapping("/testeData")
    public Date retornaData(){

        return new Date();
    }

    @GetMapping(value = "/testeAlo")
    public Alo retornaAlo(){
        Alo a = new Alo();
        a.setSaudacao("Oi");
        a.setNumeroDaSorte(29);
        return a;
    }

    @GetMapping("/testeErro")
    public void geraExcecao() throws Exception{

        throw new Exception("Ops");
    }

    @GetMapping("/testeCustom/{nome}")
    public ResponseEntity<Alo> retornaAlo(@PathVariable String nome){

        if(nome.startsWith("J")){

            return ResponseEntity.notFound().build();
        }
        else {

            Alo a = new Alo();
            a.setSaudacao(nome);
            a.setNumeroDaSorte(37);
            return ResponseEntity.ok(a);
        }
    }
}
