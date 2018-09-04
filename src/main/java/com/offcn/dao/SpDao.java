package com.offcn.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.offcn.po.Sp;
@Repository
public interface SpDao {
         public void savesp(Sp sp);
         //public void savesp1(Sp sp);
	     public List<Sp> selectsp();
	     //public List<Sp> selectsp1();
	
}
