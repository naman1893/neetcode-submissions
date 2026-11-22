
class Solution {

    // Count function (for understanding count)
    private int count(int open, int close) {
        if (open == 0 && close == 0)
            return 1;

        if (open == close) {
            return count(open - 1, close);
        } else if (open < close) {
            if (open != 0) {
                return count(open - 1, close) + count(open, close - 1);
            } else {
                return count(open, close - 1);
            }
        }

        return 0;
    }

    // Generate all valid parentheses
    private void backtrack(List<String> ans, String path, int open, int close) {
        if (open == 0 && close == 0) {
            ans.add(path);
            return;
        }

        if (open == close) {
            backtrack(ans, path + "(", open - 1, close);
        } else if (open < close) {
            if (open != 0) {
                backtrack(ans, path + "(", open - 1, close);
            }
            backtrack(ans, path + ")", open, close - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        System.out.println("Count: " + count(n, n));
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", n, n);
        return ans;
    }
}
