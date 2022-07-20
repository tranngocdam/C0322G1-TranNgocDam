package com.codegym.repository.impl;

import com.codegym.model.Song;
import com.codegym.repository.BaseRepository;
import com.codegym.repository.ISongRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Repository
public class ISongRepositoryImpl implements ISongRepository {

    @Override
    public List<Song> findAll() {
        BaseRepository.entityManager.clear();
        TypedQuery<Song> typedQuery= BaseRepository.entityManager.createQuery
                ("select s from Song s", Song.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Song song) {
        EntityTransaction entityTransaction=BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(song);
        entityTransaction.commit();
    }

    @Override
    public Song findById(Integer id) {
        TypedQuery<Song> typedQuery=BaseRepository.entityManager.createQuery("select s from Song as s where s.id=:id", Song.class);
        typedQuery.setParameter("id", id);
        try {
            return typedQuery.getSingleResult();
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public void edit(Song song) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(song);
        entityTransaction.commit();
    }
        @Override
        public void delete(Integer id) {
            EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
            entityTransaction.begin();
            BaseRepository.entityManager.remove(BaseRepository.entityManager.find(Song.class,id));
            entityTransaction.commit();
        }

}
