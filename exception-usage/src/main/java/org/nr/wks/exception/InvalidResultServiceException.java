package org.nr.wks.exception;

public class InvalidResultServiceException extends ServiceException {

    public InvalidResultServiceException(String message) {
        super(ServiceError.RESULT_INVALID, message);
    }

}
