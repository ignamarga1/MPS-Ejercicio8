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
    public void whenConstructingATreeWithANotValidComparatorItCreatesAnInvalidTree(){
        c = null;

        assertThrows(RuntimeException.class, () -> tree = new AvlTree<>(c));
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
    public void Should_NotIncludeANode_When_DeletingLeafNodeOnTheRight() {
        tree = new AvlTree<>(c);
        node = new AvlNode<>(1);
        AvlNode<Integer> left = new AvlNode<>(2);
        node.setLeft(left);
        tree.insertAvlNode(node);
        tree.deleteNode(left);
        assertNull(tree.searchNode(left));
    }

    @Test
    @DisplayName("Test de se inserta un nodo inválido")
    public void whenInsertingAnInvalidNodeAnExceptionIsThrown(){
        tree = new AvlTree<>(c);
        node = null;
        assertThrows(RuntimeException.class, () -> tree.insertAvlNode(node));
    }



    // PRUEBAS DE AVLNODE //////////////////
    @Test
    @DisplayName("Test de se pasa un nodo válido para setLeft")
    public void whenUsingSetLeftWithAValidNodeItWorks(){
        node = new AvlNode<>(1);
        AvlNode<Integer> aux = new AvlNode<>(2);

        node.setLeft(aux);

        assertEquals(aux, node.getLeft());
    }

    @Test
    @DisplayName("Test de se pasa un nodo inválido para setLeft")
    public void whenUsingSetLeftWithAnInvalidNodeAnExceptionIsThrown(){
        node = new AvlNode<>(1);
        AvlNode<Integer> aux = null;

        assertThrows(RuntimeException.class, () ->node.setLeft(aux));
    }
    @Test
    @DisplayName("Test de se pasa un nodo válido para setRight")
    public void whenUsingSetRightWithAValidNodeItWorks(){
        node = new AvlNode<>(1);
        AvlNode<Integer> aux = new AvlNode<>(2);

        node.setRight(aux);

        assertEquals(aux, node.getRight());
    }

    @Test
    @DisplayName("Test de se pasa un nodo inválido para setRight")
    public void whenUsingSetRightWithAnInvalidNodeAnExceptionIsThrown(){
        node = new AvlNode<>(1);
        AvlNode<Integer> aux = null;

        assertThrows(RuntimeException.class, () ->node.setRight(aux));
    }

    @Test
    @DisplayName("Test de se pasa un nodo válido para setParent")
    public void whenUsingSetParentWithAValidNodeItWorks(){
        node = new AvlNode<>(1);
        AvlNode<Integer> aux = new AvlNode<>(2);

        node.setParent(aux);

        assertEquals(aux, node.getParent());
    }

    @Test
    @DisplayName("Test de se pasa un nodo inválido para setParent")
    public void whenUsingSetParentWithAnInvalidNodeAnExceptionIsThrown(){
        node = new AvlNode<>(1);
        AvlNode<Integer> aux = null;

        assertThrows(RuntimeException.class, () ->node.setParent(aux));
    }
    @Test
    @DisplayName("Test de se pasa un nodo válido para setClosestNode")
    public void whenUsingSetClosestNodeWithAValidNodeItWorks(){
        node = new AvlNode<>(1);
        AvlNode<Integer> aux = new AvlNode<>(2);

        node.setClosestNode(aux);

        assertEquals(aux, node.getClosestNode());
    }

    @Test
    @DisplayName("Test de se pasa un nodo inválido para setClosestNode")
    public void whenUsingSetClosestNodeWithAnInvalidNodeAnExceptionIsThrown(){
        node = new AvlNode<>(1);
        AvlNode<Integer> aux = null;

        assertThrows(RuntimeException.class, () ->node.setClosestNode(aux));

    }
}
