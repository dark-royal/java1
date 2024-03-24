package data.models;

import java.time.LocalDateTime;

public class Entry {
    public Entry(int id, String body, String title) {
        this.id = id;
        this.body = body;
        this.title = title;
    }

    public Entry(){

    }

    private int id;
    private String body;
    private String title;
    private LocalDateTime dateCreated = LocalDateTime.now();

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", title='" + title + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public int getId() {
        return id;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setId(int id) {
        this.id = id;
    }
}


