package com.hospital.reservation.dao;

import com.hospital.reservation.vo.AppointmentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.time.LocalDateTime;
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

	// 같은 의사, 같은 시간에 이미 예약(취소 제외)이 있는지 확인 -> 더블부킹 방지용
	boolean existsConflict(@Param("doctorNo") Long doctorNo, @Param("appointmentDt") LocalDateTime appointmentDt);
}