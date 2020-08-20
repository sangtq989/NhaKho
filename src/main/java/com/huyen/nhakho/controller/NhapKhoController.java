package com.huyen.nhakho.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huyen.nhakho.entity.Kho;
import com.huyen.nhakho.entity.PhieuNhapKho;
import com.huyen.nhakho.entity.PhieuXuatKho;
import com.huyen.nhakho.entity.relation.*;
import com.huyen.nhakho.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.*;

@Controller
@RequestMapping(value = "/nhap-kho")
public class NhapKhoController {

    private final KhoRepo khoRepo;
    private final PhieuNhapKhoRepo phieuNhapKhoRepo;
    private final PhieuXuatKhoRepo phieuXuatKhoRepo;
    private final PhieuNhapDetailRepo chiTietPhieuNhapKhoRepo;
    private final PhieuXuatDetailRepo chiPhieuXuatKhoRepo;
    private final NhaCungCapRepo nccRepo;
    private final VatTuRepo vatTuRepo;

    @Autowired
    public NhapKhoController(KhoRepo repo, PhieuNhapKhoRepo phieuNhapKhoRepo, PhieuXuatKhoRepo phieuXuatKhoRepo, PhieuNhapDetailRepo chiTietPhieuNhapKho, PhieuXuatDetailRepo chiPhieuXuatKhoRepo, NhaCungCapRepo nccRepo, VatTuRepo vatTuRepo) {
        this.khoRepo = repo;
        this.phieuNhapKhoRepo = phieuNhapKhoRepo;
        this.phieuXuatKhoRepo = phieuXuatKhoRepo;
        this.chiTietPhieuNhapKhoRepo = chiTietPhieuNhapKho;
        this.chiPhieuXuatKhoRepo = chiPhieuXuatKhoRepo;
        this.nccRepo = nccRepo;
        this.vatTuRepo = vatTuRepo;
    }

    @GetMapping(value = "/kho-hang")
    public String khoHang(Model model) {
        Iterable<Kho> khos = khoRepo.findAll();
        model.addAttribute("allKho", khos);
        return "content/nhap-kho/kho-hang";
    }

    @GetMapping(value = "/hoa-don-nhap")
    public String hoaDonNhap(Model model) {
        List<PhieuNhapKho> phieuNhapKhos = (List<PhieuNhapKho>) phieuNhapKhoRepo.findAll();

        model.addAttribute("phieuNhapList", phieuNhapKhos);
        return "content/nhap-kho/hoa-don-nhap";
    }

    @GetMapping(value = "/chi-tiet-hoa-don/{id}")
    public String chiTiet(@PathVariable Long id, Model model) {
        System.out.println(chiTietPhieuNhapKhoRepo.findHangHoa(id));
        model.addAttribute("detailNhapKho", phieuNhapKhoRepo.getOne(id));
        model.addAttribute("itemPhieuNhap", chiTietPhieuNhapKhoRepo.findHangHoa(id));
        return "content/nhap-kho/hoa-don-detail";
    }

    @GetMapping(value = "/add-hoa-don")
    public String showForm(Model model) {
        model.addAttribute("allKho", khoRepo.findAll());
        model.addAttribute("allNCC", nccRepo.findAll());
        model.addAttribute("allVatTu", vatTuRepo.findAll());
        return "content/nhap-kho/form-add-hoa-don-nhap";
    }


    @PostMapping(path = "/add-hoa-don-submit")
    public String submitAddNhap(PhieuNhapRequest result, Model model) {
//        System.out.println(result.getResult());
//        String json =  "{'itemId':'4','qty':'1'}";
        Type listType = new TypeToken<List<Test>>() {
        }.getType();
        List<Test> test = new Gson().fromJson(result.getResult(), listType);
        PhieuNhapKho phieuNhap = new PhieuNhapKho();
        phieuNhap.setKho(khoRepo.getOne(result.getKho()));
        phieuNhap.setNhaCungCap(nccRepo.getOne(result.getNhaCungCap()));
        phieuNhap.setNgayLap(new Date().toString());
        PhieuNhapKho phieunhapResult = phieuNhapKhoRepo.save(phieuNhap);
        for (Test item : test) {
            ChiTietPhieuNhapKho chitietItem = new ChiTietPhieuNhapKho();
            chitietItem.setOrder(phieuNhapKhoRepo.getOne(phieunhapResult.getId()));
            chitietItem.setProduct(vatTuRepo.getOne(item.getItemId()));
            chitietItem.setSoLuong(item.getQty());
            chiTietPhieuNhapKhoRepo.save(chitietItem);
        }
        System.out.println(test);
        return "redirect:/nhap-kho/hoa-don-nhap";
    }

    @PostMapping(path = "/add-kho", consumes = "application/x-www-form-urlencoded")
    public String addKho(Kho kho, Model model) {
        khoRepo.save(kho);
        return "redirect:/nhap-kho/kho-hang";
    }

    @GetMapping(value = "/delete-kho-hang/{id}")
    public String deleteKhoHang(@PathVariable long id) {
        khoRepo.deleteById(id);
        return "redirect:/nhap-kho/kho-hang";
    }
    @GetMapping(value = "/delete-hoa-don-nhap/{id}")
    public String deleteHoaDonNhap(@PathVariable long id) {
        phieuNhapKhoRepo.deleteById(id);
        return "redirect:/nhap-kho/hoa-don-nhap";
    }
}
