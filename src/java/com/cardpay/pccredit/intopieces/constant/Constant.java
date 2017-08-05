package com.cardpay.pccredit.intopieces.constant;

import java.util.HashMap;
import java.util.Map;

public class Constant {
	/* 操作失败 */
	public static String FAIL_MESSAGE = "操作失败";
	
	/* 操作成功 */
	public static String SUCCESS_MESSAGE = "操作成功";
	
	/* 操作成功 */
	public static String UPLOAD_SUCCESS_MESSAGE = "导出并上传成功";
	
	/* 文件为空 */
	public static String FILE_EMPTY = "文件不可为空";
	
	/* 结果集 */
	public static String RESULT_LIST1 = "resultList1";
	
	/* 结果集 */
	public static String RESULT_LIST2 = "resultList2";
	
	/* 影像资料上传路径 */
//	public static String FILE_PATH = "/usr/pccreditFile/";
	public static String FILE_PATH = "/home/sealy/TFile/";
	
	/* 影像资料补扫上传路径 */
	public static String FILE_PATH_BS = "/usr/pccreditFilebs/";
	
	/* 保存进件*/
	public static String SAVE_INTOPICES = "save";
	
	/* 申请进件*/
	public static String APPROVE_INTOPICES = "audit";  //太原复用
	
	/* 拒绝进件*/
	public static String REFUSE_INTOPICES = "refuse";//太原复用
	
	/* 申请已通过*/
	public static String APPROVED_INTOPICES = "approved";//太原复用
	
	/* 成功进件*/
	public static String SUCCESS_INTOPICES = "success";//太原复用
	
	/* 申请未通过-补充调查*/
	public static String NOPASS_REPLENISH_INTOPICES = "nopass_replenish";//太原复用
	
	/* 申请未通过-重新调查*/
	public static String NOPASS_RE_INTOPICES = "nopass_re";//太原复用
	
	/*放款成功*/
	public static String END = "end";//太原复用
	
	/*以下是上传状态*/
	public static String INITIAL_INTOPICES="initial";
	
	public static String  EXPORT_INTOPICES="export";
	
	public static String  UPLOAD_INTOPICES="upload";
	
	
	
	
	
	/*联系人*/
	public static String CONTACTID = "contactId";
	
	/*担保人*/
	public static String GUARANTORID = "guarantorId";
	
    /*推荐人*/
	public static String RECOMMENDID = "recommendId";
	
	/**
	 * 定时生成 默认用户
	 */
	public static String SCHEDULES_SYSTEM_USER = "system";
	
	
	/*FTP链接配置*/
	public static String FTPIP = "11.23.11.43";
	
	public static String FTPPORT = "21";
	
	public static String FTPUSERNAME = "root";
	
	public static String FTPPASSWORD = "abc,123";
	
	public static String FTPPATH = "qiankang";
	
	
	/*进件审批记录*/
	public static String APPSP= "1";//审批客户经理
	public static String APPFD= "2";//辅调客户经理
	
	
	public static Map<Integer,String> ATT_BATCH_1 = new HashMap<Integer,String>(){{
	  /*put(1,"合同扫描件");
		put(2,"贷款申请表");
		put(4,"调查报告");
		put(8,"征信查询授权书");
		put(16,"工作底稿");
		put(32,"信用报告及联网核查");
		put(64,"贷审小组决议表");
		put(128,"规范操作承诺书");
		put(256,"收入证明文件");
		put(512,"借款人资产文件、住址证明");
		put(1024,"借款人及共同借款人身份证复印件");
		put(2048,"借款人及共同借款人婚姻状况证明");
		put(4096,"担保人及配偶身份证明复印件");
		put(8192,"担保人及配偶婚姻状况说明");
		put(16384,"担保人收入证明");
		put(1073741824,"其他");*/
		put(1,"财产(存款,理财等)");
		put(2,"银行流水");
		put(4,"证件");
		put(8,"工资证明");
		put(16,"其它");
		put(32,"审贷结论");
	}};
	
	
	
	public static Map<Integer,String> ATT_BATCH_2 = new HashMap<Integer,String>(){{
	  /*put(1,"合同扫描件");
		put(2,"贷款申请表");
		put(4,"调查报告");
		put(8,"征信查询授权书");
		put(16,"工作底稿");
		put(32,"信用报告及联网核查");
		put(64,"贷审小组决议表");
		put(128,"规范操作承诺书");
		put(256,"收入证明文件");
		put(512,"借款人资产文件、住址证明");
		put(1024,"借款人及共同借款人身份证复印件");
		put(2048,"借款人及共同借款人婚姻状况证明");
		put(4096,"担保人及配偶身份证明复印件");
		put(8192,"担保人及配偶婚姻状况说明");
		put(16384,"担保人收入证明");
		put(1073741824,"其他");*/
		put(1,"照片1");
		put(2,"照片2");
		put(4,"照片3");
	}};
	
	
	
}
