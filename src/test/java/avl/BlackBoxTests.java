package avl;/*
Created by Pedro Ankersmit Carrión
*/

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
