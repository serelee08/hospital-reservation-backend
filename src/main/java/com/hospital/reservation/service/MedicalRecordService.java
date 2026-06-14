package com.hospital.reservation.service;

import com.hospital.reservation.dao.MedicalRecordDAO;
import com.hospital.reservation.vo.MedicalRecordVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalRecordService {

    private final MedicalRecordDAO medicalRecordDAO;

    public List<MedicalRecordVO> getAllRecords() {
        return medicalRecordDAO.findAll();
    }

    public MedicalRecordVO getRecordById(Long recordNo) {
        return medicalRecordDAO.findById(recordNo);
    }

    public List<MedicalRecordVO> getRecordsByPatient(Long patientNo) {
        return medicalRecordDAO.findByPatient(patientNo);
    }

    public int createRecord(MedicalRecordVO record) {
        return medicalRecordDAO.insert(record);
    }

    public int updateRecord(MedicalRecordVO record) {
        return medicalRecordDAO.update(record);
    }

    public int deleteRecord(Long recordNo) {
        return medicalRecordDAO.delete(recordNo);
    }
}