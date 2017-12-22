package com.shri.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author shrisowdhaman
 * Dec 15, 2017
 */
public class BcryptClient {

	private static Logger logger = LoggerFactory.getLogger(BcryptClient.class);
	
	public static void main(String[] args) throws IOException {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		logger.info("Enter the word to Bcrypt :");
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		
		String word = buf.readLine();
		
		String bcryptWord = encoder.encode(word);
		
		logger.info("Encrypt Word : "+bcryptWord);

	}

}
