package auctions;

import auctions.Item;
import java.util.Date;
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
public class ItemTest {

    Item testItem = new Item();

    public ItemTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        testItem.setId(1);
        testItem.setSeller("x");
        testItem.setTitle("x");
        testItem.setCategory("x");
        testItem.setDescription("x");
        testItem.setTime(1);
        Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        testItem.setCreated_on(sqlDate);
        testItem.setBidder("x");
        testItem.setPrice(1);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Item.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        int expResult = 1;
        int result = testItem.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Item.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        testItem.setId(id);
        assertEquals(0, testItem.getId());
    }

    /**
     * Test of getSeller method, of class Item.
     */
    @Test
    public void testGetSeller() {
        System.out.println("getSeller");
        String expResult = "x";
        String result = testItem.getSeller();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSeller method, of class Item.
     */
    @Test
    public void testSetSeller() {
        System.out.println("setSeller");
        String seller = "";
        testItem.setSeller(seller);
        assertEquals("", testItem.getSeller());
    }

    /**
     * Test of getTitle method, of class Item.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        String expResult = "x";
        String result = testItem.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTitle method, of class Item.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "";
        testItem.setTitle(title);
        assertEquals("",testItem.getTitle());
    }

    /**
     * Test of getCategory method, of class Item.
     */
    @Test
    public void testGetCategory() {
        System.out.println("getCategory");
        String expResult = "x";
        String result = testItem.getCategory();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCategory method, of class Item.
     */
    @Test
    public void testSetCategory() {
        System.out.println("setCategory");
        String category = "";
        testItem.setCategory(category);
        assertEquals("", testItem.getCategory());
    }

    /**
     * Test of getDescription method, of class Item.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        String expResult = "x";
        String result = testItem.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class Item.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        testItem.setDescription(description);
        assertEquals("", testItem.getDescription());
    }

    /**
     * Test of getTime method, of class Item.
     */
    @Test
    public void testGetTime() {
        System.out.println("getTime");
        int expResult = 1;
        int result = testItem.getTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTime method, of class Item.
     */
    @Test
    public void testSetTime() {
        System.out.println("setTime");
        int time = 0;
        testItem.setTime(time);
        assertEquals(0, testItem.getTime());
    }

    /**
     * Test of getCreated_on method, of class Item.
     */
    @Test
    public void testGetCreated_on() {
        System.out.println("getCreated_on");
        Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        Date expResult = sqlDate;
        Date result = testItem.getCreated_on();
        assertEquals(expResult, result);
    }

   
    /**
     * Test of getBidder method, of class Item.
     */
    @Test
    public void testGetBidder() {
        System.out.println("getBidder");
        String expResult = "x";
        String result = testItem.getBidder();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBidder method, of class Item.
     */
    @Test
    public void testSetBidder() {
        System.out.println("setBidder");
        String bidder = "";
        testItem.setBidder(bidder);
        assertEquals("", testItem.getBidder());
    }

    /**
     * Test of getPrice method, of class Item.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        int expResult = 1;
        int result = testItem.getPrice();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPrice method, of class Item.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        int price = 0;
        testItem.setPrice(price);
        assertEquals(0, testItem.getPrice());
    }

    /**
     * Test of RemainingTime method, of class Item.
     */
    @Test
    public void testRemainingTime() {
        System.out.println("RemainingTime");
        int expResult = 1;
        int result = testItem.RemainingTime();
        assertEquals(expResult, result);
    }

}