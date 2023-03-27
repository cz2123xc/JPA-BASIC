package jpabook.jpashop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEMBER_ID")
    private Long id;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

//    @ManyToMany // 일반적으로 이런 정석 방법 ManyToMany 는 쓰지 않는다.
//    @JoinTable(name="MEMBER_PRODUCT")
//    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "member") // 중간 테이블을 이용한 ManyToMany
    private List<MemberProduct> memberProducts = new ArrayList<>();

    private String name;
    private String city;
    private String street;
    private String zipcode;

}
