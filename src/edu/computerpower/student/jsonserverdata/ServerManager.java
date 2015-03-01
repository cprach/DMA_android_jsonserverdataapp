package edu.computerpower.student.jsonserverdata;

import java.util.ArrayList;
import java.util.List;


public class ServerManager {
	
	List<Server> servers = new ArrayList<Server>();
	
	public ServerManager() {
		
	}
	
	public ServerManager(List<Server> servers) {
		setServers(servers);
	}

	public List<Server> getServers() {
		return servers;
	}

	public void setServers(List<Server> servers) {
		this.servers = servers;
	}
	
	

}
