package com.jforce.lms;

import com.jforce.lms.dao.UserDAO;
import com.jforce.lms.user.User;
import org.apache.tomcat.util.http.LegacyCookieProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.sql.Timestamp;
import java.util.Date;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.sql.ResultSet;

@SpringBootApplication
public class LmsApplication //implements CommandLineRunner
{

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(LmsApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		//System.out.println(this.userDAO.createTable());
//		this.createUser();
//		//this.gettingUser();
//	}

	@Bean
	public WebServerFactoryCustomizer<TomcatServletWebServerFactory> cookieProcessorCustomizer() {
		return (serverFactory) -> serverFactory.addContextCustomizers(
				(context) -> context.setCookieProcessor(new LegacyCookieProcessor()));
	}
	
	Date date = new Date();
	Timestamp timestamp = new Timestamp(date.getTime());
	

	public void createUser() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter username");
		String username = br.readLine();
		
		System.out.println("Enter First Name");
		String firstname = br.readLine();
		
		System.out.println("Enter Last Name");
		String lastname = br.readLine();
		
		System.out.println("Enter enrollmentMonth");
		String enrollmentMonth = br.readLine();
		
		System.out.println("Enter Password");
		String password = br.readLine();
		String encodedPassword = passwordEncoder.encode(password);
		
		System.out.println("Enter Fathers Name");
		String fatherName = br.readLine();
		
		System.out.println("Enter Mothers Name");
		String motherName = br.readLine();
		
		System.out.println("Enter Program Id");
		String programId = br.readLine();
		
		System.out.println("Enter Email");
		String email = br.readLine();
		
		System.out.println("Enter Mobile");
		String mobile = br.readLine();
		
		System.out.println("Enter Acad Session");
		String acadSession = br.readLine();
		
		System.out.println("Enter Roll No");
		String rollNo = br.readLine();
		
		
		 

//		int i = this.userDAO.insertUser(
//				username,
//        		firstname,
//        		lastname,
//        		encodedPassword,
//        		1,
//        		timestamp,
//        		"Peter",
//        		timestamp,
//        		"Peter",
//        		"2020",
//        		enrollmentMonth,
//        		"Y",
//        		"2020",
//        		"Nov",
//        		fatherName,
//        		motherName,
//        		programId,
//        		email,
//        		mobile,
//        		"0",
//        		acadSession,
//        		null,
//        		rollNo,
//        		51405420,
//        		"Centre of Interior Enviornment  Design",
//        		null,
//        		null,
//        		"abcd",
//        		null
//				);
//		System.out.println(i + "User Added");
	}

//	public void gettingUser() throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("Enter User Id");
//		Long userId = Long.parseLong(br.readLine());
//		System.out.println("UserDetails from database is " + userId);
//
//		User user = this.userDAO.findByUsername(userId);
//		System.out.println(user);
//	}
}
