package com.kosmo.ver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
@Component
public class EchoHandler extends TextWebSocketHandler {
	Logger logger = LoggerFactory.getLogger(EchoHandler.class);
	List<WebSocketSession> sessionList = new ArrayList<>();
	Map<String,List<WebSocketSession>> sessionMap = new HashMap<>();
	//클라이언트와 연결 이후에 실행되는 메소드
	@Override
	public void afterConnectionEstablished(WebSocketSession session) 
	throws Exception
	{
		String uri = session.getUri().toString();
		//ws:\\\\192.168.0.244:5000\\ver2\\echo?roomCreate:kosmo59
		String real = uri.split("\\?")[1];//roomCreate:kosmo59
		String status = real.split("\\:")[0];//roomCreate
		String roomName = real.split("\\:")[1];//kosmo59
		if("roomCreate".equals(status)) {
			sessionList.add(session);
			sessionMap.put("roomName",sessionList);
			logger.info("{}  방이 생성되고  세션 아이디는 {}",roomName, session.getId());
		}
		logger.info("sessionList : "+sessionList.size());
	}
	//클라이언트가 서버로 메시지를 전송했을 때 실행되는 메소드
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) 
			throws Exception
	{
		logger.info("{} 로 부터 {} 받음", session.getId(), message.getPayload());
		String msg_chat = "100";
		StringTokenizer st = new StringTokenizer(message.getPayload(),"#");
		String kind = st.nextToken();
		if(msg_chat.equals(kind)) {
			String msg = st.nextToken();
			for(WebSocketSession sess:sessionList) {
				sess.sendMessage(new TextMessage(session+msg));
			}
		}
	}
	
	//클라이언트와 연결을 끊었을 때 실행되는 메소드
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception
	{
		logger.info("afterConnectionClosed 호출 성공");
		logger.info("{} 연결 끊김 : ", session.getId());
		run_start:
		for(int i=0;i<sessionMap.size();i++) {
			Object[] keys = sessionMap.keySet().toArray();
			sessionList = sessionMap.get(keys[i]);
			for(int j=0;j<sessionList.size();j++) {
				if(session.equals(sessionList.get(j))){
					sessionList.remove(j);
					for(WebSocketSession sess : sessionList) {
						sess.sendMessage(new TextMessage(sessionList.size()+":"+"현재 인원수"));
					}
					logger.info("for문 안에 {} 연결 끊김 : ", session.getId());
					break run_start;
				}
			}
		}
	}
}









