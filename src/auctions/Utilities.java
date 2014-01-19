package auctions;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * Class including methods used by items to connect with SQL Db
 * 
 * @author D.Mouroutis
 * @author M.Vidalis
 * @author P.Karvounopoulos
 */
public class Utilities {

    
    /**
     * Scales the size of an image to fit the screen
     * 
     * @param img
     * @param width
     * @param height
     * @return 
     */
    public static BufferedImage scaleImage(BufferedImage img, int width, int height) {
        int imgWidth = img.getWidth();
        int imgHeight = img.getHeight();
        if (imgWidth*height < imgHeight*width) {
            width = imgWidth*height/imgHeight;
        } else {
            height = imgHeight*width/imgWidth;
        }
        BufferedImage newImage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D g = newImage.createGraphics();
        try {
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g.setBackground(Color.BLACK);
            g.clearRect(0, 0, width, height);
            g.drawImage(img, 0, 0, width, height, null);
        } finally {
            g.dispose();
        }
        return newImage;
    }

    
    /*
     *  Change img to array bytes 
     */
    public static byte[] img2Byte(BufferedImage img) throws IOException {
        ByteArrayOutputStream ImgObj = new ByteArrayOutputStream();
        ImageIO.write(img, "jpg", ImgObj);
        byte[] ImgBytes = ImgObj.toByteArray();
        ImgObj.close();
        return ImgBytes;
    }

    
    /*
     *  Change array bytes to img
     */
    public static BufferedImage byte2Img(byte[] img) throws IOException{
        return ImageIO.read(new ByteArrayInputStream(img));
    }

    
    /**
     * Retrieve items from DB after preparing the SQL Query
     * 
     * @param key_word  Search parameter 
     * @param method    Search type, search by:
     *                  1 = Category
     *                  2 = Bidder
     *                  3 = Item Title
     * @return object item
     */
    public static Item[] getItems(String key_word, int method){
        String tSql = "UPDATE ITEMS SET Remaining_Time=?, Created_on=?  WHERE id=?";
        String sql = null;
        PreparedStatement preparedStatement = null;
        Connection conn = SQLConn.sql_open();
        switch (method){
            case 0:
                sql = "SELECT * FROM ITEMS";
                try {
                    preparedStatement = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                } catch (SQLException ex) {
                    Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 1:
                sql = "SELECT * FROM ITEMS WHERE CATEGORY=?";
                try {
                    preparedStatement = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    preparedStatement.setString(1, key_word);
                } catch (SQLException ex) {
                    Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 2:
                sql = "SELECT * FROM ITEMS WHERE BIDDER=?";
                try {
                    preparedStatement = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    preparedStatement.setString(1, key_word);
                } catch (SQLException ex) {
                    Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 3:
                sql = "SELECT * FROM ITEMS WHERE LOCATE(?,Name)";
                try {
                    preparedStatement = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    preparedStatement.setString(1, key_word);
                } catch (SQLException ex) {
                    Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            default:
                sql = "SELECT * FROM ITEMS";
                try {
                    preparedStatement = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                } catch (SQLException ex) {
                    Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            
        }
        ResultSet set = null;
        int lim = 0;
        try {
            set = preparedStatement.executeQuery();
            set.last();
            lim = set.getRow();
        } catch (SQLException ex) {
                    Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Item[] item = new Item[lim];
        try {
            int counter =0;
            set.beforeFirst();
            while (set.next()){
                item[counter] = new Item();
                item[counter].setId(set.getInt("id"));
                item[counter].setTitle(set.getString("Name"));
                item[counter].setCategory(set.getString("Category"));
                item[counter].setDescription(set.getString("Description"));
                item[counter].setCreated_on(set.getDate("Created_on"));
                item[counter].setTime(set.getInt("Remaining_Time"));
                item[counter].setPrice(set.getInt("Price"));
                item[counter].setSeller(set.getString("Seller"));
                item[counter].setBidder(set.getString("Bidder"));
                item[counter].setTime(item[counter].RemainingTime());
                BufferedImage image = null;
                try {
                    image = byte2Img(set.getBytes("Img"));
                } catch (IOException ex) {
                    Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
                }
                item[counter].setImage(image);


                try {
                    preparedStatement = conn.prepareStatement(tSql);
                    preparedStatement.setInt(1, item[counter].getTime());
                    Date date = new java.util.Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    preparedStatement.setDate(2, sqlDate);
                    preparedStatement.setInt(3, item[counter].getId());
                    preparedStatement.execute();
                } catch (SQLException ex) {
                    Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
                }
                counter++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        SQLConn.sql_close(conn);
        return item; 
    }
    
}