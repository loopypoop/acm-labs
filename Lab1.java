package acm_labs;

import java.util.ArrayList;

public class Lab1 {
    
    //lab1_arr_task1
    class NumArray {
    
        private int[] prefixSum;

        public NumArray(int[] nums) {
            prefixSum = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                prefixSum[i] = nums[i];
                if (i > 0)
                    prefixSum[i] += prefixSum[i - 1];
            }
        }

        public int sumRange(int i, int j) {


            int sum = prefixSum[j];

            if (i > 0)
                sum -= prefixSum[i - 1];
            return sum;
        }
    }
    
    //lab1_arr_task2   
    class Solution2 {
        public int maxSubArray(int[] nums) {
            int maxSum = nums[0] + nums[1];
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum = 0;
                for(int j = i + 1; j < nums.length; j++) {
                    sum += nums[j];
                    if(maxSum < sum)
                        maxSum = sum;
                }
            }
            return maxSum;
        }
    }
    
    //lab1_arr_task3
    class Solution3 {
        public int[] productExceptSelf(int[] nums) {
            int[] output = new int[nums.length];
            int product = 1;

            for(int i = 0; i < nums.length; i++)
                product *= nums[i];

            for(int i = 0; i < nums.length; i++) {
                output[i] = product / nums[i];
            }

            return output;
        }
    }   
    
    //lab1_arr_task4
    class Solution4 {
        public int missingNumber(int[] nums) {
            int total = 0;
            int sumArray = 0;
            for (int i = 1; i <= nums.length; i++)
                total += i;

            for (int i = 0; i < nums.length; i++)
                sumArray += nums[i];

            if (total == sumArray)
                return 0;
            else
                return total - sumArray;
        }
    }
    
    //lab1_arr_task5
    class Solution5 {
        public double findMaxAverage(int[] nums, int k) {
            double maxSum = nums[0];
            int sum = 0;
            double total = 0;
            for(int i = 0; i < nums.length; i++) {
                sum = 0;
                for (int j = i; j < i + k; j++) {
                    if(i + k >= nums.length)
                        break;
                    sum += nums[j];
                    if(maxSum < sum)
                        maxSum = sum;
                }
            }
            total = maxSum / k;
            return total;
        }
    }
    
    //lab1_string_task1
    class Solution6 {
        public String reverseWords(String s) {
            ArrayList<String> words = new ArrayList<>();

            String reverse = "";
            String word = "";
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == ' ') {
                    words.add(word);
                    word = "";
                } else if (i == s.length() - 1) {
                    word += s.charAt(i);
                    words.add(word);
                } else
                    word += s.charAt(i);
            }
            for (int i = words.size() - 1; i >= 0; i--) {
                if(i == 0)
                    reverse += words.get(i);
                else
                    reverse += words.get(i) + " ";
            }

            return reverse;
        }
    }
    
    //lab1_string_task2
    class Solution7 {
        public String licenseKeyFormatting(String S, int K) {
            String tmp = "";
            for(int i = 0; i < S.length(); i++)
                if(S.charAt(i) != '-')
                    tmp += S.charAt(i);
            tmp = tmp.toUpperCase();
            String rev = "";
            String total = "";
            int cnt = 0;
            for (int i = tmp.length() - 1; i >= 0; i--) {
                if(cnt == K) {
                    rev += '-';
                    cnt = 0;
                }
                rev += tmp.charAt(i);
                cnt++;
            }
            for(int i = rev.length() - 1; i >= 0; i--)
                total += rev.charAt(i);

            return total;
        }
    }
    
    //lab1_string_task3
    class Solution8 {
        public int myAtoi(String s) {
                    int i = 0;
            while (i < s.length() && s.charAt(i) == ' ')
                i++;

            boolean flag = true;

            if (s.charAt(i) == '-') {
                flag = false;
                i++;
            }
            else if (s.charAt(i) == '+') {
                flag = true;
                i++;
            }

            int result = 0;
            while (s.length() > i && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                result = result*10 + (s.charAt(i) - '0');
                i++;
            }
            if (flag == false)
                result = -result;

            if (result > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (result < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            return result;

        }
    }
    
    //lab1_string_task4
    class Solution9 {
    
        public  String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        public  String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        public  String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

        public String numberToWords(int num) {
            if (num == 0) return "Zero";
            return helper(num); 
        }

        public String helper(int num) {
            String result = new String();
            if (num < 10) result = belowTen[num];
            else if (num < 20) result = belowTwenty[num - 10];
            else if (num < 100) result = belowHundred[num / 10] + " " + helper(num % 10);
            else if (num < 1000) result = helper(num / 100) + " Hundred " +  helper(num % 100);
            else if (num < 1000000) result = helper(num / 1000) + " Thousand " +  helper(num % 1000);
            else if (num < 1000000000) result = helper(num / 1000000) + " Million " +  helper(num % 1000000);
            else result = helper(num / 1000000000) + " Billion " + helper(num % 1000000000);
            return result;
        }
    }
    
    //lab1_string_task5
    class Solution {
        public String reverseWords(String s) {
            ArrayList<String> words = new ArrayList<>();
            String word = "";

            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == ' ') {
                    words.add(word);
                    word = "";
                } else if (i == s.length() - 1) {
                    word += s.charAt(i);
                    words.add(word);
                } else
                    word += s.charAt(i);
            }

            String result = "";
            String reversedWord = "";
            for(int i = 0; i < words.size(); i++) {
                for(int j = words.get(i).length() - 1; j >= 0; j--) {
                    reversedWord += words.get(i).charAt(j);
                }
                if(i == words.size() - 1)
                    result += reversedWord;
                else
                    result += reversedWord + " ";
                reversedWord = "";
            }

            return result;
        }
    }
    
    public static void main(String[] args) {}
}
