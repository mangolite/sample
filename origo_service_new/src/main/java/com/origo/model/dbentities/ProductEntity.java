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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//-----------------------------------------------------------------------------
@Entity
@Table(name = "ORIGO_TXN_COMPANY_PRODUCT_DETAILS")
public class ProductEntity {
	
	public ProductEntity() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID")
	private Integer productId;
	
	@ManyToOne
	@JoinColumn(name="ORIGO_ID_FK", updatable=false,nullable=false)
	private CompanyProfileEntity company;
	
	/**
	 * This field describes about the product name.
	 */
	@Column(name = "PRODUCT_NAME", length=500)
	private String productName;
	
	/**
	 * This field describes about the product specification.
	 */
	@Column(name = "PRODUCT_SPECS",length=4000)
	private String productSpecification;
	
	/**
	 * This field describes about the product features.
	 */
	@Lob
	@Column(name = "PRODUCT_DESC")
	private byte[] productDesc;
	
	/**
	 * This field indicates the active flag of the product.
	 * Valid Value Y or N
	 */
	@Column(name = "ACTIVE_FLAG",length=1)
	private Character activeFlag;
	
	/**
	 * This field describes the path of image of product.
	 * Image of a product is saved in file system.
	 */
	@Column(name = "PRODUCT_PIC",length=1000)
	private String productPic;
	
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public CompanyProfileEntity getCompany() {
		return company;
	}

	public void setCompany(CompanyProfileEntity company) {
		this.company = company;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductSpecification() {
		return productSpecification;
	}

	public void setProductSpecification(String productSpecification) {
		this.productSpecification = productSpecification;
	}

	public byte[] getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(byte[] productDesc) {
		this.productDesc = productDesc;
	}

	public Character getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Character activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getProductPic() {
		return productPic;
	}

	public void setProductPic(String productPic) {
		this.productPic = productPic;
	}

}
