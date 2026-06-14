package com.hospital.reservation.dao;

import com.hospital.reservation.vo.AppointmentVO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface AppointmentDAO {

	List<AppointmentVO> findAll();
	AppointmentVO findById(Long appointmentNO);
	List<AppointmentVO> findByPatient(Long patientNo);
	List<AppointmentVO>findByDoctor(Long doctorNo);
	int insert(AppointmentVO appointment);
	int updateStatus(AppointmentVO appointment);
	int delete(Long appointmentNo);
}
