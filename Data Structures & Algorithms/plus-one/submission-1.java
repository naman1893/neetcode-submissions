class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;  // No carry needed, return early
            }
            digits[i] = 0;  // Carry over to next digit
        }

        // If we're here, all digits were 9 (e.g. 999 → 1000)
        int[] result = new int[n + 1];
        result[0] = 1;  // First digit is 1, rest are 0 by default
        return result;
    }
}
