package com.coupon.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coupon.dao.CouponDao;
import com.coupon.dto.CouponDto;
import com.coupon.entity.CouponEntity;

@Service
public class CouponServiceImpl implements CouponService {
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	CouponDao couponDao;

	public CouponDto getCoupon(String couponcode) {
		CouponEntity findByCouponCode = couponDao.findBycouponcode(couponcode);  //al+shift+L
		System.out.println("System.out.println(\"couponcode \"+couponDtomap.getCouponcode());"+findByCouponCode.getCouponcode());
		CouponDto couponDtomap = mapper.map(findByCouponCode, CouponDto.class);
		return couponDtomap;
	}
	
	public CouponDto insertCoupon(CouponDto couponDto) {
		System.out.println("In service class");
		CouponEntity couponEntitymap = mapper.map(couponDto, CouponEntity.class);
		System.out.println("couponcode Enitity "+couponEntitymap.getCouponcode());
		CouponEntity save = couponDao.save(couponEntitymap);
		CouponDto  couponDtomap = mapper.map(save, CouponDto.class);
		System.out.println("couponcode "+couponDtomap.getCouponcode());
		return couponDtomap;
		
		
	}

	public CouponDto deleteCouponById(Integer couponid) {
//		CouponEntity byId = couponDao.getById(couponId);
		Optional<CouponEntity> findById = couponDao.findById(couponid);
		couponDao.deleteById(couponid);
		CouponDto map = mapper.map(findById, CouponDto.class);
		return map;
	}

	public List<CouponDto> getAllCoupon() {
		
		List<CouponEntity> findAll = couponDao.findAll();
		CouponDto[] map = mapper.map(findAll, CouponDto[].class);
		List<CouponDto> listCouponDto = Arrays.asList(map);
		return listCouponDto;
	}

}
