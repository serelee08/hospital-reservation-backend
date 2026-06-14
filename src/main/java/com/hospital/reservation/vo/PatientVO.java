 package com.hospital.reservation.vo;

 import lombok.*;
 import java.time.LocalDate;
 import java.time.LocalDateTime;
 
 @Getter
 @Setter
 @Builder
 @NoArgsConstructor
 @AllArgsConstructor

public class PatientVO {
     
	 private Long patientNo;
	 private String memberId;
	 private String password;
	 private String name;
	 private String phone;
	 private LocalDate birthDate;
	 private String gender;
	 private LocalDateTime createdAt;
}
