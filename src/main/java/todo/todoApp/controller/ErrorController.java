package todo.todoApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller("error")
public class ErrorController {

    public ModelAndView handleException(HttpServletRequest request, Exception ex){
        ModelAndView mv = new ModelAndView();

        mv.addObject("exception", ex.getLocalizedMessage());
        mv.addObject("url", request.getRequestURL());

        mv.setViewName("ERROR!!!");
        return mv;
    }
}
