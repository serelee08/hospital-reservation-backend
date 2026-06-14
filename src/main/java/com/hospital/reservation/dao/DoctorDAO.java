package com.hospital.reservation.dao;

import com.hospital.reservation.vo.DoctorVO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface DoctorDAO {
    List<DoctorVO> findAll();
    DoctorVO findById(Long doctorNo);
    List<DoctorVO> findByDepartment(Long departmentNo);
    int insert(DoctorVO doctor);
    int update(DoctorVO doctor);
    int delete(Long doctorNo);
}