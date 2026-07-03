package com.hospital.reservation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

// 프로젝트 전체 컨트롤러에서 발생하는 예외를 한 곳에서 잡아서
// 일관된 형태(JSON: { "error": "메시지" })로 응답해주는 전역 예외 처리기.
// Service 계층에서 IllegalArgumentException / IllegalStateException을 던지면
// 여기서 자동으로 가로채서 적절한 HTTP 상태코드로 변환한다.
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 잘못된 요청 (예: 존재하지 않는 의사, 과거 시간 예약 등) -> 400 Bad Request
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleBadRequest(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
    }

    // 상태 충돌 (예: 더블부킹 - 이미 예약된 시간) -> 409 Conflict
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Map<String, String>> handleConflict(IllegalStateException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("error", e.getMessage()));
    }

    // 위 두 가지로 분류되지 않는 예상치 못한 모든 예외 -> 500 Internal Server Error
    // 실제 예외 내용을 클라이언트에 그대로 노출하지 않고 일반 메시지로 응답한다.
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGeneral(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("error", "서버 오류가 발생했습니다."));
    }
}