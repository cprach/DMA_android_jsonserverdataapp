package edu.computerpower.student.jsonserverdata;

import java.util.ArrayList;
import java.util.List;

public class Server {
	
	private int id;
	private String region;
	private String servername;
	private List<Player> players = new ArrayList<Player>();
	
	public Server() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getServername() {
		return servername;
	}

	public void setServerName(String servername) {
		this.servername = servername;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	
	

}
