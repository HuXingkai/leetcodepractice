package com.company;

public class LongestPalindromicSubstring {
    public String longestPalindrom(String s){
        int beginIndex=0;
        int endIndex=0;
        int len = s.length();
        if (len == 0) {
            return "";
        }
        if (len == 1) {
            return s;
        }
        Boolean [][] dp = new Boolean [len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            //这里利用了“&&”的短路功能（即如果第一个表达式为 false，则不再计算第二个表达式），排除了可能出现的字符串越界异常。
            if (i + 1 < len && s.charAt(i)==s.charAt(i+1)) {
                dp[i][i + 1] = true;
                beginIndex = i;
                endIndex = i + 1;
            } else if (i+1<len) dp[i][i + 1] = false;
        }

        for (int n = 3; n <= len; n++) {
            for (int i = 0; i <= len - n; i++) {
                int j = i + n - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                    //System.out.println("i="+i+"j="+j+"dp[i][j]"+dp[i][j]);
                    if (dp[i][j] && n > endIndex - beginIndex) {
                        endIndex = j;
                        beginIndex = i;
                    }
                } else dp[i][j] = false;
            }
        }

        return s.substring(beginIndex, endIndex+1);
    }

    public static void main(String [] args) {
        LongestPalindromicSubstring ls = new LongestPalindromicSubstring();
        String s = "aaa";
        System.out.println(ls.longestPalindrom(s));
    }

}
