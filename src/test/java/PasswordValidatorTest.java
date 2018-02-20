package test.java;

import static org.junit.Assert.*;
import org.junit.Test;
import main.java.pwvalidation.PasswordValidator;

public class PasswordValidatorTest {

	@Test
	public void testLengthRule() {
		PasswordValidator pv = new PasswordValidator();
		assertEquals(pv.validate("12345678901a"), true);
		assertEquals(pv.validate("1234567890fewfa"), false);
		assertEquals(pv.validate("1a"), false);
		assertEquals(pv.validate("abcD123"), true);
	}
	
	@Test
	public void testAtLeastOneNumber() {
		PasswordValidator pv = new PasswordValidator();
		assertEquals(pv.validate("fhgyethHj"), false);
		assertEquals(pv.validate("ABCedfi1"), true);
		assertEquals(pv.validate("abcedf"), false);
	}
	
	@Test
	public void testAtLeastOneLowercaseLetter() {
		PasswordValidator pv = new PasswordValidator();
		assertEquals(pv.validate("ABGHRa23"), true);
		assertEquals(pv.validate("9858746"), false);
		assertEquals(pv.validate("paoe12"), true);
	}
	
	@Test
	public void testLowercaseOnly() {
		PasswordValidator pv = new PasswordValidator();
		assertEquals(pv.validate("ab123456"), true);
		assertEquals(pv.validate("ABSDL45"), false);
		assertEquals(pv.validate("degdyuewgdf"), false);
	}
	
	@Test
	public void testNoRepeats() {
		PasswordValidator pv = new PasswordValidator();
		assertEquals(pv.validate("abcdabcd"), false);
		assertEquals(pv.validate("oaiwuehgfew1"), true);
		assertEquals(pv.validate("abc12abc12"), false);
	}
	
}
