package org.nr.wks.exception;

public enum ServiceError {

    /**
     * 被除数非法
     */
    DIVIDEND_INVALID(1),

    /**
     * 除数非法
     */
    DIVISOR_INVALID(2),

    /**
     * 结果非法
     */
    RESULT_INVALID(3),

    /**
     * 非预期错误,例如 NullPointException
     */
    INTERNAL_ERROR(-1);

    /**
     * 错误码
     */
    private int code;

    ServiceError(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
