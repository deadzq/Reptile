package com.offcn.service;

import java.util.Date;
import java.util.List;

import com.offcn.po.Sp;

public interface SpService {
	public void savesp(Sp sp);
	public void savesp1(Sp sp);
	 public List<Sp> selectsp();
    public List<Sp> selectsp1();
	
	
}
