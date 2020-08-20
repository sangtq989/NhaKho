package com.huyen.nhakho.entity.relation;

import com.huyen.nhakho.entity.HangHoa;
import com.huyen.nhakho.entity.PhieuXuatKho;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "chi_tiet_phieu_xuat")
@Generated
@Getter
@Setter
@ToString
public class ChiTietPhieuXuatKho {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phieu_xuat_id", nullable = false, //
            foreignKey = @ForeignKey(name = "phieu_xuat_detail_fk"))
    private PhieuXuatKho order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hang_hoa_id", nullable = false, //
            foreignKey = @ForeignKey(name = "phieu_xuat_item_fk"))
    private HangHoa product;

    @Column(name = "so_luong")
    private int soLuong;


}
