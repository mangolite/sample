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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//-----------------------------------------------------------------------------
@Entity
@Table(name = "ORIGO_TXN_COMPANY_VIDEOS")
public class VideoEntity extends BaseEntity{
	
	public VideoEntity() {
		super();
	}
	
	@ManyToOne
	@JoinColumn(name="ORIGO_ID", insertable=false, updatable=false,nullable=false)
	private CompanyProfileEntity company;
	
	@Column(name = "VIDEO_ID")
	private Integer videoId;
	
	@Column(name = "VIDEO_NAME")
	private String videoName;
	
	@Column(name = "VIDEO_EMBEDED_CODE")
	private String videoCode;
	
	@Column(name = "VIDEO_CLIPART")
	private String videoClipArt;
	
	@Column(name = "VIDEO_URL")
	private String videoURL;

	public Integer getCompanyId() {
		return videoId;
	}

	public void setCompanyId(Integer videoId) {
		this.videoId = videoId;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getVideoCode() {
		return videoCode;
	}

	public void setVideoCode(String videoCode) {
		this.videoCode = videoCode;
	}

	public String getVideoText() {
		return videoURL;
	}

	public void setVideoText(String videoURL) {
		this.videoURL = videoURL;
	}
	
}

