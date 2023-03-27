package jpabook.jpashop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Product {

    @Id @GeneratedValue
    private Long id;
    private String name;
//    @ManyToMany(mappedBy = "products") // 일반적으로 이런 정석 방법 ManyToMany 는 쓰지 않는다.
//    private List<Member> members = new ArrayList<>();

    @OneToMany(mappedBy = "product") // 중간 테이블을 이용한 ManyToMany
    private List<MemberProduct> memberProducts = new ArrayList<>();

}
