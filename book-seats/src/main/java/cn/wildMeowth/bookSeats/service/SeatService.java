package cn.wildMeowth.bookSeats.service;

import java.util.List;
import java.util.Map;

import cn.wildMeowth.bookSeats.entity.Seat;

public interface SeatService {
	List<Map<String, String>> listSeats(String time);
	
	List<Map<String, String>> listUserSeats(String userId);
	
	List<Map<String, String>> listUserSeatsforNo(String userId);
	
	Seat addSeat(String id, String userId, String time, String status) throws UserNotFoundException, SeatNotFoundException ;
	
	Seat deleteSeat (String id, String userId, String time, String status) throws SeatNotFoundException ;
	
	Seat updateStatus (String id, String userId, String time, String status) throws SeatNotFoundException ;

	List<Map<String, String>> listSeatsByUserIdAndTime (String userId, String time);
}
