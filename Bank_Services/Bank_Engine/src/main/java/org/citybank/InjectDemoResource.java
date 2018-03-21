package org.citybank;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/injectdemo")
public class InjectDemoResource {

	
	@RequestMapping(value="/emp/{type}",method=RequestMethod.GET)
	public String matrixparam(@PathVariable String type, @MatrixVariable("name") String name){
	
		return "Varibale is "+type;
	}
	
}
