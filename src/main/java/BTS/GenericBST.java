package BTS;// Jonathon Sauers
// jo046326
// COP 3503, Fall 2017
// GenericBST.java


import java.io.*;
import java.util.*;

// The type <T> must extend comparable, otherwise compareTo will not work.
public class GenericBST<T extends Comparable<T>>
{
	private Node<T> root;

	// Helper method for insertion.
	public void insert(T data)
	{
		root = insert(root, data);
	}

	// Inserts a new node and returns the root.
	private Node<T> insert(Node<T> root, T data)
	{
		// If the tree is empty, create a node. Which will be the root.
		if (root == null)
		{
			return new Node<T>(data);
		}
		// Determine whether to go left or right down the BST.
		else if (data.compareTo(root.data) < 0)
		{
			root.left = insert(root.left, data);
		}
		else if (data.compareTo(root.data) > 0)
		{
			root.right = insert(root.right, data);
		}
		else
		{
			// We are disallowing insertion of duplicate values for
			// this assignment.
		}

		return root;
	}

	// Helper method for deletion.
	public void delete(T data)
	{
		root = delete(root, data);
	}

	// Finds a given node, and deletes it.
	private Node<T> delete(Node<T> root, T data)
	{
		// Checks for empty tree.
		if (root == null)
		{
			return null;
		}
		// Recursively traverse the tree down to find the node to be deleted.
		else if (data.compareTo(root.data) < 0)
		{
			root.left = delete(root.left, data);
		}
		else if (data.compareTo(root.data) > 0)
		{
			root.right = delete(root.right, data);
		}
		else
		{
			// When we hit the bottom of the tree.
			if (root.left == null && root.right == null)
			{
				return null;
			}
			// If we can only go left.
			else if (root.right == null)
			{
				return root.left;
			}
			// If we can only go right.
			else if (root.left == null)
			{
				return root.right;
			}
			// If the root is deleted, this finds the biggest value in the left
			// subtree and puts in in the root.
			else
			{
				root.data = findMax(root.left);
				root.left = delete(root.left, root.data);
			}
		}

		return root;
	}

	// This method assumes root is non-null, since this is only called by
	// delete() on the left subtree, and only when that subtree is non-empty.
	private T findMax(Node<T> root)
	{
		while (root.right != null)
		{
			root = root.right;
		}

		return root.data;
	}

	// Returns true if the value is contained in the BST.
	public boolean contains(T data)
	{
		return contains(root, data);
	}

	// Traverses the tree to determine if a given value in contained within it.
	private boolean contains(Node<T> root, T data)
	{
		// Checks for empty tree.
		if (root == null)
		{
			return false;
		}
		// Recursively moving left or right down the tree.
		else if (data.compareTo(root.data) < 0)
		{
			return contains(root.left, data);
		}
		else if (data.compareTo(root.data) > 0)
		{
			return contains(root.right, data);
		}
		// Returns true when it finds the value.
		else
		{
			return true;
		}
	}

	// Helper function that prints the inorder traversal.
	public void inorder()
	{
		System.out.print("In-order Traversal:");
		inorder(root);
		System.out.println();
	}

	// Inorder: Left, root, right
	private void inorder(Node<T> root)
	{
		if (root == null)
			return;

		inorder(root.left);
		System.out.print(" " + root.data);
		inorder(root.right);
	}

	// Helper function that prints the preorder traversal.
	public void preorder()
	{
		System.out.print("Pre-order Traversal:");
		preorder(root);
		System.out.println();
	}

	// Preorder: Root, left, right
	private void preorder(Node<T> root)
	{
		if (root == null)
			return;

		System.out.print(" " + root.data);
		preorder(root.left);
		preorder(root.right);
	}

	// Helper function that prints the postorder traversal.
	public void postorder()
	{
		System.out.print("Post-order Traversal:");
		postorder(root);
		System.out.println();
	}

	// Postorder: Left, right, root
	private void postorder(Node<T> root)
	{
		if (root == null)
			return;

		postorder(root.left);
		postorder(root.right);
		System.out.print(" " + root.data);
	}

	// How difficult I found this assignment.
	public static double difficultyRating()
	{
		return 3.0;
	}

	// How many hours I spent on this assignment.
	public static double hoursSpent()
	{
		return 2.0;
	}

}
