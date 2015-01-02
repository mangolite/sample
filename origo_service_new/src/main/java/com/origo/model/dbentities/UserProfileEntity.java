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
//--------------------------------------------------------
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
//--------------------------------------------------------
@Entity
@Table(name = "ORIGO_TXN_USER_PROFILE")
public class UserProfileEntity extends BaseUserEntity{
	
	public UserProfileEntity() {
		super();
	}
	
	@Lob
	@Column(name = "USER_DESC")
	private String userDesc;
	
	@Column(name = "DESIGNATION",length=255)
	private String designation;
	
	public String getAboutMeDesc() {
		return userDesc;
	}
	
	public void setAboutMeDesc(String userDesc) {
		this.userDesc = userDesc;
	}
	
	public String getDesignation() {
		return designation;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
}
