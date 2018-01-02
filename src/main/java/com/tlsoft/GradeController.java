package com.tlsoft;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tlsoft.entities.Grade;
import com.tlsoft.entities.InputObj;
import com.tlsoft.repository.GradeRepository;

import net.minidev.json.JSONObject;




@RestController
@RequestMapping(path = "/grade")
public class GradeController {

	@Autowired
	private GradeRepository gradeRepository;
	
	
	public @ResponseBody Grade deleteGrade(@RequestBody Grade grade) {
		return null;
	}
	
	
	@PostMapping(path = "/req") // Map ONLY GET Requests
	//@PutMapping(path = "/add")
	public @ResponseBody Grade addNewGrade(@RequestBody InputObj input) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		Grade _grade = null;
		String action = input.getAction();
		if(!StringUtils.isEmpty(action)) {
			_grade  = input.getGrade();
			if("REM".equals(action)) {
				gradeRepository.delete(_grade);
			} else {
				gradeRepository.save(_grade);
			}
		}
		return _grade;
	}

	@SuppressWarnings("unchecked")
	@GetMapping(path = "/serving")
	public @ResponseBody List<Grade> getGrade() {
		Iterable<Grade> gradeItr = gradeRepository.findAll();
		Iterator<Grade> grades = gradeItr.iterator();
		if(grades != null) {
			return IteratorUtils.toList(grades);
		}
		
		/*SortedMap<String, String> a = new TreeMap<String, String>();
		Set<String> m = new LinkedHashSet<String>();*/
		
		
		return new ArrayList<Grade>();
		
	}
	
}
