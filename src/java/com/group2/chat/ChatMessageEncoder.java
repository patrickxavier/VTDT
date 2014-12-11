/*
 * Created by Ragan Walker on 2014.12.11  * 
 * Copyright © 2014 Ragan Walker. All rights reserved. * 
 */
package com.group2.chat;

import javax.json.Json;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
 
public class ChatMessageEncoder implements Encoder.Text<ChatMessage> {
	@Override
	public void init(final EndpointConfig config) {
	}
 
	@Override
	public void destroy() {
	}
 
	@Override
	public String encode(final ChatMessage chatMessage) throws EncodeException {
		return Json.createObjectBuilder()
				.add("message", chatMessage.getMessage())
				.add("sender", chatMessage.getSender())
				.add("received", chatMessage.getReceived().toString()).build()
				.toString();
	}
}