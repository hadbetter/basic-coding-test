package com.dumdil.study.divisor.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.dumdil.study.divisor.code.Divisor;

public class DivisorTest {

	private Divisor divisor;
	
	@Before
	public void setup() {
		divisor = new Divisor();
	}
	
	@Test
	public void calculateDivisor() {
		int n = 20;
		divisor.calculate(n);
		
	}

}
