package org.nr.wks.dto;

/**
 * Created by NightRunner on 2017-03-08.
 */
public class AjaxResult implements java.io.Serializable {

    private Integer code = 0;

    private String message ;

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
