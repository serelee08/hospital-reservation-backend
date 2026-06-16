# 🔗 API 명세 (Hospital Reservation System)

> [← README로 돌아가기](./README.md)

전체 REST API 엔드포인트 명세입니다.
Base URL: `http://localhost:8080`

---

## Department (진료과)
| Method | Endpoint | 설명 |
|--------|----------|------|
| GET | `/api/departments` | 전체 조회 |
| GET | `/api/departments/{no}` | 단건 조회 |
| POST | `/api/departments` | 등록 |
| PUT | `/api/departments/{no}` | 수정 |
| DELETE | `/api/departments/{no}` | 삭제 |

## Patient (환자)
| Method | Endpoint | 설명 |
|--------|----------|------|
| GET | `/api/patients` | 전체 조회 |
| GET | `/api/patients/{no}` | 단건 조회 |
| POST | `/api/patients` | 등록 |
| PUT | `/api/patients/{no}` | 수정 |
| DELETE | `/api/patients/{no}` | 삭제 |

## Doctor (의사)
| Method | Endpoint | 설명 |
|--------|----------|------|
| GET | `/api/doctors` | 전체 조회 |
| GET | `/api/doctors/{no}` | 단건 조회 |
| GET | `/api/doctors/department/{departmentNo}` | 진료과별 조회 |
| POST | `/api/doctors` | 등록 |
| PUT | `/api/doctors/{no}` | 수정 |
| DELETE | `/api/doctors/{no}` | 삭제 |

## Appointment (예약)
| Method | Endpoint | 설명 |
|--------|----------|------|
| GET | `/api/appointments` | 전체 조회 |
| GET | `/api/appointments/{no}` | 단건 조회 |
| GET | `/api/appointments/patient/{patientNo}` | 환자별 예약 조회 |
| GET | `/api/appointments/doctor/{doctorNo}` | 의사별 예약 조회 |
| POST | `/api/appointments` | 예약 등록 |
| PATCH | `/api/appointments/{no}/status` | 예약 상태 변경 |
| DELETE | `/api/appointments/{no}` | 예약 취소 |

## Medical Record (진료기록)
| Method | Endpoint | 설명 |
|--------|----------|------|
| GET | `/api/medical-records` | 전체 조회 |
| GET | `/api/medical-records/{no}` | 단건 조회 |
| GET | `/api/medical-records/patient/{patientNo}` | 환자별 진료기록 |
| POST | `/api/medical-records` | 등록 |
| PUT | `/api/medical-records/{no}` | 수정 |
| DELETE | `/api/medical-records/{no}` | 삭제 |
