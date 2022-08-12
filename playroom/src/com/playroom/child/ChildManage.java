package com.playroom.child;

import java.util.ArrayList;
import java.util.List;

import com.playroom.common.DAO;

public class ChildManage extends DAO {

	private static ChildManage cm = new ChildManage();

	private ChildManage() {
	}

	static ChildManage getInstance() {
		return cm;
	}

	// 어린이 등록
	public int registChild(Child child) {
		int result = 0;
		try {
			conn();
			String sql = "insert into child (child_name , child_age,"
					+ "member_id, child_class, child_explain) values (?,?,?,?,?)";
			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, child.getChildName());
			pstmt.setInt(2, child.getChildAge());
			pstmt.setString(3, child.getChildParents());
			pstmt.setString(4, child.getChildClass());
			pstmt.setString(5, child.getChildExplain());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

	// 어린이 수정 메소드
	public int updateChild(Child child) {
		int result = 0;
		try {
			conn();
			// UPDATE [테이블] SET [열] = '변경할값' WHERE [조건]
			String sql = "update child set child_name=? , child_age =?,"
					+ " child_class=?, child_explain=? where member_id=?";

			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, child.getChildName());
			pstmt.setInt(2, child.getChildAge());
			pstmt.setString(3, child.getChildClass());
			pstmt.setString(4, child.getChildExplain());
			pstmt.setString(5, child.getChildParents());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;

	}

	// 어린이 정보 조회
	public List<Child> getDetailMychild(String cmemberId) {
		List<Child> list = new ArrayList<>();
		Child child = null;
		try {
			conn();
			String sql = "select * from child where member_id = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cmemberId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				/*
				 * CHILD_NAME CHILD_AGE MEMBER_ID CHILD_CLASS CHILD_EXPLAIN
				 */

				child = new Child();

				child.setChildParents(rs.getString("member_id"));
				child.setChildName(rs.getString("child_name"));
				child.setChildAge(rs.getInt("child_age"));
				child.setChildClass(rs.getString("child_class"));
				child.setChildExplain(rs.getString("child_explain"));
				list.add(child);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
}
