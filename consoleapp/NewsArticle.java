package consoleapp;

public class NewsArticle {
    private final String title;
    private final String author;
    private final String publishDate;
    private final String url;
    private final String summary;

    public NewsArticle(String title, String author, String publishDate, String url, String summary) {
        this.title = title != null ? title : "";
        this.author = author != null ? author : "";
        this.publishDate = publishDate != null ? publishDate : "";
        this.url = url != null ? url : "";
        this.summary = summary != null ? summary : "";
    }

    //Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getPublishDate() { return publishDate; }
    public String getUrl() { return url; }
    public String getSummary() { return summary; }

    @Override
    public String toString() {
        return String.format("Title: %s%nAuthor: %s%nPublished: %s%nURL: %s%nSummary: %s%n",
                title, author.isEmpty() ? "Unknown" : author, publishDate, url, summary);
    }
}
