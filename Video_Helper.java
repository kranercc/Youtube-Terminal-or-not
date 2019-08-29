package youtube;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Vector;

public class Video_Helper 
{

	public Vector<String> searchVideo(String videoName) throws IOException
	{
		String search = "https://www.youtube.com/results?search_query=" + videoName;
		search = search.replace(' ', '_');	

		//System.out.println("Searching video " + videoName + " ...");
		
		//get contents
		URL url = new URL(search);
		
		InputStream is = url.openConnection().getInputStream();

		BufferedReader reader = new BufferedReader( new InputStreamReader( is )  );

		String line = null;
		Vector<String> hrefs = new Vector<String>();
		while( ( line = reader.readLine() ) != null )  {
		   //System.out.println(line);
			
			//
			//get substring
			//
		
			try 
			{
				String toAdd = line.substring(line.indexOf("href=\"/watch"), 97);
				toAdd = toAdd.substring(toAdd.indexOf("=") + 2, 26);
				hrefs.add(toAdd);
				
				/*
				for(int i =0; i < toAdd.length()-1; i++)
				{
					
					System.out.println(toAdd.charAt(i) + " -> index: " + i);
				}*/
				
			}
			catch(Exception e) {}
			

		}
		reader.close();
		
		return hrefs;
	}
	

}
