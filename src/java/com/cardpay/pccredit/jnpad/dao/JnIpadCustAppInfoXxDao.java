package com.cardpay.pccredit.jnpad.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cardpay.pccredit.intopieces.model.IntoPieces;
import com.cardpay.pccredit.jnpad.filter.CustomerApprovedFilter;
import com.cardpay.pccredit.jnpad.filter.NotificationMessageFilter;
import com.cardpay.pccredit.jnpad.model.CustYunyinVo;
import com.cardpay.pccredit.jnpad.model.RetrainUserVo;
import com.cardpay.pccredit.notification.model.NotificationMessage;
import com.wicresoft.util.annotation.Mapper;

@Mapper
public interface JnIpadCustAppInfoXxDao {

    public int findCustAppInfoXxCount(@Param("userId") String userId,
						    		  @Param("status1") String status,
						    		  @Param("status2") String status2,
						    		  @Param("status3") String status3,
						    		  @Param("status4") String status4);
    
    
    public List<IntoPieces> findCustomerApprovedList(CustomerApprovedFilter filter);
	public int findCustomerApprovedCountList(CustomerApprovedFilter filter);
	
	public int updateCustomerApplicationInfo(CustomerApprovedFilter filter);
	public String calCreditAmt(CustomerApprovedFilter filter);
	public int overdueCustomerCount(CustomerApprovedFilter filter);
	
	public List<NotificationMessage> findNotificationMessageByFilter(NotificationMessageFilter filter);
	public int findNotificationCountMessageByFilter(NotificationMessageFilter filter);
	
	public String getRewardIncentiveInformation(@Param("year") int year,@Param("month") int month,@Param("id") String id);
	public String getReturnPrepareAmountById(@Param("id") String id);
	
	public CustYunyinVo findYunyinstatus(@Param("userId") String userId);
	
	public List<RetrainUserVo> findAccountManagerRetraining(@Param("id") String id);

	//进件列表根据状态查询数量
	public int findNoticeCountByFilter(NotificationMessageFilter filter);


	public void changeIsLook(@Param("id")String id,@Param("cardId") String cardId);

//改变审贷会通知状态
	public void changeSdhIsLook(@Param("id")String id, @Param("status")String status);


	public String getSumReturnPrepareAmountById(@Param("userId")String userId);
}
