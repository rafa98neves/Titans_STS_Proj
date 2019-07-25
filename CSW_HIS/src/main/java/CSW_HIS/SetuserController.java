package CSW_HIS;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SetuserController {

    @RequestMapping("/setuser")
    public ResponseEntity<?> user(@RequestParam(value="name", required=false) String name,
    		@RequestParam(value="age", required=false) String age,
    		@RequestParam(value="address", required=false) String address){
    
		    	Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		       	Matcher matcher = pattern.matcher(name);
		       	
	       		if(name==null) {
	       			return new ResponseEntity<>("Insert a name please!", HttpStatus.BAD_REQUEST);
	       		}
	       		else if(!matcher.matches()) {
	       			return new ResponseEntity<>("Invalid characters in your name!", HttpStatus.BAD_REQUEST);
	       		}
	       		else if(age==null) {
	       			return new ResponseEntity<>("Insert an age please!", HttpStatus.BAD_REQUEST);
	       		}
	       		else if(address==null) {
	       			return new ResponseEntity<>("Insert an address please!", HttpStatus.BAD_REQUEST);
	       		}
	       		else if(!age.matches("\\d+")) {
	       			return new ResponseEntity<>("Age must be numeric", HttpStatus.BAD_REQUEST);
	       		}

    			Connect c = new Connect();
    			c.Insert(String.format("INSERT INTO users(name,age,address) VALUES (\"%s\",%d,\"%s\")",name,Integer.parseInt(age), address));
    			
    			ArrayList<User> info = c.GetInfo(String.format("SELECT * FROM users"));
    	    	return new ResponseEntity<ArrayList<User>>(info, HttpStatus.CREATED);
    		}
       
}