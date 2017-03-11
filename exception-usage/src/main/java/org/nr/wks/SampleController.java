package org.nr.wks;

import org.nr.wks.dto.Result;
import org.nr.wks.exception.InvalidResultServiceException;
import org.nr.wks.exception.ServiceError;
import org.nr.wks.exception.ServiceException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //@RestController与@Controller的区别为 所有@RequestMapping 默认加入 @ResponseBody
public class SampleController {

    @RequestMapping("v0/divide/valid")
    public Object v0DivideValid(
            @RequestParam Double dividend,
            @RequestParam Double divisor,
            @RequestParam Double result) {

        Result ajaxResult = new Result();

        try {

            /**
             *现有代码对参数非法的处理方式
             */
            if (dividend.compareTo(0.0D) < 1) {
                ajaxResult.setMessage("dividend invalid");
                ajaxResult.setCode(1);
                return ajaxResult;
            }

            if (divisor.compareTo(0.0D) < 1) {
                ajaxResult.setMessage("divisor invalid");
                ajaxResult.setCode(2);
                return ajaxResult;
            }

            if (!new Double(dividend / divisor).equals(result)) {
                ajaxResult.setMessage("result invalid");
                ajaxResult.setCode(3);
                return ajaxResult;
            }

            ajaxResult.setCode(0);
            ajaxResult.setMessage("result is valid");

        } catch (Exception ex) {
            ajaxResult.setCode(-1);
            ajaxResult.setMessage("internal error");
        }

        return ajaxResult;
    }

    @RequestMapping("v1/divide/valid")
    public Object v1DivideValid(
            @RequestParam Double dividend,
            @RequestParam Double divisor,
            @RequestParam Double result) {

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

}
