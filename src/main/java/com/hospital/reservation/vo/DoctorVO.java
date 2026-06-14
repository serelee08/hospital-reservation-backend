package com.hospital.reservation.vo;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorVO {
    
	private Long doctorNo;
	private String name;
	private String specialty;
	private String phone;
	private Long departmentNo;
	private LocalDateTime createdAt;
}
