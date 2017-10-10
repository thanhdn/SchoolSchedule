package com.tlsoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tlsoft.entities.Grade;
import com.tlsoft.repository.GradeRepository;

@RestController  
@RequestMapping(path="/grade")
public class GradeController {
	
	 @Autowired 
	 private GradeRepository gradeRepository;
	 
	 
	@PostMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody Grade addNewGrade (@RequestBody Grade grade) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		gradeRepository.save(grade);
		return grade;
	}
	
	@GetMapping(path="/view")
	public @ResponseBody Grade getGrade() {
		return new Grade();
	}
}
