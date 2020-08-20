package com.huyen.nhakho.entity;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "loai_hang")
@Generated
@Getter
@Setter
@ToString
public class LoaiHang {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String tenLoaiHang;
}
