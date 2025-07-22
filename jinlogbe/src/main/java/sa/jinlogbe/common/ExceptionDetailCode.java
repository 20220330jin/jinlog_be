package sa.jinlogbe.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionDetailCode {
    SUCCESS_DEFAULT("000", "비즈니스가 정상적으로 완료되었습니다.", "비즈니스 성공");

    private String code;
    private String message;
    private String description;
}
