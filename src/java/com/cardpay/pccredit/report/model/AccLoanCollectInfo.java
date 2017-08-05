package com.cardpay.pccredit.report.model;

import java.math.BigDecimal;

import com.wicresoft.jrad.base.database.model.BusinessModel;

/**
 * @author chinh
 *
 * 2015-8-2上午11:05:27
 */
public class AccLoanCollectInfo extends BusinessModel{
	
	private static final long serialVersionUID = -7513388150092036959L;
	
	private String rowIndex;
	private String increaseLoancount;//新增贷款客户数
	private String loanCustomerSum;//贷款客户总数
	private String increaseCusSum;//新增客户数
	private String centreLoansSun;//中心授信总数
	private Double loanBalanceSum;//新增用信余额
	private Double increaseLoanCredit;//新增授信金额
	private Double increaseBalanceTheMonth;//新增用信余额(日均)
	private Double overdueBalanceTheMon;//逾期金额
	private Double overdueBalance; //累计逾期总额
	private String increseOverdueCusTheMon;//新增逾期客户数
	private String resvIntAccum;//累计实收利息
	private String overdueCusM0;//累计逾期客户数M0以上
	private String overdueCusM1;//累计逾期客户数M1以上
	private String overdueCusM2;//累计逾期客户数M2以上
	private String overdueCusM3;//累计逾期客户数M3以上
	private String overdueCusM4;//累计逾期客户数M4以上
	private String contAmt;//累计授信金额
	private String contBalace;//累计用信余额
	private String alloverdue;//累计逾期客户数
	
	private String  xy;//信用产品贷款余额
	private String  bz;//保证产品贷款余额
	private String  dy;//担保产品贷款余额
	private BigDecimal  pslsd;//post流水产品贷款余额
	private String pos;

	private BigDecimal monthaverageamt;//当月日均贷款余额
	private String  ma;//当月日均贷款余额  显示用
	private BigDecimal totalmonthaverageamt;//累计至今的日均贷款余额
	private String  ta;//累计至今的日均贷款余额 显示用
	
	//占比
	private String  c101numproportion;
	private String  c102numproportion;
	private String  c100numproportion;
	
	private String  c101amtproportion;
	private String  c102amtproportion;
	private String  c100amtproportion;
	
	//笔数 
	private String c101Num;
	private String c102Num;
	private String c100Num;
	
	//金额
	private String c101Amt;
	private String c102Amt;
	private String c100Amt;
	
	
	
	
	
	public String getC101Num() {
		return c101Num;
	}
	public void setC101Num(String c101Num) {
		this.c101Num = c101Num;
	}
	public String getC102Num() {
		return c102Num;
	}
	public void setC102Num(String c102Num) {
		this.c102Num = c102Num;
	}
	public String getC100Num() {
		return c100Num;
	}
	public void setC100Num(String c100Num) {
		this.c100Num = c100Num;
	}
	public String getC101Amt() {
		return c101Amt;
	}
	public void setC101Amt(String c101Amt) {
		this.c101Amt = c101Amt;
	}
	public String getC102Amt() {
		return c102Amt;
	}
	public void setC102Amt(String c102Amt) {
		this.c102Amt = c102Amt;
	}
	public String getC100Amt() {
		return c100Amt;
	}
	public void setC100Amt(String c100Amt) {
		this.c100Amt = c100Amt;
	}
	public String getC101numproportion() {
		return c101numproportion;
	}
	public void setC101numproportion(String c101numproportion) {
		this.c101numproportion = c101numproportion;
	}
	public String getC102numproportion() {
		return c102numproportion;
	}
	public void setC102numproportion(String c102numproportion) {
		this.c102numproportion = c102numproportion;
	}
	public String getC100numproportion() {
		return c100numproportion;
	}
	public void setC100numproportion(String c100numproportion) {
		this.c100numproportion = c100numproportion;
	}
	public String getC101amtproportion() {
		return c101amtproportion;
	}
	public void setC101amtproportion(String c101amtproportion) {
		this.c101amtproportion = c101amtproportion;
	}
	public String getC102amtproportion() {
		return c102amtproportion;
	}
	public void setC102amtproportion(String c102amtproportion) {
		this.c102amtproportion = c102amtproportion;
	}
	public String getC100amtproportion() {
		return c100amtproportion;
	}
	public void setC100amtproportion(String c100amtproportion) {
		this.c100amtproportion = c100amtproportion;
	}
	public BigDecimal getMonthaverageamt() {
		return monthaverageamt;
	}
	public void setMonthaverageamt(BigDecimal monthaverageamt) {
		this.monthaverageamt = monthaverageamt;
	}
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public BigDecimal getTotalmonthaverageamt() {
		return totalmonthaverageamt;
	}
	public void setTotalmonthaverageamt(BigDecimal totalmonthaverageamt) {
		this.totalmonthaverageamt = totalmonthaverageamt;
	}
	public String getTa() {
		return ta;
	}
	public void setTa(String ta) {
		this.ta = ta;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public BigDecimal getPslsd() {
		return pslsd;
	}
	public void setPslsd(BigDecimal pslsd) {
		this.pslsd = pslsd;
	}
	public String getXy() {
		return xy;
	}
	public void setXy(String xy) {
		this.xy = xy;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getDy() {
		return dy;
	}
	public void setDy(String dy) {
		this.dy = dy;
	}
	public String getIncreaseLoancount() {
		return increaseLoancount;
	}
	public void setIncreaseLoancount(String increaseLoancount) {
		this.increaseLoancount = increaseLoancount;
	}
	public String getLoanCustomerSum() {
		return loanCustomerSum;
	}
	public void setLoanCustomerSum(String loanCustomerSum) {
		this.loanCustomerSum = loanCustomerSum;
	}
	public String getIncreaseCusSum() {
		return increaseCusSum;
	}
	public void setIncreaseCusSum(String increaseCusSum) {
		this.increaseCusSum = increaseCusSum;
	}
	public String getCentreLoansSun() {
		return centreLoansSun;
	}
	public void setCentreLoansSun(String centreLoansSun) {
		this.centreLoansSun = centreLoansSun;
	}
	public Double getLoanBalanceSum() {
		return loanBalanceSum;
	}
	public void setLoanBalanceSum(Double loanBalanceSum) {
		this.loanBalanceSum = loanBalanceSum;
	}
	public Double getIncreaseLoanCredit() {
		return increaseLoanCredit;
	}
	public void setIncreaseLoanCredit(Double increaseLoanCredit) {
		this.increaseLoanCredit = increaseLoanCredit;
	}
	public Double getIncreaseBalanceTheMonth() {
		return increaseBalanceTheMonth;
	}
	public void setIncreaseBalanceTheMonth(Double increaseBalanceTheMonth) {
		this.increaseBalanceTheMonth = increaseBalanceTheMonth;
	}
	public Double getOverdueBalanceTheMon() {
		return overdueBalanceTheMon;
	}
	public void setOverdueBalanceTheMon(Double overdueBalanceTheMon) {
		this.overdueBalanceTheMon = overdueBalanceTheMon;
	}
	public Double getOverdueBalance() {
		return overdueBalance;
	}
	public void setOverdueBalance(Double overdueBalance) {
		this.overdueBalance = overdueBalance;
	}
	public String getIncreseOverdueCusTheMon() {
		return increseOverdueCusTheMon;
	}
	public void setIncreseOverdueCusTheMon(String increseOverdueCusTheMon) {
		this.increseOverdueCusTheMon = increseOverdueCusTheMon;
	}
	public String getOverdueCusM0() {
		return overdueCusM0;
	}
	public void setOverdueCusM0(String overdueCusM0) {
		this.overdueCusM0 = overdueCusM0;
	}
	public String getOverdueCusM1() {
		return overdueCusM1;
	}
	public void setOverdueCusM1(String overdueCusM1) {
		this.overdueCusM1 = overdueCusM1;
	}
	public String getOverdueCusM2() {
		return overdueCusM2;
	}
	public void setOverdueCusM2(String overdueCusM2) {
		this.overdueCusM2 = overdueCusM2;
	}
	public String getOverdueCusM3() {
		return overdueCusM3;
	}
	public void setOverdueCusM3(String overdueCusM3) {
		this.overdueCusM3 = overdueCusM3;
	}
	public String getOverdueCusM4() {
		return overdueCusM4;
	}
	public void setOverdueCusM4(String overdueCusM4) {
		this.overdueCusM4 = overdueCusM4;
	}
	public String getRowIndex() {
		return rowIndex;
	}
	public void setRowIndex(String rowIndex) {
		this.rowIndex = rowIndex;
	}
	public String getResvIntAccum() {
		return resvIntAccum;
	}
	public void setResvIntAccum(String resvIntAccum) {
		this.resvIntAccum = resvIntAccum;
	}
	public String getContAmt() {
		return contAmt;
	}
	public void setContAmt(String contAmt) {
		this.contAmt = contAmt;
	}
	public String getContBalace() {
		return contBalace;
	}
	public void setContBalace(String contBalace) {
		this.contBalace = contBalace;
	}
	public String getAlloverdue() {
		return alloverdue;
	}
	public void setAlloverdue(String alloverdue) {
		this.alloverdue = alloverdue;
	}

}
