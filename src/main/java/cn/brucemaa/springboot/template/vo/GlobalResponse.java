package cn.brucemaa.springboot.template.vo;

import cn.brucemaa.springboot.template.constant.ResponseStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.var;

/**
 * projectName:spring-boot-template
 * cn.brucemaa.springboot.template.vo
 * 统一封装响应对象
 * @author Bruce Maa
 * @since 2019/12/5.13:18
 */
@Getter
@Setter
public class GlobalResponse {

    private Integer code;

    private String msg;

    private Object body;

    public GlobalResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public GlobalResponse(ResponseStatus responseStatus) {
        this.code = responseStatus.getCode();
        this.msg = responseStatus.getMsg();
    }

    public static GlobalResponse ok(Object body) {
        var response = new GlobalResponse(ResponseStatus.OK);
        response.setBody(body);
        return response;
    }

    public static GlobalResponse ok() {
        return new GlobalResponse(ResponseStatus.OK);
    }

    public static GlobalResponse error(String msg) {
        var response  = new GlobalResponse(ResponseStatus.INTERNAL_SERVER_ERROR);
        response.setMsg(msg);
        return response;
    }

    public static GlobalResponse error() {
        return new GlobalResponse(ResponseStatus.INTERNAL_SERVER_ERROR);
    }
}
