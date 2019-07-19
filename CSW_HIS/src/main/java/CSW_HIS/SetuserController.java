package CSW_HIS;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SetuserController {

    @RequestMapping("/setuser")
    public ResponseEntity user(@RequestParam(value="name", defaultValue="World") String name,
    		@RequestParam(value="age", defaultValue="") String age,
    		@RequestParam(value="address", defaultValue="World") String address){
	       		
    			Connect c = new Connect();
    			c.Insert(String.format("INSERT INTO users(name,age,address) VALUES (%s,%d,%s)",name,Integer.parseInt(age), address));
    			
    			ArrayList<User> info = c.GetInfo(String.format("SELECT * FROM users"));
    	    	return new ResponseEntity<ArrayList<User>>(info, HttpStatus.CREATED);
    		}
       
}