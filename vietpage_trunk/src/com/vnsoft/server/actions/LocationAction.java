package com.vnsoft.server.actions;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.vnsoft.server.biz.LocationBean;
import com.vnsoft.server.model.KeyValue;
import com.vnsoft.server.util.JSONHelper;


public class LocationAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2870135585896271116L;
	private String action;
	private String id;
	private String type;
	@Override
	public String execute() throws Exception {
		getHttpServletRequest().setCharacterEncoding("utf-8");
		getHttpServletResponse().setCharacterEncoding("utf-8");
		action = getHttpServletRequest().getParameter("action");
		id = getHttpServletRequest().getParameter("id");
		System.out.println(">>>>>>>>> type >>>>>>>>>>>>"+type);
		if("getlocation".equals(action) && id != null && !id.isEmpty()){
			boolean all = true;
			if(type != null && type.equals("limit")){
				all = false;
			}
			List<KeyValue> locations  = new ArrayList<>();
			locations.add(new KeyValue("0", "-- Chon vị trí --"));
			locations.addAll(1,LocationBean.getInstance().getLocation(Integer.valueOf(id),all));
			PrintWriter out = getHttpServletResponse().getWriter();
			out.write(JSONHelper.toJSONArray(locations).toString());
			out.close();
		}
		return SUCCESS;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
