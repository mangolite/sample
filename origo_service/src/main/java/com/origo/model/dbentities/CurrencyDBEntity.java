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
/**
This DBEntity stores the details of the currency
**/
public class
	CurrencyDBEntity
{
	//--------------------------------------------------------------------------	
	/**
	 This field indicates origoEntity
	**/
	public String
		origoEntity
	;
	
	/**
	 This field indicates currency code
	**/
	public String
		codCurrency
	;
	
	/**
	 This field indicates currency name
	**/
	public String
		namCurrency
	;
	
	/**
	 This field indicates host currency code
	**/
	public String
		hostCodCurrency
	;
	
	/**
	 This field indicates currency name as per ISO
	**/
	public  String
		isoNameCurrency1
	;

	/**
	 This field indicates fractional digit as per ISO
	**/
	public  int
		isoFractionalDegit
	;
	/**
	 This field indicates country code as per ISO
	**/
	public  String
		isoCodeCountry
	;
	/**
	**/
	public  String
		isoNameCountryFull
	;

	/**
	 This field indicates whether currency is local or not
	**/
	public boolean
		isLocal
	;
	//--------------------------------------------------------------------------	
	/**
	 The default constructor of the  CurrencyEntity
	**/
	public CurrencyDBEntity () {
		super();
	}
	//--------------------------------------------------------------------------	
}		
//------------------------------------------------------------------------------
//
//End of File
//
//------------------------------------------------------------------------------

