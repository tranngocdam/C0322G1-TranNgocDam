package com.codegym.service;

import com.codegym.model.Declaration;
import com.codegym.repository.IDeclarationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeclarationServiceImpl implements IDeclarationService {
    @Autowired
    private IDeclarationRepository iDeclarationRepository;

    @Override
    public List<Declaration> findAll() {
        return iDeclarationRepository.findAll();
    }

    @Override
    public void save(Declaration declaration) {
        iDeclarationRepository.save(declaration);
    }

    @Override
    public Declaration findById(Integer id) {
        return iDeclarationRepository.findById(id);
    }
}
