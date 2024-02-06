package com.coupon.service;

import java.util.List;

import com.coupon.dto.CouponDto;

public interface CouponService {
	
	public CouponDto getCoupon(String couponcode);
	public CouponDto insertCoupon(CouponDto couponDto);
	public CouponDto deleteCouponById(Integer couponid);
	public List<CouponDto> getAllCoupon();

}
