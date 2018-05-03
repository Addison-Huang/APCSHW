/*****************************************************
 * class BST - v1:partial
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT)
 *
 * A BST maintains the invariant that, for any node N with value V,
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value,
 *  and any value in its right subtree must be greater.)
 * This BST only holds ints (its nodes have int cargo)
 *****************************************************/
/* Addison Huang and Frank Chen
   APCS pd2
   Hw 44 -- Prune Your Tree
   2018 05 03
*/

public class BST
{

    //instance variables / attributes of a BST:
    TreeNode _root;

    /*****************************************************
     * default constructor
     *****************************************************/
    BST( )
    {
	_root = null;
    }


    /*****************************************************
     * void insert( int )
     * Adds a new data element to tree.
     *****************************************************/
    public void insert( int newVal )
    {
	TreeNode newNode = new TreeNode( newVal );

	if ( _root == null ) {
	    _root = newNode;
	    return;
	}
	insert( _root, newNode );
    }
    //recursive helper for insert(int)
    public void insert( TreeNode stRoot, TreeNode newNode )
    {
	if ( newNode.getValue() < stRoot.getValue() ) {
	    //if no left child, make newNode the left child
	    if ( stRoot.getLeft() == null )
		stRoot.setLeft( newNode );
	    else //recurse down left subtree
		insert( stRoot.getLeft(), newNode );
	    return;
	}
	else { // new val >= curr, so look down right subtree
	    //if no right child, make newNode the right child
	    if ( stRoot.getRight() == null )
		stRoot.setRight( newNode );
	    else //recurse down right subtree
		insert( stRoot.getRight(), newNode );
	    return;
	}
    }//end insert()




    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

    // each traversal should simply print to standard out
    // the nodes visited, in order

    //process root, recurse left, recurse right
    public void preOrderTrav()
    {
	preOrderTrav( _root );
    }
    public void preOrderTrav( TreeNode currNode )
    {
	if ( currNode == null ) //stepped beyond leaf
	    return;
	System.out.print( currNode.getValue() + " " );
	preOrderTrav( currNode.getLeft() );
	preOrderTrav( currNode.getRight() );
    }

    //recurse left, process root, recurse right
    public void inOrderTrav()
    {
	inOrderTrav( _root );
    }
    public void inOrderTrav( TreeNode currNode )
    {
	if ( currNode == null ) //stepped beyond leaf
	    return;
	inOrderTrav( currNode.getLeft() );
	System.out.print( currNode.getValue() + " " );
	inOrderTrav( currNode.getRight() );
    }

    //recurse left, recurse right, process root
    public void postOrderTrav()
    {
	postOrderTrav( _root );
    }
    public void postOrderTrav( TreeNode currNode )
    {
	if ( currNode == null ) //stepped beyond leaf
	    return;
	postOrderTrav( currNode.getLeft() );
	postOrderTrav( currNode.getRight() );
	System.out.print( currNode.getValue() + " "  );
    }

    //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
    TreeNode search( int target )
    {
	return search (target, _root);
    }

    TreeNode search (int target, TreeNode currNode) {
	if (currNode == null || currNode.getValue() == target) {
	    return currNode;
	}
	else if (target < currNode.getValue()) {
	    return search(target,currNode.getLeft());
	}
	else if (target > currNode.getValue()) {
	    return search(target,currNode.getRight());
	}
	else {
	    return null;
	}
    }


    /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 0
     *****************************************************/
    public int height()
    {
	return height(_root);
    }

    public int height(TreeNode currNode) {
	if (currNode == null) {
	    return 0;
	}
	if (currNode.getLeft() == null && currNode.getRight() == null)
	    return 1;
	else
	    return 1 + Math.max(height(currNode.getLeft()), height(currNode.getRight()));
    }

    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    public int numLeaves()
    {
	return numLeaves(_root);
    }

    public int numLeaves (TreeNode currNode) {
	int foo = 0;
	if (currNode == null) {
	    return 0;
	}
	foo += numLeaves(currNode.getLeft());
	if (currNode.getLeft() == null && currNode.getRight() == null)
	    foo++;
	foo += numLeaves(currNode.getRight());
	return foo;
    }

    public boolean isLeaf( TreeNode node ) { 
	return ( node.getLeft() == null && node.getRight() == null );
    }
    
    public TreeNode remove( int remVal )
    {
	TreeNode leader = _root;  
	TreeNode follower = null;

	//walks down to the node
	while(leader != search(remVal)){
	    follower = leader;
	    if(remVal > leader.getValue())
		leader = leader.getRight();
	    else
		leader = leader.getLeft();
	}
	//it is a leaf
	if ( isLeaf(leader) ) {
	    //tree is 1 node
	    if(follower == null)
		_root = null;
	    //removing a left child
	    else if(follower.getLeft() == leader)
		follower.setLeft(null);
	    //removing a left child
	    else
		follower.setRight(null);
	}
	//end remove leaf
	
	//remove a node with 1 child
	else if ( leader.getRight()==null ) { //node has a left child
	    //removing a root
	    if(follower == null)
		_root =  _root.getLeft();
	    //node being removed is a left child
	    else if (follower.getLeft() == leader)
		follower.setLeft(leader.getLeft());
	    //node being removed is a right child
	    else
		follower.setRight(leader.getLeft());
	    
	}
	else if ( leader.getLeft()==null ) { //node has a right child
	    //removing a root
	    if(follower == null)
		_root =  _root.getRight();
	    //node being removed is a left child
	    else if(follower.getLeft() == leader)
		follower.setLeft(leader.getRight());
	    //node being removed is a right child
	    else
		follower.setRight(leader.getRight());	    
	}
	// Removing a node with 2 subtrees
	else
	    {
		TreeNode max = leader.getLeft();
			
		// Find greatest node less than root
		while( max.getRight() != null )
		    {
			max = max.getRight();
		    }
			
		// Replacement node for removal node
		TreeNode temp = new TreeNode( max.getValue() );
		temp.setLeft( leader.getLeft() );
		temp.setRight( leader.getRight() );
			
		remove( max.getValue() );
			
		if( leader == _root )
		    {
			_root = temp;
		    }
		else if( follower.getRight() == leader )
		    {
			follower.setLeft( temp );
		    }
		else if( follower.getLeft() == leader )
		    {
			follower.setRight( temp );
		    }
	    }
	return leader;
    }


    //main method for testing
    public static void main( String[] args )
    {
	BST arbol = new BST();

	//PROTIP: sketch state of tree after each insertion
	//        ...BEFORE executing these.
	arbol.insert( 4 );
	arbol.insert( 2 );
	arbol.insert( 5 );
	arbol.insert( 6 );
	arbol.insert( 1 );
	arbol.insert( 3 );

	System.out.println( "\n-----------------------------");
	System.out.println( "pre-order traversal:" );
	arbol.preOrderTrav();

	System.out.println( "\n-----------------------------");
	System.out.println( "in-order traversal:" );
	arbol.inOrderTrav();

	System.out.println( "\n-----------------------------");
	System.out.println( "post-order traversal:" );
	arbol.postOrderTrav();

	System.out.println( "\n-----------------------------");
	System.out.println( "height:");
	System.out.println(arbol.height());

	System.out.println( "\n-----------------------------");
	System.out.println( "number of leaves:");
	System.out.println(arbol.numLeaves());

	System.out.println( "\n-----------------------------");
	System.out.println( "finding 3:");
	System.out.println(arbol.search(3));
    
			
    }

}//end class
