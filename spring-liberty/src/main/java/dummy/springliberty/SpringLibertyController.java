package dummy.springliberty;

import java.net.InetAddress;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.ui.Model;

@Controller
public class SpringLibertyController {
    @RequestMapping("/")
    public String index(Model model, @RequestHeader("User-Agent") String userAgent) {
        model.addAttribute("userAgent", userAgent);
 
        try {
            InetAddress ia = InetAddress.getLocalHost();
            model.addAttribute("hostName", ia.getHostName());
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return "index";
    }
 
    @RequestMapping("/healthz")
    public String healthz() {
        return "healthz";
    }
}
