package com.ssafy.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Audience {
	private Movie movie;
	
	@Autowired
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	public void runMovie() {
		System.out.println(this.movie.getInfo() + "를 관람합니다.");
	}
}
