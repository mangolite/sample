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
//-------------------------------------------------
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//--------------------------------------------------
@Entity
@Table(name = "ORIGO_TXN_COMPANY_RESOURCE")
public class CompanyResourceEntity {
	
	public CompanyResourceEntity() {
		super();
	}
	
	@Id
	@Column(name = "RESOURCE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer resourceId;

	@ManyToOne
//	@JoinColumn(name="ORIGO_ID", insertable=false, updatable=false, nullable=false)
	private CompanyProfileEntity company;

	/**
	This field indicates  the line2 . 
	**/
	@Column(name = "RESOURCE_NAME",length=1000)
	private String 
		resourceName
	;
	/**
	This field indicates  the line3 . 
	**/
	@Column(name = "RESOURCE_DESC",length=4000)
	private String 
		resourceDesc	
	;
	
	/**
	This field indicates  the line2 . 
	**/
	@Column(name = "RESOURCE_PATH",length=255)
	private String 
		resourcePath
	;
	
	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	public CompanyProfileEntity getCompany() {
		return company;
	}

	public void setCompany(CompanyProfileEntity company) {
		this.company = company;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceDesc() {
		return resourceDesc;
	}

	public void setResourceDesc(String resourceDesc) {
		this.resourceDesc = resourceDesc;
	}

	public String getResourcePath() {
		return resourcePath;
	}

	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}


}
