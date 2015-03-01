package edu.computerpower.student.jsonserverdata;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	private List<Player> topPlayers = new ArrayList<Player>();
	private ServerManager serverManager;
	private JsonHelper jsonHelper;
	private TextView txtServerData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		displayData();
	}

	protected void displayData() {

		jsonHelper = new JsonHelper();
		serverManager = jsonHelper.deserializeServerData(this);
		txtServerData = (TextView)findViewById(R.id.txtServerData);
		StringBuilder sb = new StringBuilder();

		List<Server> serverList = serverManager.getServers();

		sb.append("\n" + serverList.size() + " Game Servers:\n");

		for (Server s : serverList) {

			Server currentServer = s;

			sb.append("\nServer Id: " + currentServer.getId() + "\n");
			sb.append("Name: " + currentServer.getServername() + "\n");
			sb.append("Region: " + currentServer.getRegion() + "\n\n");

			List<Player> playerList = currentServer.getPlayers();

			sb.append("\t\t" + playerList.size() + " Players on " + currentServer.getServername() + ":\n");

			for (Player p : playerList) {

				Player currentPlayer = p;

				sb.append("\n\t\t\tPlayer username: " + currentPlayer.getUsername() + "\n");
				sb.append("\t\t\tHigh score: " + currentPlayer.getHighscore() + "\n");

				checkTopPlayer(currentPlayer);

				List<Integer> previousScoresList = currentPlayer.getPreviousscores();

				sb.append("\t\t\t" + previousScoresList.size() + " Previous scores for " + currentPlayer.getUsername() + ":\n");

				for (Integer i : previousScoresList) {
					sb.append("\t\t\t\t\t\t" + i + "\n");
				}

			}

		}

		sb.append("\nTop player(s) on all servers:\n\n");

		for (Player p : topPlayers) {

			sb.append(p.getUsername() + " " + p.getHighscore() + "\n");

		}

		sb.append("\n\n");

		txtServerData.setText(sb.toString());
	}

	protected void checkTopPlayer(Player p) {
		
		if(topPlayers.size() == 0) {
			
			topPlayers.add(p);
			
		} else {
			
			if (p.getHighscore() > topPlayers.get(0).getHighscore()) {
				
				topPlayers.clear();
				topPlayers.add(p);
				
			} else if (p.getHighscore() == topPlayers.get(0).getHighscore()) {
				
				topPlayers.add(p);
				
			}
		}
	}
	
	public void modifyData(View view) {
		
		List<Server> serverList = serverManager.getServers();
		
		String namePrefix = "SRV_";
		
		for (Server s : serverList) {
			s.setServerName(namePrefix + s.getServername());
		}
		
		String jsonString = jsonHelper.serializeServerData(serverManager);
		
		txtServerData.setText(jsonString);
		
		Button btnModify = (Button)findViewById(R.id.btnModifyData);
		btnModify.setVisibility(View.INVISIBLE);
		
	}

	//		protected void displayData() {
	//			
	//			JsonHelper jsonHelper = new JsonHelper();
	//			ServerManager serverManager = jsonHelper.deserializeServerData(this);
	//			TextView txtServerData = (TextView)findViewById(R.id.txtServerData);
	//			StringBuilder sb = new StringBuilder();
	//	
	//			List<Server> serverList = serverManager.getServers();
	//	
	//			sb.append("\n" + serverList.size() + " Game Servers:\n");
	//			
	//			for (Server s : serverList) {
	//				
	//				Server currentServer = s;
	//				
	//				sb.append("\nServer Id: " + currentServer.getId() + "\n");
	//				sb.append("Name: " + currentServer.getServername() + "\n");
	//				sb.append("Region: " + currentServer.getRegion() + "\n\n");
	//	
	//				List<Player> playerList = currentServer.getPlayers();
	//				
	//				sb.append("\t\t" + playerList.size() + " Players on " + currentServer.getServername() + ":\n");
	//				
	//				for (Player p : playerList) {
	//					
	//					Player currentPlayer = p;
	//					
	//					sb.append("\n\t\t\tPlayer username: " + currentPlayer.getUsername() + "\n");
	//					sb.append("\t\t\tHigh score: " + currentPlayer.getHighscore() + "\n");
	//						
	//					List<Integer> previousScoresList = currentPlayer.getPreviousscores();
	//					
	//					sb.append("\t\t\t" + previousScoresList.size() + " Previous scores for " + currentPlayer.getUsername() + ":\n");
	//					
	//					for (Integer i : previousScoresList) {
	//						sb.append("\t\t\t\t\t\t" + i + "\n");
	//					}
	//	
	//				}
	//	
	//			}
	//			
	//			sb.append("\n\n");
	//	
	//			txtServerData.setText(sb.toString());
	//		}


	//		protected void displayData() {
	//			
	//			JsonHelper jsonHelper = new JsonHelper();
	//			ServerManager serverManager = jsonHelper.deserializeServerData(this);
	//			TextView txtServerData = (TextView)findViewById(R.id.txtServerData);
	//			StringBuilder sb = new StringBuilder();
	//	
	//			List<Server> serverList = serverManager.getServers();
	//	
	//			sb.append("\n" + serverList.size() + " Game Servers:\n");
	//			
	//			for (Server s : serverList) {
	//				
	//				Server currentServer = s;
	//				
	//				sb.append("\nServer Id: " + currentServer.getId() + "\n");
	//				sb.append("Name: " + currentServer.getServername() + "\n");
	//				sb.append("Region: " + currentServer.getRegion() + "\n\n");
	//	
	//				List<Player> playerList = currentServer.getPlayers();
	//				
	//				sb.append("\t\t" + playerList.size() + " Players on " + currentServer.getServername() + ":\n");
	//				
	//				for (Player p : playerList) {
	//					
	//					Player currentPlayer = p;
	//					
	//					sb.append("\n\t\t\tPlayer username: " + currentPlayer.getUsername() + "\n");
	//					sb.append("\t\t\tHigh score: " + currentPlayer.getHighscore() + "\n");
	//					
	//				}
	//	
	//			}
	//	
	//			sb.append("\n\n");
	//	
	//			txtServerData.setText(sb.toString());
	//		}


	//	protected void displayData() {
	//
	//		JsonHelper jsonHelper = new JsonHelper();
	//		ServerManager serverManager = jsonHelper.deserializeServerData(this);
	//		TextView txtServerData = (TextView)findViewById(R.id.txtServerData);
	//		StringBuilder sb = new StringBuilder();
	//
	//		List<Server> serverList = serverManager.getServers();
	//
	//		sb.append("\n" + serverList.size() + " Game Servers:\n");
	//
	//		for (Server s : serverList) {
	//
	//			Server currentServer = s;
	//
	//			sb.append("\nServer Id: " + currentServer.getId() + "\n");
	//			sb.append("Name: " + currentServer.getServername() + "\n");
	//			sb.append("Region: " + currentServer.getRegion() + "\n\n");
	//
	//		}
	//
	//		sb.append("\n\n");
	//
	//		txtServerData.setText(sb.toString());
	//	}

	//	protected void displayData() {
	//		
	//		JsonHelper jsonHelper = new JsonHelper();
	//		ServerManager serverManager = jsonHelper.deserializeServerData(this);
	//		TextView txtServerData = (TextView)findViewById(R.id.txtServerData);
	//		StringBuilder sb = new StringBuilder();
	//
	//		List<Server> serverList = serverManager.getServers();
	//
	//		sb.append("\n" + serverList.size() + " Game Servers:\n");
	//		
	//		for (Server s : serverList) {
	//			
	//			Server currentServer = s;
	//			
	//			sb.append("\nServer Id: " + currentServer.getId() + "\n");
	//			sb.append("Name: " + currentServer.getServername() + "\n");
	//			sb.append("Region: " + currentServer.getRegion() + "\n\n");
	//
	//			List<Player> playerList = currentServer.getPlayers();
	//			
	//			sb.append("\t\t" + playerList.size() + " Players on " + currentServer.getServername() + ":\n");
	//			
	//			for (Player p : playerList) {
	//				
	//				Player currentPlayer = p;
	//				
	//				sb.append("\n\t\t\tPlayer username: " + currentPlayer.getUsername() + "\n");
	//				sb.append("\t\t\tHigh score: " + currentPlayer.getHighscore() + "\n");
	//				
	//				checkTopPlayer(currentPlayer);
	//
	//				List<Integer> previousScoresList = currentPlayer.getPreviousscores();
	//				
	//				sb.append("\t\t\t" + previousScoresList.size() + " Previous scores for " + currentPlayer.getUsername() + ":\n");
	//				
	//				for (Integer i : previousScoresList) {
	//					sb.append("\t\t\t\t\t\t" + i + "\n");
	//				}
	//
	//			}
	//
	//		}
	//
	//		sb.append("\nTop player(s) on all servers:\n\n");
	//		
	//		for (Player p : topPlayers) {
	//			
	//			sb.append(p.getUsername() + " " + p.getHighscore() + "\n");
	//			
	//		}
	//		
	//		sb.append("\n\n");
	//
	//		txtServerData.setText(sb.toString());
	//	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
