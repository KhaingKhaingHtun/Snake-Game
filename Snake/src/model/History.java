package model;

import java.sql.ResultSet;
import java.time.LocalTime;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;

public class History {

	private LongProperty history_id;
	private IntegerProperty total_fruit_eaten;
	private IntegerProperty total_score;
	private ObjectProperty<LocalTime> start_time;
	private ObjectProperty<LocalTime> end_time;
	
	private User user;
	
	public History() {}

	public History(Integer total_fruit_eaten, Integer total_score, LocalTime start_time, LocalTime end_time, User user) {
		super();
		this.total_fruit_eaten = new SimpleIntegerProperty(total_fruit_eaten);
		this.total_score = new SimpleIntegerProperty(total_score);
		this.start_time = new SimpleObjectProperty<LocalTime>(start_time);
		this.end_time = new SimpleObjectProperty<LocalTime>(end_time);
		this.user = user;
	}

	public History(Long history_id, Integer total_fruit_eaten, Integer total_score, LocalTime start_time, LocalTime end_time, User user) {
		super();
		this.history_id = new SimpleLongProperty(history_id);
		this.total_fruit_eaten = new SimpleIntegerProperty(total_fruit_eaten);
		this.total_score = new SimpleIntegerProperty(total_score);
		this.start_time = new SimpleObjectProperty<LocalTime>(start_time);
		this.end_time = new SimpleObjectProperty<LocalTime>(end_time);
		this.user = user;
	}


	public Long getHistoryId() {
		return history_id.get();
	}

	public void setHistoryId(Long history_id) {
		this.history_id = new SimpleLongProperty(history_id);
	}

	public Integer getTotal_fruit_eaten() {
		return total_fruit_eaten.get();
	}

	public void setTotal_fruit_eaten(Integer total_fruit_eaten) {
		this.total_fruit_eaten = new SimpleIntegerProperty(total_fruit_eaten);
	}

	public Integer getTotal_score() {
		return total_score.get();
	}

	public void setTotal_score(Integer total_score) {
		this.total_score = new SimpleIntegerProperty(total_score);
	}

	public LocalTime getStart_time() {
		return start_time.get();
	}

	public void setStart_time(LocalTime start_time) {
		this.start_time = new SimpleObjectProperty<LocalTime>(start_time);
	}

	public LocalTime getEnd_time() {
		return end_time.get();
	}

	public void setEnd_time(LocalTime end_time) {
		this.end_time = new SimpleObjectProperty<LocalTime>(end_time);
	}
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "History [Historyid=" + history_id + ", total_fruit_eaten=" + total_fruit_eaten + ", total_score=" + total_score
				+ ", start_time=" + start_time + ", end_time=" + end_time + "]";
	}

	
}
