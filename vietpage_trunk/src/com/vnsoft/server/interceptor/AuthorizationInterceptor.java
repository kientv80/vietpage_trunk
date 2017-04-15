package com.vnsoft.server.interceptor;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.vnsoft.server.actions.LoginAction;
import com.vnsoft.server.biz.AuthorizationBean;
import com.vnsoft.server.model.CompanyInfo;

@SuppressWarnings("serial")
public class AuthorizationInterceptor extends AbstractInterceptor {
	public static final String ACCESS_DENINED = "access_denined";
	public static final String TYPE_COMPANY = "company";
	public static final String TYPE_ABOUT = "about";
	public static final String TYPE_CONTACTINFO = "contactinfo";
	public static final String TYPE_SERVICE = "service";
	public static final String TYPE_MENUITEM = "menuitem";
	public static final String TYPE_NEWS = "news";
	public static final String LOAD_COMMENTS = "loadComments";
	public static final String DELETE = "delete";
	public static final String EDIT = "edit";
	public static final String ADD = "add";
	private Logger logger = Logger.getLogger(AuthorizationInterceptor.class);
	List<String> actions = new ArrayList<>();
	{
		actions.add(ADD);
		actions.add(EDIT);
		actions.add(DELETE);
		actions.add(LOAD_COMMENTS);
	}
	@Override
	public String intercept(ActionInvocation inv) throws Exception {
		if(checkAuthorize(inv)){
			return inv.invoke();
		}else{
			return ACCESS_DENINED;
		}
	}

	private boolean checkAuthorize(ActionInvocation inv) throws Exception, Exception {
		Object action = inv.getInvocationContext().getParameters().get("action");
		Object type = inv.getInvocationContext().getParameters().get("type");
		Object id = inv.getInvocationContext().getParameters().get("id");
		Object selectedIds = inv.getInvocationContext().getParameters().get("selectedIds");
		if(action != null && needCheckAuthorize(getValue(action))){
			if(type == null || type.toString().isEmpty()  || id.toString().isEmpty()){
				logger.debug("checkAuthorize action="+action + " type=" + type + " id=" + id + " DONT need to Authorize");
				return false;
			}
				
			String act = getValue(action);
			String t = getValue(type);
			String i = getValue(id);
			String ids = getValue(selectedIds);
			List<Integer> IDs = new ArrayList<>();
			if(!isNumber(i)){//selectedIds
				logger.debug("checkAuthorize list of changed ids=" + ids);
				if(ids !=null && !ids.isEmpty()){
					String[] rawIds = ids.split(";");
					for (String tmp : rawIds) {
						if(isNumber(tmp.split(":")[1])){
							IDs.add(Integer.valueOf(tmp.split(":")[1]));
						}
					}
				}
				
			}
			if(i == null || i.isEmpty() || !isNumber(i)){
				if(IDs.size()==0){
					logger.debug("checkAuthorize action="+action + " type=" + type + " id=" + id + ". no id or ids to check");
					return false;

				}
			}
			logger.debug("Begin checkAuthorize action="+act + " type=" + t + " id=" + i + " ids=" + ids);
			CompanyInfo com = (CompanyInfo)inv.getInvocationContext().getSession().get(LoginAction.COMPANY_INFO);
			if(TYPE_NEWS.equals(t)){
				if(AuthorizationBean.getOwnerOfNews(Integer.valueOf(i.toString())) != com.getId())
					return false;
			}else if(TYPE_MENUITEM.equals(t)){
				if(IDs.size()>0){
					for(int checkedId : IDs){
						if(AuthorizationBean.getOwnerOfMenuItem(checkedId) != com.getId())
							return false;
					}
				}else{
					if(AuthorizationBean.getOwnerOfMenuItem(Integer.valueOf(i.toString())) != com.getId())
						return false;
				}
			}else if(TYPE_SERVICE.equals(t)){
				if(Integer.valueOf(i.toString()) != com.getId())
					return false;
			}else if(TYPE_CONTACTINFO.equals(t)){
				if(Integer.valueOf(i.toString()) != com.getId())
					return false;
			}else if(TYPE_ABOUT.equals(t)){
				if(Integer.valueOf(i.toString()) != com.getId())
					return false;
			}else if(TYPE_COMPANY.equals(t)){
				if(com.getId() != Long.valueOf(i.toString()).longValue()){
					return false;
				}
			}
			logger.debug("Pass checkAuthorize action="+act + " type=" + t + " id=" + i + " ids=" + ids);
			return true;
		}
		return true;
	}
	private boolean isNumber(String i) {
		try {
			Integer.valueOf(i);
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	private String getValue(Object obj){
		if (obj instanceof String[]) {
			String[] tmp = (String[]) obj;
			return tmp[0];
			
		}else{
			if(obj != null)
				return obj.toString();
		}
		return null;
	}
	private boolean needCheckAuthorize(String action){
		logger.debug("Enter needCheckAuthorize action =" + action);
		boolean result = false;
		for(String act : actions){
			if(action.toString().startsWith(act) || action.toString().equals(act) ){
				logger.debug("needCheckAuthorize action =" + action + " -> need to check authorize");
				result = true;
				break;
			}
		}
		if(!result)
			logger.debug("End needCheckAuthorize: don't need to check action=" + action.toString());
		return result;
	}
}
