package com.example.demo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/yosr")
public class firstController {
	
	
	@RequestMapping(value="/demo",method = RequestMethod.GET)
    public String greeting() {
      
        return "greeting";
    }
	
	@RequestMapping(value="/demo",method = RequestMethod.POST)
	public String sayHello(@RequestBody RequestYosr yosr)
	{
		
		return "hello " + yosr.getName();
		
	}
	@RequestMapping(value="/calculatrice",method = RequestMethod.POST)
	public String input (@RequestBody CalculatriceYosr yosr2)
	{
		
		switch(yosr2.getOperation())
		{
		case "+" :
			return Float.toString( yosr2.getNum1()+yosr2.getNum2());
			 
		case "*" : 
			return Float.toString(yosr2.getNum1()*yosr2.getNum2());
		case "-" :
			return Float.toString(yosr2.getNum1()-yosr2.getNum2());
		case "/" :
		{ 	
			if (yosr2.getNum2()== 0)
				return "impossible" ;
			else
			return Float.toString(yosr2.getNum1()/yosr2.getNum2()); 
		}
		default :
			return  "operation invalide"; 
			
		}
		 
	}
	

}
