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

Copyright © 2014 OrigoXtreme Pvt Ltd.

Modification History

Date		Version		Author			Description
----------	-----------	--------------- ----------------------------------------
07 12 2014	1			Ram G Suri		Initial Version								
------------------------------------------------------------------------------*/
package com.origo.model.dbentities;
//------------------------------------------------------------------------------
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
//------------------------------------------------------------------------------
/**
 * This DB Entity models to carry address details of the customer.
 **/
@Entity
@Table(name = "ORIGO_TXN_COMPANY_ADDRESS")
public final class 
	AddressEntity 
extends 
	BaseEntity
{	
	/**
	The default constructor for the class. This does not initialize any fields.
	**/
	public AddressEntity() {
		super();
	}
	/**
	This field indicates  the line1 . 
	**/
	@Column(name = "LINE1")
	private String 
		line1
	;
	/**
	This field indicates  the line2 . 
	**/
	@Column(name = "LINE2")
	private String 
		line2
	;
	/**
	This field indicates  the line3 . 
	**/
	@Column(name = "LINE3")
	private String 
		line3
	;
	/**
	This field indicates  the codCountry . 
	**/
	@Column(name = "COUNTRY_CODE")
	private String 
		codCountry
	;
	/**
	This field indicates the description of country . 
	**/
	@Column(name = "COUNTRY_DESC")
	private String 
		country
	;
	/**
	This field indicates the description of state . 
	**/
	@Column(name = "STATE")
	private String 
		state
	;
	/**
	This field indicates the description of city . 
	**/
	@Column(name = "CITY")
	private String 
		city
	;
	/**
	This field indicates  the zip . 
	**/
	@Column(name = "ZIP")
	private String 
		zip
	;

	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public String getLine2() {
		return line2;
	}
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	public String getLine3() {
		return line3;
	}
	public void setLine3(String line3) {
		this.line3 = line3;
	}
	public String getCodCountry() {
		return codCountry;
	}
	public void setCodCountry(String codCountry) {
		this.codCountry = codCountry;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	
	
//------------------------------------------------------------------------------
}
//-----------------------------------------------------------------------------
//
//End Of File
//
//-----------------------------------------------------------------------------
