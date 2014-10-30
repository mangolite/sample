package com.web.app;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.webutils.WebContextUtil;

/**
 * @author <a href="mailto:lalit.tanwar07@gmail.com">Lalit Tanwar</a>
 * @version 1.0
 * @lastModified Sep 10, 2014
 */
@Service
public class MessageClient {

	private static SimpMessagingTemplate client;
	private static final String USER_PREFIX = "/notify/";
	private static final String ALL_PREFIX = "/event/";

	public static SimpMessagingTemplate getClient() {
		return client;
	}

	public static void setClient(SimpMessagingTemplate tempClient) {
		client = tempClient;
	}

	/**
	 * To send message to specified user
	 * 
	 * <p>
	 * stompClient.on('eventName',listener);
	 * </p>
	 * 
	 * @param user
	 * @param eventPath
	 * @param payload
	 */
	public static void sendToUser(String user, String eventPath, Object payload) {
		client.convertAndSendToUser(user, USER_PREFIX + eventPath, payload);
	}

	/**
	 * To send message to current user (Current user is user who has
	 * initiated the request).
	 *
	 * To listen to this message on client-side use: -
	 * <p>
	 * stompClient.on('eventName',listener);
	 * </p>
	 * 
	 * @param eventName
	 * @param payload
	 */
	public static void send(String eventName, Object payload) {
		client.convertAndSendToUser(WebContextUtil.getUserToken(), USER_PREFIX + eventName, payload);
	}

	/**
	 * To broadcast the message, to listen to this message on
	 * client-side use: -
	 * 
	 * <p>
	 * stompClient.on('event','eventName',listener);
	 * </p>
	 * 
	 * @param eventName
	 * @param payload
	 */
	public static void sendToAll(String eventName, Object payload) {
		client.convertAndSend(ALL_PREFIX + eventName, payload);
	}

}