package com.zixuan007.admin.pojo;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

/**
 * @author zixuan007
 */
@ToString
@Getter
public enum ResultStatus {

    SUCCESS(HttpStatus.OK, 200, "ok"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, 400, "BAD_REQUEST"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 500, "internal server error"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, 401, "Unauthorized");

    ResultStatus(HttpStatus httpStatus, int code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    /**
     * 返回的Http状态码
     */
    private HttpStatus httpStatus;

    /**
     * 业务异常码
     */
    private Integer code;

    /**
     * 业务异常描述信息
     */
    private String message;


}
