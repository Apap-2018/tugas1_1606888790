package com.apap.tugas1.service;

import java.util.Optional;
import java.util.Set;

import com.apap.tugas1.model.InstansiModel;

public interface InstansiService {

	Optional<InstansiModel> getInstansiById(Long id);

	Set<InstansiModel> getAllInstansi();

}
