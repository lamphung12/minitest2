package com.example.baitapproduct.service;

import com.example.baitapproduct.mode.OderDetail;
import com.example.baitapproduct.repository.IOrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class OrderDetailIpl implements OrderDetailService{

    @Autowired
    IOrderDetailRepository repository;
    @Override
    public Iterable<OderDetail> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<OderDetail> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public OderDetail save(OderDetail oderDetail) {
      return  repository.save(oderDetail);

    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);

    }
}
