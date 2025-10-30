package consoleapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class NewsApplication {

    private static final String API_URL = "https://api.worldnewsapi.com/top-news";
    private static final String API_KEY = "6f54e612016246789b00b46948a9679d";
    private static final String SEPARATOR = "=" .repeat(80);
    private static final String LINE_SEPARATOR = "-".repeat(80);

    private final Scanner scanner;
    private final NewsParser parser;
    private final FileManager fileManager;

    public NewsApplication() {
        this.scanner = new Scanner(System.in);
        this.parser = new NewsParser();
        this.fileManager = new FileManager();
    }

    public static void main(String[] args) {
        NewsApplication app = new NewsApplication();
        app.run();
    }

    public void run() {
        displayWelcome();

        while (true) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    fetchAndDisplayNews();
                    break;
                case 2:
                    viewSavedNews();
                    break;
                case 3:
                    displayAbout();
                    break;
                case 4:
                    System.out.println("\n📰 Thank you for using Terminal News App! Goodbye!");
                    return;
                default:
                    System.out.println("\n❌ Invalid choice. Please try again.");
            }

            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }

    private void displayWelcome() {
        System.out.println(SEPARATOR);
        System.out.println("               📰 TERMINAL NEWS APPLICATION 📰");
        System.out.println("                    Stay Informed, Stay Updated");
        System.out.println(SEPARATOR);
    }

    private void displayMenu() {
        System.out.println("\n" + LINE_SEPARATOR);
        System.out.println("                         MAIN MENU");
        System.out.println(LINE_SEPARATOR);
        System.out.println(" 1. 🌐 Fetch Latest News");
        System.out.println(" 2. 📁 View Saved News");
        System.out.println(" 3. ℹ️  About");
        System.out.println(" 4. 🚪 Exit");
        System.out.println(LINE_SEPARATOR);
        System.out.print("Enter your choice (1-4): ");
    }

    private int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void fetchAndDisplayNews() {
        System.out.println("\n🔄 Fetching latest news...");

        try {
            String jsonResponse = makeApiRequests();
            List<NewsArticle> articles = parser.parseNewsResponse(jsonResponse);

            if (articles.isEmpty()) {
                System.out.println("❌ No news articles found.");
                return;
            }

            displayNewsArticles(articles);

            System.out.print("\n💾 Save these articles to file? (y/n): ");
            String saveChoice = scanner.nextLine().trim().toLowerCase();

            if (saveChoice.equals("y") || saveChoice.equals("yes")) {
                fileManager.saveNewsToFile(articles);
                System.out.println("✅ News articles saved successfully!");
            }

        } catch (Exception e) {
            System.err.println("❌ Error fetching news: " + e.getMessage());
        }
    }

    private String makeApiRequests() throws IOException {
        String urlString = API_URL + "?date=" + getCurrentDate();
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("x-api-key", API_KEY);
        connection.setConnectTimeout(10000);
        connection.setReadTimeout(10000);

        int responseCode = connection.getResponseCode();

        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new IOException("HTTP Error: " + responseCode);
        }

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            return response.toString();
        }
    }

    private String getCurrentDate() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    private void displayNewsArticles(List<NewsArticle> articles) {
        System.out.println("\n" + SEPARATOR);
        System.out.println("                      📰 LATEST NEWS HEADLINES");
        System.out.println(SEPARATOR);

        for (int i = 0; i < articles.size(); i++) {
            NewsArticle article = articles.get(i);

            System.out.println("\n📄 Article " + (i + 1) + ":");
            System.out.println("   Title: " + article.getTitle());
            System.out.println("   Author: " + (article.getAuthor().isEmpty() ? "Unknown" : article.getAuthor()));
            System.out.println("   Published: " + article.getPublishDate());
            System.out.println("   URL: " + article.getUrl());

            if (!article.getSummary().isEmpty()) {
                System.out.println("   Summary: " + truncateText(article.getSummary(), 200));
            }

            if (i < articles.size() - 1) {
                System.out.println("\n   " + "-".repeat(60));
            }
        }

        System.out.println("\n" + SEPARATOR);
        System.out.println("Total articles: " + articles.size());
    }

    private String truncateText(String text, int maxLength) {
        if (text.length() <= maxLength) {
            return text;
        }
        return text.substring(0, maxLength) + "...";
    }

    private void viewSavedNews() {
        System.out.println("\n📁 Loading saved news...");
        List<String> savedFiles = fileManager.getSavedNewsFiles();

        if (savedFiles.isEmpty()) {
            System.out.println("❌ No saved news files found.");
            return;
        }

        System.out.println("\n📋 Available saved news files:");
        for (int i = 0; i < savedFiles.size(); i++) {
            System.out.println((i + 1) + ". " + savedFiles.get(i));
        }

        System.out.print("\nEnter file number to view (0 to cancel): ");
        int choice = getUserChoice();

        if (choice > 0 && choice <= savedFiles.size()) {
            String content = fileManager.readNewsFile(savedFiles.get(choice - 1));
            System.out.println("\n" + SEPARATOR);
            System.out.println(content);
            System.out.println(SEPARATOR);
        }
    }

    private void displayAbout() {
        System.out.println("\n" + SEPARATOR);
        System.out.println("                      📰 ABOUT THIS APPLICATION");
        System.out.println(SEPARATOR);
        System.out.println(" Terminal News App v1.0");
        System.out.println(" A simple, clean console application for reading news");
        System.out.println("");
        System.out.println(" Features:");
        System.out.println(" • Fetch latest news from World News API");
        System.out.println(" • Display news in organized, readable format");
        System.out.println(" • Save news articles to text files");
        System.out.println(" • View previously saved news");
        System.out.println("");
        System.out.println(" Developed with Java's rich algorithm capabilities");
        System.out.println(SEPARATOR);
    }

}