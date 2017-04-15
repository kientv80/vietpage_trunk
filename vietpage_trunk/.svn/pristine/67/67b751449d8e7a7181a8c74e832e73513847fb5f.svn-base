package com.vnsoft.server.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.vnsoft.server.actions.LoginAction;
import com.vnsoft.server.model.User;

@SuppressWarnings("serial")
public class AdminInterceptor extends AbstractInterceptor {
	@Override
	public String intercept(ActionInvocation inv) throws Exception {
		
		if(inv.getInvocationContext().getSession().containsKey(LoginAction.USER)){
			User user = (User)inv.getInvocationContext().getSession().get(LoginAction.USER);
			if("admin".equals(user.getRole())){
				return inv.invoke();
			}else{
				return AuthorizationInterceptor.ACCESS_DENINED;
			}
		}
		return "login";
	}

}
