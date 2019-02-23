package sr.unasat.nyusu.entities;

public class OilPrice {
    private int id;
    private double unleaded;
    private double diesel;

    public OilPrice(int id, double unleaded, double diesel) {
        this.id = id;
        this.unleaded = unleaded;
        this.diesel = diesel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getUnleaded() {
        return unleaded;
    }

    public void setUnleaded(double unleaded) {
        this.unleaded = unleaded;
    }

    public double getDiesel() {
        return diesel;
    }

    public void setDiesel(double diesel) {
        this.diesel = diesel;
    }

    @Override
    public String toString() {
        return "Oilprice{" +
                "id=" + id +
                ", unleaded='" + unleaded + '\'' +
                ", diesel='" + diesel + '\'' +
                '}';
    }
}