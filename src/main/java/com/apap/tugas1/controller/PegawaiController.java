package com.apap.tugas1.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.service.InstansiService;
import com.apap.tugas1.service.JabatanService;
import com.apap.tugas1.service.PegawaiService;
//import com.apap.tugas1.service.ProvinsiService;

@Controller
public class PegawaiController {

	@Autowired
	private PegawaiService pegawaiService;	
	
	@Autowired
	private JabatanService jabatanService;
	
	@Autowired
	private InstansiService instansiService;
	
//	@Autowired
//	private ProvinsiService provinsiService;
	
	@RequestMapping("/")
	public String index(Model model) {
		Set<JabatanModel> listJabatan = jabatanService.getAllJabatan();
		model.addAttribute("listJabatan", listJabatan);
		
		Set<InstansiModel> listInstansi = instansiService.getAllInstansi();
		model.addAttribute("listInstansi", listInstansi);
		model.addAttribute("headerTitle", "Home");
		return "index";
	}
	
	@RequestMapping("/pegawai")
	public String viewPegawai (@RequestParam String nip, Model model) {
		PegawaiModel pegawai = pegawaiService.getPegawaiByNip(nip);
		model.addAttribute("pegawai", pegawai);
		
		InstansiModel instansiPegawai = pegawai.getInstansi();
		String namaInstansiPegawai = instansiPegawai.getNama() + " - " + instansiPegawai.getProvinsi().getNama();
		model.addAttribute("namaInstansiPegawai", namaInstansiPegawai);
		
		Set<JabatanModel> setJabatan = pegawai.getJabatan();
		model.addAttribute("setJabatan", setJabatan);
		
		String gaji = "Rp" + Integer.toString(pegawai.getGaji());
		model.addAttribute("gaji", gaji);
		model.addAttribute("headerTitle", "Data Pegawai");
		return "viewPegawai";
	}
	
	@RequestMapping("/pegawai/termuda-tertua")
	public String viewPegawai (@RequestParam Long idInstansi, Model model) {
		List<PegawaiModel> listPegawai = pegawaiService.getTuaMudaInstansi(instansiService.getInstansiById(idInstansi).get());
		model.addAttribute("pegawaiTertua", listPegawai.get(0));
		model.addAttribute("pegawaiTermuda", listPegawai.get(listPegawai.size()-1));
		return "viewPegawaiTuaMuda";
	}
}
