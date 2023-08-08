package sg.rp.edu.rp.c346.id22038845.moremovieslesson12;

import java.io.Serializable;

public class Movies implements Serializable {
    private int id;
    private String title;
    private String genre;
    private int year;
    private String rating;

    private String link;

    public Movies(int id, String title, String genre, int year, String rating, String link) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public String getRating() {
        return rating;
    }

    public String getLink(){
        return link;
    }

    public void setMovie(String title, String genre, int year, String rating, String link){
        this.title =title;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
        this.link = link;
    }
}
