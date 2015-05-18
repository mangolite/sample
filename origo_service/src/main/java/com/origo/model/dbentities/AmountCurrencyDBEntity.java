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

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
/**
 * This DBEntity models to carry amount related information.
**/
@Entity
@Table(name="COMPANY_REVENUE_DETAILS")
public  class 
	AmountCurrencyDBEntity 
{
	//-------------------------------------------------------------------------
	
	@Id
	@Column(name="ORIGO_ID", unique=true, nullable=false)
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="employee"))
	private int origoId;
	
	public int getOrigoId() {
		return origoId;
	}
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private CompanyProfileEntity companyEntity;
	
	/** 
	 * This field indicates amount. 
	**/  
	@Column(name = "ANNUAL_REVENUE")
	public BigDecimal
		amount	
	;
	
	/**
	 This field indicates currency code
	**/
	@Column(name = "CODE_CURRENCY")
	public String
		codCurrency
	;
	
	/**
	 This field indicates currency name
	**/
	@Column(name = "NAME_CURRENCY")
	public String
		namCurrency
	;

	/**
	 This field indicates fractional digit as per ISO
	**/
	@Column(name = "ISO_FRACT_DIGIT",length=10)
	public  int
		isoFractionalDegit
	;
	/**
	 This field indicates country code as per ISO
	**/
	@Column(name = "ISO_COUNTRY_CODE",length=5)
	public  String
		isoCodeCountry
	;
	
	/**
	**/
	@Column(name = "ISO_COUNTRY_NAME",length=5)
	public  String
		isoNameCountryFull
	;

	/** 
	 * This field indicates type. 
	 * local or regional
	**/
	@Column(name = "TYPE")
	public String
		type
	;

	public void setOrigoId(int origoId) {
		this.origoId = origoId;
	}
	
	public CompanyProfileEntity getCompanyEntity() {
		return companyEntity;
	}
	public void setCompanyEntity(CompanyProfileEntity companyEntity) {
		this.companyEntity = companyEntity;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getCodCurrency() {
		return codCurrency;
	}
	public void setCodCurrency(String codCurrency) {
		this.codCurrency = codCurrency;
	}
	public String getNamCurrency() {
		return namCurrency;
	}
	public void setNamCurrency(String namCurrency) {
		this.namCurrency = namCurrency;
	}
	public int getIsoFractionalDegit() {
		return isoFractionalDegit;
	}
	public void setIsoFractionalDegit(int isoFractionalDegit) {
		this.isoFractionalDegit = isoFractionalDegit;
	}
	public String getIsoCodeCountry() {
		return isoCodeCountry;
	}
	public void setIsoCodeCountry(String isoCodeCountry) {
		this.isoCodeCountry = isoCodeCountry;
	}
	public String getIsoNameCountryFull() {
		return isoNameCountryFull;
	}
	public void setIsoNameCountryFull(String isoNameCountryFull) {
		this.isoNameCountryFull = isoNameCountryFull;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	//-------------------------------------------------------------------------
	/**
	 * 	The default constructor for the class. This does not initialize any fields.
	**/
	public AmountCurrencyDBEntity () {
	}
	//-------------------------------------------------------------------------

}
//-----------------------------------------------------------------------------
//
//End Of File
//
//-----------------------------------------------------------------------------