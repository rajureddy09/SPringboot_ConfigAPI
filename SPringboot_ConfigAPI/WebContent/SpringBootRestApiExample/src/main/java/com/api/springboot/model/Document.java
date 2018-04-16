package com.api.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Document {
    
	@GeneratedValue
	private int docId;
	

	private double versionNo;
	
	private String appCode;
	public Document(){
		
	}
	public Document(int id,double versionNo, String appCode){
	this.docId=id;
	this.versionNo=versionNo;
	this.appCode=appCode;
	}
	
	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	
	public double getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(double versionNo) {
		this.versionNo = versionNo;
	}

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appCode == null) ? 0 : appCode.hashCode());
		result = prime * result + docId;
		long temp;
		temp = Double.doubleToLongBits(versionNo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		if (appCode == null) {
			if (other.appCode != null)
				return false;
		} else if (!appCode.equals(other.appCode))
			return false;
		if (docId != other.docId)
			return false;
		if (Double.doubleToLongBits(versionNo) != Double.doubleToLongBits(other.versionNo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Document [docId=" + docId + ", versionNo=" + versionNo + ", appCode=" + appCode + "]";
	}
	
	
}
