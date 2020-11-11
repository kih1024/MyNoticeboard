package com.kih.board.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// db에 접근하기 위한 dao
public interface PostsRepository extends JpaRepository<Posts,Long> {

}
