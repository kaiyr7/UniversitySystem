package Attributes;

import Enums.Priority;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class News implements Serializable, Comparable<News> {
    private LocalDateTime dateTime;
    private String content;
    private String comment;
    private Priority priority;

    public News() {
    	
    }

    public News(LocalDateTime dateTime, String content) {
        this.dateTime = dateTime;
        this.content = content;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String toString() {
        return    "Date:  " + this.dateTime + "\n   Content:  " + this.content + "\n";
    }

    public int hashCode() {
        return Objects.hash(dateTime);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        News other = (News) obj;
        return this.dateTime.equals(other.dateTime);
    }

    public int compareTo(News news) {
        return this.dateTime.compareTo(news.dateTime);
    }

}

