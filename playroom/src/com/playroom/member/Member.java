package com.playroom.member;

import lombok.Data;
import lombok.ToString;

@Data
@ToString

public class Member {
	/*
member_id VARCHAR2(20) PRIMARY key,
member_pw VARCHAR2(20) not null,
member_name VARCHAR2(20) not null,
child_name VARCHAR2(20) not null,
member_email VARCHAR2(100),
member_addr VARCHAR2(150),
member_start date,
member_last date,
member_pay number,
member_role CHAR(1)
	 */
	private String memberId;
	private String memberPw;
	private String memberName;
	private String childName;
	private String memberEmail;
	private String memberAddr;
	private String memberStart;
	private String memberLast;
	private int memberPay;
	private String memberRole;
	
	
}
