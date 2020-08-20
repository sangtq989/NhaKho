package com.huyen.nhakho.entity;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Generated
@Getter
@Setter
@ToString
public class VatTuRequest {

    private Long id;

    private Long loaiHang;

    private String tenHangHoa;

    private float donGia;

    private int soLuong;

    private String ghiChu;
}
