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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.NotEmpty;
//-----------------------------------------------------------------------------
@Entity
@Table(name = "ORIGO_TXN_CONTACT_DETAILS")
public class ContactDetailsEntity {
	
	
	public ContactDetailsEntity() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;

	@Column(name = "telephone")
    @NotEmpty
    @Digits(fraction = 0, integer = 10)
    private String telephone;
    
	@Column(name = "CONTACT_NUMBER_TYPE",length=15)
	private String contactNumberType;
	
	@Column(name = "CONTACT_EMAIL",length=100)
	private String contactEmail;
	
	@ManyToOne
//	@JoinColumn(name="ORIGO_ID", insertable=false, updatable=false, nullable=false)
	private CompanyProfileEntity companyProfile;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

	
	
    public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getContactNumberType() {
		return contactNumberType;
	}

	public void setContactNumberType(String contactNumberType) {
		this.contactNumberType = contactNumberType;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public CompanyProfileEntity getCompanyProfile() {
		return companyProfile;
	}

	public void setCompanyProfile(CompanyProfileEntity companyProfile) {
		this.companyProfile = companyProfile;
	}

}

