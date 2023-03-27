package jpabook.jpashop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderItem {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

//    @ManyToOne // 다대일 양방향 관계(권장 O)
//    @JoinColumn(name = "ORDER_ID")
//    private Order order;

    @ManyToOne // 일대다 양방향
    @JoinColumn(name = "ORDER_ID", insertable = false, updatable = false)
    private Order order;


    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    private int orderPrice;
    private int count;

}
