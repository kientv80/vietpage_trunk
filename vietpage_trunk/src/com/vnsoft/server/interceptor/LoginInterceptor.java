package com.vnsoft.server.interceptor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.vnsoft.server.actions.LoginAction;

@SuppressWarnings("serial")
public class LoginInterceptor extends AbstractInterceptor {
	private static Map<String,List<String>> filterMap = new HashMap<>();
	static {
		filterMap.put("item", Arrays.asList(new String[]{AuthorizationInterceptor.EDIT}));
		filterMap.put("menu", Arrays.asList(new String[]{AuthorizationInterceptor.DELETE}));
		filterMap.put("comment", Arrays.asList(new String[]{"getcomments"}));
		filterMap.put("contactinfo", Arrays.asList(new String[]{AuthorizationInterceptor.EDIT}));
		filterMap.put("service_update", Arrays.asList(new String[]{AuthorizationInterceptor.EDIT}));
		filterMap.put("about_update", Arrays.asList(new String[]{AuthorizationInterceptor.EDIT}));
		filterMap.put("userloginreport", Arrays.asList(new String[]{}));
		filterMap.put("newuserreport", Arrays.asList(new String[]{}));
		filterMap.put("pageVisitReport", Arrays.asList(new String[]{}));
		filterMap.put("register", Arrays.asList(new String[]{"loadRegisterInfo","updateRegisterInfo"}));
	}
			
	@Override
	public String intercept(ActionInvocation inv) throws Exception {
		String actionName = inv.getProxy().getActionName();
		Object action = null;
		if(filterMap.containsKey(actionName) && inv.getInvocationContext().getParameters().get("action") != null){
			Object[] params  = (Object[])inv.getInvocationContext().getParameters().get("action");
			if(params.length > 0)
				action = params[0].toString();
		}
		if(filterMap.containsKey(actionName) && (filterMap.get(actionName).size() > 0 && !filterMap.get(actionName).contains(action))){
			return inv.invoke();
		}else if(inv.getInvocationContext().getSession().containsKey(LoginAction.USER)){
			return inv.invoke();
		}
		return "login";
	}

}
