package com.example.demo;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:8080"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class SpringBootJdbcController {
		
	@Autowired
	JdbcTemplate jdbc;
	@Autowired
	DataRepository dataRepository;
	
	@RequestMapping(value="/read")
	public DataResponse index() {		
		return dataRepository.findAll();
	}
	
	@RequestMapping(value = "/data")
	public Data getData(@RequestParam String recipeid) {
		
		DataRequest req = new DataRequest();
		req.setRecipeid(recipeid);
		return dataRepository.find(req);
	}
	
	@RequestMapping(value= "/api/**", method=RequestMethod.OPTIONS)
	@CrossOrigin(origins = "http://localhost:8080")
	public void corsHeaders(HttpServletResponse response) {
	    response.addHeader("Access-Control-Allow-Origin", "*");
	    response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
	    response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with");
	    response.addHeader("Access-Control-Max-Age", "3600");
	}
	
    @CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String savedata(@RequestParam String item1,
			@RequestParam String item2,
			@RequestParam String item3,
			@RequestParam String item4,
			@RequestParam String recipename) {
		
		IngredientReqDTO reqDto = new IngredientReqDTO();
		reqDto.setIngredient1(item1);
		reqDto.setIngredient2(item2);
		reqDto.setIngredient3(item3);
		reqDto.setIngredient4(item4);
		reqDto.setRecipeName(recipename);
		
		dataRepository.saveData(reqDto);
		return "data inserted successfully";
	}
}
