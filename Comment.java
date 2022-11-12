import java.util.Date;

public class Comment {
    // Comment's attributes
    private String author;
    private String msg;
    private Date date;

    // Comment constructor when a user posts a comment
    public Comment(String author, String msg){
        this.author = author;
        this.msg = msg;
        this.date = new Date();
    }

    // Comment constructor when a user reads a comment from another user
    public Comment(String author, String msg, Date date) {
        this.author = author;
        this.msg = msg;
        this.date = date;
    }

    // Returning comment's msg
    public String getMsg() {
        return msg;
    }

    // Setting comment's msg
    public void setMsg(String msg) {
        this.msg = msg;
    }

    // Returning comment's author
    public String getAuthor() {
        return author;
    }

    // Setting comment's author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Returning comment's date
    public Date getDate() {
        return date;
    }

    // Setting comment's date
    public void setDate(Date date) {
        this.date = date;
    }
}
