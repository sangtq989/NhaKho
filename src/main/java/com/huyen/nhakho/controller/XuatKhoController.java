package com.huyen.nhakho.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huyen.nhakho.entity.PhieuXuatKho;
import com.huyen.nhakho.entity.relation.ChiTietPhieuXuatKho;
import com.huyen.nhakho.entity.relation.PhieuXuatRequest;
import com.huyen.nhakho.entity.relation.Test;
import com.huyen.nhakho.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Type;
import java.util.List;

@Controller
@RequestMapping(value = "/xuat-kho")
public class XuatKhoController {
    private final PhieuXuatKhoRepo phieuXuatKhoRepo;
    private final PhieuXuatDetailRepo chiPhieuXuatKhoRepo;
    private final VatTuRepo vatTuRepo;

    public XuatKhoController(PhieuXuatKhoRepo phieuXuatKhoRepo, PhieuXuatDetailRepo chiPhieuXuatKhoRepo, VatTuRepo vatTuRepo) {
        this.phieuXuatKhoRepo = phieuXuatKhoRepo;
        this.chiPhieuXuatKhoRepo = chiPhieuXuatKhoRepo;
        this.vatTuRepo = vatTuRepo;
    }

    @GetMapping(value = "/danh-sach-hd-xuat")
    public String hoaDonList(Model model) {
        List<PhieuXuatKho> allPhieuXuat = phieuXuatKhoRepo.findAll();
        model.addAttribute("allPhieuXuat", allPhieuXuat);
        return "content/xuat-kho/hoa-don-xuat-list";
    }

    @GetMapping(value = "/chi-tiet-hoa-don-xuat/{id}")
    public String hoaDonDetail(@PathVariable Long id,Model model) {
        PhieuXuatKho detailXuatKho = phieuXuatKhoRepo.getOne(id);
        List<ChiTietPhieuXuatKho> listItem = chiPhieuXuatKhoRepo.findItemXuat(id);
        model.addAttribute("detailXuatKho", detailXuatKho);
        model.addAttribute("itemPhieuXuat", listItem);
        return "content/xuat-kho/hoa-don-xuat-detail";
    }

    @GetMapping(value = "/add-hoa-don-xuat")
    public String showFormXuat(Model model) {
        model.addAttribute("allVatTu", vatTuRepo.findAll());
        return "content/xuat-kho/form-add-hoa-don-xuat";
    }

    @PostMapping(path = "/add-hoa-don-xuat-submit")
    public String submitAddXuat(PhieuXuatRequest result, Model model) {
//        System.out.println(result.getResult());
//        String json =  "{'itemId':'4','qty':'1'}";
        Type listType = new TypeToken<List<Test>>() {
        }.getType();
        List<Test> test = new Gson().fromJson(result.getResult(), listType);
        PhieuXuatKho phieuXuatKho = new PhieuXuatKho();
        phieuXuatKho.setTenKhach(result.getTenKhachHang());
        phieuXuatKho.setNgayNhap(result.getNgayNhap());
        PhieuXuatKho phieuXuatKhoResult = phieuXuatKhoRepo.save(phieuXuatKho);
        for (Test item : test) {
            ChiTietPhieuXuatKho chitietItem = new ChiTietPhieuXuatKho();
            chitietItem.setOrder(phieuXuatKhoRepo.getOne(phieuXuatKhoResult.getId()));
            chitietItem.setProduct(vatTuRepo.getOne(item.getItemId()));
            chitietItem.setSoLuong(item.getQty());
            chiPhieuXuatKhoRepo.save(chitietItem);
        }
        System.out.println(test);
        return "redirect:/xuat-kho/danh-sach-hd-xuat";
    }

    @GetMapping(path = "delete-hoa-don-xuat/{id}")
    public String deleteHoaDonXuat(@PathVariable Long id) {
        phieuXuatKhoRepo.deleteById(id);
        return "redirect:/xuat-kho/danh-sach-hd-xuat";
    }

}
