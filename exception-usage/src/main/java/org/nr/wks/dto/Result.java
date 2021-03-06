package org.nr.wks.dto;

/**
 * Created by NightRunner on 2017-03-08.
 */
public class Result implements java.io.Serializable {

    /**
     * 为0为成功, 其他为错误
     */
    private Integer code = 0;

    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
