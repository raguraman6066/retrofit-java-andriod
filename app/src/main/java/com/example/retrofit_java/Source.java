
package com.example.retrofit_java;


public class Source {

    private long userId;
    private long id;
    private String title;
    private String body;

    /**
     * No args constructor for use in serialization
     *
     */
    public Source() {
    }

    /**
     * 
     * @param id
     * @param title
     * @param body
     * @param userId
     */
    public Source(long userId, long id, String title, String body) {
        super();
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
