/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zakhire_trie;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Hanoi
 */
public class Zakhire_Trie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
//       Trie1 trie = new Trie1();
//       trie.initialize();
//       NodeItem ni = new NodeItem();
//       ni.letString.add("Zahra"); 
//       ni.letString.add("Fatima"); 
        /*
       Node n = new Node();
       
       int len = 0;
       NodeItem ni;
       char ch = 'w';
       Integer test = 1;
       String word  = "Salam";
       String word1 = "Sonbol";
       ni =  new NodeItem();
       ni.letStr = word.substring(0, 1);
       ni.childStr.add(test.toString());
       n.nodeList.add(ni);

       for(Integer i=2; i<=word.length(); i++)
       {
           ni =  new NodeItem();           
           ni.letStr = word.substring(i-1, i);
           ni.childStr.add(i.toString());
           n.nodeList.add(ni);
           System.out.println("str: "+n.nodeList.get(i-2).letStr+"    child: "+n.nodeList.get(i-2).childStr);
       }   
         System.out.println("str: "+n.nodeList.get(4).letStr+"    child: "+n.nodeList.get(4).childStr);
        char ch1, ch2;
        
       for(Integer i=0; i<=word1.length(); i++)
       {
           ch1 = word1.charAt(0);
           if(ch1 == n.nodeList.get(i).letStr.charAt(i))
           {
            for(int j=0; j<n.nodeList.get(i).childStr.size(); j++)
            {
                n.nodeList.get(i+1).letStr.charAt(n.nodeList.get(i).childStr.get(j).charAt(j));
            }
           }
           ni =  new NodeItem();           
           ni.letStr = word.substring(i-1, i);
           ni.childStr.add(i.toString());
           n.nodeList.add(ni);
           System.out.println("str: "+n.nodeList.get(i-2).letStr+"    child: "+n.nodeList.get(i-2).childStr);
       }   

       
       /*
       Integer i=1;
           ni.childStr.add(i.toString());
           n.nodeList.add(ni);
           ni.childStr.clear();
            ni = new NodeItem();
           ni.letStr = word.substring(i, i+1);
      i=2;
           ni.childStr.add(i.toString());
           n.nodeList.add(ni);
           ni.childStr.clear();
           ni = new NodeItem();
           ni.letStr = word.substring(i, i+1);
      i=3;
           ni.childStr.add(i.toString());
           n.nodeList.add(ni);
           ni.childStr.clear();
           ni = new NodeItem();
           ni.letStr = word.substring(i, i+1);


      
       ArrayList<String> str  = new ArrayList<String>();
       str.add("salam");
       str.add("aleik");
       
               
       
//       len = ni.letStr.length();
//       
//       ni.childStr
//       n.nodeList.add(0,);
       String test1 = "san";
       
       System.out.println("sub: " +str);
       
       
        String spl[];
        
        String test = "1;5;33;789;34;56;";
        spl = test.split(";");
        String test2 = "salam aleikom";
        
        for(int i=0; i<spl.length; i++)
            System.out.println("i: "+i+" con: "+spl[i]);
        Integer inTest = Integer.parseInt(spl[0]);
//        inTest = inTest.intValue();
        
        //test2[inTest.intValue()];
        ArrayList<String> str = new ArrayList<String>();
        String strTest = "hkl;";
        
        String strTest = ";*";
        String[] spl = strTest.split(";");
        System.out.println("2:  "+spl.length);
        /*
        Integer lenSpl = 0;
        for(int z=0; z < spl.length; z++)
           lenSpl += spl[z].length();

//        int lenspl = spl.length;
  //      int len = strTest.length();
        /*
        str.add("zahra");
        str.add("fatima");
        str.add("mahya");
        str.add("");
        str.add("");
        for(int i=0; i<str.size(); i++)
            System.out.println("i: "+i+"  len: "+str.get(i).length());
//        test2 = 2+"salam";
  //      System.out.println("2:  "+test2);
       */
        Trie1 trie = new Trie1();
        trie.initialize();
                
    }
}
