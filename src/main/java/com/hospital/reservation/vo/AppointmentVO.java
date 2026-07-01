package com.hospital.reservation.vo;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentVO {
      
	private Long appointmentNo;
	private Long patientNo;
	private Long doctorNo;
	private LocalDateTime appointmentDt;
	private String status;
	private String memo;
	private LocalDateTime createdAt;
	
	// JOIN 결과 담는 표시용 DTO
	private String patientName;
	private String doctorName;
	private String departmentName;
}
