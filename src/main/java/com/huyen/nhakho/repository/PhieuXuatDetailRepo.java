package com.huyen.nhakho.repository;

import com.huyen.nhakho.entity.relation.ChiTietPhieuNhapKho;
import com.huyen.nhakho.entity.relation.ChiTietPhieuXuatKho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhieuXuatDetailRepo extends JpaRepository<ChiTietPhieuXuatKho,Long> {
    @Query("select d from ChiTietPhieuXuatKho  d where d.order.id = ?1")
    public List<ChiTietPhieuXuatKho> findItemXuat(Long id);
}
