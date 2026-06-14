package com.hospital.reservation.dao;

import com.hospital.reservation.vo.PatientVO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface PatientDAO {
     
	List<PatientVO> findAll();
	PatientVO findById(Long patientNo);
	int insert(PatientVO patient);
	int update(PatientVO patient);
	int delete(Long patientNo);
}
