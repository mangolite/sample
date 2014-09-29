package com.web.engine;

import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

import com.web.app.MessageClient;

public class DataEngine {
	public static final Timer timer = new Timer();
	private static final long LIVE_EXPIRY_TIME = 500;
	private static final long LIVE_EXPIRY_TIME_DELAY = 500;
	private static final Map<String, SampleData> samples = new ConcurrentHashMap<String, SampleData>();
	private static final SampleData avgData = new SampleData();
	private static Double ZERO_VALUE = 0.0;

	static {
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				synchronized (avgData) {
					avgData.setTime(new Date().toLocaleString());
					MessageClient.sendToAll("market_price", avgData);
				}
			}
		}, LIVE_EXPIRY_TIME_DELAY, LIVE_EXPIRY_TIME);
	}

	public void addData(String user, SampleData data) {
		/*
		 * if (samples.containsKey(data.getUid())) { SampleData uData =
		 * samples.get(data.getUid()); avgData.setVolume(avgData.getVolume() -
		 * uData.getVolume()); }
		 */
		if (data != null && data.getPrice() > ZERO_VALUE
				&& data.getVolume() > 0) {
			synchronized (avgData) {
				samples.put(user, data);
				Double totalPrice = 0.0;
				Long totalVolume = 0L;
				for (Entry<String, SampleData> sData : samples.entrySet()) {
					totalPrice = totalPrice + sData.getValue().getPrice();
					totalVolume = totalVolume + sData.getValue().getVolume();
				}
				avgData.setPrice(totalPrice);
				avgData.setVolume(totalVolume);
				avgData.setRate(totalPrice / totalVolume);
			}
		}
	}

}
