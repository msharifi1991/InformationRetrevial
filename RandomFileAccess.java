/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication14;

/**
 *
 * @author VAIO
 */
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
//import org.apache.lucene.analysis.porterStemer;
public class RandomFileAccess {
String line;
	 void RandomFileAccessExample(ArrayList<String>querytoken) throws IOException
	    {
                int docnumber=0;
	        RandomAccessFile file = new RandomAccessFile("input.txt", "rw");	        
	        ArrayList<String> doc = new ArrayList<String>(); 
	        ArrayList<String> word = new ArrayList<String>();
	        ArrayList<String> word2 = new ArrayList<String>();
	        while((line=file.readLine())!=null){
	        	StringTokenizer tz=new StringTokenizer(line, "[,\\;\\-\\:\\ ]");
	    	 	while(tz.hasMoreTokens()){
	String next=tz.nextToken();
	// here we should remove stop words and stemmer the string next
        if(next.equals("<p>")){
		 String offset=Long.toString( file.getFilePointer());
		 System.out.println("ofset"+offset);
		 doc.add(offset); 
                 docnumber++;
	}
        else
                {
//	 PorterStemmer stemmer = new PorterStemmer();

                    word.add(next);
                word2.add(Integer.toString(docnumber));
		}
	        }
}
	        int j=1;
	        
	        for (int i=0;i<doc.size();i++){
	        	System.out.print("number "+j);
	        	System.out.print("beginig of each doc "+doc.get(i));
	        	System.out.println("end of each doc "+doc.get(i+1));
	        	i+=1;
	        	j++;
	        }	    
	  BuildLomet g=new BuildLomet(word,word2,querytoken);

            }
         
}
