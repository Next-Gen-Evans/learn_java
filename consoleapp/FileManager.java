package consoleapp;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileManager {

    private static final String NEWS_DIR = "saved_news";

    public FileManager() {
        createNewsDirectory();
    }

    private void createNewsDirectory() {
        File dir = new File(NEWS_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    public void saveNewsToFile(List<NewsArticle> articles) {
        String fileName = "news_" + LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")) + ".txt";
        File file = new File(NEWS_DIR, fileName);

        try(PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            writer.println("=" .repeat(80));
            writer.println("                      SAVED NEWS ARTICLES");
            writer.println("                   " + LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            writer.println("=" .repeat(80));
            writer.println();

            for (int i = 0; i < articles.size(); i++) {
                NewsArticle article = articles.get(i);
                writer.println("Article " + (i + 1) + ":");
                writer.println("-".repeat(60));
                writer.println(article.toString());
                writer.println();
            }

            writer.println("=" .repeat(80));
            writer.println("Total articles saved: " + articles.size());
            writer.println("File: " + fileName);
            writer.println("=" .repeat(80));
        } catch (IOException e) {
            System.err.println("Error saving news to file: " + e.getMessage());
        }
    }

    public List<String> getSavedNewsFiles() {
        File dir = new File(NEWS_DIR);
        File[] files = dir.listFiles((d, name) -> name.startsWith("news_") && name.endsWith(".txt"));

        List<String> fileNames = new ArrayList<>();
        if (files != null) {
            Arrays.sort(files, (f1, f2) -> Long.compare(f2.lastModified(), f1.lastModified()));
            for (File file : files) {
                fileNames.add(file.getName());
            }
        }

        return fileNames;
    }

    public String readNewsFile(String fileName) {
        File file = new File(NEWS_DIR, fileName);
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            return "Error reading file: " + e.getMessage();
        }

        return content.toString();
    }
}
