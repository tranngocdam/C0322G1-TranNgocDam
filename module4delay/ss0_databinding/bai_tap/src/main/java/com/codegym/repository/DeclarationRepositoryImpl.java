package com.codegym.repository;

import com.codegym.model.Declaration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DeclarationRepositoryImpl implements IDeclarationRepository {
    private static final Map<Integer, Declaration> declarationList;
    static {
        declarationList=new HashMap<>();
        declarationList.put(1, new Declaration(1,"Van An", "1992",
                "o to", "2020-09-02","2020-09-10", "khong đi đau"));
        declarationList.put(2, new Declaration(2,"Xuan Nam", "1982",
                "may bay", "2020-10-12","2020-10-19", "Nha Trang"));
    }

    @Override
    public List<Declaration> findAll() {
        return new ArrayList<>(declarationList.values());
    }

    @Override
    public void save(Declaration declaration) {
        declarationList.put(declaration.getId(), declaration);
    }

    @Override
    public Declaration findById(Integer id) {
        return declarationList.get(id);
    }
}
