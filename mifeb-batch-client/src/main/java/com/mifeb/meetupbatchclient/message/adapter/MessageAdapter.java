package com.mifeb.meetupbatchclient.message.adapter;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.mifeb.meetupmodel.entity.event.Event;
import com.mifeb.meetupmodel.entity.eventmember.EventMember;
import com.mifeb.meetupmodel.entity.eventmember.EventMemberId;
import com.mifeb.meetupmodel.entity.group.Group;
import com.mifeb.meetupmodel.entity.member.Member;

public class MessageAdapter {

	public static EventMember adapt(String message) {
//      System.out.print(message);
      JsonReader jsonReader = Json.createReader(new StringReader(message));
      JsonObject jsonObject = jsonReader.readObject();
      jsonReader.close();
      Long groupId = jsonObject.getJsonObject("group").getJsonNumber("group_id").longValue();
      String groupName = jsonObject.getJsonObject("group").getString("group_name");
      Float groupLat = jsonObject.getJsonObject("group").getJsonNumber("group_lat").bigDecimalValue().floatValue();
      Float groupLon = jsonObject.getJsonObject("group").getJsonNumber("group_lon").bigDecimalValue().floatValue();
      String groupCity = jsonObject.getJsonObject("group").getString("group_city");

      Group group = new Group();
      group.setGroupId(groupId);
      group.setGroupName(groupName);
      group.setLat(groupLat);
      group.setLon(groupLon);
      group.setCity(groupCity);
      
      String eventId = jsonObject.getJsonObject("event").getString("event_id");
      String eventName = jsonObject.getJsonObject("event").getString("event_name");
      Long time = jsonObject.getJsonObject("event").getJsonNumber("time").longValue();
      Event event = new Event();
      event.setEventId(eventId);
      event.setEventName(eventName);
      event.setGroup(group);
      event.setTime(time);
      
      Long memberId = jsonObject.getJsonObject("member").getJsonNumber("member_id").longValue();
      String memberName = jsonObject.getJsonObject("member").getString("member_name");
      Member member = new Member();
      member.setMemberId(memberId);
      member.setMemberName(memberName);
      
      EventMember eventMember = new EventMember();
      EventMemberId eventMemberId = new EventMemberId();
      eventMemberId.setEvent(event);
      eventMemberId.setMember(member);
      Long inscriptionTime = jsonObject.getJsonNumber("mtime").longValue();
      eventMember.setEventMemberId(eventMemberId);
      eventMember.setInscriptionTime(inscriptionTime);
      return eventMember;
	}
}
