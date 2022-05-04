package hello.springboard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;


@Controller
public class HomeController {

    private static final Logger Logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/home.do")
    public String home(Locale locale, Model model) {
        Logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "home";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "ok";
    }
}
