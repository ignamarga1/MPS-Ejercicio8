package avl;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestIgnacio {
    AvlTree<Integer> tree;
    AvlNode<Integer> node;
    Comparator<Integer> c = Integer::compare;
    @Test
    @DisplayName("Test de buscar un ítem no válido")
    public void whenTheTargetNodeItemIsNullAnExceptionShouldBeRaised() {
        tree = new AvlTree<>(c);
        AvlNode<Integer> targetNode = new AvlNode<>(3);

        assertThrows(RuntimeException.class, () -> tree.search(targetNode.getItem()));
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

        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Test de eliminar un nodo no válido a partir de su ítem")
    public void whenTheNodeBeingDeletedIsNullAnExceptionShouldBeRaised() {
        tree = new AvlTree<>(c);
        node = new AvlNode<>(null);

        assertThrows(RuntimeException.class, () -> tree.delete(node.getItem()));
    }

    @Test
    @DisplayName("Test de eliminar un nodo válido a partir de su ítem")
    public void shouldReturnATreeWithoutTheNodeThatHasBeenDeleted() {
        tree = new AvlTree<>(c);
        node = new AvlNode<>(3);

        AvlTree<Integer> expectedValue = new AvlTree<>(c);
        tree.delete(node.getItem());
        AvlTree<Integer> actualValue = tree;

        assertEquals(expectedValue, actualValue);
    }
}
