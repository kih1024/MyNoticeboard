package com.kih.board.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

//    이미 생성된 사용자인지 아닌지 처음 가입해야하는 사용자인지 확인하기 위한 메소드.
    Optional<User> findByEmail(String email);
}
