package run.micromall.micromall.core.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 响应码
 *
 * @author songhaozhi
 * @since 2021/1/12
 */
@Getter
@AllArgsConstructor
public enum ResponseCode {

    SUCCESS("200", "操作成功"),

    UNAUTHORIZED("401", "非法访问"),

    NOT_PERMISSION("403", "没有权限"),

    NOT_FOUND("404", "你请求的资源不存在"),

    FAIL("500", "操作失败"),

    LOGIN_EXCEPTION("4000", "登陆失败"),

    SYSTEM_EXCEPTION("5000", "系统异常,请联系管理员"),

    PARAMETER_EXCEPTION("5001", "请求参数校验异常"),

    PARAMETER_PARSE_EXCEPTION("5002", "请求参数解析异常"),

    HTTP_MEDIA_TYPE_EXCEPTION("5003", "HTTP Media 类型异常"),

    DATEBASE_EXECUTION_EXCEPTION("5004", "数据库执行语句出现异常"),


    ;
    private final String code;
    private final String msg;

    public static ResponseCode getApiCode(String code) {
        ResponseCode[] responseCodes = ResponseCode.values();
        for (ResponseCode ec : responseCodes) {
            if (code.equals(ec.getCode())) {
                return ec;
            }
        }
        return SUCCESS;
    }
}
