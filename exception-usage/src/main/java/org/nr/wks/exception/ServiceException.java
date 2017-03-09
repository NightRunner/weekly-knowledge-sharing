package org.nr.wks.exception;

public class ServiceException extends RuntimeException {
    private Integer code;

    private ServiceException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ServiceException(ServiceError serviceError, String message) {
        this(serviceError.getCode(), message);
    }

    public static ServiceException createDividendInvalid() {
        return new ServiceException(ServiceError.DIVIDEND_INVALID, " dividend invalid");
    }

    public static ServiceException createDivisorInvalid() {
        return new ServiceException(ServiceError.DIVISOR_INVALID, "divisor invalid");
    }

    public Integer getCode() {
        return code;
    }
}
