package com.playroom.app;

import java.util.Scanner;

import com.playroom.member.MemberService;

public class Application {
	Scanner sc = new Scanner(System.in);
	MemberService ms = new MemberService();
	
	int menuNo = 0;
	
	public Application() {
		run();
		
	}

	private void run() {
		System.out.println("1. 로그인 | 2. 종료");
		menuNo=Integer.parseInt(sc.nextLine());
//		int a = Integer.parseInt(sc.nextLine());
		switch (menuNo) {
		case 1://로그인 하는 기능
			ms.doLogin();
			
			if(MemberService.memberInfo != null) {
				new ManageMent();
			}
			break;
		case 2:
			System.out.println("종료합니다.");
			break;
		}
		
//		if ( a == 1) {
//			ms.doLogin();
////			
//				new ManageMent();
//		}else if ( a == 2) {
//			
//			MemberService.memberInfo = null;
//			System.out.println("종료");
//		}
	}
}
