package com.ajie.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ajie
 * @date 2023/5/20
 * @description:
 */
@Data
public class AjieResult {
    @ApiModelProperty(value = "是否成功")
    private Boolean success;
    @ApiModelProperty(value = "返回状态码")
    private Integer code;
    @ApiModelProperty(value = "返回消息")
    private String msg;
    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<>();

    public AjieResult() {
    }

    public static AjieResult okResult() {
        AjieResult result = new AjieResult();
        result.setSuccess(true);
        result.setCode(ResultCode.SUCCESS);
        result.setMsg("success");
        return result;
    }

    public static AjieResult errorResult() {
        AjieResult result = new AjieResult();
        result.setSuccess(false);
        result.setCode(ResultCode.ERROR);
        result.setMsg("error");
        return result;
    }

    public AjieResult success(Boolean success) {
        this.success = success;
        return this;
    }

    public AjieResult code(Integer code) {
        this.code = code;
        return this;
    }

    public AjieResult msg(String msg) {
        this.msg = msg;
        return this;
    }

    public AjieResult data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }
}
