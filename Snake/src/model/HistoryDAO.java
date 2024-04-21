package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import database.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart.Data;

public class HistoryDAO {
	
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pStmt;
	private ResultSet rs;
	public History history;
	private final UserDAO userDAO = new UserDAO();

	
	private void close() {
		try {
			if (connection != null) 
				connection.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public LocalTime getTimeInterval(Long user_id) {
		List<LocalTime> timeIntervalList = new ArrayList<>();
		LocalTime timeInterval = LocalTime.of(0, 0, 0);
		LocalTime bestTime = LocalTime.of(0, 0, 0);
		
		connection = DBConnection.getConnection();
		try {
			
			pStmt = connection.prepareStatement("select start_time, end_time from history where user_id='"+user_id+"';");
			rs = pStmt.executeQuery();
			while (rs.next()) {
				LocalTime start_time = rs.getTime("start_time").toLocalTime();
				LocalTime end_time = rs.getTime("end_time").toLocalTime();
				Duration duration = Duration.between(start_time, end_time);
				timeInterval = LocalTime.of(0, 0, 0).plus(duration);
				timeIntervalList.add(timeInterval);
				System.out.println("the time interval : "+timeInterval);
				 
			}
			
			if (!timeIntervalList.isEmpty()) {
	            bestTime = Collections.max(timeIntervalList);
	            System.out.println("The best time is: " + bestTime);
	        } else {
	            System.out.println("No records found.");
	        }
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return bestTime;
	}
	
	
	public int getLatestScore(Long user_id) {
		int latestScore = 0;
		ObservableList<History> histories = getAllScoresByUserId(user_id);
		
		connection = DBConnection.getConnection();
		try {
			pStmt = connection.prepareStatement("select total_score as latest_score from history order by history_id desc limit 1 where user_id='"+user_id+"';");
			rs = pStmt.executeQuery();
			if (rs.next()) {
				latestScore = rs.getInt("latest_score");
				System.out.println("The latest score is: " + latestScore);
			}else {
				System.out.println("The latest score is: 1");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return latestScore;
	}
	
	public int getTotalPlayedGame(Long user_id) {
		int totalPlayedGame = 0;
		connection = DBConnection.getConnection();
		try {
			pStmt = connection.prepareStatement("select count(*) as total_played_game from history where user_id='"+user_id+"';");
			rs = pStmt.executeQuery();
			if (rs.next()) {
				totalPlayedGame = rs.getInt("total_played_game");
				System.out.println("The total played game is: " + totalPlayedGame);
	        } else {
	        	System.out.println("The total played game is:1");
			}
	         
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return totalPlayedGame;
	}
	
	public int getHighestScore(Long user_id) {
	    int highestScore = 0; 

	    connection = DBConnection.getConnection();
	    try {
	        pStmt = connection.prepareStatement("select MAX(total_score) as highest_score from history where user_id='"+user_id+"';");
	        rs = pStmt.executeQuery();

	        if (rs.next()) {
	            highestScore = rs.getInt("highest_score");
	            System.out.println("The highest score is: " + highestScore);
	        } else {
	            System.out.println("The highest score is:1");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close();
	    }

	    return highestScore;
	}
	
	
//	public List<History> getAllScores(){
//		List<History> scores = new ArrayList<History>();
//		connection = DBConnection.getConnection();
//		
//		try {
//			stmt = connection.createStatement();
//			rs = stmt.executeQuery("select * from history;");
//			while(rs.next()) { 
//				
//				scores.add(new History(
//						rs.getLong("history_id"),
//                        rs.getInt("total_fruit_eaten"),
//                        rs.getInt("total_score"),
//                        rs.getTime("start_time").toLocalTime(),
//                        rs.getTime("end_time").toLocalTime()));
//			};
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			close();
//		}
//		return scores;
//	}
	
	public ObservableList<History> getAllScoresByUserId(Long user_id){
		
		ObservableList<History> scores = FXCollections.observableArrayList();
		connection = DBConnection.getConnection();
		User user= userDAO.getUserById(user_id);
		
		try {
			pStmt = connection.prepareStatement("select * from history where user_id =?;");
			pStmt.setLong(1, user_id);
			rs = pStmt.executeQuery();
			while(rs.next()) { 
				scores.add(new History(
						rs.getLong("history_id"),
						rs.getInt("total_fruit_eaten"),
						rs.getInt("total_score"),
						rs.getTime("start_time").toLocalTime(),
						rs.getTime("end_time").toLocalTime(),
						user)
						);
			};
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return scores;
	}

}
