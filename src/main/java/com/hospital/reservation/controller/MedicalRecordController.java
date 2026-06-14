package com.hospital.reservation.controller;

import com.hospital.reservation.service.MedicalRecordService;
import com.hospital.reservation.vo.MedicalRecordVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/medical-records")
@RequiredArgsConstructor
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;

    @GetMapping
    public ResponseEntity<List<MedicalRecordVO>> getAll() {
        return ResponseEntity.ok(medicalRecordService.getAllRecords());
    }

    @GetMapping("/{recordNo}")
    public ResponseEntity<MedicalRecordVO> getById(@PathVariable Long recordNo) {
        return ResponseEntity.ok(medicalRecordService.getRecordById(recordNo));
    }

    @GetMapping("/patient/{patientNo}")
    public ResponseEntity<List<MedicalRecordVO>> getByPatient(@PathVariable Long patientNo) {
        return ResponseEntity.ok(medicalRecordService.getRecordsByPatient(patientNo));
    }

    @PostMapping
    public ResponseEntity<Integer> create(@RequestBody MedicalRecordVO record) {
        return ResponseEntity.ok(medicalRecordService.createRecord(record));
    }

    @PutMapping("/{recordNo}")
    public ResponseEntity<Integer> update(@PathVariable Long recordNo,
                                           @RequestBody MedicalRecordVO record) {
        record.setRecordNo(recordNo);
        return ResponseEntity.ok(medicalRecordService.updateRecord(record));
    }

    @DeleteMapping("/{recordNo}")
    public ResponseEntity<Integer> delete(@PathVariable Long recordNo) {
        return ResponseEntity.ok(medicalRecordService.deleteRecord(recordNo));
    }
}