package com.codegym.service.impl;

import com.codegym.model.Song;
import com.codegym.repository.ISongRepository;
import com.codegym.repository.impl.ISongRepositoryImpl;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ISongServiceImpl implements ISongService {
    @Autowired
    ISongRepository iSongRepository=new ISongRepositoryImpl();

    @Override
    public List<Song> findAll() {
        return iSongRepository.findAll();
    }

    @Override
    public void save(Song song) {
        this.iSongRepository.save(song);
    }

    @Override
    public Song findById(Integer id) {
        return iSongRepository.findById(id);
    }

    @Override
    public void edit(Song song) {
        iSongRepository.edit(song);
    }

    @Override
    public void delete(Integer id) {
        iSongRepository.delete(id);
    }
}
