package com.company;

import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;
import org.omg.CORBA.Any;

import javax.management.InstanceAlreadyExistsException;
import java.nio.BufferUnderflowException;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {
    private static class BinaryNode<AnyType>{
        BinaryNode(AnyType theElement, BinaryNode<AnyType> left, BinaryNode<AnyType> right){
            this.element = theElement;
            this.left = left;
            this.right = right;
        }
        AnyType element;//data in the node
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;
    }//未解之谜：为什么要用嵌套类不用内部类？一棵搜索树不是有很多节点吗？

    private BinaryNode<AnyType> root;

    /**
     * initialize
     */
    public BinarySearchTree(){
        this.root = null;
    }

    /**
     * make empty 就完事儿了
     */
    public void makeEmpty(){
        root = null;
    }

    /**
     * is it empty?
     * @return
     */
    public boolean isEmpty(){
        return root == null;
    }

    public boolean contains(AnyType x){
        return contains(root, x);
    }

    public AnyType findMin(){
        if (isEmpty()) throw new BufferUnderflowException();
        else return findMin(root).element;
    }

    public AnyType findMax(){
        if (isEmpty()) throw new BufferUnderflowException();
        else return findMax(root).element;
    }
    public void insert(AnyType x){
        insert(root, x);
    }

    public void remove(AnyType x){
        remove(root, x);
    }

    /**
     * to find if x is in tree
     * @param node current node
     * @param x the element
     * @return
     */
    private boolean contains(BinaryNode<AnyType> node, AnyType x){
        if (node == null){
            return false;
        }
        int result = x.compareTo(node.element);
        if (result > 0){
            return contains(node.right, x);
        }
        else if (result > 0){
            return contains(node.right, x);
        }
        else return true;
    }

    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> node){
        if (node == null) return null;
        else if (node.left == null){
            return node;
        }
        else return findMin(node.left);
    }

    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> node){
        if (node == null) return null;
        else if (node.right == null){
            return node;
        }
        else return findMax(node.right);
    }

    private BinaryNode<AnyType> insert(BinaryNode<AnyType> node, AnyType x){
        if (node == null){
            return new BinaryNode<>(x, null, null);
        }
        int result = x.compareTo(node.element);

        if (result > 0){
            insert(node.right, x);
        }
        else if (result < 0){
            insert(node.left, x);
        }
        return node;
    }

    private BinaryNode<AnyType> remove(BinaryNode<AnyType> node, AnyType x){
        if (node == null){
            return new BinaryNode<>(x, null, null);
        }
        int result = x.compareTo(node.element);
        if (result < 0){
            remove(node.left, x);
        }
        else if (result > 0){
            remove(node.right, x);
        }
        else
    }
}
