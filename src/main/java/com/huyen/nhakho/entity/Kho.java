package com.huyen.nhakho.entity;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "kho")
@Generated
@Getter
@Setter
@ToString
public class Kho {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ten_kho")
    private String tenKho;

}
