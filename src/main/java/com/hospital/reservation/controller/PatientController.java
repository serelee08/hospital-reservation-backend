package com.hospital.reservation.controller;

import com.hospital.reservation.service.PatientService;
import com.hospital.reservation.vo.PatientVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {
    
	private final PatientService patientService;
	
	@GetMapping
	public ResponseEntity<List<PatientVO>> getAll(){
		return ResponseEntity.ok(patientService.getAllPatients());
	}
	@GetMapping("/{patientNo}")
	public ResponseEntity<PatientVO> getById(@PathVariable Long paitnetNo){
		return ResponseEntity.ok(patientService.getPatientById(paitnetNo));
	}
	@PostMapping
	public ResponseEntity<Integer> register(@RequestBody PatientVO patient) {
		return ResponseEntity.ok(patientService.registerPatient(patient));
	}
	@PutMapping("/{patientNo}")
	public ResponseEntity<Integer> update(@PathVariable Long patientNo, 
			                                      @RequestBody PatientVO patient) {
        patient.setPatientNo(patientNo);
        return ResponseEntity.ok(patientService.updatePatient(patient));
    }
	
	public ResponseEntity<Integer> delete(@PathVariable Long patientNo){
		return ResponseEntity.ok(patientService.deletePatient(patientNo));
	}
	
}
