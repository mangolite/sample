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
package com.origo.model.vo;
//-----------------------------------------------------------------------------
/**
This DTO models <code> User Defined Fields</code> to extend the 
Value Object with additional data. All Value Object are expected and 
required to have a mandatory instance variable of this. 
<p>
The following declaration has to be put in all VOs.
<code>
<p>
public UDFDTO []<p>
	udfFields<p>
;<p>
</code>
**/
public final class
	UDFVO
extends
	BaseVO
{
	/**
	 * SerialVersion UID
	 */
	private static final long serialVersionUID = 1L;
	//-------------------------------------------------------------------------	
	/**
	This field indicates name of the UDF field.
	**/
	public String 
		udfName
	;
	/**
	This field indicates the value of the UDF field.
	**/
	public String 
		udfValue
	;
	/**
	 * This field is used for supporting VO structure as UDFValue.
	 * Assign the Marshalled (String representation) VO to the field.
	 * The value  will be delivered as XML structure and not data.
	**/	
	public volatile String 
		udfObjectValue
	;
	//-------------------------------------------------------------------------	
	/**
	The default constructor for the class. This does not initialize any fields.
	**/
	public UDFVO () {
		
	}
	//-------------------------------------------------------------------------	
}
//-----------------------------------------------------------------------------
//
//	End of File
//
//-----------------------------------------------------------------------------