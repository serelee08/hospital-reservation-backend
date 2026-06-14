package com.hospital.reservation.service;

import com.hospital.reservation.dao.PatientDAO;
import com.hospital.reservation.vo.PatientVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
         
	private final PatientDAO patientDAO;
	    
	public List<PatientVO> getAllPatients(){
		return patientDAO.findAll();
	}
	
	public PatientVO getPatientById(Long patientNo) {
		return patientDAO.findById(patientNo);
	}
	public int registerPatient(PatientVO patient) {
		return patientDAO.insert(patient);
	}
	public int updatePatient(PatientVO patient) {
		return patientDAO.update(patient);
	}
	public int deletePatient(Long patientNo) {
		return patientDAO.delete(patientNo);
	}
}
