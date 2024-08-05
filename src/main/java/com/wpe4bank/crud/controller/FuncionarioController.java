package com.wpe4bank.crud.controller;

import com.wpe4bank.crud.model.Funcionario;
import com.wpe4bank.crud.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @PostMapping
    public Funcionario salvar(@RequestBody Funcionario funcionario){
        return service.salvar(funcionario);
    }

    @PutMapping("/{id}")
    public Funcionario editar(@PathVariable Long id, @RequestBody Funcionario funcionario){
        return service.editar(id, funcionario);
    }

    @GetMapping
    public List<Funcionario> buscarTodos(){
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    public Funcionario buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}
