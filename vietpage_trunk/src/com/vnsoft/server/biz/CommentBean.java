package com.vnsoft.server.biz;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.vnsoft.server.model.Comment;



public class CommentBean {
	Logger log = Logger.getLogger(CommentBean.class);
	public List<Comment> getComments(int comId, int limit) throws Exception{
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		List<Comment> comments = new ArrayList<>();
		try {
			con = JDBCConnection.getInstance().getConnection();
			stm = con.prepareStatement("Select  * from comment  where comid=? ORDER BY posteddate LIMIT " + limit);
			stm.setInt(1, comId);
			result = stm.executeQuery();
			while (result.next()) {
				Comment com = new Comment();
				com.setId(result.getInt("id"));
				com.setComid(result.getInt("comid"));
				com.setContent(result.getString("content"));
				com.setEmailOfPoster(result.getString("emailofposter"));
				com.setPostedDate(result.getDate("posteddate"));
				com.setPostedBy(result.getString("postedby"));
				comments.add(com);
			}
		} catch (Exception e) {
			log.error("", e);
		}finally{
			if (result != null)
				result.close();
			if (stm != null)
				stm.close();
			if (con != null)
				con.close();
		}
		return comments;
	}
	public void addComment(Comment com) throws Exception{
		String sql = "insert into comment(comid,posteddate,content,postedby,emailofposter)values(?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stm = null;
		try {
			con = JDBCConnection.getInstance().getConnection();
			stm = con.prepareStatement(sql);
			stm.setInt(1, com.getComid());
			stm.setDate(2, new Date(Calendar.getInstance().getTimeInMillis()));
			stm.setString(3, com.getContent());
			stm.setString(4, com.getPostedBy());
			stm.setString(5, com.getEmailOfPoster());
			stm.executeUpdate();
		} catch (Exception e) {
			log.error("", e);
		}finally{
			if (stm != null)
				stm.close();
			if (con != null)
				con.close();
		}
	}

}
