package com.mifeb.meetupbatchclient;

import java.net.URI;
import java.net.URISyntaxException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.mifeb.meetupbatchclient.message.adapter.MessageAdapter;
import com.mifeb.meetupbatchclient.websocket.WebsocketClientEndpoint;
import com.mifeb.meetupmodel.entity.eventmember.EventMember;
import com.mifeb.meetupmodel.service.event.EventService;

/**
 * Hello world!
 *
 */
@EntityScan("com.mifeb.meetupmodel")
@EnableJpaRepositories("com.mifeb.meetupmodel")
@ComponentScan({"com.mifeb.meetupmodel"})
@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {
	
	@Autowired
	private EventService eventService;
	
    public static void main( String[] args ) {
    	SpringApplication app = new SpringApplication(SpringBootConsoleApplication.class);
        app.setBannerMode(Mode.OFF);
        app.run(args);
    }
    
    @Override
    public void run(String... args) throws Exception {
    	try {
            // open websocket
            final WebsocketClientEndpoint clientEndPoint = new WebsocketClientEndpoint(new URI("ws://stream.meetup.com/2/rsvps"));
            
            boolean error = false;
                       
            // add listener
            clientEndPoint.addMessageHandler(new WebsocketClientEndpoint.MessageHandler() {
                public void handleMessage(String message) {
                	         	                	

                    EventMember eventMember = MessageAdapter.adapt(message);
                    eventService.insertAttendeeToEvent(eventMember);
                    
                    System.out.println(eventMember.getEventMemberId().getEvent().getGroup().getCity() + ", " + 
                    		eventMember.getEventMemberId().getEvent().getEventName() + ", " + 
                    		eventMember.getEventMemberId().getMember().getMemberName());
                }
            });
            
            while(!error) {
            	try  {
            		clientEndPoint.sendMessage("");
		            
		            // wait 5 seconds for messages from websocket
		            //Thread.sleep(120000);
            	} catch (Exception e) {
            		e.printStackTrace();
            		error = true;
            	}
            }            

        } /*catch (InterruptedException ex) {
            System.err.println("InterruptedException exception: " + ex.getMessage());
        }*/ catch (URISyntaxException ex) {
            System.err.println("URISyntaxException exception: " + ex.getMessage());
        }        
    }
}
