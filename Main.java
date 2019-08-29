package youtube;

import java.io.IOException;
import java.util.Vector;

public class Main {

	public static void main(String args[]) throws IOException
	{
		Video_Helper myVideos = new Video_Helper();
		String songName = "";
		for(int i =0; i < args.length; i++)
		{
			songName += args[i] + " ";
			
		}
		Vector<String> videos = myVideos.searchVideo(songName);
		
		Runtime.getRuntime().exec("firefox https://youtube.com" + videos.get(0));
		
		
	}
	
}
