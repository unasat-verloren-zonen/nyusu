package sr.unasat.nyusu.entities;

public class Weather {

    private String summary;
    private String icon;
    private double temperature;

    public Weather() {
    }

    public Weather(String summary, String icon, double temperature) {
        this.summary = summary;
        this.icon = icon;
        this.temperature = temperature;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "summary='" + summary + '\'' +
                ", icon='" + icon + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}
