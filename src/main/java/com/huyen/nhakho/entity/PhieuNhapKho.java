package com.huyen.nhakho.entity;

import com.huyen.nhakho.entity.relation.ChiTietPhieuNhapKho;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Generated
@Getter
@Setter
@Table(name = "phieu_nhap_kho")
public class PhieuNhapKho {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_kho")
    private Kho kho;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_ncc")
    private NhaCungCap nhaCungCap;

    @OneToMany(mappedBy = "order")
    private List<ChiTietPhieuNhapKho> chiTietPhieuNhapKho;

    @Column(name = "ngay_nhap")
    private String ngayLap;

    @Column(name = "tong_tien")
    private double tongTien;
}
