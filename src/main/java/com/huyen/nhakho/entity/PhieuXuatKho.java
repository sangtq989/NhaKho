package com.huyen.nhakho.entity;

import com.huyen.nhakho.entity.relation.ChiTietPhieuNhapKho;
import com.huyen.nhakho.entity.relation.ChiTietPhieuXuatKho;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "phieu_xuat_kho")
@Generated
@Getter
@Setter
@ToString
public class PhieuXuatKho {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ten_khach_hang")
    private String tenKhach;
    @Column(name = "ngay_nhap")
    private String ngayNhap;
    @Column(name = "tong_tien")
    private double tongTien;
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChiTietPhieuXuatKho> chiTietPhieuXuatKhos;



}
