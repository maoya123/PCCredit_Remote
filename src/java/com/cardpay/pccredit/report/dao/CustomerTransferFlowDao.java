package com.cardpay.pccredit.report.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cardpay.pccredit.manager.web.AccountManagerParameterForm;
import com.cardpay.pccredit.postLoan.filter.PostLoanFilter;
import com.cardpay.pccredit.postLoan.model.ContractForm;
import com.cardpay.pccredit.postLoan.model.MibusidataForm;
import com.cardpay.pccredit.report.filter.AccLoanCollectFilter;
import com.cardpay.pccredit.report.filter.CustomerMoveFilter;
import com.cardpay.pccredit.report.filter.ReportFilter;
import com.cardpay.pccredit.report.model.AccLoanCollectInfo;
import com.cardpay.pccredit.report.model.BjjdktjbbForm;
import com.cardpay.pccredit.report.model.CustomerMoveForm;
import com.cardpay.pccredit.report.model.DkyetjbbForm;
import com.cardpay.pccredit.report.model.DqzzdktjbbForm;
import com.cardpay.pccredit.report.model.PercentForm;
import com.cardpay.pccredit.report.model.XdlctjbbForm;
import com.cardpay.pccredit.report.model.YffdktjbbForm;
import com.cardpay.pccredit.report.model.YqdktjbbForm;
import com.cardpay.pccredit.report.model.YqhkdktjbbForm;
import com.wicresoft.util.annotation.Mapper;

@Mapper
public interface CustomerTransferFlowDao {
    
	List<CustomerMoveForm> findCustomerTransferList(CustomerMoveFilter filter);
	int findCustomerMoveCountList(CustomerMoveFilter filter);
	public List<CustomerMoveForm> getCustomerMovelList(CustomerMoveFilter filter);
	
	List<YffdktjbbForm> findYffdktjbbFormList(ReportFilter filter);
	int findYffdktjbbFormCountList(ReportFilter filter);
	public List<YffdktjbbForm> getYffdktjbbFormlList(ReportFilter filter);
	
	List<BjjdktjbbForm> findbjjdktjbbFormList(ReportFilter filter);
	int findbjjdktjbbFormCountList(ReportFilter filter);
	public List<BjjdktjbbForm> getbjjdktjbbFormList(ReportFilter filter);
	
	List<DqzzdktjbbForm> findDqzzdktjbbFormList(ReportFilter filter);
	int findDqzzdktjbbFormCountList(ReportFilter filter);
	public List<DqzzdktjbbForm> getDqzzdktjbbFormList(ReportFilter filter);
	
	List<DkyetjbbForm> findDkyetjbbFormList(ReportFilter filter);
	int findDkyetjbbFormCountList(ReportFilter filter);
	public List<DkyetjbbForm> getDkyetjbbFormList(ReportFilter filter);
	
	List<YqdktjbbForm> findYqdktjbbFormList(ReportFilter filter);
	int findYqdktjbbFormCountList(ReportFilter filter);
	public List<YqdktjbbForm> getYqdktjbbFormList(ReportFilter filter);
	
	List<YqhkdktjbbForm> findYqhkdktjbbFormList(ReportFilter filter);
	int findYqhkdktjbbFormCountList(ReportFilter filter);
	public List<YqhkdktjbbForm> getYqhkdktjbbFormList(ReportFilter filter);
	
	
	List<XdlctjbbForm> findXdlctjbbFormList(ReportFilter filter);
	int findXdlctjbbFormCountList(ReportFilter filter);
	public List<XdlctjbbForm> getXdlctjbbFormList(ReportFilter filter);
	
	public List<AccLoanCollectInfo> getAccLoanCollect(AccLoanCollectFilter filter);
	
	public List<PercentForm> getLoanAmtAndNum(AccLoanCollectFilter filter);
	public List<PercentForm> getEmp(Map<String, Object> param);
	
	List<AccountManagerParameterForm> findAccountManagerParameterByUserId(@Param("userId") String userId);
	
	List<MibusidataForm> findTzJnListByFilter(PostLoanFilter filter);
	
	/**
	 * 利息分段统计查询
	 */
	List<MibusidataForm> findLxSubsectJnListByFilter(PostLoanFilter filter);
	
	
	/**
	 * 授信分段统计查询
	 */
	List<ContractForm> findContractJnListByFilter(PostLoanFilter filter);
}