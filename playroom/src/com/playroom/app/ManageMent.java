package com.playroom.app;

import java.util.Scanner;

import com.playroom.child.ChildService;
import com.playroom.member.MemberService;
import com.playroom.play.PlayService;

public class ManageMent {

	Scanner sc = new Scanner(System.in);

	MemberService ms = new MemberService();
	ChildService cs = new ChildService();
	PlayService ps = new PlayService();
//	Application al = new Application();

	int menuNo = 0;

	public ManageMent() {
		playJob();
	}

	private void playJob() {
		while (true) {
			// 메뉴 출력 이동
			menuInfo();
			if (MemberService.memberInfo.getMemberRole().equals("1")) {
				if (menuNo == 1) {
					// 고객등록
					ms.registerCustomer();
				} else if (menuNo == 2) {
					// 고객 수정
					ms.updaterCustomer();
				} else if (menuNo == 3) {
					// 어린이 등록
					cs.registerChild();
				} else if (menuNo == 4) {
					// 어린이 수정
					cs.updaterChild();
				} else if (menuNo == 5) {
					// 강사,시간표,식단표 조회
					ps.getPlay();
				} else if (menuNo == 6) {
					// 시간표 식단 변경
					ps.updaterPlay();
				} else if (menuNo == 7) {
					// 고객,어린이 삭제
					ms.deleteCustomer();
				} else if (menuNo == 8) {
					// 고객조회
					ms.getDetailmember();
				} else if (menuNo == 9) {
					// 총매출금액
					ms.allPay();
				}else if (menuNo == 10) {
					System.out.println("종료");
					if (MemberService.memberInfo != null) {

						MemberService.memberInfo = null;
					}
					new Application();
					break;
				}
			} else if (MemberService.memberInfo.getMemberRole().equals("0")) {

				if (menuNo == 1) {
					// 나의 정보 조회
					ms.getDetailMyinfo();
				} else if (menuNo == 2) {
					// 어린이 정보 조회
					cs.getDetailMychild();
				} else if (menuNo == 3) {
					// 학원 시간표
					ps.getPlay();
				} else if (menuNo == 4) {
					// 종료
					System.out.println("종료");
					if (MemberService.memberInfo != null) {

						MemberService.memberInfo = null;
					}
					
					new Application();
					break;
				}
			}

		}

	}

	private void menuInfo() {
		// role == 1, admin(관리자)
		if (MemberService.memberInfo.getMemberRole().equals("1")) {
			System.out.println("▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽"
					+ "▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼");
			System.out.println("▷ 1. 고객 등록 | 2. 고객 수정  | 3. 어린이 등록 | 4. 어린이 수정" + " | 5. 강사,시간표,식단표 조회 | 6. 시간표 식단 변경"
					+ " | 7. 회원 탈퇴 | 8. 고객 조회 | 9. 월별매출 | 10. 종료 ◀");
			System.out.println("△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△"
					+ "△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲");
		}
		// role == 0 회원
		else if (MemberService.memberInfo.getMemberRole().equals("0")) {
			System.out.println("▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼▽▼");
			System.out.println("▷ 1. 나의 정보 조회 | 2. 어린이 정보 조회 | 3. 학원 시간표 | 4. 종료 ◀");
			System.out.println("△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲△▲");
		}
		System.out.println("입력>");
		menuNo = Integer.parseInt(sc.nextLine());

	}
}
