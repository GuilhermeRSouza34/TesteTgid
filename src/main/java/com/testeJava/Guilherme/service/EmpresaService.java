package com.testeJava.Guilherme.service;

import com.testeJava.Guilherme.model.Empresa;
import com.testeJava.Guilherme.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Empresa adicionarEmpresa(Empresa empresa) {
        // Verificar se a empresa já existe
        if (empresa.getId() != null && empresaRepository.existsById(empresa.getId())) {
            throw new RuntimeException("Empresa já existe");
        }

        return empresaRepository.save(empresa);
    }

    public Empresa atualizarEmpresa(Empresa empresa) {
        // Verificar se a empresa existe
        if (empresa.getId() == null || !empresaRepository.existsById(empresa.getId())) {
            throw new RuntimeException("Empresa não encontrada");
        }

        return empresaRepository.save(empresa);
    }

    public void excluirEmpresa(Long empresaId) {
        // Verificar se a empresa existe
        if (!empresaRepository.existsById(empresaId)) {
            throw new RuntimeException("Empresa não encontrada");
        }

        empresaRepository.deleteById(empresaId);
    }

}