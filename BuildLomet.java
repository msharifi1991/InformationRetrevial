/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication14;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author VAIO
 */

public class BuildLomet {        
 public BuildLomet(ArrayList<String>doc,ArrayList<String>word2,ArrayList<String>querytoken) {
  Lomet2[][][][] interarray = new Lomet2[27][27][27][27];
  for(int i=0; i<27;i++){
    for(int j=0;j<27;j++){
        for(int k=0;k<27;k++){
            for(int h=0; h<27;h++){
          
                interarray[i][j][k][h]=new Lomet2();
            interarray[i][j][k][h].valid=false;
            interarray[i][j][k][h].offset=0;
         interarray[i][j][k][h].vocab=new Lomet3();
       //  interarray[i][j][k][h].vocab;
            }
        }
    }
}//end of for
 for(int i=0;i<doc.size();i++){
      String u=doc.get(i);
      String docnumber=word2.get(i);
      char x=placement(u,1);      
      int firstdeminstation =where(x);
               char y=placement(u,2);
            int seconddeminstation =where(y);
               char z=placement(u,3);
            int thirddeminstation =where(z);
               char w=placement(u,4);
            int forthdeminstation =where(w);
            
             interarray[firstdeminstation][seconddeminstation][thirddeminstation][forthdeminstation].vocab.vocab=u;
             interarray[firstdeminstation][seconddeminstation][thirddeminstation][forthdeminstation].vocab.docnumbers.add(docnumber);
         if(firstdeminstation==0||seconddeminstation==0||thirddeminstation==0||forthdeminstation==0 || u.length()<=4)
        interarray[firstdeminstation][seconddeminstation][thirddeminstation][forthdeminstation].valid=true;
 }
Searchquery ghazal3=new Searchquery(interarray,querytoken);
 }
public static char placement(String gh,int whichletter){
char firstletter = 0 ;
char secondletter=0;
char thirdletter=0;
char forthletter=0;
if(gh.length()>0)
firstletter = gh.charAt(0);
else{
firstletter ='\0';    
}
if(gh.length()>1)
secondletter =gh.charAt(1);
else{
secondletter ='\0';    
}
if(gh.length()>2)
thirdletter = gh.charAt(2);
else{
thirdletter ='\0';    
}
if(gh.length()>3)
forthletter = gh.charAt(3);
else{
forthletter ='\0';    
}   
if(whichletter==1)
    return firstletter;
if(whichletter==2)
    return secondletter;
if(whichletter==3)
    return thirdletter;
if(whichletter==4)
return forthletter;
else return '\0';
}//method placement
public static int where(char letter){
    int where = 0;
    char letter2 = Character.toLowerCase(letter);
    switch(letter2){
        case '\0':where=0;
        case 'a':where=1;break;
        case 'b':where=2;break;
        case 'c':where=3;break;
        case 'd':where=4;break;
        case 'e':where=5;break;
            case'f':where=6;break;
     case'g':where=7;break;
          case'h':where=8;break;
               case'i':where=9;break;
                    case'j':where=10;break;
                         case'k':where=11;break;
                              case'l':where=12;break;
                                   case'm':where=13;break;
                                        case'n':where=14;break;
                                             case'o':where=15;break;
                                                  case'p':where=16;break;
                                                       case'q':where=17;break;
                                                            case'r':where=18;break;
                                                                 case's':where=19;break;
                                                                      case't':where=20;break;
                                                                           case'u':where=21;break;
                                                                                case'v':where=22;break;
                                                          case'w':where=23;break;
                                                                   case'x':where=24;break;
                                                                 case'y':where=25;break;
                                                          case'z':where=26 ;break;
    }
    return where;        
}   
}//class

  class Lomet2{
boolean valid;
    int offset;
    // vocab=new ArrayList<>();    
 Lomet3  vocab = new Lomet3();
  }
class Lomet3{
    String vocab;
    ArrayList<String> docnumbers;
}
 HASH TREE 
HASH MAP KALAMEH RO COD MIKONIM LOOKC UP //48 MEG