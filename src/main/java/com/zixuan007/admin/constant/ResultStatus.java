package com.zixuan007.admin.constant;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

/**
 * @author zixuan007
 */
@ToString
@Getter
public enum ResultStatus {

    // 默认Http状态码
    SUCCESS(HttpStatus.OK, 200, "ok"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, 400, "错误的请求"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 500, "服务器内部错误"),
    NOT_MODIFIED(HttpStatus.NOT_MODIFIED, 304, "数据未删除"),

    // 自定义状态码
    LOGIN_ERROR(HttpStatus.OK, 1001, "您还未登录或登录失效，请重新登录！"),
    NOT_HAVE_PRIVILEGES(HttpStatus.OK, 1002, "对不起，您没有权限哦!"),
    ;

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
