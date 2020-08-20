package com.huyen.nhakho.controller;

import com.huyen.nhakho.entity.HangHoa;
import com.huyen.nhakho.entity.LoaiHang;
import com.huyen.nhakho.entity.NhaCungCap;
import com.huyen.nhakho.entity.VatTuRequest;
import com.huyen.nhakho.repository.LoaiHangRepo;
import com.huyen.nhakho.repository.NhaCungCapRepo;
import com.huyen.nhakho.repository.VatTuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "/hang-hoa")
public class HangHoaController {

    private final NhaCungCapRepo nccRepo;
    private final VatTuRepo vatTuRepo;
    private final LoaiHangRepo loaiHangRepo;

    @Autowired
    public HangHoaController(NhaCungCapRepo repo, VatTuRepo vatTuRepo, LoaiHangRepo loaiHangRepo) {
        this.nccRepo = repo;
        this.vatTuRepo = vatTuRepo;
        this.loaiHangRepo = loaiHangRepo;
    }

    @GetMapping("/vat-tu")
    public String vattu(Model model) {
        model.addAttribute("allVatTu", vatTuRepo.findAll());
        model.addAttribute("allLoaiHang", loaiHangRepo.findAll());
        return "content/hang-hoa/vat-tu-list";
    }

    @GetMapping("/ncc")
    public String ncc(Model model) {
        model.addAttribute("allNCC", nccRepo.findAll());
        return "content/hang-hoa/ncc-list";
    }

    @PostMapping(path = "/add-ncc", consumes = "application/x-www-form-urlencoded")
    public String addNhaCungCap(NhaCungCap ncc) {
        nccRepo.save(ncc);
        return "redirect:/hang-hoa/ncc";
    }

    @PostMapping(path = "/add-vat-tu", consumes = "application/x-www-form-urlencoded")
    public String addVatTu(VatTuRequest vatTuRequest) {
        try {
           LoaiHang loaiHang = loaiHangRepo.getOne(Long.valueOf(vatTuRequest.getLoaiHang()));
           HangHoa hangHoa = new HangHoa();
           hangHoa.setTenHangHoa(vatTuRequest.getTenHangHoa());
           hangHoa.setDonGia(vatTuRequest.getDonGia());
           hangHoa.setLoaiHang(loaiHang);
           hangHoa.setGhiChu(vatTuRequest.getGhiChu());
           hangHoa.setSoLuong(vatTuRequest.getSoLuong());
           vatTuRepo.save(hangHoa);
        } catch (Exception e) {
            System.out.println(e);
        }
        return "redirect:/hang-hoa/vat-tu";
    }

    @GetMapping(path = "/delete-vat-tu/{id}")
    public String deleteVatTu(@PathVariable Long id){
        try {
            vatTuRepo.deleteById(id);
        }catch (Exception e){
            System.out.println(e);
        }finally {
            return "redirect:/hang-hoa/vat-tu";
        }
    }
    @GetMapping(path = "/delete-ncc/{id}")
    public String deleteNhaCungCap(@PathVariable Long id){
        try {
            nccRepo.deleteById(id);
        }catch (Exception e){
            System.out.println(e);
        }finally {
            return "redirect:/hang-hoa/ncc";
        }
    }

}
