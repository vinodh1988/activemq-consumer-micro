package com.fullapp.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {
   @JmsListener(destination = "pqueue")
	public void receive(String message) {
		 Path path=Paths.get("e:\\files\\messagelogs.txt");
		 message="\n"+message;
		 try {
			 Files.write(path, message.getBytes(),StandardOpenOption.CREATE,StandardOpenOption.APPEND);
			 
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
	}
}
