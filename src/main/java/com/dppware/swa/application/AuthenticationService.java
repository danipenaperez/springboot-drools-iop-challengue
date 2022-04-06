package com.dppware.swa.application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dppware.swa.application.bean.SuccessAuthOBean;
import com.dppware.swa.application.bean.userdetails.GrantedAuthorityImpl;
import com.dppware.swa.infrastructure.persistence.entity.User;
import com.dppware.swa.infrastructure.persistence.repository.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthenticationService {
	
	public static String SIGN_SECRET_VALUE = "SECREt-SECRET_SECRET_SECRET";

	@Autowired
	private UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@PostConstruct
	void iamalive() {
		System.out.println("ME han creado authentication service");
	}

	@Transactional
	public SuccessAuthOBean login(String username, String password) {
		User userInfo = userRepository.findByEmail(username);
		SuccessAuthOBean successAuthOBean = null;

		if (!passwordEncoder.matches(password, userInfo.getPassword())) { // Bcrypt match
			throw new RuntimeException("Unauthorized");
		}
		successAuthOBean = SuccessAuthOBean.builder().userId(userInfo.getId()).userName(userInfo.getEmail())
				.token(getJWTToken(userInfo)).build();
		return successAuthOBean;
	}

	private String getJWTToken(User user) {
		String secretKey = SIGN_SECRET_VALUE;

		List<GrantedAuthorityImpl> grantedAuthorities = new ArrayList<GrantedAuthorityImpl>();
		user.getRoles().stream()
				.forEach(authority -> grantedAuthorities.add(new GrantedAuthorityImpl(authority.getName())));

		String token = Jwts.builder().setId("softtekJWT").setSubject(user.getEmail())
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 6000000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return "Bearer " + token;
	}

}
