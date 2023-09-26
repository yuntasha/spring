package hanium.englishfairytale.exception.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    // Common
    INVALID_REQUEST_PARAMETER(CommonCode.REQUEST_PARAMETER.getCode(), BAD_REQUEST, "잘못된 요청 형식"),
    INVALID_JSON_TYPE(CommonCode.JSON_TYPE.getCode(), BAD_REQUEST, "JSON을 파싱할 수 없는 경우"),
    INVALID_METHOD_TYPE(CommonCode.METHOD_NOT_ALLOWED.getCode(), BAD_REQUEST, "지원하지 않는 HTTP 메서드인 경우"),
    DATA_INTEGRITY_VIOLATE(CommonCode.DATA_INTEGRITY.getCode(), BAD_REQUEST, "데이터 무결성을 위반한 경우"),
    UNAUTHORIZED_OPERATION(CommonCode.UNAUTHORIZED_OPERATION.getCode(), BAD_REQUEST,
            "허가되지 않은 작업을 시도한 경우"),
    TOKEN_VERIFY_FAIL(CommonCode.TOKEN_VERIFY.getCode(), BAD_REQUEST, "토큰 검증에 실패한 경우"),
    FILE_SIZE(CommonCode.FILE_SIZE.getCode(), PAYLOAD_TOO_LARGE, "파일 용량이 초과된 경우"),
    SERVICE_UNAVAILABLE(CommonCode.SERVICE_UNAVAILABLE.getCode(), HttpStatus.SERVICE_UNAVAILABLE,
            "서비스에 문제가 발생한 경우"),

    // Tale
    TALE_NOT_FOUND(TaleCode.NOT_FOUND.getCode(), NOT_FOUND, "존재하지 않는 동화"),
    EXCEED_KEYWORD_LIMIT(TaleCode.KEYWORD_COUNT_LIMIT.getCode(), BAD_REQUEST, "입력 키워드 개수 초과"),
    DUPLICATED_KEYWORD(TaleCode.KEYWORD_DUPLICATED.getCode(), BAD_REQUEST, "중복된 키워드가 있는 경우"),
    IMAGE_PROCESSING_IO(TaleCode.IMAGE_IO.getCode(), BAD_REQUEST, "이미지 처리 중 문제가 발생한 경우"),
    ;

    private final String code;
    private final HttpStatus status;
    private final String message;
}
