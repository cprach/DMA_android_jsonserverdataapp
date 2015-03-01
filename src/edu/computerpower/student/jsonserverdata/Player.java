package edu.computerpower.student.jsonserverdata;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private String username;
	private int highscore;
	private List<Integer> previousscores = new ArrayList<Integer>();
	
	public Player() {
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getHighscore() {
		return highscore;
	}
	public void setHighscore(int highscore) {
		this.highscore = highscore;
	}
	
	public List<Integer> getPreviousscores() {
		return previousscores;
	}
	public void setPreviousscores(List<Integer> previousscores) {
		this.previousscores = previousscores;
	}

}

