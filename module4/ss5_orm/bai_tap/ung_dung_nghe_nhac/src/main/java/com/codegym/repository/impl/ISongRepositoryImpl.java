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
        TypedQuery<Song> typedQuery= BaseRepository.entityManager.createQuery("select s from Song s", Song.class);
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


    @Transactional
    @Override
    public void edit(Song song) {
        Query query= BaseRepository.entityManager.createQuery("UPDATE Song as s SET s.songName = :songName, " +
                " s.singer = :singer, s.songType = :songType, s.link = :link WHERE s.id = :id");
        query.setParameter("id", song.getId());
        query.setParameter("songName", song.getSongName());
        query.setParameter("singer", song.getSinger());
        query.setParameter("songType", song.getSongType());
        query.setParameter("link", song.getLink());

        query.executeUpdate();
    }

    @Override
    public void delete(Integer id) {
        Song song = findById(id);
        if (song != null){
            BaseRepository.entityManager.remove(song);
        }
    }
}
