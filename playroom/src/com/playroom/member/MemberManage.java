package com.playroom.member;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.playroom.common.DAO;

public class MemberManage extends DAO {

	private static MemberManage mm = new MemberManage();

	private MemberManage() {
	}

	public static MemberManage getInstance() {
		return mm;
	}

	// 로그인
	// 로그인 메소드
	public Member loginInfo(String id) {
		Member member = null;
		try {
			conn();
			// id -> pk
			// 1 row
			// id / pw / ... /
			String sql = "select * from pmember where member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new Member();

				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberRole(rs.getString("member_role"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return member;
	}
	
	//로그아웃 기능
	

	// 고객 등록 메소드
	public int registCustomer(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "insert into pmember (member_id , member_pw,"
					+ "member_name, child_name, member_email, member_addr, member_start,"
					+ "member_last,member_pay, member_role) values (?,?,?,?,?,?,?,ADD_MONTHS(sysdate, ?),?,?)";// member_role
			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getChildName());
			pstmt.setString(5, member.getMemberEmail());
			pstmt.setString(6, member.getMemberAddr());
			pstmt.setString(7, member.getMemberStart());
			pstmt.setString(8, member.getMemberLast());
			pstmt.setInt(9, member.getMemberPay());
			pstmt.setString(10, member.getMemberRole());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;

	}

	// 고객 수정 메소드
	public int updateCustomer(Member member) {
		int result = 0;
		try {
			conn();
			// UPDATE [테이블] SET [열] = '변경할값' WHERE [조건]
			String sql = "update pmember set member_pw =? , member_name =?,"
					+ "child_name=?, member_email=?, member_addr=?,member_pay=? where member_id=?";

			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, member.getMemberPw());
			pstmt.setString(2, member.getMemberName());
			pstmt.setString(3, member.getChildName());
			pstmt.setString(4, member.getMemberEmail());
			pstmt.setString(5, member.getMemberAddr());
			pstmt.setInt(6, member.getMemberPay());
			pstmt.setString(7, member.getMemberId());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;

	}

	//고객 삭제
	public int deleteCustomer(Member member) {
		int result = 0;
		try {
			conn();
			
			String sql = "delete from pmember where member_id=?";

			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, member.getMemberId());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;

	}
	//회원 조회
	public List<Member> getDetailMember(String memberId){
		List<Member> list = new ArrayList<>();
		Member member = null;
		try {
			conn();
			String sql = "select * from pmember where member_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				/*
				 MEMBER_ID
				MEMBER_PW
				MEMBER_NAME
				CHILD_NAME
				MEMBER_EMAIL
				MEMBER_ADDR
				MEMBER_START
				MEMBER_LAST
				MEMBER_PAY
				MEMBER_ROLE
				 */
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberName(rs.getString("member_name"));
				member.setChildName(rs.getString("child_name"));
				member.setMemberEmail(rs.getString("member_email"));
				member.setMemberAddr(rs.getString("member_addr"));
				member.setMemberStart(rs.getString("member_start"));
				member.setMemberLast(rs.getString("member_last"));
				member.setMemberPay(rs.getInt("member_pay"));
				member.setMemberRole(rs.getString("member_role"));
				list.add(member);
				
				}
			}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	
	//나의 정보 조회
	public List<Member> getDetailMyinfo(String memberId){
		List<Member> list = new ArrayList<>();
		Member member = null;
		try {
			conn();
			String sql = "select * from pmember where member_id = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberName(rs.getString("member_name"));
				member.setChildName(rs.getString("child_name"));
				member.setMemberEmail(rs.getString("member_email"));
				member.setMemberAddr(rs.getString("member_addr"));
				member.setMemberStart(rs.getString("member_start"));
				member.setMemberLast(rs.getString("member_last"));
				member.setMemberPay(rs.getInt("member_pay"));
				member.setMemberRole(rs.getString("member_role"));
				list.add(member);
				
				}
			}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	
	
	
	
	
	//매출총합
	public int getPay(){
		int pay = 0;
		try {
			conn();
			String sql = "SELECT sum(member_pay) FROM pmember";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
		
			if(rs.next()) {
				pay = rs.getInt("sum(member_pay)");
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}		
		return pay;
	}
}
