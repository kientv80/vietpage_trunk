package com.vnsoft.server.actions;

import java.util.Calendar;
import java.util.Map;

import org.apache.log4j.Logger;

import com.vnsoft.server.biz.CompanyBean;
import com.vnsoft.server.biz.NewsBean;
import com.vnsoft.server.model.News;

public class CompanyAction extends StandarLayout {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6832423155938800985L;
	private String headerImage;
	private String contentImage;
	private String newsContent;
	private String description;
	private String publicWebsite;
	private Logger logger = Logger.getLogger(CompanyAction.class);
	@Override
	public String execute() {
		try {
//			init();
			if(getComId() == null || getComId().isEmpty()){
				return "nocompanyid";
			}
			String imageSeperator = "/";
			if ("editheader".equals(getAction())) {
				System.out.println("edit header");
				if (getHeaderImage().indexOf("\\") > 0)
					imageSeperator = "\\";
				
				String fileName = "header_"+getComId()+"_"+System.currentTimeMillis()+".jpg";
				
				Map<String,String> image = uploadFile(fileName,getComId(),UPLOAD_OBJECT.BANNER);
				CompanyBean.getInstance().editCompanyHeaderImage(Integer.valueOf(getComId()),image.get(StandarLayout.IMAGE), image.get(StandarLayout.THUMBNAIL));
				
			} else if ("editContentImage".equals(getAction())) {
				if (contentImage.indexOf("\\") > 0)
					imageSeperator = "\\";
				String fileName = "page_"+getComId()+"_"+System.currentTimeMillis()+".jpg";
				Map<String,String> file = uploadFile(fileName,getComId(),UPLOAD_OBJECT.PAGE_CENTER);
				CompanyBean.getInstance().editCompanyImage(Integer.valueOf(getComId()), file.get(StandarLayout.IMAGE),file.get(StandarLayout.THUMBNAIL));
				
			} else if ("editNews".equals(getAction())) {
				News n = new News();
				n.setContent(newsContent);
				n.setComId(Long.valueOf(getComId()));
				NewsBean.getInstance().editNewsInfo(n);
			}else if("editDescription".equals(getAction())){
				CompanyBean.getInstance().editCompanyDescription(Integer.valueOf(getComId()), description);
			}else if ("edit_publish".equals(getAction())) {
				
				if(publicWebsite != null && !publicWebsite.isEmpty()){
					CompanyBean.getInstance().publicWebsite(Integer.valueOf(getComId()),true);
					System.out.println("edit_publish "+publicWebsite);
				}
				else{
					CompanyBean.getInstance().publicWebsite(Integer.valueOf(getComId()),false);
					System.out.println("edit_publish null "+publicWebsite);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("", e);
		}
		return super.execute();
	}

	public String getHeaderImage() {
		return headerImage;
	}

	public void setHeaderImage(String headerImage) {
		this.headerImage = headerImage;
	}

	public String getContentImage() {
		return contentImage;
	}

	public void setContentImage(String contentImage) {
		this.contentImage = contentImage;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription(){
		return this.description;
	}

	public String getPublicWebsite() {
		return publicWebsite;
	}

	public void setPublicWebsite(String publicWebsite) {
		this.publicWebsite = publicWebsite;
	}
}
