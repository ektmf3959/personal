package com.playroom.child;

import java.util.List;
import java.util.Scanner;

import com.playroom.member.Member;
import com.playroom.member.MemberManage;
import com.playroom.member.MemberService;

public class ChildService {
	Scanner sc = new Scanner(System.in);

	// 어린이 등록
	public void registerChild() {
		Child child = new Child();
		System.out.println("어린이 이름>");
		String name = sc.nextLine();
		System.out.println("어린이 나이>");
		int age = Integer.parseInt(sc.nextLine());
		System.out.println("보호자 ID>");
		String pid = sc.nextLine();
		System.out.println("배정반,시간대>");
		String cs = sc.nextLine();
		System.out.println("어린이에 대해 알려주세요>");
		String ex = sc.nextLine();

		child.setChildName(name);
		child.setChildAge(age);
		child.setChildParents(pid);
		child.setChildClass(cs);
		child.setChildExplain(ex);

		int result = ChildManage.getInstance().registChild(child);

		if (result == 1) {
			System.out.println("어린이 등록 완료");

		} else {
			System.out.println("어린이 등록 실패");
		}
	}

	// 어린이 수정
	public void updaterChild() {
		Child child = new Child();
		System.out.println("변경할 어린이의 보호자 ID를 입력하세요>");
		String pid = sc.nextLine();
		System.out.println("어린이 이름>");
		String name = sc.nextLine();
		System.out.println("어린이가 몇살로 자랐나요>");
		int age = Integer.parseInt(sc.nextLine());
		System.out.println("바뀐반>");
		String cs = sc.nextLine();
		System.out.println("어린이에 대해 다시 알려주세요>");
		String ex = sc.nextLine();

		child.setChildName(name);
		child.setChildAge(age);
		child.setChildClass(cs);
		child.setChildExplain(ex);
		child.setChildParents(pid);

		int result = ChildManage.getInstance().updateChild(child);

		if (result == 1) {
			System.out.println("어린이의 정보 수정 완료");

		} else {
			System.out.println("어린이의 정보 수정 실패");
		}
	}
	
	
public void getDetailMychild() {
		
		System.out.println("어린이 이름>");
		String childName = sc.nextLine();
				
		/*
		 * CHILD_NAME 
		 * CHILD_AGE 
		 * MEMBER_ID 
		 * CHILD_CLASS 
		 * CHILD_EXPLAIN
		 */
		
		List<Child> list = ChildManage.getInstance().getDetailMychild(childName);
		
		
				//MemberManage.getInstance().getDetailMyinfo(MemberService.memberInfo.getMemberId());
		for ( Child child : list) {
			
			System.out.println("ID : " + child.getChildParents());
			System.out.println("어린이 이름 : " + child.getChildName());
			System.out.println("어린이 나이 : " + child.getChildAge());
			System.out.println("어린이반 : " + child.getChildClass());
			System.out.println("우리 어린이 : " + child.getChildExplain());
			
		}
		
	}

}
