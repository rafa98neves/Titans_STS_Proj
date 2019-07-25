package CSW_HIS;

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
    	
		    	Pattern pattern = Pattern.compile("[a-zA-Z0-9_]*");
		       	Matcher name_matcher = pattern.matcher(name);
		       	
		       	pattern = Pattern.compile("[a-zA-Z0-9\\ _º,-]*");
		       	Matcher address_matcher = pattern.matcher(address);
		       	address_matcher.replaceAll(" ");
		       	
	       		if(name==null || name.equals("")) {
	       			return new ResponseEntity<>("Insert a name please!", HttpStatus.BAD_REQUEST);
	       		}
	       		else if(!name_matcher.matches()) {
	       			return new ResponseEntity<>("Invalid characters in your name!", HttpStatus.BAD_REQUEST);
	       		}
	       		else if(age==null || age.isEmpty()) {
	       			return new ResponseEntity<>("Insert an age please!", HttpStatus.BAD_REQUEST);
	       		} 
	       		else if(address==null || address.equals("")) {
	       			return new ResponseEntity<>("Insert an address please!", HttpStatus.BAD_REQUEST);
	       		}
	       		else if(!address_matcher.matches()) {
	       			return new ResponseEntity<>("Address contains some \"special characters\" (Natalia's orders, sorry!)", HttpStatus.BAD_REQUEST);
	       		}
	       		else if(!age.matches("\\d+")) {
	       			return new ResponseEntity<>("Age must be numeric", HttpStatus.BAD_REQUEST);
	       		}
	       	
			//Easter Egg 2
			if(name.equals("Teapot") || name.equals("teapot") || name.equals("pot") || name.equals("418") || name.equals("tea") || age == 418) {
  				return new ResponseEntity<>("You're in coffee town, can't make tea here. Ask the Coimbra Titans!", HttpStatus.I_AM_A_TEAPOT);
			}	

    			Connect c = new Connect();
    			c.Insert(String.format("INSERT INTO users(name,age,address) VALUES (\"%s\",%d,\"%s\")",name,Integer.parseInt(age), address));
    	    	return new ResponseEntity<String>("Adicionado com sucesso!", HttpStatus.CREATED);
    		}
       
}
