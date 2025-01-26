package com.emcikem.llm.service.service;

import com.microsoft.azure.cognitiveservices.search.websearch.BingWebSearchAPI;
import com.microsoft.azure.cognitiveservices.search.websearch.BingWebSearchManager;
import com.microsoft.azure.cognitiveservices.search.websearch.models.ImageObject;
import com.microsoft.azure.cognitiveservices.search.websearch.models.NewsArticle;
import com.microsoft.azure.cognitiveservices.search.websearch.models.SearchResponse;
import com.microsoft.azure.cognitiveservices.search.websearch.models.VideoObject;
import com.microsoft.azure.cognitiveservices.search.websearch.models.WebPage;

/**
 * Sample code for searching web using Bing Web Search, an Azure Cognitive Service.
 *  - Search the web for "Xbox" with market and count settings and print out the name and url for first web, image, news and videos results.
 */
public class BingWebSearchSample {
    /**
     * Main function which runs the actual sample.
     *
     * @param client instance of the Bing Web Search API client
     * @return true if sample runs successfully
     */
    public static boolean runSample(BingWebSearchAPI client) {
        try {

            //=============================================================
            // This will look up a single query "Xbox" and print out name and url for first web, image, news and videos results

            System.out.println("Searched Web for \"百度是什么公司\"");
            SearchResponse webData = client.bingWebs().search()
                    .withQuery("百度是什么公司")
                    .withMarket("zh-CN")
//                    .withUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36")
                    .withCount(10)
                    .execute();

            //WebPages
            if (webData != null && webData.webPages() != null && webData.webPages().value() != null &&
                    !webData.webPages().value().isEmpty()) {
                // find the first web page
                WebPage firstWebPagesResult = webData.webPages().value().get(0);

                if (firstWebPagesResult != null) {
                    System.out.println(String.format("Webpage Results#%d", webData.webPages().value().size()));
                    System.out.println(String.format("First web page name: %s ", firstWebPagesResult.name()));
                    System.out.println(String.format("First web page URL: %s ", firstWebPagesResult.url()));
                } else {
                    System.out.println("Couldn't find web results!");
                }
            } else {
                System.out.println("Didn't see any Web data..");
            }

            //Images
            if (webData != null && webData.images() != null && webData.images().value() != null && !webData.images().value().isEmpty()) {
                // find the first image result
                ImageObject firstImageResult = webData.images().value().get(0);

                if (firstImageResult != null) {
                    System.out.printf("Image Results#%d%n", webData.images().value().size());
                    System.out.printf("First Image result name: %s %n", firstImageResult.name());
                    System.out.printf("First Image result URL: %s %n", firstImageResult.contentUrl());
                } else {
                    System.out.println("Couldn't find first image results!");
                }
            } else {
                System.out.println("Didn't see any image data..");
            }

            //News
            if (webData != null && webData.news() != null && webData.news().value() != null && !webData.news().value().isEmpty()) {
                // find the first news result
                NewsArticle firstNewsResult = webData.news().value().get(0);

                if (firstNewsResult != null) {
                    System.out.printf("News Results#%d%n", webData.news().value().size());
                    System.out.printf("First news result name: %s %n", firstNewsResult.name());
                    System.out.printf("First news result URL: %s %n", firstNewsResult.url());
                } else {
                    System.out.println("Couldn't find any News results!");
                }
            } else {
                System.out.println("Didn't see first news data..");
            }

            //Videos
            if (webData != null && webData.videos() != null && webData.videos().value() != null && webData.videos().value().size() > 0) {
                // find the first video result
                VideoObject firstVideoResult = webData.videos().value().get(0);

                if (firstVideoResult != null) {
                    System.out.printf("Video Results#%s%n", webData.videos().value().size());
                    System.out.printf("First Video result name: %s %n", firstVideoResult.name());
                    System.out.printf("First Video result URL: %s %n", firstVideoResult.contentUrl());
                } else {
                    System.out.println("Couldn't find first video results!");
                }
            } else {
                System.out.println("Didn't see any video data..");
            }

            return true;
        } catch (Exception f) {
            System.out.println(f.getMessage());
            f.printStackTrace();
        }
        return false;
    }

    /**
     * Main entry point.
     *
     * @param args the parameters
     */
    public static void main(String[] args) {
        try {
            //=============================================================
            // Authenticate

            // If you are going to set the AZURE_BING_SAMPLES_API_KEY environment variable, make sure you set it for your OS, then reopen your command prompt or IDE.
            // If not, you may get an API key not found exception.
            // IMPORTANT: if you have not set the `AZURE_BING_SAMPLES_API_KEY` environment variable to your cognitive services API key:
            // 1. comment out the below line
            final String subscriptionKey = "5c3fb12e688b447faae011bd8cf8fae9";
            // 2. paste your cognitive services API key below, and uncomment the line
            //final String subscriptionKey = "enter your key here";

            BingWebSearchAPI client = BingWebSearchManager.authenticate(subscriptionKey);


            runSample(client);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
