package com.product.signin;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserInControler {
	@PostMapping(value="/signin")
	public UserIn save(@RequestBody UserIn uIn){
		UserInDA uda=new UserInDA();
		return uda.signIn(uIn);
	}

}
