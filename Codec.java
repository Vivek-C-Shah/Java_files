public class Codec {

    public static void main(String[] args) {
        System.out.println(decode(encode("https://leetcode.com/problems/design-tinyurl")));
    }
    public static String encode(String longUrl) {
//        https://leetcode.com/problems/design-tinyurl
//        http://tinyurl.com/4e9iAk
        StringBuilder sb = new StringBuilder();
        sb.append("http://tinyurl.com/");
        sb.append(helper(longUrl, true));
        return sb.toString();
    }

//    using caesar cipher

    public static String helper(String a, boolean b){
        int key = 0;
        if(b){
            key = 5;
        }
        else {
            key = -5;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            sb.append((char) (a.charAt(i) + key));
        }
        return (sb.toString());
    }

    // Decodes a shortened URL to its original URL.
    public static String decode(String shortUrl) {
        return helper(shortUrl.substring(19), false);
    }
}