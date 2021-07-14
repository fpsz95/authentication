package com.jforce.lms.jwt;

import com.jforce.lms.user.UserDetailsImpl;
import io.jsonwebtoken.Jwts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.ui.Model;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

public class JwtUsernameAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	Logger logger = LoggerFactory.getLogger(JwtUsernameAndPasswordAuthenticationFilter.class);

    private final AuthenticationManager authenticationManager;
    private final JwtConfig jwtConfig;
    private final SecretKey secretKey;
    private final JwtToken jwtToken;

    public JwtUsernameAndPasswordAuthenticationFilter(AuthenticationManager authenticationManager,
                                                      JwtConfig jwtConfig,
                                                      SecretKey secretKey,
                                                      JwtToken jwtToken) {
        this.authenticationManager = authenticationManager;
        this.jwtConfig = jwtConfig;
        this.secretKey = secretKey;
        this.jwtToken = jwtToken;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        System.out.println("***********Authentication attemptAuthentication********1********");
        //authenticateRequest - Authenticate to see whether the username and password are correct, Also Object
        //convert a JSON to Java Object using the readValue() method of ObjectMapper class, this method deserializes a JSON content from given JSON content String.
//            UsernameAndPasswordAuthenticationRequest authenticationRequest = new ObjectMapper()
//                    .readValue(request.getInputStream(), UsernameAndPasswordAuthenticationRequest.class);

        String username = request.getParameter("username");
        System.out.println("Username provided from frontend is = " + username);
        String password= request.getParameter("password");
        System.out.println("Password provided from frontend is = " + password);

        //Authenticatio is an interface that has implementation UsernamePasswordAuthenticationToken
        Authentication authentication = new UsernamePasswordAuthenticationToken(
//                    authenticationRequest.getUsername(), //Principal
//                    authenticationRequest.getPassword() // Credentials
                username,
                password
        );
        //Authentication authenticate;
        System.out.println("***********Authentication attemptAuthentication********2********");
        Authentication authenticate = null;
        try {
        	logger.info("Inside Authentication Try");
        	authenticate = authenticationManager.authenticate(authentication); //authenticationManager will make sure that the username exists, if exists then its checks whether the password is correct or not
        	
        }
        catch(AuthenticationException ae) {
        	logger.info("INSIDE AuthenticationException ae");
        	try {
				response.sendRedirect("signin?msg=error");
			} catch (IOException e) {
				e.printStackTrace();
			}
//        	try {
//				request.getRequestDispatcher("signin?msg=error").forward(request, response);
//			} catch (ServletException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
        }
        //SecurityContextHolder.getContext().setAuthentication(authenticate); //My code from bezkoder
        System.out.println("authenticate object is = " + authenticate);
        return authenticate;
    }

    //generating a token
    //executed when attempt authentication is done executing
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        System.out.println("***********INSIDE SUCCESSFUL AUTHENTICATION()****************");
        String token = getToken(authResult);
        System.out.println(token);
//        response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
//        response.setHeader("Pragma","no-cache");
//        response.setDateHeader("Expires", 0);

//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Authorization", "Bearer " + token);
//        response.setHeader(jwtConfig.getAuthorizationHeader(), jwtConfig.getTokenPrefix() + token);
//        HttpSession httpSession = request.getSession();
//        httpSession.setAttribute(jwtConfig.getAuthorizationHeader(), jwtConfig.getTokenPrefix() + token);
        //response.setHeader("Authorization", "Bearer " + token);
//        Cookie cookie = new Cookie(jwtConfig.getAuthorizationHeader(), jwtConfig.getTokenPrefix() + token);
//        cookie.setMaxAge(5000);
//        cookie.setSecure(false);
//        cookie.setHttpOnly(true);

        HttpSession httpSession = request.getSession();
        httpSession.setAttribute(jwtConfig.getAuthorizationHeader(), jwtConfig.getTokenPrefix() + token);

        String s = httpSession.getAttribute("Authorization").toString();
        String id = httpSession.getId();
        System.out.println("httpsession value is = " + s);
        System.out.println("httpsession ID value is = " + id);
        UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();
        System.out.println(userDetails.getUsername());
        System.out.println(userDetails.getAuthorities());
        Set<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toSet());
//        roles.contains()
//        System.out.println(roles);
//        String role = roles.toString();
//        System.out.println(role);
        boolean b = roles.contains("ROLE_FACULTY");
        if(b){
        	logger.info("Inside Faculty Role");
            response.sendRedirect("/faculty/faculty-students-details");
        }else if (roles.contains("ROLE_ADMIN")){
        	logger.info("Inside FACULTY Role");
            response.sendRedirect("/admin/profile");
        }else if (roles.contains("ROLE_STUDENT")){
        	logger.info("Inside STUDENT Role");
            response.sendRedirect("/student/student-faculty-details");
        }else{
            System.out.println("This role does not exist ");
        }

//        response. addCookie(cookie);
//        RequestDispatcher dd= request.getRequestDispatcher("/faculty/profile");
//        dd.forward(request, response);
        //request.getRequestDispatcher("/faculty/profile").forward(request,response);
        //request.getRequestDispatcher("/faculty/profile").forward(request,response); // Works
        //jwtToken.setToken(token);
    }

    private String getToken(Authentication authResult) {
        return Jwts.builder() // From import io.jsonwebtoken.Jwts;
                .setSubject(authResult.getName())
                .claim("authorities", authResult.getAuthorities()) //Payload - Data
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(jwtConfig.getTokenExpirationAfterDays())))
                .signWith(secretKey)
                .compact();
    }
}
