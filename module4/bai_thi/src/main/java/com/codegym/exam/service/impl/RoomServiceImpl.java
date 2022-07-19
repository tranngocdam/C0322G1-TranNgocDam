package com.codegym.exam.service.impl;

import com.codegym.exam.model.Room;
import com.codegym.exam.repository.IRoomRepository;
import com.codegym.exam.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements IRoomService {
    @Autowired
    private IRoomRepository iRoomRepository;

    @Override
    public List<Room> getAllRoom() {
        return iRoomRepository.getAllRoom();
    }

    @Override
    public void setStatus(String roomCode) {
        iRoomRepository.setStatus(roomCode);
    }

    @Override
    public void updateStatus(Integer id) {
        iRoomRepository.updateStatus(id);
    }
}
