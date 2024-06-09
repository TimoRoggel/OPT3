package org.freezer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductDecisionTest {

    public class Product {
        private boolean isAvailable;
        private boolean hasValidName;
        private boolean hasValidId;

        public Product(boolean isAvailable, boolean hasValidName, boolean hasValidId) {
            this.isAvailable = isAvailable;
            this.hasValidName = hasValidName;
            this.hasValidId = hasValidId;
        }

        public boolean canBePrinted() {
            return isAvailable && (hasValidName || hasValidId);
        }
    }

    // Test cases voor Modified Condition/Decision Coverage
    @Test
    public void testTrueTrueTrue() {
        Product product = new Product(true, true, true);
        assertTrue(product.canBePrinted());
    }

    @Test
    public void testTrueTrueFalse() {
        Product product = new Product(true, true, false);
        assertTrue(product.canBePrinted());
    }

    @Test
    public void testTrueFalseTrue() {
        Product product = new Product(true, false, true);
        assertTrue(product.canBePrinted());
    }

    @Test
    public void testTrueFalseFalse() {
        Product product = new Product(true, false, false);
        assertFalse(product.canBePrinted());
    }

    @Test
    public void testFalseTrueTrue() {
        Product product = new Product(false, true, true);
        assertFalse(product.canBePrinted());
    }

    @Test
    public void testFalseTrueFalse() {
        Product product = new Product(false, true, false);
        assertFalse(product.canBePrinted());
    }

    @Test
    public void testFalseFalseTrue() {
        Product product = new Product(false, false, true);
        assertFalse(product.canBePrinted());
    }

    @Test
    public void testFalseFalseFalse() {
        Product product = new Product(false, false, false);
        assertFalse(product.canBePrinted());
    }

    // Test cases voor Equivalentieklassen en Randwaarden
    @Test
    public void testAvailableWithValidNameAndValidId() {
        Product product = new Product(true, true, true);
        assertTrue(product.canBePrinted());
    }

    @Test
    public void testAvailableWithValidNameOnly() {
        Product product = new Product(true, true, false);
        assertTrue(product.canBePrinted());
    }

    @Test
    public void testAvailableWithValidIdOnly() {
        Product product = new Product(true, false, true);
        assertTrue(product.canBePrinted());
    }

    @Test
    public void testAvailableWithInvalidNameAndInvalidId() {
        Product product = new Product(true, false, false);
        assertFalse(product.canBePrinted());
    }

    @Test
    public void testUnavailableWithValidNameAndValidId() {
        Product product = new Product(false, true, true);
        assertFalse(product.canBePrinted());
    }

    @Test
    public void testUnavailableWithValidNameOnly() {
        Product product = new Product(false, true, false);
        assertFalse(product.canBePrinted());
    }

    @Test
    public void testUnavailableWithValidIdOnly() {
        Product product = new Product(false, false, true);
        assertFalse(product.canBePrinted());
    }

    @Test
    public void testUnavailableWithInvalidNameAndInvalidId() {
        Product product = new Product(false, false, false);
        assertFalse(product.canBePrinted());
    }

    @Test
    public void testPairwise() {
        // Testgevallen op basis van Pairwise Testing
        Product product1 = new Product(true, true, true);
        Product product2 = new Product(true, true, false);
        Product product3 = new Product(true, false, true);
        Product product4 = new Product(true, false, false);
        Product product5 = new Product(false, true, true);
        Product product6 = new Product(false, true, false);
        Product product7 = new Product(false, false, true);
        Product product8 = new Product(false, false, false);

        // Verifieer de verwachte uitkomsten
        assertTrue(product1.canBePrinted());  // Verwacht: true
        assertTrue(product2.canBePrinted());  // Verwacht: true
        assertTrue(product3.canBePrinted()); // Verwacht: true
        assertFalse(product4.canBePrinted()); // Verwacht: false
        assertFalse(product5.canBePrinted()); // Verwacht: false
        assertFalse(product6.canBePrinted()); // Verwacht: false
        assertFalse(product7.canBePrinted()); // Verwacht: false
        assertFalse(product8.canBePrinted()); // Verwacht: false
    }
}
