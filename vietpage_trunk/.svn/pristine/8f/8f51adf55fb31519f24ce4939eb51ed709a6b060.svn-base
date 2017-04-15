package com.vnsoft.server.model;

import java.io.Serializable;
import java.sql.Date;

public class Feed implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6363985170907793868L;
	String feed;
	private Date postedDate;
	String image;
	private String comName;
	long comid;
	long id;
	private String title;
	private String link;
	private String thumb1Image;
	private String thumb2Image;
	private int viewCount;
	public String getFeed() {
		return feed;
	}

	public void setFeed(String feed) {
		this.feed = feed;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public long getComid() {
		return comid;
	}

	public void setComid(long comid) {
		this.comid = comid;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getThumb1Image() {
		if (thumb1Image != null)
			return thumb1Image;
		else
			return image;
	}

	public void setThumb1Image(String thumb1Image) {
		this.thumb1Image = thumb1Image;
	}

	public String getThumb2Image() {
		if (thumb2Image != null)
			return thumb2Image;
		else
			return image;
	}

	public void setThumb2Image(String thumb2Image) {
		this.thumb2Image = thumb2Image;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comName == null) ? 0 : comName.hashCode());
		result = prime * result + (int) (comid ^ (comid >>> 32));
		result = prime * result + ((feed == null) ? 0 : feed.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + ((postedDate == null) ? 0 : postedDate.hashCode());
		result = prime * result + ((thumb1Image == null) ? 0 : thumb1Image.hashCode());
		result = prime * result + ((thumb2Image == null) ? 0 : thumb2Image.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + viewCount;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Feed)) {
			return false;
		}
		Feed other = (Feed) obj;
		
		if (id != other.id) {
			return false;
		}
		return true;
	}
	

}
