package com.doubleverify.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LongNumbersArithmeticControllerServlet")
public class LongNumbersArithmeticControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LongNumbersArithmeticControllerServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String command = request.getParameter("command");
		int[] firstNumber = null;
		int[] secondNumber = null;

		if (command == null) {
			command = "SHOW_DEFAULT_PAGE";
		} else {
			firstNumber = stringToIntArray(request.getParameter("firstNumber"));
			secondNumber = stringToIntArray(request.getParameter("secondNumber"));
		}

		switch (command) {
		case "SHOW_DEFAULT_PAGE":
			showDefaultPage(request, response);
			break;
		case "ADD":
			sum(request, response, firstNumber, secondNumber);
			break;

		case "MULTIPLY":
			multiply(request, response, firstNumber, secondNumber);
			break;
		}
	}

	private void showDefaultPage(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.html");

		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sum(HttpServletRequest request, HttpServletResponse response, int[] firstNum, int[] secondNum) {
		int[] sum = firstNum.length > secondNum.length? LongNumbersArithmeticCalculator.sum(firstNum, secondNum) :
			LongNumbersArithmeticCalculator.sum(secondNum, firstNum);
		String result = fromIntArrayToString(sum);
		request.setAttribute("RESULT", result);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/long-numbers-addition.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String fromIntArrayToString(int[] str) {

		String result = "";

		for (int num : str) {
			result += num;
		}

		return result;
	}

	private void multiply(HttpServletRequest request, HttpServletResponse response, int[] firstNum, int[] secondNum) {
		int[] multiplied = firstNum.length > secondNum.length? LongNumbersArithmeticCalculator.multiply(firstNum, secondNum) :
			LongNumbersArithmeticCalculator.multiply(secondNum, firstNum);
		String result = fromIntArrayToString(multiplied);

		request.setAttribute("RESULT", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/long-numbers-multiplication.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int[] stringToIntArray(String str) {

		if (str == null) {
			return null;
		}

		int[] newArray = new int[str.length()];

		for (int i = 0; i < str.length(); i++) {
			newArray[i] = str.charAt(i) - '0';
		}

		return newArray;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
