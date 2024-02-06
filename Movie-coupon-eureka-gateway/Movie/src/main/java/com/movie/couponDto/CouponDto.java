package com.movie.couponDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CouponDto{
	
	private int id;
	private String couponcode;
	private String expirydate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCouponcode() {
		return couponcode;
	}
	public void setCouponcode(String couponcode) {
		this.couponcode = couponcode;
	}
	public String getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}
	
	

}
