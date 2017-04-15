package com.vnsoft.server.actions;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.vnsoft.server.biz.CommentBean;
import com.vnsoft.server.model.Comment;
import com.vnsoft.server.util.JSONHelper;

public class CommentAction extends StandarLayout {
	/**
	 * 
	 */
	private static final long serialVersionUID = -877144978169421834L;
	private String comment;
	private String emailOfPoster;
	private String postedBy;
	private String action;
	private List<Comment> comments = new ArrayList<>();
	private String companyId;
	private Logger logger = Logger.getLogger(CommentAction.class);
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String execute() {
		try {
			if (getComId() == null || getComId().isEmpty()) {
				return "nocompanyid";
			}
			if ("new".equals(action)) {
				Comment com = new Comment();
				com.setContent(comment);
				com.setComid(Integer.valueOf(getComId()));
				com.setEmailOfPoster(emailOfPoster);
				com.setPostedBy(postedBy);
				com.setPostedDate(new Date());
				try {
					new CommentBean().addComment(com);
					setComments(new CommentBean().getComments(Integer.valueOf(getComId()), 100));
				} catch (Exception e) {
					e.printStackTrace();
				}
				return SUCCESS;
			}
			if ("getcomments".equals(action) && getComId() != null) {
				List<Comment> coms = new CommentBean().getComments(Integer.valueOf(getComId().toString()), 20);

				String comments = JSONHelper.toJSONArray(coms).toString();
				getHttpServletResponse().setContentType("application/json;charset=utf-8");
				PrintWriter out = getHttpServletResponse().getWriter();
				String result = "{\"results\":" + comments + "}";
				out.write(getCallback() + "(" + result + ")");
				out.write(comments);
				out.close();

			} else {
				System.out.println("Load comment comid="+getComId());
				super.execute();
				setComments(new CommentBean().getComments(Integer.valueOf(getComId()), 100));
				System.out.println("Found comments size=" + getComments().size());
				return "load";
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("", e);

		}
		return super.execute();
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getEmailOfPoster() {
		return emailOfPoster;
	}

	public void setEmailOfPoster(String emailOfPoster) {
		this.emailOfPoster = emailOfPoster;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
}
