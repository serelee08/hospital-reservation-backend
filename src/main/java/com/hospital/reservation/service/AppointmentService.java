package com.hospital.reservation.service;

import com.hospital.reservation.dao.AppointmentDAO;
import com.hospital.reservation.dao.DoctorDAO;
import com.hospital.reservation.vo.AppointmentVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentDAO appointmentDAO;
    private final DoctorDAO doctorDAO;

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
        // 1. 존재하지 않는 의사인지 확인
        if (doctorDAO.findById(appointment.getDoctorNo()) == null) {
            throw new IllegalArgumentException("존재하지 않는 의사입니다.");
        }
        // 2. 과거 시간으로 예약하는지 확인
        if (appointment.getAppointmentDt().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("과거 시간으로 예약할 수 없습니다.");
        }
        // 3. 같은 의사, 같은 시간에 이미 예약이 있는지 확인 (더블부킹 방지)
        if (appointmentDAO.existsConflict(appointment.getDoctorNo(), appointment.getAppointmentDt())) {
            throw new IllegalStateException("해당 시간에 이미 예약이 있습니다.");
        }

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