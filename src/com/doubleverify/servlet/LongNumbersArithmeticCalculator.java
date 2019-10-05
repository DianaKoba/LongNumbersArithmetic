package com.doubleverify.servlet;

public class LongNumbersArithmeticCalculator {

	public static int[] sum(int[] firstNum, int[] secondNum) {

		int carry = 0;
		int[] sum = new int[firstNum.length];
		int lengthDifference = firstNum.length - secondNum.length;
		int indexOfSumArray = firstNum.length - 1;

		for (int i = secondNum.length - 1; i >= 0; i--) { // summing both arrays
			int sumOfDigits = firstNum[i + lengthDifference] + secondNum[i] + carry;

			if (sumOfDigits >= 10) {
				carry = 1;
				sum[indexOfSumArray] = sumOfDigits % 10;
			} else {
				carry = 0;
				sum[indexOfSumArray] = sumOfDigits;
			}

			indexOfSumArray--;
		}

		for (int i = lengthDifference - 1; i >= 0; i--) { // inserting the rest of the bigger number(firstNum)
			int sumOfDigits = firstNum[i] + carry;

			if (sumOfDigits >= 10) {
				carry = 1;
				sum[indexOfSumArray] = sumOfDigits % 10;
			} else {
				carry = 0;
				sum[indexOfSumArray] = sumOfDigits;
			}

			indexOfSumArray--;
		}

		if (carry == 1) { // if carry == 1 then extra digit needs to be added, creating new array
			int[] extraDigitSum = new int[firstNum.length + 1];

			extraDigitSum[0] = 1;

			for (int i = 1; i < firstNum.length + 1; i++) {
				extraDigitSum[i] = sum[i - 1];
			}

			return extraDigitSum;
		}

		return sum;
	}

	public static int[] multiply(int[] firstNum, int[] secondNum) {

		int k = firstNum.length * 2 - 1;
		int m = k + 1;
		int[] multiplied = new int[firstNum.length * 2];

		for (int i = secondNum.length - 1; i >= 0; i--) {      // iterating over multiplier 
			m--;
			k = m;
			for (int j = firstNum.length - 1; j >= 0; j--) {  // iterating over multiplicant
				int sumOfDigits = multiplied[k] + secondNum[i] * firstNum[j];
				multiplied[k] = sumOfDigits;
				k--;
			}
		}

		int carry = 0;

		for (int i = multiplied.length - 1; i > k; i--) {   
			if (multiplied[i] + carry >= 10) {
				int temp = multiplied[i] + carry;
				carry = temp / 10;
				multiplied[i] = temp % 10;
			} else {
				carry = 0;
			}
		}

		if (carry > 0) {    // if carry left for the first digit
			multiplied[k] += carry;
		}

		int flag = 0;
		int[] newMultiplied = null;
		int indexOfNewMultiplied = 0;

		if (multiplied[0] == 0) // if the result didn't take all the multiplied's space
		{
			for (int i = 1; i < multiplied.length; i++) {
				if (multiplied[i] != 0 && flag == 0) { // if zeros at start are over flag==1
					flag = 1;
				}

				if (flag == 1) { // if flag == 1 creating the new array to hold the number
					newMultiplied = new int[multiplied.length - i];
					flag = -1;
				}

				if (flag == -1) { // if flag == -1 we start inserting numbers to the new array
					newMultiplied[indexOfNewMultiplied] = multiplied[i];
					indexOfNewMultiplied++;
				}

			}
		}

		if (flag != 0) { // not all digits are zero;
			return newMultiplied;
		} else if (multiplied[0] == 0 && flag == 0) { // the result is zero
			return new int[1];
		}

		return multiplied; // the return value took all the space of the multiplied array
	}
}
