package com.huyen.nhakho.repository;

import com.huyen.nhakho.entity.LoaiHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiHangRepo extends JpaRepository<LoaiHang,Long> {
}
