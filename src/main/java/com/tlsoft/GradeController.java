package com.tlsoft;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.IteratorUtils;
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
@RequestMapping(path = "/grade")
public class GradeController {

	@Autowired
	private GradeRepository gradeRepository;

	@PostMapping(path = "/add") // Map ONLY GET Requests
	public @ResponseBody Grade addNewGrade(@RequestBody Grade grade) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Grade _grade = gradeRepository.save(grade);
		return _grade;
	}

	@SuppressWarnings("unchecked")
	@GetMapping(path = "/view")
	public @ResponseBody List<Grade> getGrade() {
		Iterable<Grade> gradeItr = gradeRepository.findAll();
		Iterator<Grade> grades = gradeItr.iterator();
		if(grades != null) {
			return IteratorUtils.toList(grades);
		}
		return new ArrayList<Grade>();
	}
}
