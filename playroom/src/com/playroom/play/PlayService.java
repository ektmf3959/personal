package com.playroom.play;

import java.util.List;
import java.util.Scanner;

public class PlayService {
	Scanner sc = new Scanner(System.in);
	
	//수업 변경
	public void updaterPlay() {
		Play play = new Play();
		System.out.println("변경할 수업의 선생님 이름을 쓰세요>");
		String t = sc.nextLine();
		System.out.println("변경할 시간표를 쓰세요>");
		String time = sc.nextLine();
		System.out.println("변경한 식단표를 쓰세요>");
		String food = sc.nextLine();

		play.setTeacher(t);
		play.setTime(time);
		play.setFood(food);
		
		int result = PlayManage.getInstance().updatePlay(play);

		if (result == 1) {
			System.out.println("변경 완료");

		} else {
			System.out.println("변경 실패");
		}
	}
	
	//조회
	public void getPlay() {
		List<Play> list = PlayManage.getInstance().getPlay();
		for (Play play : list) {
			System.out.println("==========================================");
			System.out.println("| 선생님 : " + play.getTeacher());
			System.out.println("| 시간표 : " + play.getTime());
			System.out.println("| 식단표 : " + play.getFood());
			System.out.println("==========================================");
		}
	}
}
