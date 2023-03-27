package jpabook.jpashop;

import jpabook.jpashop.entity.*;
import jpabook.jpashop.repository.LockerRepository;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.repository.OrderItemRepository;
import jpabook.jpashop.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class JpashopApplicationTests {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private LockerRepository lockerRepository;

	@Test
	public void test01() { // ManyToOne 단방향, 양방향

//		Order order = new Order();
//		order.addOrderItem(new OrderItem()); // 양방향일때 양방향 연관관계 주입

//		Order order = new Order();
//		orderRepository.save(order);
//		OrderItem orderItem = new OrderItem();
//		orderItem.setOrder(order);
//		orderItemRepository.save(orderItem); // 단방향일때 연관관계 주입


	}

	@Test
	public void test02() { // OneToMany 단방향

		OrderItem orderItem = new OrderItem();
		orderItem.setOrderPrice(1000);
		orderItemRepository.save(orderItem);

		LocalDateTime now = LocalDateTime.now();
		Order order = new Order();
		order.setOrderDate(now); // 위에서 Insert 된 orderItem 을 update 문으로 order 의 PK를 FK로 넣어주게 된다.
		order.getOrderItems().add(orderItem); // OneToMany 로 Order 테이블이 OrderItem 테이블의 주인이기때문에 orderItem 테이블을 호출해서 값을 넣어준다.
		orderRepository.save(order);
	}

	@Test
	public void test03() {

		Locker locker = new Locker();
		locker.setName("락커01");
		lockerRepository.save(locker);

		Member member = new Member();
		member.setName("홍길동");
		memberRepository.save(member);

	}



}
