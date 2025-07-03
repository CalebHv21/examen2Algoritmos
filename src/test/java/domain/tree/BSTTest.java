package domain.tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para la clase BST.
 * Creada por CalebHv21 con ayuda de Copilot el 2025-07-03 02:33:37 UTC.
 */
public class BSTTest {

    @Test
    @DisplayName("BST: Probar la eliminación de subárboles con un solo hijo (removeSubTree1)")
    void testRemoveSubTree1() throws TreeException {
        BST bst = new BST();
        bst.add(50);
        bst.add(30); bst.add(70);
        bst.add(20); bst.add(40);
        bst.add(80);
        bst.add(85); // Hijo único de 80
        bst.add(10);
        bst.add(5);  // Hijo único de 10

        bst.removeSubTree1();

        String expectedInOrder = "20 30 40 50 70 ";
        assertEquals(expectedInOrder, bst.inOrder());

        assertFalse(bst.contains(10));
        assertFalse(bst.contains(5));
        assertFalse(bst.contains(80));
        assertFalse(bst.contains(85));
        assertTrue(bst.contains(70));
        assertTrue(bst.contains(20));
    }
}