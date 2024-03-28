/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<String>();
        }
        return helper("", digits);
    }

    public String getStr(int num){
        int n = ((num-2)*3);
        if (num>1 && num<7) {
            String str = new String(""+(char)('a'+n)+(char)('b'+n)+(char)('c'+n));
            return str;
        }
        else if (num == 7) {
            return "pqrs";

        }
        else if (num == 8) {
            return "tuv";
        }
        else if (num == 9) {
            return "wxyz";
        }
        else return "";
    }

    public List<String> helper(String p, String up){
        if (up.isEmpty()) {
            List<String> lst = new ArrayList<>();
            lst.add(p);
            return lst;
        }
        String str = getStr(Integer.parseInt(String.valueOf(up.charAt(0))));
        // System.out.println(str);

        List<String> ans = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            ans.addAll(helper(p+str.charAt(i), up.substring(1)));
        }
        return ans;
    }
}
// @lc code=end

