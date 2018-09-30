package com.yanzi.study.lession18.jpa;

import com.yanzi.study.lession18.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityJPA extends JpaRepository<Authority, String> {
}
