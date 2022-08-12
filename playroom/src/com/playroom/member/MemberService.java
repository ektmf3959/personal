package com.playroom.member;

import java.util.List;
import java.util.Scanner;

import com.playroom.app.Application;





public class MemberService {
	public static Member memberInfo = null;
	Scanner sc = new Scanner(System.in);
	
	//로그인
	public void doLogin() {
		Member member = new Member();
		
		System.out.println("ID>");
		
		String id = sc.nextLine();
		
		System.out.println("PW>");
		
		String pw = sc.nextLine();
	
		// 1 row
		
		member = MemberManage.getInstance().loginInfo(id);
		
		try {
	         if (member != null) {
	            memberInfo = member;
	         } else {
	            System.out.println("등록되지 않은 아이디 입니다.");
	            new Application();
	         }
	         if (member.getMemberPw().equals(pw)) {
	            memberInfo = member;
	         } else {
	            System.out.println("비밀번호가 일치하지 않습니다.");

	            memberInfo = null;
	            new Application();
	         }
	      } catch (Exception e) {
	    	  
	      }return;
	}
	
//	public void doLogin() {
//	      Member member = new Member();
//	   
//	      System.out.println("접속할 ID를 입력해주세요 ▶▶");
//	      String id = sc.nextLine();
//	      System.out.println("접속할 PW를 입력해주세요 ▶▶>");
//	      String pw = sc.nextLine();
//
//	      member = MemberManage.getInstance().getloginInfo(id);
//
//	      if (member != null && member.getMemberId().equals(id) && member.getMemberPw().equals(pw)) {
//	         memberInfo = member;
//	         System.out.println("   〓〓 환영합니다 !! 〓〓");
//	         System.out.println("  〓〓 로그인 되었습니다. 〓〓");
//	         return;
//	      } else if (member == null){
//	         System.out.println("    〓〓 존재하지 않는 ID입니다. 〓〓");
//	         System.out.println("  〓〓 로그인 ID를 다시 확인해주세요. 〓〓");
//	         return;
//	      }else if (member.getMemberId().equals(id) && !member.getMemberPw().equals(pw)) {
//	         System.out.println("      〓〓 잘못된 PW입니다. 〓〓");
//	         System.out.println("  〓〓 로그인 PW를 다시 확인해주세요. 〓〓");
//	         return;
//	      }

		
		
		
		
		
//		//DB에서 조회한 정보와 내가 입력한 PW 비교
//		if(member.getMemberPw().equals(pw)) {
//			memberInfo = member;
//		} else {
//			System.out.println("로그인 실패");
//		}
//	}
	
	//로그아웃
//	public void logout() {
//		
//		if(memberInfo != null)
//		memberInfo = null;
//	}
	
	//고객 등록
	public void registerCustomer() {
		Member member = new Member();
		System.out.println("고객 ID>");
		String id = sc.nextLine();
		System.out.println("고객  PW>");
		String pw = sc.nextLine();
		System.out.println("고객 이름>");
		String name = sc.nextLine();
		System.out.println("자녀 이름>");
		String cname = sc.nextLine();
		System.out.println("이메일>");
		String mail = sc.nextLine();
		System.out.println("주소>");
		String addr = sc.nextLine();
		System.out.println("첫날>");
		String start = sc.nextLine();
		System.out.println("기간>"); // 마지막날 계산식으로 출력? 첫날+3개월, 첫날+6개월
		String last = sc.nextLine();
		System.out.println("결제액>");
		int pay = Integer.parseInt(sc.nextLine());

				
		
		member.setMemberId(id);
		member.setMemberPw(pw);
		member.setMemberName(name);
		member.setChildName(cname);
		member.setMemberEmail(mail);
		member.setMemberAddr(addr);
		member.setMemberStart(start);
		member.setMemberLast(last);
		member.setMemberPay(pay);		
		member.setMemberRole("0");
		
		int result = MemberManage.getInstance().registCustomer(member);
		
		if(result == 1) {
			System.out.println("고객 정보 등록 완료");
			
		} else {
			System.out.println("고객 정보 등록 실패");
		}
	}
	
	//고객 정보 수정
	public void updaterCustomer() {
		Member member = new Member();
		System.out.println("변경할 고객 ID>");
		String id = sc.nextLine();
		
		System.out.println("고객  PW>");
		String pw = sc.nextLine();
		System.out.println("고객 이름>");
		String name = sc.nextLine();
		System.out.println("자녀 이름>");
		String cname = sc.nextLine();
		System.out.println("이메일>");
		String mail = sc.nextLine();
		System.out.println("주소>");
		String addr = sc.nextLine();
		System.out.println("결제액>");
		int pay = Integer.parseInt(sc.nextLine());				
		
		member.setMemberId(id);
		member.setMemberPw(pw);
		member.setMemberName(name);
		member.setChildName(cname);
		member.setMemberEmail(mail);
		member.setMemberAddr(addr);
		member.setMemberPay(pay);
		
		int result = MemberManage.getInstance().updateCustomer(member);
		
		if(result == 1) {
			System.out.println("고객 정보 수정 완료");
			
		} else {
			System.out.println("고객 정보 수정 실패");
		}
	}
	
	//고객 삭제(child 함께 삭제)
	public void deleteCustomer() {
		Member member = new Member();
		System.out.println("삭제할 ID>");
		String member_id = sc.nextLine();
		
		member.setMemberId(member_id);

		int result = MemberManage.getInstance().deleteCustomer(member);
		if (result == 1) {
			System.out.println("삭제완료");

		} else {
			System.out.println("삭제실패");
		}

	}
	//조회
	public void getDetailmember() {
		
		System.out.println("고객 ID>");
		String memberId = sc.nextLine();
				
		List<Member> list = MemberManage.getInstance().getDetailMember(memberId);
		for ( Member member : list) {
			
			System.out.println("ID : " + member.getMemberId());
			System.out.println("회원명 : "+ member.getMemberName());
			System.out.println("자녀 이름 : " + member.getChildName());
			System.out.println("이메일 : " + member.getMemberEmail());
			System.out.println("주소 : " + member.getMemberAddr());
			System.out.println("등록일 : " + member.getMemberStart());
			System.out.println("만료일 : " + member.getMemberLast());
			System.out.println("지출액 : " + member.getMemberPay());
			
		}
		
	}
	
	//나의 조회
	public void getDetailMyinfo() {
		
//		System.out.println("고객 ID>");
//		String memberId = sc.nextLine();
				
		List<Member> list = MemberManage.getInstance().getDetailMyinfo(MemberService.memberInfo.getMemberId());
		for ( Member member : list) {
			
			System.out.println("ID : " + member.getMemberId());
			System.out.println("회원명 : "+ member.getMemberName());
			System.out.println("자녀 이름 : " + member.getChildName());
			System.out.println("이메일 : " + member.getMemberEmail());
			System.out.println("주소 : " + member.getMemberAddr());
			System.out.println("등록일 : " + member.getMemberStart());
			System.out.println("만료일 : " + member.getMemberLast());
			System.out.println("지출액 : " + member.getMemberPay());
			
		}
		
	}
	
	
	
	
	
	
	
	//매출총합
	public void allPay() {
		List<Member> list = MemberManage.getInstance().getPay();
//		int pay = MemberManage.getInstance().getPay();
//			
//			System.out.println("==================");
//			System.out.println("|    " + pay + "    |");
//			System.out.println("==================");
		
			for ( Member member : list) {
			
			System.out.println("| 월 : " + member.getMemberStart() + " | 매출 : " + member.getMemberPay() + " | ");
			
		}

	}
	
	
	
	
}
