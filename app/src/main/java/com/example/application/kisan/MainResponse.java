package com.example.application.kisan;

import java.util.List;

/**
 * Created by HP on 08-03-2018.
 */

public class MainResponse {

    private String status;
    private int totalResults;
    private List<ArticleList> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<ArticleList> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleList> articles) {
        this.articles = articles;
    }
}
