package com.cos.yjh.domain.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 테이블 모델
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // 테이블 생성


public class User {	// 모델링
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	
	private int		id;				//PK (자동증가 번호)
	private String username;// 아이디
	private String password;
	private String email;
}