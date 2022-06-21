package com.example.baitapproduct.repository;

import com.example.baitapproduct.mode.OderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderDetailRepository extends JpaRepository<OderDetail,Long> {
}
