package com.wpe4bank.crud.service;

import com.wpe4bank.crud.model.Funcionario;
import com.wpe4bank.crud.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository repository;

    public Funcionario buscarPorId(Long id){
        Optional<Funcionario> funcionario = repository.findById(id);
        return funcionario.orElse(null);
    }

    public List<Funcionario> buscarTodos(){
        return repository.findAll();
    }

    public Funcionario salvar(Funcionario funcionario){
        return repository.save(funcionario);
    }

    public Funcionario editar(Long id, Funcionario funcionario){
        Funcionario funcionarioExistente = buscarPorId(id);

        if (funcionarioExistente == null){
            return null;
        }

        funcionario.setId(id);

        return salvar(funcionario);

    }

    public void deletar(Long id){
        Funcionario funcionario = buscarPorId(id);
        repository.delete(funcionario);
    }

}
