package com.offcn.po;

public class Spstr implements Comparable<Spstr>{

	private String name;
	private String lprice;
	private String price;
	private String hprice;
	private String date;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLprice() {
		return lprice;
	}
	public void setLprice(String lprice) {
		this.lprice = lprice;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getHprice() {
		return hprice;
	}
	public void setHprice(String hprice) {
		this.hprice = hprice;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	@Override
	public String toString() {
		return "Spstr [name=" + name + ", lprice=" + lprice + ", price=" + price + ", hprice=" + hprice + ", date="
				+ date + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((hprice == null) ? 0 : hprice.hashCode());
		result = prime * result + ((lprice == null) ? 0 : lprice.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Spstr other = (Spstr) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (hprice == null) {
			if (other.hprice != null)
				return false;
		} else if (!hprice.equals(other.hprice))
			return false;
		if (lprice == null) {
			if (other.lprice != null)
				return false;
		} else if (!lprice.equals(other.lprice))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}
	@Override
	public int compareTo(Spstr o) {
		// TODO Auto-generated method stub
		return this.date.compareTo(o.date);
	}
	
	
}
