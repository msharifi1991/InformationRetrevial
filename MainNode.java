/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zakhire_trie;

import java.util.ArrayList;

/**
 *
 * @author Hanoi
 */

public class MainNode 
{
    ArrayList<Node> mainNodes = new  ArrayList<Node>();
}
class NodeItem 
{
//    int rChild;
  //  int lChild;
   // boolean flag;
   // char content;
    String letStr = "";
    ArrayList< String> childStr = new ArrayList<String>();

//    @Override
//    public int compareTo(Object o) {
//        throw new UnsupportedOperationException("Not supported yet.");
//    void clean()
//    {
//        letStr = "";
//        childStr.clear();
//    }
    }

class Node
{
    ArrayList<NodeItem> nodeList = new ArrayList<NodeItem>();
}