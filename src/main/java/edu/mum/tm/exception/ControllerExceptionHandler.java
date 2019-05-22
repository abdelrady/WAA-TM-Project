package edu.mum.tm.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ModelAndView handleError(HttpServletRequest req, RuntimeException exception, Model model) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("error", exception.getMessage());
        mav.addObject("exception", exception);
        mav.addObject("url", req.getRequestURL() + "?" + req.getQueryString());
        req.setAttribute("error", exception.getMessage());
        req.setAttribute("exception", exception);
        req.setAttribute("url", req.getRequestURL() + "?" + req.getQueryString());
        mav.setViewName("error");
        return mav;
    }
}
