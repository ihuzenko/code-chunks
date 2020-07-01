package chunks.task.calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContiguousCellsSearchTest {

    @Test
    public void getMax_0() {
        int[][] mx = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        assertEquals(0, ContiguousCellsSearch.getMaxSizeOfContiguousUnits(mx));
    }

    @Test
    public void getMax_16() {
        int[][] mx = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0},
                {1, 0, 1, 1, 0},
                {1, 0, 1, 1, 0},
                {1, 0, 1, 1, 0},
        };

        assertEquals(16, ContiguousCellsSearch.getMaxSizeOfContiguousUnits(mx));
    }
}