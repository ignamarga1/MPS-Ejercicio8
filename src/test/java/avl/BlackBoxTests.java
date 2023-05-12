package avl;/*
Created by Pedro Ankersmit Carrión
*/

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class BlackBoxTests {
    AvlTree<Integer> tree;
    AvlNode<Integer> node;
    Comparator<Integer> c = Integer::compare;

    @Test
    @DisplayName("Test del constructor válido")
    public void whenConstructingATreeWithAValidComparatorItGetsCreated(){

        tree = new AvlTree<>(c);

        assertEquals(null, tree.top);
    }
    @Test
    @DisplayName("Test del constructor inválido")
    public void whenConstructingATreeWithANotValidComparatorItThrowsException(){
        c = null;
        tree = new AvlTree<>(c);

        assertEquals(node, tree.searchNode(node));
    }
    @Test
    @DisplayName("Test de se inserta un nodo valido")
    public void whenInsertingAValidNodeItGetsAddedInTheTree(){
        tree = new AvlTree<>(c);
        node = new AvlNode<>(1);

        tree.insertAvlNode(node);

        assertEquals(node, tree.searchNode(node));
    }

    @Test
    public void Should_ThrowException_When_DeletingANullNode(){
        tree = new AvlTree<>(c);
        assertThrows(RuntimeException.class, () -> tree.deleteNode(null));
    }

    @Test
    public void Should_NotIncludeANode_When_DeletingIt(){
        tree = new AvlTree<>(c);
        node = new AvlNode<>(1);
        tree.insertAvlNode(node);
        tree.deleteNode(node);
        assertNull(tree.searchNode(node));
    }

    @Test
    public void Should_TopBecomeNull_When_DeletingTopLeafNode(){
        tree = new AvlTree<>(c);
        node = new AvlNode<>(1);
        tree.insertAvlNode(node);
        tree.deleteLeafNode(node);
        assertNull(tree.getTop());
    }

    @Test
    public void Should_NotIncludeANode_When_DeletingLeafNodeOnTheLeft(){
        tree = new AvlTree<>(c);
        node = new AvlNode<>(1);
        AvlNode<Integer> left = new AvlNode<>(2);
        node.setLeft(left);
        tree.insertAvlNode(node);
        tree.deleteNode(left);
        assertNull(tree.searchNode(left));
    }

    @Test
    public void Should_NotIncludeANode_When_DeletingLeafNodeOnTheRight(){
        tree = new AvlTree<>(c);
        node = new AvlNode<>(1);
        AvlNode<Integer> left = new AvlNode<>(2);
        node.setLeft(left);
        tree.insertAvlNode(node);
        tree.deleteNode(left);
        assertNull(tree.searchNode(left));
    }
}
