package com.maybank.assignment.service;

import java.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.maybank.assignment.repositories.GreetingRepository;
import com.maybank.assignment.model.*;
import java.util.*;

@Service
public class GreetingService {
	//
	public static final int MORNING_ID = 1;
	public static final int AFTERNOON_ID = 2;
	public static final int EVENING_ID = 3;
	public static final int GOODNIGHT_ID = 4;
	public static final int TWELVE = 12;
	public static final int FIFTEEN = 15;
	public static final int NINTEEN = 19;
	//
	@Autowired
	GreetingRepository greetingRepository;

	public String getGreeting() {
		LocalTime currentTime = LocalTime.now();
		String greeting = "";
		int hour = currentTime.getHour();
		if (hour < TWELVE) {
			greeting = greetingRepository.findById(MORNING_ID).get().getGreet();
		} else if (hour >= TWELVE && hour <= FIFTEEN) {
			greeting = greetingRepository.findById(AFTERNOON_ID).get().getGreet();
		} else if (hour > FIFTEEN && hour <= NINTEEN) {
			greeting = greetingRepository.findById(EVENING_ID).get().getGreet();
		} else {
			greeting = greetingRepository.findById(GOODNIGHT_ID).get().getGreet();
		}
		return greeting;

	}

	public void insertGreeting() {
		ArrayList<Greeting> list = new ArrayList<Greeting>();
		Greeting morning = new Greeting();
		morning.setId(1);
		morning.setGreet("Good Morning");
		Greeting afternoon = new Greeting();
		afternoon.setId(2);
		afternoon.setGreet("Good Afternoon");
		Greeting evening = new Greeting();
		evening.setId(3);
		evening.setGreet("Good Evening");
		Greeting night = new Greeting();
		night.setId(4);
		night.setGreet("Good Night");
		//
		list.add(morning);
		list.add(afternoon);
		list.add(evening);
		list.add(night);
		greetingRepository.saveAll(list);

	}

}
