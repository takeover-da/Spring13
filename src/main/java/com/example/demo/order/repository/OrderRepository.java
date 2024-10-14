package com.example.demo.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.order.entity.Order;
import java.util.List;
import java.time.LocalDate;


public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	// 날짜를 기준으로 주문이력 조회
	@Query(nativeQuery = true, value = "select * from tbl_order where order_date = :date")
	List<Order> findByOrderDate(@Param("date") LocalDate date);

	// 날짜를 기준으로 주문이력 삭제
	@Query(nativeQuery = true, value = "delete from tbl_order where order_date = :date")
	void removeByOrderDate(@Param("date") LocalDate date);
}
