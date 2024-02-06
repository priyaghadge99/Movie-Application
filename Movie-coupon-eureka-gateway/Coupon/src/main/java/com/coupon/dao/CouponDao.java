package com.coupon.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coupon.entity.CouponEntity;

@Repository
public interface CouponDao extends JpaRepository<CouponEntity, Integer> {

	public CouponEntity findBycouponcode(String couponcode);

}
