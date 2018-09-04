package com.offcn.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.offcn.po.Sp;
import com.offcn.po.Spstr;
import com.offcn.service.SpService;

/*@Controller*/
/*public class PlumController {

	// http://localhost:8080/Day03homework/line.html
	
	
	@Autowired
	SpService spService;
	
	@RequestMapping("getallsp")
	@ResponseBody
	public List<Spstr> getallsp() throws ParseException{
		List<Sp> list = spService.selectsp();
		List<Spstr> liststr = new ArrayList<Spstr>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		for (Sp sp : list) {
		Spstr spstr = new Spstr();
		String str = format.format(sp.getDate());
		String[] split = str.split("-");
		spstr.setPrice(sp.getPrice());
		spstr.setDate(split[2]);
		liststr.add(spstr);
		}
		List<Spstr> collect = liststr.stream().sorted().collect(Collectors.toList());
		return collect;
	}
	@RequestMapping("getallsp1")
	@ResponseBody
	public List<Spstr> getallsp1(){
		List<Sp> list = spService.selectsp1();
		List<Spstr> liststr = new ArrayList<Spstr>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		for (Sp sp : list) {
		Spstr spstr = new Spstr();
		String str = format.format(sp.getDate());
		String[] split = str.split("-");
		spstr.setPrice(sp.getPrice());
		spstr.setDate(split[2]);
		liststr.add(spstr);
		}
		List<Spstr> collect = liststr.stream().sorted().collect(Collectors.toList());
		return collect;
	}
	
}*/
