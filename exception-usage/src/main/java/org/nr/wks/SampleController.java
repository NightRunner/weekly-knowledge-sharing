package org.nr.wks;

import org.nr.wks.dto.AjaxResult;
import org.nr.wks.exception.ServiceException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @RequestMapping("/api/divide/valid")
    public Object plusValid(
            @RequestParam("number1") Double number1,
            @RequestParam("number2") Double number2,
            @RequestParam("result") Double result) {
        AjaxResult ajaxResult = new AjaxResult();
        try {
            if (number1.compareTo(0.0D) < 1) {
                throw ServiceException.createBeDivideNumberInvalid();
            }

            if (number2.compareTo(0.0D) < 1) {
                throw ServiceException.createDivideNumberInvalid();
            }

            if (!new Double(number1 / number2).equals(result)) {
                throw ServiceException.createResultInvalid();
            }

            ajaxResult.setCode(0);
            ajaxResult.setMessage("result is valid");

        } catch (ServiceException ex) {
            ajaxResult.setCode(ex.getCode());
            ajaxResult.setMessage(ex.getMessage());
        } catch (Exception ex) {
            ajaxResult.setCode(-1);
            ajaxResult.setMessage(ex.getMessage());
        }

        return ajaxResult;
    }

}
