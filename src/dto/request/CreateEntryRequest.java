package dto.request;

import java.time.LocalDateTime;

public class CreateEntryRequest {
    private String body;
    private String title;
    private String author;
    private LocalDateTime dateAndTimeCreated = LocalDateTime.now();

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getDateAndTimeCreated() {
        return dateAndTimeCreated;
    }

    public void setDateAndTimeCreated(LocalDateTime dateAndTimeCreated) {
        this.dateAndTimeCreated = dateAndTimeCreated;
    }
}


