package com.offcn.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.offcn.po.Sp;
import com.offcn.service.SpService;
@Controller
public class Capture {
    @Test
	public  void grabber() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		SpService spService = (SpService) context.getBean(SpService.class);
		   Date date = new Date();
		   SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		   String format = simpleDateFormat.format(date);
		   List<Sp> selectsp = spService.selectsp();
		   System.out.println(selectsp);
		   String format2="";
		   if(selectsp !=null && selectsp.size()>0){
			   Date date2 = selectsp.get(0).getDate();
			   format2 = simpleDateFormat.format(date2);
			 }
		    for (int i = 1; i < 17; i++) {
			   String html = getUrlString("http://www.xinfadi.com.cn/marketanalysis/0/list/"+i+".shtml?prodname=%E6%9D%8E%E5%AD%90&begintime=2017-04-04&endtime="+format);	
				List<Sp> list = getinfo(html);
				if(selectsp!=null && selectsp.size()>0){
					if(i==1){
				if(new SimpleDateFormat("yyyy-MM-dd").format(list.get(0).getDate()).equals(format2)){
					return;
				}else{
					spService.savesp(list.get(0));
					return;
				}
				}
					return;
				}
				else {
				for (Sp sp : list) {
					spService.savesp(sp);
				}
		    }
			}
	   System.out.println("运行中："+date.toLocaleString());
	}
	//得到html
	public  String getUrlString(String url){
		String html=null;
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("User-Agent", " Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0");
		httpGet.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		try {
			CloseableHttpResponse resp = client.execute(httpGet);
			int statusCode = resp.getStatusLine().getStatusCode();
			if(statusCode==200){
				HttpEntity entity = resp.getEntity();
				html=EntityUtils.toString(entity,"utf-8");
				EntityUtils.consume(entity);
			}else{
				System.out.println("异常："+statusCode);
				
			}
			client.close();
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return html;
	}
	//抓取平均价格与日期，并且插入数据库
	public  List<Sp> getinfo(String html){
		List<Sp> list=new ArrayList<Sp>();
		if(html!=null && !html.equals("")){
			Document doc = Jsoup.parse(html);
			 Elements select = doc.getElementsByClass("tr_1").first().siblingElements();
			for (Element element : select) {
				 Sp sp = new Sp();
				 sp.setName(element.select("tr").select("td").get(0).text());
				 sp.setLprice(Float.parseFloat(element.select("tr").select("td").get(1).text()));
				 sp.setPrice(Float.parseFloat(element.select("tr").select("td").get(2).text()));
				 sp.setHprice(Float.parseFloat(element.select("tr").select("td").get(3).text()));
				 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				 Date date;
				try {
					date = simpleDateFormat.parse(element.select("tr").select("td").get(6).text());
					 sp.setDate(date);
					list.add(sp);
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
		
	}
		 
		
}

