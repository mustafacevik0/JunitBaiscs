package com.cogent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class NumberCalculationTest {
	
	NumberCalculation nc;
	
	@BeforeEach
	void init() {
		nc=new NumberCalculation();
	}
	
	@Test
	void testAddition() {
		
		assertEquals(nc.add(10,20), 30); // first arg is function and second is what we expect
		
	}
	
	
	@Nested
	class AddTest{
		
		@Test
		void addPositive() {
			// we can do also reverse, expected be 1st arg
			assertEquals(3, nc.add(1, 2));
			
		}
		
		@Test
		void addPositive_Negative() {
			assertEquals(0, nc.add(1, -1));
			
		}
		
		@Test
		void addNegative() {
			assertEquals(-2, nc.add(-1, -1));
			
		}
		
		
	}
	

	@Test
	void testMultiply() {
		
		// if one test fails, all others(rest/next) will fail
		assertAll(
				()-> assertEquals(0, nc.multiply(1,0)),
				()-> assertEquals(7, nc.multiply(7,1)),
				()-> assertEquals(90, nc.multiply(10,9))
				);
	}
	@Test
	void testDivide() {
		assertThrows(ArithmeticException.class, ()->nc.divide(1,0), "denominator CAN'T be zero");
	}
}
