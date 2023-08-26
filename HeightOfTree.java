//Height of a Binary Tree
/*
*      input: nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1}
*      output: 3
*/

import java.util.*;

public class HeightOfTree 
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
        int index=-1;           //index pointer

        //build tree from a preorder array
        Node buildTree( int nodes[] )
        {
            index++;
            if( nodes[index]==-1)
            {
                //if elemnet is -1 then there is not any node exists
                return null;
            }

            Node newNode=new Node( nodes[index]);   //new node create
            newNode.left=buildTree( nodes );        //call for left child
            newNode.right=buildTree( nodes );       //call for right child

            return newNode;     //return root
        }
    }

    //method to find the height
    static int calculateHeight( Node root )
    {
        if( root==null )
        {
            //if node does not exists then resturn 0
            return 0;
        }

        int left=calculateHeight( root.left );      //left height 
        int right=calculateHeight( root.right );    //right height

        int myHeight=Math.max( left,right)+1;   //maximum of left and right height with root

        return myHeight;
    }

    public static void main( String args[])
    {
        Scanner Sc=new Scanner(System.in);
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree bt=new BinaryTree();
        Node root=bt.buildTree( nodes );
        System.out.print( calculateHeight( root ) );
    }
}