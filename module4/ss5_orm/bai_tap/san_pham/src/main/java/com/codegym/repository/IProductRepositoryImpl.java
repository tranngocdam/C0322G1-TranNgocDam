package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class IProductRepositoryImpl implements IProductRepository {
    @Override
    public List<Product> findAll() {
        TypedQuery<Product> typedQuery= BaseRepository.entityManager.createQuery("select s from Product s", Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction=BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public Product findById(Integer id) {
        TypedQuery<Product> typedQuery=BaseRepository.entityManager.createQuery
                ("select s from Product as s where s.id=:id", Product.class);
        typedQuery.setParameter("id", id);
        try {
            return typedQuery.getSingleResult();
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public void edit(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void delete(Integer id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(BaseRepository.entityManager.find(Product.class,id));
        entityTransaction.commit();
    }
}
