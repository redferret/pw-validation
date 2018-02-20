package main.java.pwvalidation;

import java.util.regex.Pattern;

/**
 * Tests against a single regular expression
 * @author Richard DeSilvey
 *
 */
public class ValidationRule {

	private String regex;
	
	public ValidationRule() {
		regex = "";
	}
	
	public ValidationRule(String regex) {
		this.regex = regex;
	}

	public boolean validate(String password) {
		return Pattern.matches(regex, password);
	}
	
	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}
	
}
