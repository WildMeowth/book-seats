package cn.wildMeowth.bookSeats.dao;

import java.util.List;
import java.util.Map;

import cn.wildMeowth.bookSeats.entity.Seat;

public interface SeatDao {
	List<Map<String, String>> findSeatByTime(String time);
	List<Map<String, String>> findSeatByUserId(String userId);
	List<Map<String, String>> findSeatByUserIdforNo(String userId);
	int addSeat(Seat seat);
	int deleteSeat(Seat seat);
	int updateStatus(Seat seat);
	List<Map<String, String>> findSeatByUserIdAndTime(String userId, String time);
}
