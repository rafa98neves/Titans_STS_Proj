package CSW_HIS;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GetuserController {

    @RequestMapping("/getuser")
    public ResponseEntity<ArrayList<User>> user( 
    		@RequestParam(value="name", defaultValue="") String name,
    		@RequestParam(value="age", defaultValue="") String age,
    		@RequestParam(value="address", defaultValue="") String address){
    	
    	ArrayList<User> info;
    	Connect c = new Connect();
    	
    	if(!name.equals("")) info = c.GetInfo(String.format("SELECT * FROM users WHERE name like %s",name));
    	else if(!age.isEmpty()) info = c.GetInfo(String.format("SELECT * FROM users WHERE age=%s",age));
    	else if(!address.equals("")) info = c.GetInfo(String.format("SELECT * FROM users WHERE address like %s",address));
    	else info = c.GetInfo(String.format("SELECT * FROM users"));
    	
    	return new ResponseEntity<ArrayList<User>>(info, HttpStatus.CREATED);		
	}
       
}