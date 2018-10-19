package com.apap.tugas1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.service.JabatanService;
//import com.apap.tugas1.service.InstansiService;
//import com.apap.tugas1.service.PegawaiService;
//import com.apap.tugas1.service.ProvinsiService;

@Controller
public class JabatanController {

	@Autowired
	private JabatanService jabatanService;
	
//	@Autowired
//	private PegawaiService pegawaiService;
//	
//	@Autowired
//	private InstansiService instansiService;
//	
//	@Autowired
//	private ProvinsiService provinsiService;
	
	@RequestMapping(value = "/jabatan/view", method = RequestMethod.GET)
	public String viewJabatan (@RequestParam(value = "idJabatan", required = true) Long idJabatan, Model model) {
		JabatanModel jabatan = jabatanService.getJabatanById(idJabatan).get();
		model.addAttribute("jabatan", jabatan);
		model.addAttribute("headerTitle", "Lihat Jabatan");
		return "viewJabatan";
	}
}
