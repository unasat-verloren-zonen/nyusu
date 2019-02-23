package sr.unasat.nyusu.entities;

import java.util.Date;

public class News {
    private int id;
    private String title;
    private String imgUrl;
    private String text;
    private Date date;

    public News(int id, String title, String imgUrl, String text, Date date) {
        this.id = id;
        this.title = title;
        this.imgUrl = imgUrl;
        this.text = text;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String buy) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date sell) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", img_url='" + imgUrl + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

}