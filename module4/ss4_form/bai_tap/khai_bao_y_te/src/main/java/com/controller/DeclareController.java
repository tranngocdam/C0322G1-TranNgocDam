package com.controller;

import com.model.Declare;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("declare/")
public class DeclareController {
        @RequestMapping(value = "showForm", method = RequestMethod.GET)
        public String showForm(ModelMap model){
            model.addAttribute("declare", new Declare());
            return "declare/create";
        }
        @RequestMapping(value = "/addDeclare", method = RequestMethod.POST)
        public String submit(@ModelAttribute("declare") Declare declare, ModelMap model){
            model.addAttribute("hoTen", declare.getHoTen());
            model.addAttribute("namSinh", declare.getNamSinh());
            model.addAttribute("gioiTinh", declare.getGioiTinh());
            model.addAttribute("quocTich", declare.getQuocTich());
            model.addAttribute("soCMND", declare.getSoCMND());
            model.addAttribute("thongTinDiLai", declare.getThongTinDiChuyen());
            model.addAttribute("soHieuPhuongTien", declare.getSoHieuPhuongTien());
            model.addAttribute("soGhe", declare.getSoGhe());
            model.addAttribute("ngayKhoiHanh", declare.getNgayKhoiHanh());
            model.addAttribute("ngayKetThuc", declare.getNgayKetThuc());
            model.addAttribute("thongTinDiChuyen", declare.getThongTinDiChuyen());
            return "declare/info";
        }
}
