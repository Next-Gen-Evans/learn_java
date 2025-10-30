package consoleapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewsParser {

    public List<NewsArticle> parseNewsResponse(String jsonResponse) {
        List<NewsArticle> articles = new ArrayList<>();

        try {

            Pattern newsPattern = Pattern.compile("\"news\"\\s*:\\s*\\[(.*?)\\]", Pattern.DOTALL);
            Matcher newsMatcher = newsPattern.matcher(jsonResponse);

            while (newsMatcher.find()) {
                String newsArray = newsMatcher.group(1);
                articles.addAll(parseNewsArray(newsArray));
            }

        } catch (Exception e) {
            System.err.println("Error parsing JSON response: " + e.getMessage());
        }

        return articles;
    }

    private List<NewsArticle> parseNewsArray(String newsArray) {
        List<NewsArticle> articles = new ArrayList<>();

        Pattern articlePattern = Pattern.compile("\\{(.*?)\\}(?=\\s*[,\\]])", Pattern.DOTALL);
        Matcher articleMatcher = articlePattern.matcher(newsArray);

        while (articleMatcher.find()) {
            String articleJson = articleMatcher.group(1);
            NewsArticle article = parseArticle(articleJson);
            if (article != null) {
                articles.add(article);
            }
        }

        return articles;
    }

    private NewsArticle parseArticle(String articleJson) {
        try {
            String title = extractJsonValue(articleJson, "title");
            String author = extractJsonValue(articleJson, "author");
            String publishDate = extractJsonValue(articleJson, "publish_date");
            String url = extractJsonValue(articleJson, "url");
            String summary = extractJsonValue(articleJson, "summary");

            return new NewsArticle(title, author, publishDate, url, summary);
        } catch (Exception e) {
            return null;
        }
    }

    private String extractJsonValue(String json, String key) {
        Pattern pattern = Pattern.compile("\"" + key + "\"\\s*:\\s*\"([^\"]*?)\"");
        Matcher matcher = pattern.matcher(json);
        return matcher.find() ? matcher.group(1) : "";
    }

}
