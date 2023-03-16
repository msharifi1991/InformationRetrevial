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
public class Searchquery {
 BuildLomet ghazal2 ;
    Searchquery(Lomet2[][][][] interarray, ArrayList<String> querytoken) {
     ArrayList<String> querydocnumber=new ArrayList<>();
        for(int i=0;i<querytoken.size();i++){
            String u=querytoken.get(i);
         char x=ghazal2.placement(u,1);      
      int firstdeminstation =ghazal2.where(x);
               char y=ghazal2.placement(u,2);
            int seconddeminstation =ghazal2.where(y);
               char z=ghazal2.placement(u,3);
            int thirddeminstation =ghazal2.where(z);
               char w=ghazal2.placement(u,4);
            int forthdeminstation =ghazal2.where(w);
      int size=interarray[firstdeminstation][seconddeminstation][thirddeminstation][forthdeminstation].vocab.size();
      int o=0;
      boolean v=false;
      while(size>=o){
          if(u.equals(interarray[firstdeminstation][seconddeminstation][thirddeminstation][forthdeminstation].vocab.get(o))){
              querydocnumber.add(interarray[firstdeminstation][seconddeminstation][thirddeminstation][forthdeminstation].whichdoc.get(o));
          v=true;         
          }
      o++;
      if(o==size && v==true){
          querydocnumber.add(u);
      }
      }
      if(size==o && v==false ){
          System.out.println("not found");
      }
     }
    Fuzzy masumeh=new Fuzzy(querytoken,querydocnumber);
    }
    
}
