package com.movie.Restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.movie.couponDto.CouponDto;

//@FeignClient(name = "Coupon-Service",url = "http://localhost:9000/")
@FeignClient(name="API-GATEWAY",url = "http://localhost:8080/")
public interface Restclient {
			
	@GetMapping("/coupon-api/getCoupon/{couponcode}")
	 CouponDto getCoupon(@PathVariable String couponcode);

}
