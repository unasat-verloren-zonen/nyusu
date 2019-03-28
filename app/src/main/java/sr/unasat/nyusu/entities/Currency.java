package sr.unasat.nyusu.entities;

public class Currency {
    private int id;
    private String name;
    private String symbol;
    private double buy;
    private double sell;

    public Currency(int id, String name, String symbol,
                    double buy, double sell) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.buy = buy;
        this.sell = sell;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getBuy() {
        return buy;
    }

    public void setBuy(double buy) {
        this.buy = buy;
    }

    public double getSell() {
        return sell;
    }

    public void setSell(double sell) {
        this.sell = sell;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", buy=" + buy +
                ", sell=" + sell +
                '}';
    }
}
