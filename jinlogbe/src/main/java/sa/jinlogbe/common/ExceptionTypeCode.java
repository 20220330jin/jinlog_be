package sa.jinlogbe.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionTypeCode {
    SUCCESS("E0", "비즈니스가 정상적으로 완료되었습니다.", "비즈니스 성공"),
    STATUS("E1", "부적절한 비즈니스 상태입니다.", "특정 비즈니스 정책에 대한 validate 실패 및 예외적 상황"),
    NODATA("E2", "데이터가 삭제되었거나 존재하지 않습니다.", "데이터 없음 예외"),
    FILE("E3", "파일 관련 오류가 발생했습니다.", "파일 관련 예외"),
    PARAM("E4", "입력된 파라미터가 부적절합니다.", "파라미터 정합성 관련 예외"),
    AUTH("E6", "부적절한 접근입니다.", "인증/인가 관련 예외"),
    DUP("E7", "중복된 데이터가 이미 존재합니다.", "중복 데이터 존재 예외")
    ;

    private String code;
    private String message;
    private String description;
}
