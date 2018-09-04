package com.offcn.controller;

/*import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.offcn.po.Sp;
import com.offcn.po.Spstr;
import com.offcn.service.SpService;

public class Jfree {
	   public static void main(String[] args){
		   ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
			SpService spService = (SpService) context.getBean(SpService.class);
			List<Sp> selectsp = spService.selectsp();
			List<Spstr> getlist = getlist(selectsp);
			double[][] data=new double[2][];
			double[] data1=new double[getlist.size()];
			if(getlist!=null){
				for (int i = 0; i < getlist.size(); i++) {
					data1[i]=getlist.get(i).getPrice();
				}
			}
			List<Sp> selectsp1 = spService.selectsp1();
			List<Spstr> getlist1 = getlist(selectsp1);
			double[] data2=new double[getlist1.size()];
			for (int i = 0; i < getlist1.size(); i++) {
				data2[i]=getlist1.get(i).getPrice();
			}
			data[0]=data1;
			data[1]=data2;
			String columKeys[]=new String[getlist1.size()];
			for (int i = 0; i < getlist1.size(); i++) {
				columKeys[i]=getlist1.get(i).getDate();
			}
			String rowKeys[]={"2017-6 平均价","2018-6 平均价"};
	CategoryDataset dataset = DatasetUtilities.createCategoryDataset(rowKeys, columKeys, data);
	//设置字体
	   StandardChartTheme theme = new StandardChartTheme("CN");
	   //标题
	   theme.setExtraLargeFont(new Font("宋体", Font.BOLD, 30));
	   //图例
	   theme.setRegularFont(new Font("黑体", Font.BOLD, 14));
	   //X,Y轴
	   theme.setLargeFont(new Font("隶书", Font.ITALIC, 30));
	   ChartFactory.setChartTheme(theme);
JFreeChart chart = ChartFactory.createLineChart("2017-6与2018同期李子平均价走势", "日期", "平均价", dataset);
			
         CategoryPlot plot = chart.getCategoryPlot();
         LineAndShapeRenderer renderer = (LineAndShapeRenderer)plot.getRenderer();
         renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
         renderer.setBaseItemLabelFont(new Font("隶书", Font.ITALIC, 9));
         renderer.setBaseItemLabelsVisible(true);
         try {
			ChartUtilities.saveChartAsJPEG(new File("D:\\chart\\pic.jpg"), chart, 800, 600);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         System.out.println("success");
			
}
	   public static List<Spstr> getlist(List<Sp> list){
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
