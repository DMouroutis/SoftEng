package auctions;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author D.Mouroutis
 * @author M.Vidalis
 * @author P.Karvounopoulos
 */
public class JFrameTest {

    public JFrameTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getLoginButtonPressed method, of class JFrame.
     */
    @Test
    public void getLoginButtonPressed() {
        System.out.println("getLoginButtonPressed");
        JFrame instance = new JFrame();
        int expResult = 1;
        JFrame.jButton1.doClick();
        int result = instance.getLoginButtonPressed();
        assertEquals(expResult, result);
    }

}