package com.commscope.bu.model;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
/**
 * Used for the input and defualt json creation object 
 * @author RT1050
 *
 */
public class Student2 implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String,Object> studentMap;
	
	public Student2() {
		
	}

	@JsonAnyGetter
	public Map<String, Object> getStudentMap() {
		return studentMap;
	}

	public Student2(Map<String, Object> studentMap) {
		super();
		this.studentMap = studentMap;
	}

	public void setStudentMap(Map<String, Object> studentMap) {
		this.studentMap = studentMap;
	}
	
	
}
