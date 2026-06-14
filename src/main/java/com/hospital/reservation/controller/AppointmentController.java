package com.hospital.reservation.controller;

import com.hospital.reservation.service.AppointmentService;
import com.hospital.reservation.vo.AppointmentVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<List<AppointmentVO>> getAll() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    @GetMapping("/{appointmentNo}")
    public ResponseEntity<AppointmentVO> getById(@PathVariable Long appointmentNo) {
        return ResponseEntity.ok(appointmentService.getAppointmentById(appointmentNo));
    }

    @GetMapping("/patient/{patientNo}")
    public ResponseEntity<List<AppointmentVO>> getByPatient(@PathVariable Long patientNo) {
        return ResponseEntity.ok(appointmentService.getAppointmentsByPatient(patientNo));
    }

    @GetMapping("/doctor/{doctorNo}")
    public ResponseEntity<List<AppointmentVO>> getByDoctor(@PathVariable Long doctorNo) {
        return ResponseEntity.ok(appointmentService.getAppointmentsByDoctor(doctorNo));
    }

    @PostMapping
    public ResponseEntity<Integer> create(@RequestBody AppointmentVO appointment) {
        return ResponseEntity.ok(appointmentService.createAppointment(appointment));
    }

    @PatchMapping("/{appointmentNo}/status")
    public ResponseEntity<Integer> updateStatus(@PathVariable Long appointmentNo,
                                                 @RequestParam String status) {
        return ResponseEntity.ok(appointmentService.updateStatus(appointmentNo, status));
    }

    @DeleteMapping("/{appointmentNo}")
    public ResponseEntity<Integer> delete(@PathVariable Long appointmentNo) {
        return ResponseEntity.ok(appointmentService.deleteAppointment(appointmentNo));
    }
}