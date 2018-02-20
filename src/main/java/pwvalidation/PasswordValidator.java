package main.java.pwvalidation;

import java.util.ArrayList;
import java.util.List;

/**
 * Validates passwords, default validation rules are
 * Must consist of a mixture of lowercase letters and numerical digits only, with at least one of each.
 * Must be between 5 and 12 characters in length.
 * Must not contain any sequence of characters immediately followed by the same sequence.
 * @author Richard DeSilvey
 *
 */
public class PasswordValidator {

	private List<ValidationRule> rules;
	
	public PasswordValidator() {
		rules = new ArrayList<ValidationRule>();
		rules.add(new ValidationRule("(?!(.+?)\\1).*"));
		rules.add(new ValidationRule(".*[a-z].*"));
		rules.add(new ValidationRule(".*[0-9].*"));
		rules.add(new ValidationRule(".{5,12}"));
	}
	
	public boolean validate(String password) {
		boolean valid = true;
		for (ValidationRule rule : rules) {
			if (!rule.validate(password)) {
				valid = false;
				break;
			}
		}
		return valid;
	}
}
