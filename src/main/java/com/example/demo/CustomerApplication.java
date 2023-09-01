package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class CustomerApplication {

	public static void main(String[] args) {

		SpringApplication.run(CustomerApplication.class, args);

		String s = "Ravi";
		System.out.println(s + "Kumar");
		char c[] = s.toCharArray();
		for(int i = s.length()-1; i>=0; i--){
			System.out.print(c[i]);
		}

		String s2 = new String("Ravi");
		s2.concat("Kumar");
		System.out.println("");
		System.out.println(s2);
		String s4 =  s2.concat("Kumar");
		System.out.println(s4 + "***");

		StringBuffer s3 = new StringBuffer("Ravi");
		s3.append("Kumar");
		System.out.println(s3);
	}
}
