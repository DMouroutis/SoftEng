package auctions;

import java.awt.image.BufferedImage;
import java.util.Date;


/**
 * All information about each item are initialized and retrieved from this class
 * 
 * @author D.Mouroutis
 * @author M.Vidalis
 * @author P.Karvounopoulos
 */
public class Item {
    private int id;
    private String seller;
    private String title;
    private String category;
    private String description;
    private int time;
    private Date created_on;
    private BufferedImage image;
    private String bidder;
    private int price;
    
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getSeller(){
        return seller;
    }

    public void setSeller(String seller){
        this.seller = seller;
    }

    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public String getCategory(){
        return category;
    }
    
    public void setCategory(String category){
        this.category = category;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public int getTime(){
        return time;
    }
    
    public void setTime(int time){
        this.time = time;
    }
    
    public Date getCreated_on(){
        return created_on;
    }

    public void setCreated_on(Date created_on){
        this.created_on = created_on;
    }

    public BufferedImage getImage(){
        return image;
    }

    public void setImage(BufferedImage image){
        this.image = image;
    }

    public String getBidder(){
        return bidder;
    }

    public void setBidder(String bidder){
        this.bidder = bidder;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    /*
     * Calculates the remaining time before the auction expire
     */
    public int RemainingTime(){
        Date now = new Date();
        java.sql.Date sqlDate = new java.sql.Date(now.getTime());
        long millisec = sqlDate.getTime() - created_on.getTime();
        this.time -= (int) ((((millisec/1000)/60)/60)/24);
        return time;
    }
}
