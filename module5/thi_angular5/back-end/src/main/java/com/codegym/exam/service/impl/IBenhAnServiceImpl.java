package com.codegym.exam.service.impl;

import com.codegym.exam.model.BenhAn;
import com.codegym.exam.repository.IBenhAnRepository;
import com.codegym.exam.service.BenhAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class IBenhAnServiceImpl implements BenhAnService {
    @Autowired
    private IBenhAnRepository iBenhAnRepository;

    @Override
    public Page<BenhAn> findAll(Pageable pageable) {
        return iBenhAnRepository.findAllBenhAn(pageable);
    }

    @Override
    public void save(BenhAn benhAn) {
        iBenhAnRepository.saveBenhAn(benhAn.getBacSi(), benhAn.getLiDo(), benhAn.getNgayNhapVien(),
                benhAn.getNgayRaVien(), benhAn.getPhuongPhap(), benhAn.getMaBenhNhan(), benhAn.getMaBenhAn());
    }

    @Override
    public BenhAn findByBenhAn(Integer id) {
        return iBenhAnRepository.findByIdBenhAn(id);
    }

    @Override
    public void deleteBenhAn(Integer id) {
        iBenhAnRepository.deleteBenhAn(id);
    }

    @Override
    public BenhAn editBenhAn(BenhAn benhAn) {
        return iBenhAnRepository.save(benhAn);
    }

    @Override
    public Page<BenhAn> findBenhAnByLiDo(String liDo, Pageable pageable) {
        return iBenhAnRepository.findBenhAnByLiDo("%"+ liDo+"%", pageable);
    }

}
