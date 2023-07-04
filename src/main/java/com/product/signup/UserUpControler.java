package com.product.signup;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserUpControler {

	@PostMapping(value="/signup")
	public void signUp(@RequestBody UserUp up) {
		UserUpDA sUp = new UserUpDA();
		sUp.signup(up);
	}
}
