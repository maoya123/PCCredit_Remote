package com.cardpay.pccredit.jnpad.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cardpay.pccredit.common.SFTPUtil;
import com.cardpay.pccredit.customer.model.CIPERSONBASINFOCOPY;
import com.cardpay.pccredit.customer.model.CIPERSONFAMILY;
import com.cardpay.pccredit.customer.model.CustomerInfor;
import com.cardpay.pccredit.intopieces.constant.Constant;
import com.cardpay.pccredit.intopieces.dao.comdao.IntoPiecesComdao;
import com.cardpay.pccredit.intopieces.model.IntoPieces;
import com.cardpay.pccredit.intopieces.model.LocalImage;
import com.cardpay.pccredit.jnpad.dao.JnIpadCustAppInfoXxDao;
import com.cardpay.pccredit.jnpad.filter.CustomerApprovedFilter;
import com.cardpay.pccredit.jnpad.filter.NotificationMessageFilter;
import com.cardpay.pccredit.jnpad.model.CustYunyinVo;
import com.cardpay.pccredit.jnpad.model.JnpadCustomerBianGeng;
import com.cardpay.pccredit.jnpad.model.NotificationmMessage;
import com.cardpay.pccredit.jnpad.model.RetrainUserVo;
import com.cardpay.pccredit.jnpad.model.RetrainingVo;
import com.cardpay.pccredit.manager.dao.RetrainingDao;
import com.cardpay.pccredit.manager.filter.RetrainingFilter;
import com.cardpay.pccredit.manager.model.AccountManagerRetraining;
import com.cardpay.pccredit.manager.model.Retraining;
import com.cardpay.pccredit.notification.model.NotificationMessage;
import com.cardpay.pccredit.riskControl.dao.RiskCustomerDao;
import com.cardpay.pccredit.riskControl.filter.RiskCustomerFilter;
import com.cardpay.pccredit.system.model.SystemUser;
import com.wicresoft.jrad.base.database.dao.common.CommonDao;

@Service
public class JnIpadCustAppInfoXxService {
	
	@Autowired
	private JnIpadCustAppInfoXxDao jnIpadCustAppInfoDao;
	
	@Autowired
	private CommonDao commonDao;
	
	@Autowired
	private IntoPiecesComdao intoPiecesComdao;
	
	@Autowired
	private RetrainingDao retrainingDao;
	
	@Autowired
	private RiskCustomerDao riskCustomerDao;
	
	
	public int findCustAppInfoXxCount(String userId,String status1,String status2,String status3,String status4){
		return jnIpadCustAppInfoDao.findCustAppInfoXxCount(userId,status1,status2,status3,status4);
	}
	
	
	public List<IntoPieces> findCustomerApprovedList(CustomerApprovedFilter filter) {
		List<IntoPieces>  intoPieces = jnIpadCustAppInfoDao.findCustomerApprovedList(filter);
		for(IntoPieces pieces : intoPieces){
			if(pieces.getStatus()==null){
				pieces.setNodeName("未提交申请");
			}
			else{
				if(pieces.getStatus().equals(Constant.SAVE_INTOPICES)){
					pieces.setNodeName("未提交申请");
				}else if(pieces.getStatus().equals(Constant.APPROVE_INTOPICES)){
					String nodeName = intoPiecesComdao.findNodeName(pieces.getId());
					if(StringUtils.isNotEmpty(nodeName)){
						pieces.setNodeName(nodeName);
					} else {
						pieces.setNodeName("不在审批中");
					}
				}else {
					pieces.setNodeName("审批结束");
				}
			}
		}
		return intoPieces;
	}
	
	public int findCustomerApprovedCountList(CustomerApprovedFilter filter) {
		return jnIpadCustAppInfoDao.findCustomerApprovedCountList(filter);
	}
	
	public Map<String,Object> updateCustomerApplicationInfo(CustomerApprovedFilter filter){
	   Map<String,Object> map = new LinkedHashMap<String,Object>();
       int i = jnIpadCustAppInfoDao.updateCustomerApplicationInfo(filter);
       if(i>0){
    	   map.put("result", "fail");
       }else{
    	   map.put("result", "success");
       }
       return map;
	}
	
	
	public String calCreditAmt(CustomerApprovedFilter filter){
		return jnIpadCustAppInfoDao.calCreditAmt(filter);
	}
	
	public int overdueCustomerCount(CustomerApprovedFilter filter){
		return jnIpadCustAppInfoDao.overdueCustomerCount(filter);
	}
	
	public List<NotificationMessage> findNotificationMessageByFilter(NotificationMessageFilter filter){
		return jnIpadCustAppInfoDao.findNotificationMessageByFilter(filter);
	}
	
	public int findNotificationCountMessageByFilter(NotificationMessageFilter filter){
		return jnIpadCustAppInfoDao.findNotificationCountMessageByFilter(filter);
	}
	
	public String getRewardIncentiveInformation(int year,int month,String id){
		return jnIpadCustAppInfoDao.getRewardIncentiveInformation(year,month,id);
	}
	
	public String getReturnPrepareAmountById(String id){
		return jnIpadCustAppInfoDao.getReturnPrepareAmountById(id);
	}
	
	
	/**
	 * 上传影像资料
	 * @param file
	 * @param productId
	 * @param customerId
	 * @param applicationId
	 */
	public void importImage(MultipartFile file, String productId,String customerId,String applicationId) {
		//本地测试上传
//		Map<String, String> map = UploadFileTool.uploadYxzlFileBySpring(file,customerId);
		//指定服务器上传
		Map<String, String> map = SFTPUtil.uploadJn(file, customerId);
		String fileName = map.get("fileName");
		String url = map.get("url");
		LocalImage localImage = new LocalImage();
		localImage.setProductId(productId);
		localImage.setCustomerId(customerId);
		if(applicationId != null){
			localImage.setApplicationId(applicationId);
		}
		localImage.setCreatedTime(new Date());
		if (StringUtils.trimToNull(url) != null) {
			localImage.setUri(url);
		}
		if (StringUtils.trimToNull(fileName) != null) {
			localImage.setAttachment(fileName);
		}
		commonDao.insertObject(localImage);
	}
	
	
	public List<CIPERSONFAMILY> findFamilyByNm(String custId,String userId){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", "userId");
		params.put("custId", custId);
		String sql = " select f.* from t_cipersonfamily f,basic_customer_information b "
				+ "where f.custid = b.ty_customer_id and b.user_id = #{userId} and f.custid =#{custId}";

		List<CIPERSONFAMILY> info = commonDao.queryBySql(CIPERSONFAMILY.class,sql , null);
		return info;
	}
	
	
	public List<Retraining> findRetrainingsByFilter(RetrainingFilter filter){
		return retrainingDao.findRetrainingsByFilter(filter);
	}
	
	public int findRetrainingsCountByFilter(RetrainingFilter filter){
		return retrainingDao.findRetrainingsCountByFilter(filter);	
	}
	
	public CustYunyinVo findYunyinstatus(String userId){
//		List<CustYunyinVo> list = jnIpadCustAppInfoDao.findYunyinstatus(userId);
//		if(list != null && list.size() > 0){
//			return (CustYunyinVo)list.get(0);
//		} else {
//			return null;
//		}
		return jnIpadCustAppInfoDao.findYunyinstatus(userId);
	}
	
	public List<RetrainingVo> findRetrainingsVoByFilter(RetrainingFilter filter){
		return retrainingDao.findRetrainingsVoByFilter(filter);
	}
	
	
	public List<String> findAccountManagerRetraining(String id){
		List<RetrainUserVo> volist = jnIpadCustAppInfoDao.findAccountManagerRetraining(id);
		List<String> list = new ArrayList<String>();
		for(RetrainUserVo vo :volist){
			list.add(vo.getRetrainUserName());
		}
		return list;
	}
	
	public SystemUser findSysUserById(String id){
		return commonDao.findObjectById(SystemUser.class, id) ;
	}


	public int findNoticeCountByFilter(NotificationMessageFilter filter) {
		// TODO Auto-generated method stub
		return jnIpadCustAppInfoDao.findNoticeCountByFilter(filter);
	}
	




	public int findRiskNoticeCountByFilter(RiskCustomerFilter filters) {
		// TODO Auto-generated method stub
		return riskCustomerDao.findRiskCustomersCountByFilter(filters);
	}


	public List<CustomerInfor> findbiangengCountByManagerId(String userId) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		String sql ="select * from  BASIC_CUSTOMER_INFORMATION t where t.user_id=#{userId} AND t.islook ='1'";
		sql=sql+" order by t.id asc";
		return commonDao.queryBySql(CustomerInfor.class, sql, params);
	}


	public void changeIsLook(String id, String cardId) {
		jnIpadCustAppInfoDao.changeIsLook(id,cardId);
	}


	public void insertShendaiTongzhi(NotificationmMessage notificationmmessage) {
		commonDao.insertObject(notificationmmessage);
	}


	public List<NotificationmMessage> selectshendaihuitz(String managerId) {
		String sql="select nm.id, nm.NOTICE_TYPE,nm.NOTICE_CONTENT,nm.IS_CHECK,nm.NOTICE_TITLE,nm.CREATED_BY,nm.CREATED_TIME,nm.MODIFIED_USER,nm.MODIFIED_TIME,"
				+ "su.display_name as user_id from  notification_message nm inner join sys_user su on su.id =nm.user_id  where notice_type='shendaihui'";
		if(managerId!=null&&managerId!=""){
			sql+="and user_id='"+managerId+"' and is_check='0'" ;
		}
		HashMap<String, Object> params = new HashMap<String, Object>();
		return commonDao.queryBySql(NotificationmMessage.class, sql, params);
	}


	public void changeSdhIsLook(String id,String status) {
		// TODO Auto-generated method stub
		jnIpadCustAppInfoDao.changeSdhIsLook(id,status);
	}


	public String getSumReturnPrepareAmountById(String userId) {
		// TODO Auto-generated method stub
		return jnIpadCustAppInfoDao.getSumReturnPrepareAmountById(userId);
	}
}
