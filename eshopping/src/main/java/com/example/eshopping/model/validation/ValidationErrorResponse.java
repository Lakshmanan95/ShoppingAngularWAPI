package com.example.eshopping.model.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorResponse {

	private List<Violation> violations = new ArrayList<>();
	private String status = "Error";

	public List<Violation> getViolations() {
		return violations;
	}

	public void setViolations(List<Violation> violations) {
		this.violations = violations;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
