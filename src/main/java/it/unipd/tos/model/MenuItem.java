////////////////////////////////////////////////////////////////////
// [Mattia] [Gottardello] [1142520]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

public class MenuItem {

    public enum alimenti { PIZZA, PRIMO_PIATTO }

    private alimenti itemsType;
    private String name;
    private double price;

    public MenuItem(String no, alimenti al, double pr) 
    {
        this.name = no;
        this.itemsType = al;
        this.price = pr;
    }

    public double getPrice()
    {
        return price;
    }

    public alimenti getitemsType()
    {
        return itemsType;
    }

    public String getName()
    {
        return name;
    }
}
