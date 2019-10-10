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
				multiplied[i] += carry;
				carry = 0;
			}
		}

		if (carry >= 10) {    // if carry left for the first digit
			int temp = carry;
			carry = temp / 10;
			multiplied[k] = temp % 10;    //  the most rightest digit
			k--;
			multiplied[k] = carry;
		} else if(k >= 0 && carry > 0){           // if array has space for another digit and carry isn't zero
			multiplied[k] = carry;
		} else if(k >= 0){ //                     // if array has space but no carry
			k++;
		}

		if(k > 0) { // if the number didn't take up all the space
			int j = 0;
			int[] newMultiplied  = new int[firstNum.length * 2 - k];
			for(int i = k; i < firstNum.length * 2; i++) {
				newMultiplied[j] = multiplied[i];
				j++;
			}
			
			return newMultiplied;
		}
		
		return multiplied; // the return value took all the space of the multiplied array
	}
	
	/*
	static int[] removeZeros(int[] arr) // this function can be used to handle leading zero numbers like
	{ 									// 00012 * 000, and also lines 96-102 can be deleted if we use it
	    int index = -1; 
	  
	    for (int i = 0; i < arr.length; i++) { 
	        if (arr[i] != 0) { 
	            index = i; 
	            break; 
	        } 
	    } 
	  
	    if (index == -1) { 
	    	return arr;
	    } 
	  
	    int[] newArray = new int[arr.length - index]; 
	  
	    for (int i = 0; i < arr.length - index; i++) {
	        newArray[i] = arr[index + i]; 
	    }
	    
	    return newArray;
	} 
	*/
	  
}
