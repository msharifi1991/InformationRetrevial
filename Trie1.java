/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zakhire_trie;

import java.awt.SplashScreen;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.StringTokenizer;
import org.omg.CORBA.Object;
import org.omg.CORBA.*;
import org.omg.SendingContext.RunTime;

/**
 *
 * @author Hanoi
 */
public class Trie1 {
    Node[] baseArr = new Node[27];
    int letCount=0, rightLet=0;
    
    void initialize() throws FileNotFoundException, IOException
    {
      for(int i=0; i<baseArr.length; i++)
           baseArr[i] = new Node();

       ArrayList<String> str = new ArrayList<String>();
       str.add("arousak");
       str.add("aks");
       str.add("atash");
       str.add("atashbazi");
       str.add("abadan");
       str.add("azad");
       str.add("arayeshgahepesarane");
       /*
       str.add("akkasi");
       str.add("azar");
       str.add("ashegh");
       str.add("akhtar");
       str.add("arabestane soudi");
       str.add("almas");
       str.add("akwarioume daneshkadeye computer daneshgahe sanaatie amirkabire shahre tehran va paytakhte tehran");
       str.add("bahador");
       
       */
       
    /*   str[4]="ali";
       str[5]="leila";
       str[6]="reza";
       str[7]="yasin";
       str[8]="taha";
       str[9]="hasan";
      */ 
       for(int test=0; test<str.size(); test++)
         insert(str.get(test));
       for(int j=0; j<baseArr.length; j++)
       {
           for(int i=0; i<baseArr[j].nodeList.size(); i++)
                System.out.println("The letstr : "+baseArr[j].nodeList.get(i).letStr.length()+" The childStr: "+baseArr[j].nodeList.get(i).childStr.size());
           
       }
       

             
       saveToDisk();
    }
    
    void insert(String word)
    {
        int firstIndex=0,firstLetIndex=-1, letIndex=0;
        boolean notFound=true;
        
        for(int i=0; i<baseArr.length; i++)
        {
           if(baseArr[i].nodeList.isEmpty())
           {
               firstIndex = i;
               notFound = true;
               ins(word, firstIndex, notFound);
               break;
           }
           else if(baseArr[i].nodeList.get(letCount).letStr.charAt(0) == word.charAt(0))
           {
               firstIndex = i;
               letCount++;
               rightLet = 0;
               notFound = false;
               while(letCount < word.length())
                    ins(word, firstIndex, notFound);

               letCount=0;
               break;
           }
        }
  }
void ins(String word, int firstIndex, boolean notFound)    //indexe harfi ke baham barabar shodan = rightLet
{
    String[] splitResult=null;
    NodeItem nItem;
    Node node = new Node();
    int len=0, childIndex=0;
    int chIndex;
    boolean isBreak=false;

    if(notFound == true)
    {
        while(letCount < word.length())
        {
            if(baseArr[firstIndex].nodeList.isEmpty())
            {
                for(int index=0; index < word.length(); index++)
                {
                    nItem = new NodeItem();
                    nItem.letStr = word.substring(index, index+1);
                    if(index != word.length()-1)
                        nItem.childStr.add(0+";");
                    node.nodeList.add(nItem);
                    letCount++;
                }
                baseArr[firstIndex] = node;
            }
            else      //ehtemalan lazem nabashe
            {
                baseArr[firstIndex].nodeList.get(letCount).letStr += word.substring(letCount, letCount+1);
                baseArr[firstIndex].nodeList.get(letCount-1).childStr.add(baseArr[firstIndex].nodeList.get(letCount).letStr.length()-1+";"); 
                letCount++;
            }
        }
        baseArr[firstIndex].nodeList.get(letCount-1).childStr.add("*;");  //baraye neshan dadane akharin harf nv childStr
        letCount=0;
    }
    else        //notFoun=false
    {
        splitResult = baseArr[firstIndex].nodeList.get(letCount-1).childStr.get(rightLet).split("[;\\*]");
        
        for(int i=0; i<splitResult.length; i++)
        {
            chIndex = Integer.parseInt(splitResult[i]);
            if(baseArr[firstIndex].nodeList.get(letCount).letStr.charAt(chIndex) == word.charAt(letCount))
            {
               if(letCount == baseArr[firstIndex].nodeList.size()-1)
               {
                   isBreak = false;
                   break;
               }
               letCount++;
               rightLet = chIndex;
               if(letCount == word.length() && !baseArr[firstIndex].nodeList.get(letCount-1).childStr.get(rightLet).equals("*"))
               {
                   String str = baseArr[firstIndex].nodeList.get(letCount-1).childStr.get(rightLet);
                   str +=  "*;";
                   baseArr[firstIndex].nodeList.get(letCount-1).childStr.set(rightLet, str);
               }
               notFound = false;
               isBreak = true;
               break;
             }
        }
        if(isBreak == false)
        {
            baseArr[firstIndex].nodeList.get(letCount).letStr += word.substring(letCount, letCount+1);
            String str = baseArr[firstIndex].nodeList.get(letCount-1).childStr.get(rightLet);
            str +=  baseArr[firstIndex].nodeList.get(letCount).letStr.length()-1+";";
            baseArr[firstIndex].nodeList.get(letCount-1).childStr.set(rightLet, str);
            letCount++;
            while(letCount < word.length())
            {
                if(letCount == baseArr[firstIndex].nodeList.size())
                {
                  for(int index=letCount; index < word.length(); index++)
                  {
                     nItem = new NodeItem();
                     nItem.letStr = word.substring(index, index+1);
                     if(index != word.length()-1)
                     nItem.childStr.add(0+";");
                     baseArr[firstIndex].nodeList.add(nItem);
                     letCount++;
                  }
                }
                else
                {
                   baseArr[firstIndex].nodeList.get(letCount).letStr += word.substring(letCount, letCount+1);
                   baseArr[firstIndex].nodeList.get(letCount-1).childStr.add(baseArr[firstIndex].nodeList.get(letCount).letStr.length()-1+";"); 
                   letCount++;
                }
              }
              baseArr[firstIndex].nodeList.get(letCount-1).childStr.add("*;");  //baraye neshan dadane akharin harf nv childStr
        }
    }
}
 void saveToDisk() throws FileNotFoundException, IOException
 {
     int countLet=0, splLenCount=0, childLen=0, childCount=0;
     String strDisk = null;
     
     RandomAccessFile file = new RandomAccessFile("trie.txt", "rw");
     
     for(int arrIndex=0; arrIndex < 1; arrIndex++)
     {
         
         if(baseArr[arrIndex].nodeList.isEmpty())
             break;
         else
         {
            strDisk = baseArr[arrIndex].nodeList.get(0).letStr+";";
            for(int nodIndex=0; nodIndex < baseArr[arrIndex].nodeList.size(); nodIndex++)
            {
                childLen = baseArr[arrIndex].nodeList.get(nodIndex).childStr.size();
                while(childCount < childLen)
                {
                    String[] spl = baseArr[arrIndex].nodeList.get(nodIndex).childStr.get(childCount).split(";");
                    if(spl.length > 1 && childLen == 1)
                        //break;
                        strDisk += baseArr[arrIndex].nodeList.get(nodIndex+1).letStr+";";
                    else 
                    {
                         for(int i=0; i<spl.length; i++)
                         {
                            if( spl[i].equals("*") )
                            {
                                strDisk += ",";
                             //   childCount++;
                                if(childCount == childLen-1)
                                    strDisk += ";";
                            //break;
                            }
                            else if(spl.length >= 1)
                            {
//                            else
  //                          {
                                if(childCount == childLen-1)
                                    strDisk += baseArr[arrIndex].nodeList.get(nodIndex+1).letStr.substring(Integer.parseInt(spl[i]), Integer.parseInt(spl[i])+1) +";";
                                else
                                    strDisk += baseArr[arrIndex].nodeList.get(nodIndex+1).letStr.substring(Integer.parseInt(spl[i]), Integer.parseInt(spl[i])+1) +",";
    //                        }
                            }   
                            /*
                            if(spl[i].length() > 1)
                            {
                                strDisk += baseArr[arrIndex].nodeList.get(nodIndex+1).letStr.substring(i, i+1);
                            }
                            else if(spl[i].length() == 1)
                                strDisk += baseArr[arrIndex].nodeList.get(nodIndex+1).letStr.substring(i, i+1)+",";
                            if(i == spl.length-1)
                                strDisk += baseArr[arrIndex].nodeList.get(nodIndex+1).letStr.substring(i, i+1)+";";*/
                        }
                        
                    }
                    childCount++;
                    
               }
                //strDisk += ";";                      
                childCount = 0;
            }
        }
     }
     file.writeChars(strDisk);
     file.close();
     
 }
 void find()
 {
 }
}