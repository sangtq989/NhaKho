package com.huyen.nhakho.entity;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "hang_hoa")
@Generated
@Getter
@Setter
@ToString
public class HangHoa {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    @JoinColumn(name="id_loai_hang")
    private LoaiHang loaiHang;

    @Column(name = "ten_hang_hoa")
    private String tenHangHoa;

    @Column(name = "don_gia")
    private float donGia;

    @Column(name = "so_luong")
    private int soLuong;

    @Column(name = "ghi_chu")
    private String ghiChu;
}
