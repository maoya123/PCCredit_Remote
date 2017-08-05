package com.cardpay.pccredit.jnpad.web;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cardpay.pccredit.ipad.constant.IpadConstant;
import com.cardpay.pccredit.ipad.model.Result;
import com.cardpay.pccredit.ipad.service.CustomerInforForIpadService;
import com.cardpay.pccredit.ipad.util.JsonDateValueProcessor;
import com.cardpay.pccredit.jnpad.model.CustYunyinVo;
import com.cardpay.pccredit.jnpad.model.CustomerManagerVo;
import com.cardpay.pccredit.jnpad.model.JnUserLoginIpad;
import com.cardpay.pccredit.jnpad.model.JnUserLoginResult;
import com.cardpay.pccredit.jnpad.service.JnIpadCustAppInfoXxService;
import com.cardpay.pccredit.jnpad.service.JnIpadUserLoginService;
import com.cardpay.pccredit.system.model.SystemUser;
import com.wicresoft.jrad.base.web.security.LoginManager;
import com.wicresoft.jrad.modules.log.business.LoginLogManager;
import com.wicresoft.jrad.modules.privilege.model.User;
import com.wicresoft.util.spring.Beans;
import com.wicresoft.util.web.RequestHelper;

/**
 * ipad interface
 * pad用户登录
 * songchen
 * 2016年04月16日   下午1:54:18
 */
@Controller
public class JnIpadUserLoginController {
	
	@Autowired
	private JnIpadUserLoginService userService;
	
	@Autowired
	private CustomerInforForIpadService customerInforService;
	
	@Autowired
	private JnIpadCustAppInfoXxService appInfoXxService;
	
	@Autowired
	private LoginLogManager loginLogManager;
	
	/**
	 * 用户登录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/ipad/user/JnLogin.json")
	public String login(HttpServletRequest request) {
		String login = RequestHelper.getStringValue(request, "login");
		String passwd = RequestHelper.getStringValue(request, "password");
		String ipAddress = request.getRemoteAddr();
		String signInMsg;
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Result result = null;
		JnUserLoginResult loginResult = null;
		if(StringUtils.isEmpty(login) || StringUtils.isEmpty(passwd)){
			result = new Result();
			result.setStatus(IpadConstant.FAIL);
			result.setReason(IpadConstant.LOGINNOTNULL);
			map.put("result",result);
		}else{
			loginResult = new JnUserLoginResult();
			JnUserLoginIpad user = userService.login(login, passwd);
			String LocationType=userService.findServer5();
			map.put("LocationType", LocationType);
			if(user!=null){
				loginResult.setUser(user);
				loginResult.setStatus(IpadConstant.SUCCESS);
				loginResult.setReason(IpadConstant.LOGINSUCCESS);
				signInMsg="PAD端成功";
			}else{
				loginResult.setStatus(IpadConstant.FAIL);
				loginResult.setReason(IpadConstant.LOGINFAIL);
				signInMsg="PAD端密码错误";
			}
			map.put("result",loginResult);
			map.put("login",login);
			loginLogManager.addSignInLog(login, LoginManager.LOCAL, ipAddress, signInMsg);
		}
		JSONObject json = JSONObject.fromObject(map);
		return String.valueOf(json);
	}
	
	@ResponseBody
	@RequestMapping(value = { "/ipad/user/logout.json" })
	public String logout(HttpServletRequest request) {
		String login = RequestHelper.getStringValue(request, "login");
		String ipAddress = request.getRemoteAddr();
		loginLogManager.addSignOutLog(login, LoginManager.LOCAL, ipAddress, "PAD端成功");

		return null;

	}
	/**
	 * 产品查询
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/ipad/product/prodBrowse.json", method = { RequestMethod.GET })
	public String browse(HttpServletRequest request) {
		String currentPage=request.getParameter("currentPage");
		String pageSize=request.getParameter("pageSize");
		Map<String,Object> result = new LinkedHashMap<String,Object>();
		int page = 1;
		int limit = 10;
		if(StringUtils.isNotEmpty(currentPage)){
			page = Integer.parseInt(currentPage);
		}
		if(StringUtils.isNotEmpty(pageSize)){
			limit = Integer.parseInt(pageSize);
		}
		List<com.cardpay.pccredit.ipad.model.ProductAttribute> products = userService.findProducts(page,limit);
		int totalCount = userService.findProductsCount();
		result.put("totalCount", totalCount);
		result.put("result", products);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
		JSONObject json = JSONObject.fromObject(result, jsonConfig);
		return json.toString();
	}
	
	/**
	 * 客户新增
	 */
	@ResponseBody
	@RequestMapping(value = "/ipad/customerInfor/customerInsert.json")
	public String insert(HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		String name = request.getParameter("name");
		String cardId = request.getParameter("cardId");
		String cardType = request.getParameter("cardType");
		
		String userId = request.getParameter("userId");
		map = customerInforService.addCustomer(name,cardId,cardType,userId);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
		JSONObject json = JSONObject.fromObject(map, jsonConfig);
		return json.toString();
	}
	
	/**
	 * 查看当前客户登录信息
	 */
	@ResponseBody
	@RequestMapping(value = "/ipad/user/findSysUserMsg.json")
	public String findSysUserMsg(HttpServletRequest request) {
		String loginId = RequestHelper.getStringValue(request, "userId");
		//查询登录用户
		SystemUser user = userService.findUser(loginId);
		//查询机构
		String orgName = userService.findOrg(loginId);
		CustomerManagerVo  customerManagerVo = new CustomerManagerVo();
		customerManagerVo.setName(user.getDisplayName());//姓名
		customerManagerVo.setSex(user.getGender());//性别
		customerManagerVo.setAge(user.getAge()+"");//年龄
		customerManagerVo.setOrg(orgName);//所属银行
		customerManagerVo.setExternalId(user.getExternalId());//客户经理编号
		customerManagerVo.setSxqx("");//授信权限
		customerManagerVo.setFkze("");//放款总额
		//查询上次登录时间
		String LastLogin =userService.findLastLogin(loginId);
		//response
		Map<String,Object> result = new LinkedHashMap<String,Object>();
		result.put("result", customerManagerVo);
		result.put("LastLogin", LastLogin);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
		JSONObject json = JSONObject.fromObject(result, jsonConfig);
		return json.toString();
	}
	
	
	/**
	 * 客户运营状况查询
	 */
	@ResponseBody
	@RequestMapping(value = "/ipad/user/findYunyinstatus.json")
	public String findYunyinstatus(HttpServletRequest request) {
		String userId = RequestHelper.getStringValue(request, "userId");
		//查询运营状况
		CustYunyinVo vo =  appInfoXxService.findYunyinstatus(userId);
		//response
		Map<String,Object> result = new LinkedHashMap<String,Object>();
		result.put("result", vo);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
		JSONObject json = JSONObject.fromObject(result, jsonConfig);
		return json.toString();
	}
}
