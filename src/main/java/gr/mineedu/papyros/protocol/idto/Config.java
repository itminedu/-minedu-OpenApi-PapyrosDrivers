package gr.mineedu.papyros.protocol.idto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;



public class Config {
	String serverurl;
	public String getServerurl() {
		return serverurl;
	}
	public void setServerurl(String serverurl) {
		this.serverurl = serverurl;
	}

	
	public void load(String filepath) throws IOException{
		Properties config = new Properties();
		InputStream stream = null;
		try{
				stream = new FileInputStream(new File(filepath));
				config.load(stream);
		}
		finally{
			if(stream!=null){
				stream.close();
			}
		}
		try{
	    	this.serverurl =config.getProperty("serverurl"); 
		}
		catch(NumberFormatException ex){
			ex.printStackTrace();
		}
	}
	
	public void loadClasspath() {
		String configFile = "minedu.properties";
		Properties config = new Properties();
		InputStream stream = null;
		try{
				stream = Config.class.getClassLoader().getResourceAsStream(configFile);
				try {
					config.load(stream);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		finally{
			if(stream!=null){
				try {
					stream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		try{
	    	this.serverurl =config.getProperty("serverurl"); 
		}
		catch(NumberFormatException ex){
			ex.printStackTrace();
		}
	}
	public Config(String filepath) throws IOException{
		
		load(filepath);
		

	}
	
	public Config(Boolean loadvalues) {
		if(loadvalues){
			loadClasspath(); //TODO change . Init function.
		}
		else{
			//κανενα init. 
		}
		
	}
	public Config() {
		loadClasspath();
	}
	public void load() {
		String configFile = "minedu.properties";
		try{
			load( configFile);
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
}
