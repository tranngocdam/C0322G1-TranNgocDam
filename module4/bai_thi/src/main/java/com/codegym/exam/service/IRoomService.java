package com.codegym.exam.service;

import com.codegym.exam.model.Room;

import java.util.List;

public interface IRoomService {
    List<Room> getAllRoom();

    void setStatus(String roomCode);

    void updateStatus(Integer id);
}
