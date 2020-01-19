package patterns.cursach.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import patterns.cursach.Censor;

@Controller
public class CensorController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String page(@RequestParam(name = "text", required = false, defaultValue = "") String text, Model model) {
        model.addAttribute("text", text);
        return "index";
    }

    @RequestMapping(value = "/handle", method = RequestMethod.POST)
    public String handle(
            @RequestParam(name = "source", required = false, defaultValue = "") String text,
            @RequestParam(name = "algorithm", required = false, defaultValue = "0") int algorithm,
            @RequestParam(name = "strategy", required = false, defaultValue = "0") int strategy,
            RedirectAttributes attributes) {

        attributes.addAttribute("text", "hello there");
        return "redirect:test";
    }
}
