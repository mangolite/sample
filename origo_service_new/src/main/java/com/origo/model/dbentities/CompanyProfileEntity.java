/*------------------------------------------------------------------------------

This source is part of the OrigoXtreme Pvt Ltd.

All rights reserved.  No part of this work may be reproduced, stored in a
retrieval system, adopted or transmitted in any form or by any means,
electronic, mechanical, photographic, graphic, optic recording or otherwise,
translated in any language or computer language, without the prior written
permission of OrigoXtreme Pvt Limited.

OrigoXtreme Pvt Ltd
Gurgaon
India

Copyright � 2014 OrigoXtreme Pvt Ltd.

Modification History

Date		Version		Author			Description
----------	-----------	--------------- ----------------------------------------
07 12 2014	1			Ram G Suri		Initial Version								
------------------------------------------------------------------------------*/
package com.origo.model.dbentities;
//-----------------------------------------------------------------------------
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
//-----------------------------------------------------------------------------
@Entity
@Table(name = "ORIGO_TXN_COMPANY_PROFILE", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ORIGO_ID")
		} 
)
public class CompanyProfileEntity extends BaseUserEntity implements Serializable{
	
	public CompanyProfileEntity(){
		super();
	}
	

	@OneToMany(mappedBy="company", cascade={CascadeType.ALL},fetch = FetchType.EAGER)
//	@JoinTable(name = "ORIGO_TXN_COMPANY_PRODUCT_DETAILS", joinColumns = @JoinColumn(name = "ORIGO_ID"), inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
//	@JoinColumn(name="ORIGO_ID")
	private List<ProductEntity> productEntity;	
	
	@OneToMany(mappedBy="companyProfile",cascade={CascadeType.ALL},fetch = FetchType.EAGER)
//	@JoinColumn(name="ORIGO_ID")
	private List<ContactDetailsEntity> contactDetailsEntity;	

	@OneToMany(mappedBy="company",cascade={CascadeType.ALL},fetch = FetchType.EAGER)
//	@JoinColumn(name="ORIGO_ID")
	private List<CompanyResourceEntity> resourceDetailsEntity;	

	@OneToOne(mappedBy="companyEntity", cascade=CascadeType.ALL)
	private AmountCurrencyDBEntity annualRevenue;

	@Column(name = "COMPANY_CEO",length=100)
	private String companyCEOName;
	
	@Column(name = "COMPANY_STOCK_NAME", length=100)
	private String companyStockName;
	
	@Column(name = "STOCK_CURRENCY_CODE",length=10)
	private String companyStockCode;
	
	@Column(name = "YEAR_OF_ESTABLISHMENT",length=4)
	public Integer yearEstablishedIn;
	
	@Column(name = "INDUSTRY_TYPE", length=1000)
	private String industryType;
	
	@Column(name = "COMPANY_DESC", length=4000)
	private String companyDesc;
	
//	@Column(name = "CERTIFICATION") // List Of Certificates
//	private String certification; 
	
	
	public List<ProductEntity> getProductEntity() {
		 if (this.productEntity == null) {
	            this.productEntity = new ArrayList<ProductEntity>();
	        }
			return this.productEntity;
	}

	public void setProductEntity(List<ProductEntity> productEntity) {
		this.productEntity = productEntity;
	}

	public List<ContactDetailsEntity> getContactDetailsEntity() {
		 if (this.contactDetailsEntity == null) {
	            this.contactDetailsEntity = new ArrayList<ContactDetailsEntity>();
	        }
			return this.contactDetailsEntity;
	}

	public void setContactDetailsEntity(
			List<ContactDetailsEntity> contactDetailsEntity) {
		this.contactDetailsEntity = contactDetailsEntity;
	}

	public List<CompanyResourceEntity> getResourceDetailsEntity() {
		 if (this.resourceDetailsEntity == null) {
	            this.resourceDetailsEntity = new ArrayList<CompanyResourceEntity>();
	        }
			return this.resourceDetailsEntity;
		
	}

	public void setResourceDetailsEntity(
			List<CompanyResourceEntity> resourceDetailsEntity) {
		this.resourceDetailsEntity = resourceDetailsEntity;
	}

	public String getCompanyCEOName() {
		return companyCEOName;
	}

	public void setCompanyCEOName(String companyCEOName) {
		this.companyCEOName = companyCEOName;
	}

	public String getCompanyStockName() {
		return companyStockName;
	}

	public void setCompanyStockName(String companyStockName) {
		this.companyStockName = companyStockName;
	}

	public String getCompanyStockCode() {
		return companyStockCode;
	}

	public void setCompanyStockCode(String companyStockCode) {
		this.companyStockCode = companyStockCode;
	}

	public Integer getYearEstablishedIn() {
		return yearEstablishedIn;
	}

	public void setYearEstablishedIn(Integer yearEstablishedIn) {
		this.yearEstablishedIn = yearEstablishedIn;
	}

	public String getIndustryType() {
		return industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

	public String getCompanyDesc() {
		return companyDesc;
	}

	public void setCompanyDesc(String companyDesc) {
		this.companyDesc = companyDesc;
	}

	public AmountCurrencyDBEntity getAnnualRevenue() {
		return annualRevenue;
	}

	public void setAnnualRevenue(AmountCurrencyDBEntity annualRevenue) {
		this.annualRevenue = annualRevenue;
	}

	public Integer getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(Integer employeeCount) {
		this.employeeCount = employeeCount;
	}

	public String getCertifications() {
		return certifications;
	}

	public void setCertifications(String certifications) {
		this.certifications = certifications;
	}

	public String getAcquisition() {
		return acquisition;
	}

	public void setAcquisition(String acquisition) {
		this.acquisition = acquisition;
	}


	@Column(name = "EMPLOYEE_COUNT")
	private Integer employeeCount;
	
	// Values are comma separated for certifications.
	// Values can be fetched from  ORIGO_MST_CERTIFICATION_TYPES table.
	@Column(name = "CERTIFICATIONS",length=2000)
	private String certifications;

	// Values are comma separated for acquisition.
	@Column(name = "ACQUISITION",length=4000)
	private String acquisition;
	
	
	
}
