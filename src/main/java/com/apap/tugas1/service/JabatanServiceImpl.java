package com.apap.tugas1.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.repository.JabatanDb;

@Service
@Transactional
public class JabatanServiceImpl implements JabatanService {

	@Autowired
	private JabatanDb jabatanDb;
	
	@Override
	public Set<JabatanModel> getAllJabatan() {
		return new HashSet<JabatanModel>(jabatanDb.findAll());
	}

	@Override
	public Optional<JabatanModel> getJabatanById(Long id) {
		return jabatanDb.findById(id);
	}

}