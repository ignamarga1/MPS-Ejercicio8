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

    @Test
    @DisplayName("Test de usar getTop con valores válidos")
    public void whenUsingGetTopWithValidConditionsItWorks(){
        tree = new AvlTree<>(c);
        node = new AvlNode<>(2);
        tree.insertAvlNode(node);

        assertTrue(node.equals(tree.getTop()));

    }

    @Test
    @DisplayName("Test de usar getTop con valores inválidos")
    public void whenUsingGetTopWithInvalidConditionsAnExceptionIsThrown(){
        tree = null;
        assertThrows(RuntimeException.class,()->tree.getTop());
    }

    @Test
    @DisplayName("Test de usar setTop con valores válidos")
    public void whenUsingSetTopWithValidConditionsItWorks(){
        tree = new AvlTree<>(c);
        node = new AvlNode<>(2);
        tree.setTop(node);

        assertEquals(node, tree.getTop());
    }
    @Test
    @DisplayName("Test de usar setTop con valores inválidos")
    public void whenUsingSetTopWithInvalidConditionsAnExceptionIsThrown(){
        tree = null;
        assertThrows(RuntimeException.class,()->tree.setTop(node));
    }

    @Test
    @DisplayName("Test de usar height con Valor Válido")
    public void whenUsingHeightReturnsHeight(){
        tree = new AvlTree<>(c);
        node = new AvlNode<>(3);
        tree.insertAvlNode(node);

        assertEquals(0,tree.height(node));
    }
    @Test
    @DisplayName("Test de usar height con Valor Inválido")
    public void whenUsingHeightWithInvalidNodeAnExceptionIsThrown(){
        tree = new AvlTree<>(c);
        node = new AvlNode<>(3);
        tree.insertAvlNode(node);

        assertThrows(RuntimeException.class, () -> tree.height(null));

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
    @DisplayName("Test para setParent")
    public void whenUsingSetParentWithAValidNodeItWorks(){
        node = new AvlNode<>(1);
        AvlNode<Integer> aux = new AvlNode<>(2);

        node.setParent(aux);

        assertEquals(aux, node.getParent());
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

    @Test
    @DisplayName("Test de se pasa un nodo válido para setHeight")
    public void whenUsingSetHeightWithAValidIntItWorks(){
        node = new AvlNode<>(1);

        node.setHeight(2);

        assertEquals(2, node.getHeight());
    }

    @Test
    @DisplayName("Test de se pasa un nodo inválido para setHeight")
    public void whenUsingSetHeightNodeWithAnInvalidIntAnExceptionIsThrown(){
        node = new AvlNode<>(1);

        assertThrows(RuntimeException.class, () ->node.setHeight(-1));
    }

    @Test
    @DisplayName("Test de se actualiza la altura")
    public void whenUsingUpdateHeightTheHeightIsCorrect(){
        node = new AvlNode<>(1);
        AvlNode<Integer> aux1 = new AvlNode<>(2);
        AvlNode<Integer> aux2 = new AvlNode<>(3);
        node.setHeight(0);
        aux1.setHeight(1);
        aux2.setHeight(2);
        node.setLeft(aux1);
        aux1.setLeft(aux2);

        node.updateHeight();

        assertEquals(2,node.getHeight());
    }

    @Test
    @DisplayName("Test de buscar un ítem no válido")
    public void whenTheTargetNodeItemIsNullAnExceptionShouldBeRaised() {
        tree = new AvlTree<>(c);
        AvlNode<Integer> targetNode = new AvlNode<>(3);

        //assertThrows(RuntimeException.class, () -> tree.search(targetNode.getItem()));
    }

    @Test
    @DisplayName("Test de buscar un ítem válido")
    public void shouldReturnTheTargetNodeItemIsTheSameAsTheOneBeingSearched() {
        tree = new AvlTree<>(c);
        node = new AvlNode<>(1);

        tree.insertAvlNode(node);

        AvlNode<Integer> targetNode = new AvlNode<>(1);

        int expectedValue = node.getItem();
        int actualValue = tree.search(targetNode.getItem()).getItem();

        //assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Test de eliminar un nodo no válido a partir de su ítem")
    public void whenTheNodeBeingDeletedIsNullAnExceptionShouldBeRaised() {
        tree = new AvlTree<>(c);
        node = new AvlNode<>(null);

        //assertThrows(RuntimeException.class, () -> tree.delete(node.getItem()));
    }

    @Test
    @DisplayName("Test de eliminar un nodo válido a partir de su ítem")
    public void shouldReturnATreeWithoutTheNodeThatHasBeenDeleted() {
        tree = new AvlTree<>(c);
        node = new AvlNode<>(3);

        AvlTree<Integer> expectedValue = new AvlTree<>(c);
        tree.delete(node.getItem());
        AvlTree<Integer> actualValue = tree;

        //assertEquals(expectedValue, actualValue);
    }
}
