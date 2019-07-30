package com.music.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.LyricsHandler;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

public class TrackInformation {
	File file;
	Parser parser;
	BodyContentHandler handler;
	Metadata metadata;
	FileInputStream inputstream;
	ParseContext context;
	FileInputStream fileInputStream;
	long audioFileLength;
	int frameSize;
	AudioFormat format;
	public float durationInSeconds;
	float frameRate;
	public long frameCount;
	public long qqwe;
	
	public TrackInformation(String filePath) throws IOException, SAXException, TikaException {
		  BodyContentHandler handler = new BodyContentHandler();  
	      Metadata metadata = new Metadata();  
	      FileInputStream inputstream = new FileInputStream(new File(filePath));  
	      ParseContext pcontext = new ParseContext();  
	      parser = new AutoDetectParser();
	      parser.parse(inputstream, handler, metadata, pcontext);  
	      LyricsHandler lyrics = new LyricsHandler(inputstream,handler);  
	      while(lyrics.hasLyrics()) {  
	          System.out.println(lyrics.toString());  
	      }  
	    //  System.out.println("Contents of the document:" + handler.toString());  
	    //  System.out.println("Metadata of the document:");  
	      String[] metadataNames = metadata.names();  
	      for(String name : metadataNames) {                  
	      //    System.out.println(name + ": " + metadata.get(name));  
	      }  
	
}
}
