package com.playroom.play;

import java.util.ArrayList;
import java.util.List;

import com.playroom.common.DAO;

public class PlayManage extends DAO {
	private static PlayManage pm = new PlayManage();

	private PlayManage() {
	}

	static PlayManage getInstance() {
		return pm;
	}

	// 수업 수정 메소드
	public int updatePlay(Play play) {
		int result = 0;
		try {
			conn();
			// UPDATE [테이블] SET [열] = '변경할값' WHERE [조건]
			String sql = "update play set play_table =?,play_food =?" 
						+ " where play_teacher=?";

			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, play.getTime());
			pstmt.setString(2, play.getFood());
			pstmt.setString(3, play.getTeacher());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;

	}
	
	//선생님,식단,시간표 조회
	public List<Play> getPlay() {
		List<Play> list = new ArrayList<>();
		Play play = null;
		try {
			conn();
			String sql = "select play_teacher, play_table, play_food from play";
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				play = new Play();
				play.setTeacher(rs.getString("play_teacher"));
				play.setTime(rs.getString("play_table"));
				play.setFood(rs.getString("play_food"));
				list.add(play);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;
	}
}
