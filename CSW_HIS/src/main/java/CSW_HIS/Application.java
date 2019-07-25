package CSW_HIS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@SpringBootApplication
@Controller
public class Application {
	
	public static void main(String[] args) { 
				SpringApplication.run(Application.class, args);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public RedirectView Init() {
		return new RedirectView("/GreetingBot");
    }
	
	@RequestMapping(value = "/GreetingBot", method = RequestMethod.GET)
    public String HomePage() {
        return "index.html";
    }
}

    
