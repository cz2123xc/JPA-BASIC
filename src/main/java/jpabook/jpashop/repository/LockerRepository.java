package jpabook.jpashop.repository;

import jpabook.jpashop.entity.Locker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LockerRepository extends JpaRepository<Locker, Long> {

}
