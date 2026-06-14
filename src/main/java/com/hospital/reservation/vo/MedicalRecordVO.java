package com.hospital.reservation.vo;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalRecordVO {
    private Long recordNo;
    private Long appointmentNo;
    private Long patientNo;
    private Long doctorNo;
    private String diagnosis;
    private String prescription;
    private LocalDateTime recordDt;
    private LocalDateTime createdAt;
}