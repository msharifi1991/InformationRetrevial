/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication14;

import java.util.ArrayList;

/**
 *
 * @author VAIO
 */
import java.nio.channels.FileChannel;
import java.sql.Array;
import java.util.*;
import java.awt.*;
import java.io.*;
import org.apache.lucene.analysis.Tokenizer;

public class Main {
    
       	static byte b[] = new byte[5];
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		int count=1;
		

    char first,second,third,fourth;
 //   String query="ali hasan hamid not sara";
    Scanner in= new Scanner(System.in);
    String d=in.nextLine();
    StringTokenizer tokenizer = new StringTokenizer(d," ");
    String token;
    //boolean x=tokenizer.hasMoreTokens();
    ArrayList<String> querytoken = new ArrayList<String>();
    
while(tokenizer.hasMoreTokens()){
    token = tokenizer.nextToken();
        if(token !="and")
        querytoken.add(token);
    }
 //serchquery ghazal=new serchquery(querytoken);
RandomFileAccess  f= new RandomFileAccess();
		f.RandomFileAccessExample(querytoken);
                //BuildLomet masumeh=new BuildLomet(f.);
}//for eaxh line
	}
	


