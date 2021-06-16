class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        helper("", 0, 0, n);
        return ans;
    }

    public void helper(String currentString, int open, int close, int max){
        if (currentString.length() == max * 2){
            ans.add(currentString);
            return;
        }

        if (open < max) helper(currentString + "(", open + 1, close, max);
        if (close < open) helper(currentString + ")", open, close + 1, max);

    }
}
