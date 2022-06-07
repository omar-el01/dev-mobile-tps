package ma.enset.tp3.models;

import java.util.List;

public class NewsListResponse {
    private int totalResults;

    private List<Article> articles;

    public int getTotalResults() {
        return totalResults;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
