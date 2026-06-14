package com.hospital.reservation.controller;

import com.hospital.reservation.service.DoctorService;
import com.hospital.reservation.vo.DoctorVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<DoctorVO>> getAll() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @GetMapping("/{doctorNo}")
    public ResponseEntity<DoctorVO> getById(@PathVariable Long doctorNo) {
        return ResponseEntity.ok(doctorService.getDoctorById(doctorNo));
    }

    @GetMapping("/department/{departmentNo}")
    public ResponseEntity<List<DoctorVO>> getByDepartment(@PathVariable Long departmentNo) {
        return ResponseEntity.ok(doctorService.getDoctorsByDepartment(departmentNo));
    }

    @PostMapping
    public ResponseEntity<Integer> create(@RequestBody DoctorVO doctor) {
        return ResponseEntity.ok(doctorService.createDoctor(doctor));
    }

    @PutMapping("/{doctorNo}")
    public ResponseEntity<Integer> update(@PathVariable Long doctorNo,
                                           @RequestBody DoctorVO doctor) {
        doctor.setDoctorNo(doctorNo);
        return ResponseEntity.ok(doctorService.updateDoctor(doctor));
    }

    @DeleteMapping("/{doctorNo}")
    public ResponseEntity<Integer> delete(@PathVariable Long doctorNo) {
        return ResponseEntity.ok(doctorService.deleteDoctor(doctorNo));
    }
}