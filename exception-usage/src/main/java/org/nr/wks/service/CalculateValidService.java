package org.nr.wks.service;

import org.nr.wks.exception.InvalidResultServiceException;
import org.nr.wks.exception.ServiceException;

public class CalculateValidService {
    public void divideValid(Double dividend, Double divisor, Double result) {
        if (dividend.compareTo(0.0D) < 1) {
            throw ServiceException.createDividendInvalid();
        }

        if (divisor.compareTo(0.0D) < 1) {
            throw ServiceException.createDivisorInvalid();
        }

        if (!new Double(dividend / divisor).equals(result)) {
            throw new InvalidResultServiceException("invalid result");
        }
    }

}
