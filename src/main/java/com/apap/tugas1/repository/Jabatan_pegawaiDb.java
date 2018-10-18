package com.apap.tugas1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.tugas1.model.Jabatan_pegawaiModel;

@Repository
public interface Jabatan_pegawaiDb extends JpaRepository<Jabatan_pegawaiModel, Long>{

}
