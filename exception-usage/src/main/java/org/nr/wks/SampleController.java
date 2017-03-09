package org.nr.wks;

import org.nr.wks.dto.Result;
import org.nr.wks.exception.InvalidResultServiceException;
import org.nr.wks.exception.ServiceError;
import org.nr.wks.exception.ServiceException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("api") //与@Controller的区别为 所有@RequestMapping 默认加入 @ResponseBody
public class SampleController {

    @RequestMapping("/api/v1/divide/valid")
    public Object v1DivideValid(
            @RequestParam("dividend") Double dividend,
            @RequestParam("divisor") Double divisor,
            @RequestParam("result") Double result) {

        Result ajaxResult = new Result();

        try {

            /**
             * 抛出特定异常,统一在catch块中处理
             */
            if (dividend.compareTo(0.0D) < 1) {
                //第一种异常创建方法
                throw ServiceException.createDividendInvalid();
            }

            if (divisor.compareTo(0.0D) < 1) {
                throw ServiceException.createDivisorInvalid();
            }

            if (!new Double(dividend / divisor).equals(result)) {
                //第二种异常创建方法
                throw new InvalidResultServiceException("invalid result");
            }

            ajaxResult.setCode(0);
            ajaxResult.setMessage("result is valid");

        } catch (ServiceException ex) {
            //统一处理异常
            ajaxResult.setCode(ex.getCode());
            ajaxResult.setMessage(ex.getMessage());

        } catch (Exception ex) {
            ajaxResult.setCode(ServiceError.INTERNAL_ERROR.getCode());
            ajaxResult.setMessage(ex.getMessage());
        }

        return ajaxResult;
    }

    @RequestMapping("/api/v2/divide/valid")
    public Object v2DivideValid(
            @RequestParam("dividend") Double dividend,
            @RequestParam("divisor") Double divisor,
            @RequestParam("result") Double result) {

        Result ajaxResult = new Result();

        try {

            divideValid(dividend, divisor, result);

            ajaxResult.setCode(0);
            ajaxResult.setMessage("result is valid");

        } catch (ServiceException ex) {
            //统一处理异常
            ajaxResult.setCode(ex.getCode());
            ajaxResult.setMessage(ex.getMessage());

        } catch (Exception ex) {
            ajaxResult.setCode(ServiceError.INTERNAL_ERROR.getCode());
            ajaxResult.setMessage(ex.getMessage());
        }

        return ajaxResult;
    }

    @RequestMapping("/api/v3/divide/valid")
    public Object v3DivideValid(
            @RequestParam("dividend") Double dividend,
            @RequestParam("divisor") Double divisor,
            @RequestParam("result") Double result) {

        Result ajaxResult = new Result();

        try {

            divideValid(dividend, divisor, result);

            ajaxResult.setCode(0);
            ajaxResult.setMessage("result is valid");

        } catch (ServiceException ex) {
            //统一处理异常
            ajaxResult.setCode(ex.getCode());
            ajaxResult.setMessage(ex.getMessage());

        } catch (Exception ex) {
            ajaxResult.setCode(ServiceError.INTERNAL_ERROR.getCode());
            ajaxResult.setMessage(ex.getMessage());
        }

        return ajaxResult;
    }

    private void divideValid(Double dividend, Double divisor, Double result) {
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
