package com.mycompany.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class AppTest 
{

    @Test
    public void Tree_content_value_Test()
    {
        Tree head = new Tree(3);
        assertTrue( head.getContent() == 3 );
        head.setContent(-5);
        assertTrue( head.getContent() == -5 );
    }

    @Test
    public void Tree_equality(){
        Tree one = new Tree(1);
        one.setLeftChild(new Tree(3));
        one.setRightChild(new Tree(-5));
        one.getRightChild().setLeftChild(new Tree(8));
        one.getRightChild().setRightChild(new Tree(10));
        Tree two = new Tree(1);
        two.setLeftChild(new Tree(3));
        two.setRightChild(new Tree(-5));
        two.getRightChild().setLeftChild(new Tree(8));
        two.getRightChild().setRightChild(new Tree(10));
        assertTrue(one.equals(two));
    }

    @Test
    public void Tree_depth(){
        Tree one = new Tree(1);
        one.setLeftChild(new Tree(3));
        one.setRightChild(new Tree(-5));
        one.getRightChild().setLeftChild(new Tree(8));
        one.getRightChild().setRightChild(new Tree(10));
        assertTrue(one.depth() == 2);
        one.getRightChild().getRightChild().setLeftChild(new Tree(-23));
        assertTrue(one.depth() == 3);
        Tree two = new Tree(-1);
        assertTrue(two.depth() == 0);
    }

    @Test
    public void Tree_leafs(){
        Tree one = new Tree(1);
        one.setLeftChild(new Tree(3));
        one.setRightChild(new Tree(-5));
        one.getRightChild().setLeftChild(new Tree(8));
        one.getRightChild().setRightChild(new Tree(10));
        assertTrue(one.leafs() == 3);
        one.getRightChild().getRightChild().setLeftChild(new Tree(-23));
        assertTrue(one.leafs() == 3);
        Tree two = new Tree(-1);
        assertTrue(two.leafs() == 1);
    }
}
