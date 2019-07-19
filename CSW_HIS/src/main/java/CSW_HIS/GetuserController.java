package CSW_HIS;

import java.sql.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class GetuserController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/getuser")
    public ResponseEntity user(@RequestParam(value="name", defaultValue="World") String name,
    		@RequestParam(value="age", defaultValue="") String age,
    		@RequestParam(value="address", defaultValue="World") String address){
	       		User newS = new User(counter.incrementAndGet(), name, Integer.parseInt(age), address);
	       		return new ResponseEntity<User>(newS, HttpStatus.CREATED);
    		}
       
}