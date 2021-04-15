package com.kitri.visitor.vo;

import java.sql.Timestamp;
import java.util.Date;

public class VisitorVO {
	private int vNo;
	private String vAuth;
	private String vPwd;
	private String vContent;
	private Timestamp vRegDt;
	private Date vUpdateDt;
	
	public int getvNo() {
		return vNo;
	}
	public void setvNo(int vNo) {
		this.vNo = vNo;
	}
	public String getvAuth() {
		return vAuth;
	}
	public void setvAuth(String vAuth) {
		this.vAuth = vAuth;
	}
	public String getvPwd() {
		return vPwd;
	}
	public void setvPwd(String vPwd) {
		this.vPwd = vPwd;
	}
	public String getvContent() {
		return vContent;
	}
	public void setvContent(String vContent) {
		this.vContent = vContent;
	}
	public Timestamp getvRegDt() {
		return vRegDt;
	}
	public void setvRegDt(Timestamp vRegDt) {
		this.vRegDt = vRegDt;
	}
	public Date getvUpdateDt() {
		return vUpdateDt;
	}
	public void setvUpdateDt(Date vUpdateDt) {
		this.vUpdateDt = vUpdateDt;
	}
	
	@Override
	public String toString() {
		return "VisitorVO [vNo=" + vNo + ", vAuth=" + vAuth + ", vPwd=" + vPwd + ", vContent=" + vContent + ", vRegdt="
				+ vRegDt + ", vUpdate=" + vUpdateDt + "]";
	}
	
	
}
