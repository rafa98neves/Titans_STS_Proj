package CSW_HIS;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SetuserController {
    private int counter =0;

    @RequestMapping("/setuser")
    public ResponseEntity user(@RequestParam(value="name", defaultValue="World") String name,
    		@RequestParam(value="age", defaultValue="") String age,
    		@RequestParam(value="address", defaultValue="World") String address){
	       		
    			Connect c = new Connect();
    			c.Insert(String.format("INSERT INTO users(id,name,age,address) VALUES (%d,%s,%d,%s)",counter,name,Integer.parseInt(age), address));
	       		/*Connect c = new Connect();
    			c.Insert(String.format("INSERT INTO users(id,name,age,address) VALUES (%d,%s,%d,%s)",counter,name,Integer.parseInt(age), address));*/
    			
	       		return new ResponseEntity("<html><body><h2>User added!!</h2></html>", HttpStatus.CREATED);
	       		
    		}
       
}