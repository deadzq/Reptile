package com.offcn.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.dao.SpDao;
import com.offcn.po.Sp;
@Service
public class SpServiceImpl implements SpService {
	@Autowired
    SpDao spDao;
	@Override
	public void savesp(Sp sp) {
		// TODO Auto-generated method stub
		spDao.savesp(sp);
	}
	@Override
	public void savesp1(Sp sp) {
		// TODO Auto-generated method stub
		/*spDao.savesp1(sp);*/
	}
	@Override
	public List<Sp> selectsp() {
		// TODO Auto-generated method stub
		List<Sp> sp = spDao.selectsp();
		return sp;
	}
	@Override
	public List<Sp> selectsp1() {
		// TODO Auto-generated method stub
		/*List<Sp> selectsp1 = spDao.selectsp1();*/
		return null;
	}
	
}
