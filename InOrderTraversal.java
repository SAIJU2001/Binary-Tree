//In order traversal 
// left subtree => root => right subtree 
/*
 *      input: nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1}
 *      output: 4 2 5 1 3 6
 */

import java.util.*;

public class InOrderTraversal 
{
    static class Node
    {
        //crete node which have a data ,a left pointer and a right pointer
        int data;
        Node left;
        Node right;

        Node( int data)     //constructor
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

    //inorder traversal method
    static void inOrder( Node root )
    {
        if( root==null )
        {
            return;
        }

        inOrder( root.left );       //first left child
        System.out.print( root.data+" " );      //root in mid 
        inOrder( root.right );      //then right child
    }

    public static void main( String args[])
    {
        Scanner Sc=new Scanner(System.in);
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree bt=new BinaryTree();     //call tree class
        Node root=bt.buildTree( nodes );
        inOrder( root );    //inorder method call
    }
}
