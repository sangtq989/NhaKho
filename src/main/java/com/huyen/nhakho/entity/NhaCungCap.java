package com.huyen.nhakho.entity;


import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "nha_cung_cap")
@Generated
@Getter
@Setter
@ToString
public class NhaCungCap {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ten_ncc")
    private String tenNCC;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name= "so_dien_thoai")
    private String soDienThoai;

}
