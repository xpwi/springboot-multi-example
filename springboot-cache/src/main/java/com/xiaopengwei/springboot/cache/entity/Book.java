package com.xiaopengwei.springboot.cache.entity;/** * <p> * 书 - 实体类 * </p> * * @author github.com/xpwi * @since 2019-04-20 */public class Book {    private String isbn;    private String title;    public Book(String isbn, String title) {        this.isbn = isbn;        this.title = title;    }    public String getIsbn() {        return isbn;    }    public void setIsbn(String isbn) {        this.isbn = isbn;    }    public String getTitle() {        return title;    }    public void setTitle(String title) {        this.title = title;    }    @Override    public String toString() {        return "Book{" + "isbn='" + isbn + '\'' + ", title='" + title + '\'' + '}';    }}