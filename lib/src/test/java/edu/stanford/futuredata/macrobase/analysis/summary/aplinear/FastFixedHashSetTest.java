package edu.stanford.futuredata.macrobase.analysis.summary.aplinear;

import edu.stanford.futuredata.macrobase.analysis.summary.util.FastFixedHashSet;
import edu.stanford.futuredata.macrobase.analysis.summary.util.IntSetAsLong;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class FastFixedHashSetTest {
    @Test
    public void testSimple() {
        FastFixedHashSet set = new FastFixedHashSet(16, true);
        set.add(new IntSetAsLong(1));
        set.add(new IntSetAsLong(2));
        assertTrue(set.contains(new IntSetAsLong(1)));
        assertTrue(set.contains(new IntSetAsLong(2)));
        assertEquals(16, set.getCapacity());
        FastFixedHashSet setTwo = new FastFixedHashSet(16, false);
        setTwo.add(1);
        setTwo.add(2);
        assertTrue(setTwo.contains(1));
        assertTrue(setTwo.contains(2));
        assertEquals(16, set.getCapacity());
    }
}
