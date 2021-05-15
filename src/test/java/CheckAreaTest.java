import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CheckAreaTest {
    private static final CheckArea check = new CheckArea();
    private double x;
    private double y;
    private double r;

    public CheckAreaTest(Double r) {
        this.r = r;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { {1.0}, {1.5}, {2.0}, {2.5}, {3.0} });
    }

//    @BeforeAll
//    static void setUp() {
//        check = new CheckArea();
//    }

    @Test
    public void rectangleLeftUpCornerIn() {
        x = -r/2;
        y = r;
        assertTrue(check.getHit(x, y, r));
    }

    @Test
    public void rectangleLeftUpCornerOut() {
        x = -r/2 - 0.0000000000000001;
        y = r + 0.0000000000000001;
        assertFalse(check.getHit(x, y, r));
    }

    @Test
    public void rectangleRoghtUpCornerIn() {
        x = 0;
        y = r;
        assertTrue(check.getHit(x, y, r));
    }

    @Test
    public void rectangleRightUpCornerOut() {
        x = 0 + 0.0000000000000001;
        y = r + 0.0000000000000001;
        assertFalse(check.getHit(x, y, r));
    }

    @Test
    public void rectangleTriangleCornerIn() {
        x = 0;
        y = r/2;
        assertTrue(check.getHit(x, y, r));
    }

    @Test
    public void rectangleTriangleCornerOut() {
        x = 0 + 0.0000000000000001;
        y = r/2;
        assertFalse(check.getHit(x, y, r));
    }

    @Test
    public void triangleRightCornerIn() {
        x = r;
        y = 0;
        assertTrue(check.getHit(x, y, r));
    }

    @Test
    public void triangleRightCornerOut() {
        x = r + 0.0000000000000001;
        y = 0;
        assertFalse(check.getHit(x, y, r));
    }

    @Test
    public void triangleMedianIn() {
        x = r/2;
        y = r/4;
        assertTrue(check.getHit(x, y, r));
    }

    @Test
    public void triangleRightMedianOut() {
        x = r/2 + 0.0000000000000001;
        y = r/4 + 0.0000000000000001;
        assertFalse(check.getHit(x, y, r));
    }

    @Test
    public void circleLowerBorderIn() {
        x = 0;
        y = -r/2;
        assertTrue(check.getHit(x, y, r));
    }

    @Test
    public void circleLowerBorderOut() {
        x = 0;
        y = -r/2 - 0.0000000000000001;
        assertFalse(check.getHit(x, y, r));
    }

    @Test
    public void circleTriangleCornerIn() {
        x = r/2;
        y = 0;
        assertTrue(check.getHit(x, y, r));
    }

    @Test
    public void circleTriangleCornerOut() {
        x = r/2 + 0.0000000000000001;
        y = 0 - 0.0000000000000001;
        assertFalse(check.getHit(x, y, r));
    }

    @Test
    public void circleArcMiddleIn() {
        x = r/4;
        y = -r/4;
        assertTrue(check.getHit(x, y, r));
    }

    @Test
    public void circleArcMiddleOut() {
        x = r/4 + 0.0000000000000001;
        y = -r/4 - 0.0000000000000001;
        assertFalse(check.getHit(x, y, r));
    }

    @Test
    public void middleIn() {
        x = 0;
        y = 0;
        assertTrue(check.getHit(x, y, r));
    }

    @Test
    public void middleOut() {
        x = 0 - 0.0000000000000001;
        y = 0 - 0.0000000000000001;
        assertFalse(check.getHit(x, y, r));
    }
}