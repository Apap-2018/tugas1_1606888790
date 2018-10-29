package com.apap.tugas1.service;

import java.util.Optional;
import java.util.Set;

import com.apap.tugas1.model.JabatanModel;

public interface JabatanService {

	Set<JabatanModel> getAllJabatan();

	Optional<JabatanModel> getJabatanById(Long id);

	void addJabatan(JabatanModel jabatan);

	void update(Long id, JabatanModel jabatanBaru);

	void deleteById(Long id);

}
