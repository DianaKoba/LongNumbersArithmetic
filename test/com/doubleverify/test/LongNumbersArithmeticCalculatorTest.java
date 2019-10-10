package com.doubleverify.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.doubleverify.servlet.LongNumbersArithmeticCalculator;

class LongNumbersArithmeticCalculatorTest {

	@Test
	void test() {
		// addition testing
		int[] sum = LongNumbersArithmeticCalculator.sum(new int[] { 9, 9, 9 }, new int[] { 1, 2 });
		Assert.assertArrayEquals(sum, new int[] { 1, 0, 1, 1 });
		sum = LongNumbersArithmeticCalculator.sum(new int[] { 1, 1, 1, 1, 1, 1 }, new int[] { 9, 9, 9 });
		Assert.assertArrayEquals(sum, new int[] { 1, 1, 2, 1, 1, 0 });
		sum = LongNumbersArithmeticCalculator.sum(new int[] { 2, 7, 8 }, new int[] { 1, 2, 3 }); 
		Assert.assertArrayEquals(sum, new int[] { 4, 0, 1 });                                      
                                                                                                  
		// multiplication testing
		int[] multiplication = LongNumbersArithmeticCalculator.multiply(new int[] { 3, 3, 3 }, new int[] { 3, 3, 3 });
		Assert.assertArrayEquals(multiplication, new int[] { 1, 1, 0, 8, 8, 9 });
		multiplication = LongNumbersArithmeticCalculator.multiply(new int[] { 2, 3 }, new int[] { 1, 0, 0 });
		Assert.assertArrayEquals(multiplication, new int[] { 2, 3, 0, 0 });
		multiplication = LongNumbersArithmeticCalculator.multiply(new int[] { 9, 9, 9, 9, 9, 9, 9}, new int[] { 9, 9, 9, 9, 9, 9, 9});
		Assert.assertArrayEquals(multiplication, new int[] { 9, 9, 9, 9, 9, 9, 8, 0, 0, 0, 0, 0, 0, 1 });
	}
}
