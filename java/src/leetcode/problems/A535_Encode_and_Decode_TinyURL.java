package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class A535_Encode_and_Decode_TinyURL {

    List<String> urls = new ArrayList<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        urls.add(longUrl);
        return String.valueOf(urls.size() - 1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return urls.get(Integer.parseInt(shortUrl));
    }

}
