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
//----------------------------------------------------------------------------
import javax.persistence.Entity;
import javax.persistence.Table;
//-----------------------------------------------------------------------------
@Entity
@Table(name = "ORIGO_MST_CERTIFICATION_TYPES")
public class CertificationTypeEntity extends NamedEntity{
	
	public CertificationTypeEntity(){
	  super();	
	}
	
	
	
}
