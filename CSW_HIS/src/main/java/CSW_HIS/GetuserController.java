package CSW_HIS;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GetuserController {

    @RequestMapping("/getuser")
    public ResponseEntity user(){
    	Connect c = new Connect();
    	ArrayList<User> info = c.GetInfo(String.format("SELECT * FROM users"));
    	return new ResponseEntity<ArrayList<User>>(info, HttpStatus.CREATED);		
	}
       
}