package org.devtrace.challenges;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QalifiyAlgosTest {

    // test cases from https://codegolf.stackexchange.com/questions/221/reverse-polish-notation
    @Test
    public void reversePolishNotationTest() {
        assertEquals(2.5, QalifiyAlgos.evaluateReversePolishNotation("5 2 /"), 0);
        assertEquals(2, QalifiyAlgos.evaluateReversePolishNotation("5 2.5 /"), 0);
        assertEquals(14, QalifiyAlgos.evaluateReversePolishNotation("5 1 2 + 4 * 3 - +"), 0);
        assertEquals(2, QalifiyAlgos.evaluateReversePolishNotation("4 2 5 * + 1 3 2 * + /"), 0);
    }

    @Test
    public void numberToOrdinalTest() {
        assertEquals("111th", QalifiyAlgos.numberToOrdinal(111));
        assertEquals("1st", QalifiyAlgos.numberToOrdinal(1));
        assertEquals("2nd", QalifiyAlgos.numberToOrdinal(2));
        assertEquals("3rd", QalifiyAlgos.numberToOrdinal(3));

    }

    @Test
    public void maskifyTest() {
        assertEquals("", QalifiyAlgos.maskify(""));
        assertEquals("ABCD-EFGH-IJKLM-NOPQ", QalifiyAlgos.maskify("ABCD-EFGH-IJKLM-NOPQ"));
        assertEquals("5### #### #### 4444", QalifiyAlgos.maskify("5555 5555 5555 4444"));
    }

}
