package edu.spring.hotel.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.hotel.domain.HeartVO;
import edu.spring.hotel.persistence.HeartDAO;

@Service
public class HeartServiceImple implements HeartService {
	private static Logger logger =
			LoggerFactory.getLogger(HeartServiceImple.class);
	
	@Autowired
	private HeartDAO heartDao;
	
	@Override
	public int create(HeartVO vo) {
	    logger.info("create() 호출 : vo = " + vo.toString());
	    return heartDao.insert(vo);
	} // end create()

	@Override
	public int read(HeartVO vo) {
		logger.info("read() 호출 : vo = " + vo.toString());
		return heartDao.select(vo);
	} // end read()



	@Override
	public int delete(HeartVO vo){
		logger.info("delete() 호출 : vo = " + vo.toString());
		return heartDao.delete(vo);
	} // end delete()

	/*
	 * @Override public int getHeartTotalCounts() {
	 * logger.info("getHeartTotalCounts()호출"); return
	 * heartDao.getHeartTotalCounts(); }
	 */


	
	
} // end HeartServiceImple
