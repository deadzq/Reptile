package com.offcn.controller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.offcn.po.Sp;
import com.offcn.po.Spstr;
import com.offcn.service.SpService;

public class Itext {

	public static void main(String[] args) throws Exception {
ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
SpService spService = (SpService) context.getBean(SpService.class);
	PdfWriter writer = new PdfWriter("d:\\chart\\Plum1.pdf");		
	PdfDocument document = new PdfDocument(writer);  
	Document doc = new Document(document, PageSize.A4);	
	PdfFont font = PdfFontFactory.createFont("STSongStd-Light", "UniGB-UCS2-H", false);	
	doc.add(new Paragraph("李子价格报表(单位：元/斤)").setFontSize(20).setFont(font).setTextAlignment(TextAlignment.CENTER));
	float[] arr=new float[5];
	for (int i = 0; i < arr.length; i++) {
		arr[i]=200;
	}
	Table table = new Table(arr);
	String[] string = getString();
	for (int i = 0; i < string.length; i++) {
		table.addCell(new Cell().add(new Paragraph(string[i]).setFontSize(20).setFont(font)));
	}
	List<Sp> selectsp = spService.selectsp();
	List<Spstr> getlist = getlist(selectsp);
	for (Spstr spstr : getlist) {
		table.addCell(new Cell().add(new Paragraph(spstr.getName()).setFontSize(20).setFont(font)));
		table.addCell(new Cell().add(new Paragraph(spstr.getLprice()).setFontSize(20).setFont(font)));
		table.addCell(new Cell().add(new Paragraph(spstr.getPrice()).setFontSize(20).setFont(font)));
		table.addCell(new Cell().add(new Paragraph(spstr.getHprice()).setFontSize(20).setFont(font)));
		table.addCell(new Cell().add(new Paragraph(spstr.getDate()).setFontSize(20).setFont(font)));
	}
	doc.add(table);
	System.out.println("pdf成功");
     doc.close();
	}
	 public static List<Spstr> getlist(List<Sp> list){
		 List<Spstr> list1 = new ArrayList<Spstr>();
		for (Sp sp : list) {
			Spstr spstr = new Spstr();
			spstr.setName(sp.getName());
			spstr.setLprice(String.valueOf(sp.getLprice()));
			spstr.setPrice(String.valueOf(sp.getPrice()));
			spstr.setHprice(String.valueOf(sp.getHprice()));
			spstr.setDate(new SimpleDateFormat("yyyy-MM-dd").format(sp.getDate()));
			list1.add(spstr);
		}
		return list1;
	 }
	 public static String[] getString(){
		String[] arr={"名字","最低价","平均价","最高价","日期",};
		return arr;
	 }

}
