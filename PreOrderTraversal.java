//pre order traversal 
// root => left subtree => right subtree
/*
 *      input: nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1}
 *      output: 1 2 4 5 3 6
 */

import java.util.*;

public class PreOrderTraversal 
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

    //pre order method to traverse the binary tree
    static void preOrder( Node root )
    {
        if( root==null )
        {
            return;
        }

        System.out.print( root.data+" " );  //root value print
        preOrder( root.left );  //left call
        preOrder( root.right ); //right call
    }

    public static void main( String args[])
    {
        Scanner Sc=new Scanner(System.in);
        //here the nodes in pre order
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree bt=new BinaryTree(); //object 
        Node root=bt.buildTree( nodes );
        preOrder( root );
    }
}
    
