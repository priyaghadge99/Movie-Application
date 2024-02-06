package com.coupon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coupon.dto.CouponDto;
import com.coupon.service.CouponServiceImpl;

@RestController
@RequestMapping("/coupon-api")
public class CouponController {
	
	@Autowired
	CouponServiceImpl couponServiceImpl;
	
	@GetMapping("/getCoupon/{couponcode}")
	public CouponDto getCoupon(@PathVariable String couponcode) {
		return couponServiceImpl.getCoupon(couponcode);
	}
	
	@GetMapping("/getAllCoupon")
	public ResponseEntity<List<CouponDto>> getAllCoupon(){
		return  new ResponseEntity<List<CouponDto>>(couponServiceImpl.getAllCoupon(), HttpStatus.FOUND); 
		
		
	}
	
	@PostMapping("/addCoupon")
	public ResponseEntity<CouponDto> insertCoupon(@RequestBody CouponDto couponDto){
		return new ResponseEntity<CouponDto>(	couponServiceImpl.insertCoupon(couponDto), HttpStatus.CREATED);
		
	}
	
	
	@DeleteMapping("/deleteCoupon/{couponid}")
	public ResponseEntity<CouponDto> deleteCoupon(@PathVariable Integer couponid){
		return new ResponseEntity<CouponDto>(	couponServiceImpl.deleteCouponById(couponid), HttpStatus.CREATED);
		
	}
	
	

}
