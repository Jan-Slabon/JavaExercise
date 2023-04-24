package com.mycompany.app;

class Tree{
    Integer content;
    Tree leftchild = null;
    Tree rightchild = null;

    public Tree(Integer number){  content = number;  }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Tree)) return false;
        Tree otherTree = (Tree) o;
        if(this.content != otherTree.getContent()) return false;
        boolean tmp = false;
        if (this.leftchild != null && otherTree.getLeftChild() != null) tmp = (this.leftchild.equals(otherTree.getLeftChild()));
        else if(this.leftchild == otherTree.getLeftChild()) tmp = true;
        else return false;
        if (this.rightchild != null && otherTree.getRightChild() != null) tmp = tmp && (this.rightchild.equals(otherTree.getRightChild()));
        else if (this.rightchild == otherTree.getRightChild()) tmp = tmp && true;
        else return false; 
        return tmp;
    }
    public int leafs(){
        if(leftchild == null && rightchild == null) return 1;
        else if (leftchild == null) return rightchild.leafs();
        else if (rightchild == null) return leftchild.leafs();
        else return leftchild.leafs() + rightchild.leafs();
    }
    public int depth(){
        if(leftchild == null && rightchild == null) return 0;
        else if (leftchild == null) return 1 + rightchild.depth();
        else if (rightchild == null) return 1 + leftchild.depth();
        else return 1 + Math.max(leftchild.depth(), rightchild.depth());
    }
    public void setContent(Integer number){content = number;}
    public Integer getContent(){
        return content;
    }
    public Tree getLeftChild(){
        return leftchild;
    }

    public Tree getRightChild(){
        return rightchild;
    }

    public void setLeftChild(Tree node){
        leftchild = node;
    }

    public void setRightChild(Tree node){
        rightchild = node;
    }
}