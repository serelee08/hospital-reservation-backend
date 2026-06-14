package com.hospital.reservation.service;

import com.hospital.reservation.dao.DoctorDAO;
import com.hospital.reservation.vo.DoctorVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorDAO doctorDAO;

    public List<DoctorVO> getAllDoctors() {
        return doctorDAO.findAll();
    }

    public DoctorVO getDoctorById(Long doctorNo) {
        return doctorDAO.findById(doctorNo);
    }

    public List<DoctorVO> getDoctorsByDepartment(Long departmentNo) {
        return doctorDAO.findByDepartment(departmentNo);
    }

    public int createDoctor(DoctorVO doctor) {
        return doctorDAO.insert(doctor);
    }

    public int updateDoctor(DoctorVO doctor) {
        return doctorDAO.update(doctor);
    }

    public int deleteDoctor(Long doctorNo) {
        return doctorDAO.delete(doctorNo);
    }
}