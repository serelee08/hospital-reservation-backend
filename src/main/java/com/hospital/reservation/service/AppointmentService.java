package com.hospital.reservation.service;

import com.hospital.reservation.dao.AppointmentDAO;
import com.hospital.reservation.vo.AppointmentVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentDAO appointmentDAO;

    public List<AppointmentVO> getAllAppointments() {
        return appointmentDAO.findAll();
    }

    public AppointmentVO getAppointmentById(Long appointmentNo) {
        return appointmentDAO.findById(appointmentNo);
    }

    public List<AppointmentVO> getAppointmentsByPatient(Long patientNo) {
        return appointmentDAO.findByPatient(patientNo);
    }

    public List<AppointmentVO> getAppointmentsByDoctor(Long doctorNo) {
        return appointmentDAO.findByDoctor(doctorNo);
    }

    public int createAppointment(AppointmentVO appointment) {
        appointment.setStatus("예약");
        return appointmentDAO.insert(appointment);
    }

    public int updateStatus(Long appointmentNo, String status) {
        AppointmentVO appointment = AppointmentVO.builder()
                .appointmentNo(appointmentNo)
                .status(status)
                .build();
        return appointmentDAO.updateStatus(appointment);
    }

    public int deleteAppointment(Long appointmentNo) {
        return appointmentDAO.delete(appointmentNo);
    }
}