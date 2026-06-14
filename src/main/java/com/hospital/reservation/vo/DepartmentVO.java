package com.hospital.reservation.vo;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentVO {
    private Long departmentNo;
    private String departmentName;
    private String description;
    private LocalDateTime createdAt;
}