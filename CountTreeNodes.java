//count how many nodes present in the tree
/*
*      input: nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1}
*      output: 6
*/

import java.util.*;

public class CountTreeNodes 
{
    static class Node
    {
        //implement node which has a data and two pointer fror left and right child
        int data;
        Node left;
        Node right;

        Node( int data) //constructor
        {
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static class BinaryTree
    {
        int index=-1;   //index pointer

        Node buildTree( int nodes[] )   //method that build tree preorder manner
        {
            index++;
            if( nodes[index]==-1)
            {
                //if the value is -1 it means null
                return null;
            }

            Node newNode=new Node( nodes[index]);   //new node creation
            newNode.left=buildTree( nodes );    //call for left node create
            newNode.right=buildTree( nodes );   //call for right node create

            return newNode;
        }
    }

    //method for count the nodes present in the tree
    static int countNode( Node root )
    {
        if( root==null )
        {
            //if root value null means no existance of node so return 0
            return 0;
        }

        int left=countNode( root.left );    //left node count
        int right=countNode( root.right );  //right node count

        return left+right+1;    //total node = total left node+ total right node+ root node
    }

    public static void main( String args[])
    {
        //the node array here in pre order 
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1}; //node array 
        BinaryTree bt=new BinaryTree(); //object called
        Node root=bt.buildTree( nodes );    //method call
        System.out.print( countNode( root ) );  //print the value
    }
}
    