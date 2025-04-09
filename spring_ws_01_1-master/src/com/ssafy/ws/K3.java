package com.ssafy.ws;

import org.springframework.stereotype.Component;

@Component
public class K3 implements Car {

	@Override
	public String getInfo() {
		return "K3";
	}

}
