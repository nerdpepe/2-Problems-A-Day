import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

//https://leetcode.com/problems/search-suggestions-system/

public class SearchSuggestionsSystem {
    static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> suggestionList = new ArrayList<>();
        Arrays.sort(products);
        for (int i = 0; i < searchWord.length(); i++) {
            int k = 0;
            List<String> list = new ArrayList<>();
            while (list.size() < 3 && k < products.length) {
                if (i + 1 <= products[k].length()) {
                    if (searchWord.substring(0, i + 1).equals(products[k].substring(0, i + 1)))
                        list.add(products[k]);
                }
              k++;
            }
            suggestionList.add(list);
        }
        return suggestionList;
    }

    public static void main(String... args) {
        String[] products = new String[] { "mobile", "mouse", "moneypot", "monitor", "mousepad" };
        String search = "mouse";
        List<List<String>> ans = suggestedProducts(products, search);

        for (List<String> l : ans)
            System.out.println(l);
    }
}