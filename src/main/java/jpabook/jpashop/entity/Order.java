package jpabook.jpashop.entity;

import jakarta.persistence.*;
import jpabook.jpashop.type.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.sql.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
@Getter
@Setter
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;


//    @OneToMany(mappedBy = "order") // 다대일 양방향 관계(권장 O)
//    private List<OrderItem> orderItems = new ArrayList<>();


    @OneToOne
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;


    @OneToMany  // 단방향 일대다 관계 (권장 X)
    @JoinColumn(name = "ORDER_ID")
    private List<OrderItem> orderItems = new ArrayList<>();

    private LocalDateTime orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;


//    public void addOrderItem(OrderItem orderItem) {
//        orderItems.add(orderItem);
//        orderItem.setOrder(this);
//    }
}
