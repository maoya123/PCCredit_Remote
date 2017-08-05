package com.cardpay.pccredit.jnpad.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cardpay.pccredit.jnpad.model.DelayInfoForm;
import com.cardpay.pccredit.riskControl.filter.RiskCustomerCollectionPlanFilter;
import com.cardpay.pccredit.riskControl.filter.RiskCustomerFilter;
import com.cardpay.pccredit.riskControl.model.RiskCustomer;
import com.cardpay.pccredit.riskControl.web.RiskCustomerCollectionPlanForm;
import com.cardpay.pccredit.system.model.Dict;
import com.wicresoft.util.annotation.Mapper;
@Mapper
public interface JnpadRiskCustomerCollectionDao {
	//通过id得到逾期客户催收计划
	public RiskCustomerCollectionPlanForm findRiskCustomerCollectionPlanById(@Param(value = "id")String id);
	public int findCountByFilter(RiskCustomerCollectionPlanFilter filter);
	//过滤查询逾期催收客户
	public List<RiskCustomerCollectionPlanForm> findRiskCustomerCollectionPlans(
			RiskCustomerCollectionPlanFilter filter);
	
	//得到当前客户经理下属经理名下的逾期客户催收信息数量
	public int findRiskViewSubCollectionPlansCountByFilter(RiskCustomerCollectionPlanFilter filter);
	//风险客户名单
	public List<RiskCustomer> findRiskCustomersByFilter(RiskCustomerFilter filter);
	
	List<Dict> getProductIdAndName(@Param("customerId") String customerId);
	//客户逾期信息
	public DelayInfoForm getDelayInfoByCustomerId(@Param("customerId") String customerId);
	//获取客户经理名下客户逾期信息
	public List<DelayInfoForm> getCustomerRiskInfo(@Param("managerId")String managerId);
	
	

}
