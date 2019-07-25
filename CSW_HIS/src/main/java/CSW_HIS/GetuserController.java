package CSW_HIS;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class GetuserController {

    @RequestMapping("/getuser")
    public ResponseEntity<?> getUsers( 
    		@RequestParam(value="name", defaultValue="") String name,
    		@RequestParam(value="age", defaultValue="") String age,
    		@RequestParam(value="address", defaultValue="") String address){

   		if(!Numeric(age) && age.compareTo("")!=0) {
   			return new ResponseEntity<>("Age must be numeric", HttpStatus.BAD_REQUEST);
   		}
   		
    	ArrayList<User> info;
    	Connect c = new Connect();
    	if(name.equals("") && age.isEmpty() && address.equals("")) {
    		info = c.GetInfo(String.format("SELECT * FROM users"));
    	}else {
    		boolean increment_and = false;
    		String req = "SELECT * FROM users WHERE ";
        	if(!age.isEmpty()) {
        		req = req.concat(String.format("age=%s",age));
        		increment_and = true;
        	}
        	if(!address.equals("")) {
        		if(increment_and) req = req.concat(String.format(" AND address LIKE \"%s\"",address));
        		else req = req.concat(String.format("address LIKE \"%s\"",address));
        		increment_and = true;
        	}
        	if(!name.equals("")){
        		if(increment_and) req = req.concat(String.format(" AND name LIKE \"%s\"",name));
        		else req = req.concat(String.format("name LIKE \"%s\"",name));
        	}
    		info = c.GetInfo(req);
    	}
    	return new ResponseEntity<ArrayList<User>>(info, HttpStatus.OK);		
	}
    
    public boolean Numeric(String string) {        
        boolean numeric = true;
        numeric = string.matches("-?\\d+(\\.\\d+)?");
        if(numeric)
            return true;
        else
            return false;
    
    }
}