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
//-----------------------------------------------------------------------------
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import javax.persistence.UniqueConstraint;
//------------------------------------------------------------------------------
/**
 * Simple JavaBean domain object with an id property.
 * Used as a base class for objects needing this property.
 *
 */
@Entity
@Table(name = "ORIGO_CHANNEL_USER",
       uniqueConstraints = {
		@UniqueConstraint(columnNames = "ORIGO_ID"),
		@UniqueConstraint(columnNames = "EMAILID")
		} 
       )
public class OrigoChannelUserEntity {
	
	public OrigoChannelUserEntity() {
		super();
	}
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORIGO_ID")
    private Integer idUser;
    
    @Column(name = "EMAILID",unique = true, nullable = false, length = 100)
    private String emailId;
    
    @Column(name = "PASSWORD")
    private String password;
    
    /**
     * This field indicates the id channel of the user agent.
     * 01- Web
     */
    @Column(name = "ID_CHANNEL")
    private String idChannel;
    
    @Column(name = "NBR_FAILED_LOGINS",length=1)
    private Integer nbrFailedLogins;
    
    @Column(name = "NBR_LOGINS")
    private Integer nbrLogins;
    
	@Column(name = "LOCK_FLAG",length=1)
    private Character lockFlag;
    
    @Column(name = "DATE_LASTFAILLOGIN",length=1)
    @Type(type="timestamp")
    private Date lastFailedLoginDate;
    
    @Column(name = "DATE_LASTSUCCLOGIN",length=1)
    @Type(type="timestamp")
    private Date lastSuccessLoginDate;
    
    @Column(name = "DATE_LASTLOGIN",length=1)
    @Type(type="timestamp")
    private Date lastLoginDate;
    
    @Column(name="type")
    private String type;

    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdChannel() {
		return idChannel;
	}

	public void setIdChannel(String idChannel) {
		this.idChannel = idChannel;
	}

	public Integer getNbrFailedLogins() {
		return nbrFailedLogins;
	}

	public void setNbrFailedLogins(Integer nbrFailedLogins) {
		this.nbrFailedLogins = nbrFailedLogins;
	}

	public Integer getNbrLogins() {
		return nbrLogins;
	}

	public void setNbrLogins(Integer nbrLogins) {
		this.nbrLogins = nbrLogins;
	}

	public Character getLockFlag() {
		return lockFlag;
	}

	public void setLockFlag(Character lockFlag) {
		this.lockFlag = lockFlag;
	}

	public Date getLastFailedLoginDate() {
		return lastFailedLoginDate;
	}

	public void setLastFailedLoginDate(Date lastFailedLoginDate) {
		this.lastFailedLoginDate = lastFailedLoginDate;
	}

	public Date getLastSuccessLoginDate() {
		return lastSuccessLoginDate;
	}

	public void setLastSuccessLoginDate(Date lastSuccessLoginDate) {
		this.lastSuccessLoginDate = lastSuccessLoginDate;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

    
    public void setId(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getId() {
        return idUser;
    }

    public boolean isNew() {
        return (this.idUser == null);
    }

}
