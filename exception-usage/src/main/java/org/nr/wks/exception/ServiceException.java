package org.nr.wks.exception;

public class ServiceException extends RuntimeException {
    private Integer code;

    public ServiceException(Integer code) {
        super();
        this.code = code;
    }

    public ServiceException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public static ServiceException createBeDivideNumberInvalid() {
        return new ServiceException(ErrorCodeConstants.ERROR_BE_DIVIDE_NUMBER_INVALID, " be divide number invalid");
    }

    public static ServiceException createDivideNumberInvalid() {
        return new ServiceException(ErrorCodeConstants.ERROR_DIVIDE_NUMBER_INVALID, "divide number invalid");
    }

    public static ServiceException createResultInvalid() {
        return new ServiceException(ErrorCodeConstants.ERROR_RESULT_INVALID, "result not valid");

    }

    public Integer getCode() {
        return code;
    }
}
