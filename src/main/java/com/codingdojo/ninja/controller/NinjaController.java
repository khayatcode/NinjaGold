package com.codingdojo.ninja.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class NinjaController {
	
	@GetMapping("/")
	public String rIndex() {
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public String rHome(HttpSession session) {
		//Look at counter assignment and add into numGold
		if (session.getAttribute("numGold") == null) {
	        session.setAttribute("numGold", 0);
	    }
		if(session.getAttribute("allActivity") == null) {
			ArrayList<String> myActivityList = new ArrayList<String>();
			session.setAttribute("allActivity", myActivityList);
		}
		
		if ((Integer) session.getAttribute("numGold") < -25) {
	        return "redirect:/prison";
	    }
		
		
		System.out.println("GOLD: " + session.getAttribute("numGold"));
		return "ninja.jsp";
	}
	
	@GetMapping("/prison")
	public String rPrison() {
		return "prison.jsp";
	}
	
	
	@SuppressWarnings("unchecked")
	@PostMapping("/form")
	public String sForm(HttpSession session,
			@RequestParam(value="form") String form) {
		System.out.println("form is: " + form);
		
		if(form.equals("farm")) {
			Integer numGold = (Integer) session.getAttribute("numGold");
			Random random = new Random();
	        int randomNumber = random.nextInt(11) + 10;
	        numGold += randomNumber;
			session.setAttribute("numGold", numGold);
			System.out.println("Random Number is " + randomNumber);
			
		
			
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy hh:mm a");
			String formattedDate = formatter.format(date);
			
			String resultForm = String.format("You entered a farm and earned %d gold. (%s)", randomNumber, formattedDate);

			ArrayList<String> myActivityList = (ArrayList<String>) session.getAttribute("allActivity");
			myActivityList.add(resultForm);
			session.setAttribute("allActivity", myActivityList);
		}
		
		else if(form.equals("cave")) {
			Integer numGold = (Integer) session.getAttribute("numGold");
			Random random = new Random();
	        int randomNumber = random.nextInt(6) + 5;
	        numGold += randomNumber;
			session.setAttribute("numGold", numGold);
			System.out.println("Random Number is " + randomNumber);
			
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy hh:mm a");
			String formattedDate = formatter.format(date);
			
			String resultForm = String.format("You entered a cave and earned %d gold. (%s)", randomNumber, formattedDate);

			ArrayList<String> myActivityList = (ArrayList<String>) session.getAttribute("allActivity");
			myActivityList.add(resultForm);
			session.setAttribute("allActivity", myActivityList);
		}
		
		else if(form.equals("house")) {
			Integer numGold = (Integer) session.getAttribute("numGold");
			Random random = new Random();
	        int randomNumber = random.nextInt(4) + 2;
	        numGold += randomNumber;
			session.setAttribute("numGold", numGold);
			System.out.println("Random Number is " + randomNumber);
			
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy hh:mm a");
			String formattedDate = formatter.format(date);
			
			String resultForm = String.format("You entered a house and earned %d gold. (%s)", randomNumber, formattedDate);

			ArrayList<String> myActivityList = (ArrayList<String>) session.getAttribute("allActivity");
			myActivityList.add(resultForm);
			session.setAttribute("allActivity", myActivityList);
		}
		
		
		
		else if(form.equals("quest")) {
			Integer numGold = (Integer) session.getAttribute("numGold");
			Random random = new Random();
	        int randomNumber = random.nextInt(101) - 50;
	        numGold += randomNumber;
			session.setAttribute("numGold", numGold);
			System.out.println("Random Number is " + randomNumber);
			
			if(randomNumber >= 0) {
				Date date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy hh:mm a");
				String formattedDate = formatter.format(date);
				
				String resultForm = String.format("You completed a quest and earned %d gold. (%s)", randomNumber, formattedDate);

				ArrayList<String> myActivityList = (ArrayList<String>) session.getAttribute("allActivity");
				myActivityList.add(resultForm);
				session.setAttribute("allActivity", myActivityList);
				
			} 
			else {
				Date date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy hh:mm a");
				String formattedDate = formatter.format(date);
				
				String resultForm = String.format("You failed a quest and lost %d gold. (%s)", randomNumber, formattedDate);

				ArrayList<String> myActivityList = (ArrayList<String>) session.getAttribute("allActivity");
				myActivityList.add(resultForm);
				session.setAttribute("allActivity", myActivityList);
			}
		}
		
		else if(form.equals("spa")) {
			Integer numGold = (Integer) session.getAttribute("numGold");
			Random random = new Random();
	        int randomNumber = random.nextInt(16) - 20;
	        numGold += randomNumber;
			session.setAttribute("numGold", numGold);
			System.out.println("Random Number is " + randomNumber);
			
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy hh:mm a");
			String formattedDate = formatter.format(date);
			
			String resultForm = String.format("You went to spa and lost %d gold. (%s)", randomNumber, formattedDate);

			ArrayList<String> myActivityList = (ArrayList<String>) session.getAttribute("allActivity");
			myActivityList.add(resultForm);
			session.setAttribute("allActivity", myActivityList);
		}
		
		return "redirect:/home";
	}
	
	@GetMapping("/reset")
	public String rReset(HttpSession session) {
		session.invalidate();
		return "redirect:/home";
	}
}
