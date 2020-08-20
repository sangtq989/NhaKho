package com.huyen.nhakho.repository;

import com.huyen.nhakho.entity.NhanVien;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<NhanVien, Long> {
    @Query("SELECT u FROM NhanVien u WHERE u.username = :username")
    public NhanVien getUserByUsername(@Param("username") String username);
}