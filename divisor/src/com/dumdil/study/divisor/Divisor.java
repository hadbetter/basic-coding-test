package com.dumdil.study.divisor;

public class Divisor {
	
	public void calculate(int targetNumber) {
		
		for (int divisor = 1 ; divisor <= targetNumber ; divisor++) {
			if (targetNumber % divisor == 0) {
				System.out.print(divisor);
				if (divisor == targetNumber) {
					System.out.println();
				} else {
					System.out.print(" ");
				}
			}
		}
	}
	
}
