package com.huyen.nhakho.entity.relation;

import com.huyen.nhakho.entity.HangHoa;
import com.huyen.nhakho.entity.PhieuNhapKho;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "chi_tiet_phieu_nhap")
@Generated
@Getter
@Setter
@ToString
public class ChiTietPhieuNhapKho {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phieu_nhap_id", nullable = false, //
            foreignKey = @ForeignKey(name = "phieu_nhap_detail_fk"))
    private PhieuNhapKho order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hang_hoa_id", nullable = false, //
            foreignKey = @ForeignKey(name = "phieu_nhap_item_fk"))
    private HangHoa product;

    @Column(name = "so_luong")
    private int soLuong;
}
