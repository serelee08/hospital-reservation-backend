package com.hospital.reservation.dao;

import com.hospital.reservation.vo.MedicalRecordVO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface MedicalRecordDAO {
    List<MedicalRecordVO> findAll();
    MedicalRecordVO findById(Long recordNo);
    List<MedicalRecordVO> findByPatient(Long patientNo);
    int insert(MedicalRecordVO record);
    int update(MedicalRecordVO record);
    int delete(Long recordNo);
}