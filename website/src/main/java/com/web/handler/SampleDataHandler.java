package com.web.handler;

import com.web.engine.DataEngine;
import com.web.engine.SampleData;
import com.webutils.AbstractHandler;
import com.webutils.WebContextUtil;
import com.webutils.annotations.ActionHandler;
import com.webutils.annotations.HandlerAction;

/**
 * THis is sampe test handler.
 *
 * @author <a mailto:lalit.tanwar07@gmail.com> Lalit Tanwar</a>
 * @version 1.0
 * @lastModified Aug 19, 2014
 */
@ActionHandler(name = "sampledata")
public class SampleDataHandler extends AbstractHandler {

	private static DataEngine engine = new DataEngine();
	
	@HandlerAction(name = "price_updated")
	public void getData2(SampleData data) {
		try {
			engine.addData(WebContextUtil.getUserToken(),data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
