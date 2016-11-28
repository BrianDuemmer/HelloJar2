package pack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MainClass {
	
	public static final Logger log = LogManager.getLogger("myLogger");
	
	public static void main(String[] args) {
		for(int i = 0; i < 5; i++)
		{
			log.info("Helloooooooooooooooo World!");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
