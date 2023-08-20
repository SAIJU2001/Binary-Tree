//Level order traversal 
/*
*      input: nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1}
*      output:      1
                    2 3
                    4 5 6
*/

import java.util.*;

public class LevelOrderTraversal 
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

    //level wise traversal
    static void levelOrder( Node root )
    {
        if( root==null )
        {
            //root does not point any tree then print null  
            System.out.print("null");
            return;
        }

        //here q stores the level wise nodes 
        Queue<Node>q=new LinkedList<>();
        q.add( root);   //first add the root
        q.add( null);   //null for track the level ending

        while( !q.isEmpty() )
        {
            Node curr=q.remove();
            if( curr==null )
            {
                //if node is null then this level has been end and go for the next level
                System.out.println();
                if( q.isEmpty() )
                {
                    break;
                }
                else
                {
                    q.add(null );
                }
            }
            else
            {
                //every time print the node value
                //check for left and right child if exists then add into the queue
                System.out.print(curr.data+" ");
                if( curr.left!=null )
                {
                    q.add( curr.left );
                }
                if( curr.right!=null )
                {
                    q.add( curr.right );
                }
            }
        }
    }

    public static void main( String args[])
    {
        Scanner Sc=new Scanner(System.in);
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree bt=new BinaryTree();
        Node root=bt.buildTree( nodes );
        levelOrder( root );
    }
}
    
