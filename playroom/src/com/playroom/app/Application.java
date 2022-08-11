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
		System.out.println("      llllllll");
		System.out.println("    llllllllllll");
		System.out.println("  llllllllllllllll");
		System.out.println(" lllllllllllllllllll");
		System.out.println("lllllllllllllllllllll");
		System.out.println("");
		System.out.println("    〓〓        〓〓");
		System.out.println("     ●          ●     ");
		System.out.println("");
		System.out.println("          ▲          ");
		System.out.println("");
		System.out.println("▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽");
		System.out.println("▷ 1. 로그인 | 2. 종료 ◁");
		System.out.println("△△△△△△△△△△△△△△△△△");
		try {
		int menuNo = 0;
//		if (menuNo == 0) {
//			System.out.println("다시 로그인 GG");
//			return;
		
//		int a = Integer.parseInt(sc.nextLine());
		menuNo=Integer.parseInt(sc.nextLine());
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

		  } catch(Exception e) {
			  System.out.println("종료합니다.");
			  
		  }
		return;
		
		
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
