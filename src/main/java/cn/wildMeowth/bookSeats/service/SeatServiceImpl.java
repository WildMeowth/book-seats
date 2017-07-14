package cn.wildMeowth.bookSeats.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import cn.wildMeowth.bookSeats.dao.SeatDao;
import cn.wildMeowth.bookSeats.entity.Seat;

@Service("seatService")
public class SeatServiceImpl implements SeatService {

	@Resource
	private SeatDao seatDao;
	
	@Transactional
	public List<Map<String, String>> listSeats(String time) {
		return seatDao.findSeatByTime(time);
	}

	public Seat addSeat(String id, String userId, String time, String status) throws UserNotFoundException, SeatNotFoundException {
		if(userId==null||userId.trim().isEmpty()){
			throw new UserNotFoundException("id空");
		}
		//判断用户该时段是否已经其他预定座位
		List<Map<String, String>> seatList=seatDao.findSeatByUserId(userId);
		int len = seatList.toArray().length;
		for(int i=0;i<len;i++){
			if(time.equals(seatList.get(i).get("time"))){
				throw new SeatNotFoundException("该用户该时段已预定其他座位");	
			}
		}

		//添加
		Seat seat = new Seat(id,userId,time,status);
		int n = seatDao.addSeat(seat);
		if(n!=1){
			throw new SeatNotFoundException();
		}
		return seat;
	}

	public List<Map<String, String>> listUserSeats(String userId) {
		return seatDao.findSeatByUserId(userId);
	}

	public Seat deleteSeat(String id, String userId, String time, String status) throws SeatNotFoundException {
		Seat seat = new Seat(id,userId,time,status);
		int n = seatDao.deleteSeat(seat);
		if(n!=1){
			throw new SeatNotFoundException();
		}
		return seat;
	}

	public Seat updateStatus(String id, String userId, String time, String status) throws SeatNotFoundException {
		Seat seat = new Seat(id,userId,time,status);
		int n = seatDao.updateStatus(seat);
		if(n!=1){
			throw new SeatNotFoundException();
		}
		return seat;
	}

	public List<Map<String, String>> listUserSeatsforNo(String userId) {
		return seatDao.findSeatByUserIdforNo(userId);
	}

	public List<Map<String, String>> listSeatsByUserIdAndTime(String userId, String time) {
		return seatDao.findSeatByUserIdAndTime(userId, time);
	}

}
