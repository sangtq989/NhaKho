package com.huyen.nhakho.repository;

import com.huyen.nhakho.entity.HangHoa;
import com.huyen.nhakho.entity.PhieuNhapKho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhieuNhapKhoRepo extends JpaRepository<PhieuNhapKho,Long> {

}
