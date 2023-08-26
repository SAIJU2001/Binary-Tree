//Diameter of binary tree 
/*
*      input: nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1}
*      output: 5 
*/

import java.util.*;

public class DiameterOfTree1 
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

    //method to find the diameter
    static int calculateDia( Node root )
    {
        if( root==null )
        {
            return 0;
        }

        int leftDia=calculateDia( root.left );      //left dia measure
        int rightDia=calculateDia( root.right );    //right dia measure

        int myHeight=calculateHeight( root.left )+calculateHeight( root.right )+1;  //calculate the height
        int myDia=Math.max( myHeight, Math.max( leftDia, rightDia ));   //the max is the dia
        return myDia;
    }

    //method to find the height
    static int calculateHeight( Node root )
    {
        if( root==null )
        {
            return 0;
        }

        int left=calculateHeight( root.left );      //left height call
        int right=calculateHeight( root.right );    //right height call

        int myHeight=Math.max( left,right)+1;

        return myHeight;
    }

    public static void main( String args[])
    {
        Scanner Sc=new Scanner(System.in);
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree bt=new BinaryTree();
        Node root=bt.buildTree( nodes );
        System.out.print( calculateDia( root ) );
    }
}
    
