
package javaassignment.memoryerror;

import java.util.Objects;


public class Item {
    
    private String category;
    private String name;
    private double price;
    //
    //

    public Item(String category, String name, double price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    @Override
//    public int hashCode() {
//        int hash = 3;
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Item other = (Item) obj;
//        if (!Objects.equals(this.category, other.category)) {
//            return false;
//        }
//        return true;
//    }

   
    
}
