package com.vnsoft.server.actions;

import java.util.ArrayList;
import java.util.List;

import com.vnsoft.server.biz.CompanyBean;
import com.vnsoft.server.model.CompanyInfo;

public class ApprovePageAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3449672975636385913L;
	private String comid;
	private String searchText;
	private String isApproved = null;
	private String isReviewed = null;
	private List<CompanyInfo> companies = new ArrayList<>();

	@Override
	public String execute() throws Exception {
		if (isNum(comid)) {
			if (comid != null && "un_approve".equals(getAction())){
				CompanyBean.getInstance().approvePage(Integer.valueOf(comid), false);
				CompanyBean.getInstance().markReviewed(Integer.valueOf(comid), true);
			}else if (comid != null && "approve".equals(getAction())){
				CompanyBean.getInstance().approvePage(Integer.valueOf(comid), true);
				CompanyBean.getInstance().markReviewed(Integer.valueOf(comid), true);
			}else if("reviewed".equals(getAction())){
				CompanyBean.getInstance().markReviewed(Integer.valueOf(comid), true);
			}else if (comid != null && "delete".equals(getAction())){
				CompanyBean.getInstance().deleteCompany(comid);
			}
		}
		boolean approved = false;
		boolean reviewed = false;
		if(isApproved != null)
			approved = true;
		if(isReviewed != null)
			reviewed = true;
		
		if("search".equals(getAction())){
			if(searchText != null && !searchText.isEmpty())
				companies = CompanyBean.getInstance().searchPagesByName(searchText);
			else
				companies = CompanyBean.getInstance().getPages(approved,reviewed);
		}else{
			companies = CompanyBean.getInstance().getPages(approved,reviewed);
		}
		return SUCCESS;
	}

	private boolean isNum(String comid) {
		try {
			Integer.parseInt(comid);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String getComid() {
		return comid;
	}

	public void setComid(String comid) {
		this.comid = comid;
	}

	public List<CompanyInfo> getCompanies() {
		return companies;
	}

	public void setCompanies(List<CompanyInfo> companies) {
		this.companies = companies;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public String getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(String isApproved) {
		this.isApproved = isApproved;
	}

	public String getIsReviewed() {
		return isReviewed;
	}

	public void setIsReviewed(String isReviewed) {
		this.isReviewed = isReviewed;
	}
}
