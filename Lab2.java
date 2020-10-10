
package acm_labs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Lab2 {
    
    //lab2_task1_error
    class Solution1 {
        public String sortString(String s) {
            int [] freq = new int[26];
            for (char ch: s.toCharArray()) {
                freq[ch - 'a'] += 1;
            }
            StringBuilder sb = new StringBuilder();
            while (sb.length() < s.length()) {
                for (int i=0; i<26; i++) {
                    if (freq[i] > 0) {
                        sb.append((char) (i + 'a'));
                        freq[i] -= 1;
                    }
                }
                for (int i=25; i>=0; i--) {
                    if (freq[i] > 0) {
                        sb.append((char) (i + 'a'));
                        freq[i] -= 1;
                    }
                }
            }
            return sb.toString();
        }
    }
    
    //lab2_task2
    class Solution2 {
        public double average(int[] salary) {
            Arrays.sort(salary);
            double sum = 0;
            for (int i = 1; i < salary.length - 1; ++i) {
                sum += salary[i];
            }

            return sum / (salary.length - 2);
        }
    }
    
    //lab2_task3
    class Solution3 {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            ArrayList<Integer> result = new ArrayList<>();

            for (int i = 0; i < arr2.length; ++i) {
                for(int j = 0; j < arr1.length; ++j)
                    if(arr1[j] == arr2[i])
                        result.add(arr2[i]);
            }

            int m = result.size();
            for (int i = 0; i < arr1.length; ++i) {
                boolean flag = false;
                for(int j = 0; j < arr2.length; j++)
                    if(arr1[i] == arr2[j]) {
                        flag = true;
                        break;
                    }
                if(!flag)
                    result.add(arr1[i]);

            }
            int[] arr = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                arr[i] = result.get(i);
            }

            Arrays.sort(arr, m, arr.length - 1);
            return arr;
        }
    }
    
    //lab2_task4
    class Solution4 {
        public int maxCoins(int[] piles) {
            Arrays.sort(piles);
            int sum = 0;
            for(int i = 0; i < piles.length; i++) {
                if((i + 1) % 3 == 0)
                    sum += piles[i - 1];
            }

            return sum;
        }
    }
    
    //lab2_task5
    class Solution5 {
        public int getKth(int lo, int hi, int k) {
            int xLen = hi - lo + 1;
            int[] xArr = new int[xLen]; 
            int[] xPowers = new int[xLen];

            for (int i = 0; i < xLen; i++) {
                xArr[i] = lo;
                lo++;
            }

            for (int i = 0; i < xLen; i++) {
                int steps = 0;
                int x = xArr[i];
                while (x != 1) {
                    if (x % 2 == 0)
                        x /= 2;
                    else if (x % 2 == 1)
                        x = 3 * x + 1;
                    steps++;
                }
                xPowers[i] = steps;
            }

            int[] xPowersAsc = new int[xLen];
            System.arraycopy(xPowers, 0, xPowersAsc, 0, xLen);
            Arrays.sort(xPowersAsc);

            int[] total = new int[xLen];
            for (int i = 0; i < xLen; i++) 
                for(int j = 0; j < xLen; j++) 
                    if (xPowersAsc[i] == xPowers[j]) {
                        total[i] = xArr[j];
                        xPowers[j] = -1;
                        break;
                    }
            return total[k - 1];
        }
    }
    
    //lab2_task6
    class Solution6 {
        public int largestPerimeter(int[] A) {
            Arrays.sort(A);
            for(int i = 0; i < A.length - 2; i++)
                if (A[i] < A[i + 1] + A[i + 2])
                    return A[i] + A[i + 1] + A[i + 2];        
            return 0;
        }
    }
    
    //lab2_task7
    class Solution7 {
        public int[] intersection(int[] nums1, int[] nums2) {
            if (nums1.length == 0 || nums2.length == 0)
                return new int[0];
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            ArrayList<Integer> list = new ArrayList<>();

            for(int n : nums1)
                set1.add(n);

            for(int n : nums2) {
                if(set1.contains(n))
                    set2.add(n);
            }

            int[] arr = new int[set2.size()];
            int count = 0;
            for(int n : set2) {
                arr[count] = n;
                count++;
            }
            return arr;
        }
    }
    
    //lab2_task8
    class Solution8 {
        public int[][] kClosest(int[][] points, int K) {
            int n = points.length;
            int[] dists = new int[n];
            for (int i = 0; i < n; ++i)
                dists[i] = dist(points[i]);

            Arrays.sort(dists);
            int distK = dists[K-1];

            int[][] ans = new int[K][2];
            int t = 0;
            for (int i = 0; i < n; ++i)
                if (dist(points[i]) <= distK)
                    ans[t++] = points[i];
            return ans;
        }

        public int dist(int[] point) {
            return point[0] * point[0] + point[1] * point[1];
        }
    }
    
    //lab2_task9
    class Solution9 {
        public String largestNumber(int[] nums) {

            String str[] = new String[nums.length];
            for(int i = 0; i < nums.length; i++)
                str[i] = Integer.toString(nums[i]);

            Arrays.sort(str, (a, b)->{
                return b.compareTo(a);
            });

            String ans = "";
            for(int i = 0; i < str.length; i++)
                ans += str[i];

            if(ans.charAt(0) == '0')
                return "0";

            return ans;

        }
    }
}
