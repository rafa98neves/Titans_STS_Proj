package CSW_HIS;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public ResponseEntity greeting(@RequestParam(value="name", defaultValue="World") String name) throws Exception{
       	Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
       	Matcher matcher = pattern.matcher(name);
       	if(matcher.matches()) {
       		Greeting greet = new Greeting(counter.incrementAndGet(),String.format(template, name));
       		return new ResponseEntity<Greeting>(greet, HttpStatus.CREATED);
       	}
       	else {
       		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("<html><body><h2>Error Page</h2><div>Status code: <b>400</b></div>\n<div>Exception Message: <b>Invalid input</b></div><body></html>");
       	}
    }
       
}