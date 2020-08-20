package com.huyen.nhakho.repository;

import com.huyen.nhakho.entity.HangHoa;
import com.huyen.nhakho.entity.relation.ChiTietPhieuNhapKho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PhieuNhapDetailRepo extends JpaRepository<ChiTietPhieuNhapKho,Long> {
    @Query("select d from ChiTietPhieuNhapKho  d where d.order.id = ?1")
    public List<ChiTietPhieuNhapKho> findHangHoa(Long id);
}
