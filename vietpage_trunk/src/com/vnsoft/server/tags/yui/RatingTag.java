package com.vnsoft.server.tags.yui;

import javax.servlet.jsp.JspException;

import org.apache.log4j.Logger;

public class RatingTag extends YUICustomTag {
	Logger log = Logger.getLogger(RatingTag.class);
	private int rating;

	@Override
	public int doEndTag() throws JspException {
		StringBuilder content = new StringBuilder();
		try {
			content.append("<div class=\"rating\">").append("<div class=\"ratinglabel\"></div>");
			for (int i = 0; i < rating; i++) {
				content.append("<div class=\"star\"></div>");
			}
			for (int j = 0; j < 5 - rating; j++) {
				content.append("<div class=\"graystar\"></div>");
			}
			content.append("</div>");
			print(content.toString());
		} catch (Exception e) {
			log.error("TabTag", e);
		}
		return EVAL_PAGE;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
