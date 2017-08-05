package com.cardpay.pccredit.jnpad.web;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cardpay.pccredit.customer.model.CustomerFirsthendBase;
import com.cardpay.pccredit.ipad.util.JsonDateValueProcessor;
import com.cardpay.pccredit.jnpad.model.CIPERSONBASINFO;
import com.cardpay.pccredit.jnpad.model.CustomerInfo;
import com.cardpay.pccredit.jnpad.model.StaticDictory;
import com.cardpay.pccredit.jnpad.service.JnpadCustomerSelectService;
import com.wicresoft.util.web.RequestHelper;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
/**
 * 客户信息查询
 * @author sealy
 *
 */
@Controller	
public class JnpadCustomerSelectController {

	@Autowired
	private JnpadCustomerSelectService customerSelectSercice;
	/**
	 * 根据证件号码查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/ipad/product/selectCustomerInfoByCardId.json", method = { RequestMethod.GET })
public String selectCustomerInfoByCardId(HttpServletRequest request){
	String chineseName = request.getParameter("chineseName");	
	String cardId = request.getParameter("cardId");
	String userId = "";
	String userType = request.getParameter("userType");
	if(userType.equals("1")){
		userId = request.getParameter("userId");
	}
		List<CustomerInfo> customerList = customerSelectSercice.selectCustomerInfo(cardId,chineseName,userId);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
		Map<String,Object> result = new LinkedHashMap<String,Object>();
//		Iterator<CustomerInfo> it = customerList.iterator(); 
//		
//		StringBuffer s=new StringBuffer();
//	        while(it.hasNext()){  
//	        CustomerInfo cus = it.next();
//	        String CardType =cus.getCardType();
//	        CardType =CardType.replace("0", "身份证");
//	        CardType =CardType.replace("1", "军官证");
//	        CardType =CardType.replace("2", "护照");
//	        CardType =CardType.replace("3", "香港身份证");
//	        CardType =CardType.replace("4", "澳门身份证");
//	        CardType =CardType.replace("5", "台湾身份证");
//	        s.append("<tr>"+"<td>"+cus.getChineseName()+"</td>"+
//	        		"<td>"+CardType+"</td>"+
//	        		"<td>"+cus.getCardId()+"</td>"+
//                    "<td>"+cus.getTelephone()+"</td>");
	        
//	        } 
//	     String ss = s.toString();
//	     ss=ss.replace("null", "");
	     result.put("custInfo", customerList);
	    JSONObject json = JSONObject.fromObject(result, jsonConfig);
		return json.toString();
	
	}
	
	/**
	 * 
	 * 客户原始信息查询
	 */
	 
		@ResponseBody
		@RequestMapping(value = "/ipad/product/selectAllCustomerInfoByCardId.json", method = { RequestMethod.GET })
		public String selectCustomerAllInfoByCardId(HttpServletRequest request){
			String customerInforId = RequestHelper.getStringValue(request, "customerInforId");
			CIPERSONBASINFO base = customerSelectSercice.findCustomerFirsthendById(customerInforId);
			StaticDictory staticdictory =new StaticDictory();
			base.setCardtype(staticdictory.CARDTYPE().get(base.getCardtype()));
			base.setSex(staticdictory.SEX().get(base.getSex()));
			base.setEthical(staticdictory.MINZU().get(base.getEthical()));
			base.setMarrige(staticdictory.MARRIGE().get(base.getMarrige()));
			base.setCusttype(staticdictory.CUSTTYPEJN().get(base.getCusttype()));
			base.setReside(staticdictory.RESIDE().get(base.getReside()));
			base.setEducationlevel(staticdictory.EDUCATIONLEVEL().get(base.getEducationlevel()));
			base.setDegree(staticdictory.DEGREE().get(base.getDegree()));
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
			JSONObject json = JSONObject.fromObject(base, jsonConfig);
			return json.toString();
		}
	
	
	/**
	 * 
	 * 按id查找相应的客户基本信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/ipad/product/selectCustomerById.json", method = { RequestMethod.GET })
	public String selectCustomerFirsthendById(HttpServletRequest request){

		String id = RequestHelper.getStringValue(request, "id");
		CIPERSONBASINFO customer = customerSelectSercice.selectCustomerInfoById(id);
		
		
		
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
		JSONObject json = JSONObject.fromObject(customer, jsonConfig);
		
		
		return json.toString();
	}
	
	
	/**
	 * 
	 * 按客户内码id查找相应的客户基本信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/ipad/product/selectCustomerByNm.json", method = { RequestMethod.GET })
	public String findCustomerFirsthendByNm(HttpServletRequest request){
		
		String custid = RequestHelper.getStringValue(request, "custid");
		CIPERSONBASINFO customer = customerSelectSercice.selectCustomerByNm(custid);
		
		
		
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
		JSONObject json = JSONObject.fromObject(customer, jsonConfig);
		
		
		return json.toString();
		
		
		
	}
}

