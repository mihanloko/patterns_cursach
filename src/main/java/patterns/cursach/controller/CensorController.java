package patterns.cursach.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import patterns.cursach.Censor;

@Controller
public class CensorController {

    @RequestMapping(value="/test", method= RequestMethod.GET)
    public String test() {
        return "build/index";
    }

}
