/**
 * 
 */
package com.cardpay.pccredit.postLoan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cardpay.pccredit.customer.filter.MaintenanceFilter;
import com.cardpay.pccredit.customer.model.TyRepayLshForm;
import com.cardpay.pccredit.customer.model.TyRepayTkmx;
import com.cardpay.pccredit.customer.model.TyRepayTkmxForm;
import com.cardpay.pccredit.customer.web.MaintenanceForm;
import com.cardpay.pccredit.customer.web.MaintenanceWeb;
import com.cardpay.pccredit.manager.model.REIMBURSEMENT;
import com.cardpay.pccredit.manager.web.ManagerBelongMapForm;
import com.cardpay.pccredit.postLoan.filter.BloansManagerFilter;
import com.cardpay.pccredit.postLoan.filter.FcloaninfoFilter;
import com.cardpay.pccredit.postLoan.filter.PostLoanFilter;
import com.cardpay.pccredit.postLoan.model.BadLoansResultForm;
import com.cardpay.pccredit.postLoan.model.BadloansManagerForm;
import com.cardpay.pccredit.postLoan.model.Fcloaninfo;
import com.cardpay.pccredit.postLoan.model.MibusidataForm;
import com.cardpay.pccredit.postLoan.model.Rarepaylist;
import com.cardpay.pccredit.postLoan.model.RarepaylistForm;
import com.wicresoft.util.annotation.Mapper;

/**
 * @author shaoming
 *
 * 2014年11月11日   下午3:07:50
 */
@Mapper
public interface PostLoanDao {
	/**
	 * 得到借据表
	 * @param filter
	 * @return
	 */
/*	List<TyRepayTkmxForm> findListByFilter(PostLoanFilter filter);
	int findListCountByFilter(PostLoanFilter filter);*/
	
	/**
	 * 得到流水表
	 * @param filter
	 * @return
	 */
	/*List<TyRepayLshForm> findLshListByFilter(PostLoanFilter filter);
	int findLshListCountByFilter(PostLoanFilter filter);*/
	
	
	/**
	 * JN
	 * 借据表
	 * @param filter
	 * @return
	 */
	List<Fcloaninfo> findJJJnListByFilter(PostLoanFilter filter);
	int findJJJnListCountByFilter(PostLoanFilter filter);
	
	/**
	 * JN
	 * 流水表
	 * @param filter
	 * @return
	 */
	List<RarepaylistForm> findLshJnListByFilter(PostLoanFilter filter);
	int findLshJnListCountByFilter(PostLoanFilter filter);
	
	
	/**
	 * JN
	 * 台帐表
	 * @param filter
	 * @return
	 */
	List<MibusidataForm> findTzJnListByFilter(PostLoanFilter filter);
	int findTzJnListCountByFilter(PostLoanFilter filter);
	
	/**
	 * 查询借据表详细信息
	 * @param busicode
	 * @return
	 */
	Fcloaninfo findObjectsByBusicode(@Param("busicode") String busicode);
	
	
	List<RarepaylistForm> selectRarepaylistfoInfoByBusicode(FcloaninfoFilter filter);
	
	
	List<REIMBURSEMENT> findReimbListByFilter(PostLoanFilter filter);
	int findReimbCountListByFilter(PostLoanFilter filter);
	//不良资产信息
	List<BadloansManagerForm> findBadloansManagerInfo(BloansManagerFilter filter);
	//不良资产信息数量
	int findBadloansManagerInfoSize(BloansManagerFilter filter);
	
	BadLoansResultForm findresultById(@Param("id")String id);
}
