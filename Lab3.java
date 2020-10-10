package acm_labs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Lab3 {
    
    //lab3_task1
    class Solution1 {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> used = new HashSet();
            for (int x: nums) {
                if (used.contains(x))
                    return true;
                used.add(x);
            }
            return false;
        }
    }
    
    //lab3_task2
    class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }

            for(int i = 0; i < nums.length; i++) {
                int x = target - nums[i];
                if(map.containsKey(x) && map.get(x) != i)
                    return new int[] {i, map.get(x)};
            }

            return new int[]{0};
        }
    }

    //lab3_task3
    class Solution3 {
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

    //lab3_task4
    class Solution4 {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map< String, List > ans = new HashMap<String, List>();
            for(String s: strs) {
                char[] ca = s.toCharArray();
                Arrays.sort(ca);
                String key = String.valueOf(ca);
                if(!ans.containsKey(key))
                    ans.put(key, new ArrayList());
                ans.get(key).add(s);
            }

            return new ArrayList(ans.values());
        }
    }
    
    //lab3_task5
    class Solution5 {
        public boolean wordPattern(String pattern, String s) {
            String words[] = s.split(" ");

            if (words.length != pattern.length()) 
                return false;

           HashMap < Character,String > hm1 = new HashMap<>();
           HashMap < String,Character > hm2 = new HashMap<>();        

           for (int i = 0; i < pattern.length(); i++) {
               char ch = pattern.charAt(i);
               if (!hm1.containsKey(ch)) {  
                   if (hm2.containsKey(words[i])) 
                      return false;
                   else {
                       hm1.put(ch, words[i]);
                       hm2.put(words[i], ch);
                   }     
               }
               else {
                   String val = hm1.get(ch);
                   if (!val.equals(words[i]))
                       return false;               
               }     
           }

            return true;
        }
    }

    //lab3_task6
    class Solution6 {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums.length < 3) return new ArrayList<>();
            Arrays.sort(nums);
            Set<List<Integer>> set = new HashSet<>();
            for (int i = 0; i < nums.length - 2; i++) {
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) set.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                    else if (sum > 0) k--;
                    else if (sum < 0) j++;
                }

            }

            return new ArrayList<>(set);
        }
    }
    
    //lab3_task7
    class Solution7 {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map< Integer, Integer > lastPos = new HashMap();
            int index = 0;
            for (int x: nums) {
                if (lastPos.containsKey(x) && Math.abs(index - lastPos.get(x)) <= k)
                    return true;
                lastPos.put(x, index);
                index++;
            }

            return false;
        }
    }

    //lab3_task8
    class Solution8 {
        int[] nums;
        public Solution8(int[] nums) {
            this.nums = nums;
        }

        public int pick(int target) {
            List<Integer> list = new ArrayList();

            for (int i = 0; i < nums.length; i++)
                if(nums[i] == target)
                    list.add(i);

            Random random = new Random();
            int randomIndex = random.nextInt(list.size());

            return list.get(randomIndex);
        }
    }

    //lab3_task10
    class Solution10 {
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            int ans = 0;
            HashMap < Integer, Integer > hashmap = new HashMap<>(); 
            for (int i = 0; i < A.length; i++) {

                for (int j = 0; j < B.length; j++) {

                   if (!hashmap.containsKey(A[i] + B[j])) {

                       hashmap.put(A[i] + B[j], 1);
                   } else {
                       int a = hashmap.get(A[i] + B[j]);

                       hashmap.put(A[i] + B[j], a + 1);
                   }
                }
            }


            for (int i = 0; i < C.length; i++) {

                for (int j = 0; j < D.length; j++) {
                    if (hashmap.containsKey( -(C[i] + D[j]) ))
                   ans += hashmap.get( -(C[i] + D[j]) );

                }
            }

            return ans;
        }
    }

    //lab3_task11
    class Solution11 {
        public boolean isHappy(int n) {
            Set< Integer > used = new HashSet();
            used.add(n);

            while (n != 1) {
                int res = 0;
                while (n > 0) {
                    res += (n % 10) * (n % 10);
                    n /= 10;
                }
                n = res;
                if (used.contains(n))
                    return false;
                else
                    used.add(n);
            }

            return true;
        }
    }

    //lab3_task12
    class Solution12 {
        public int[] topKFrequent(int[] nums, int k) {

            Map< Integer, Integer > fr = new HashMap<>();
            int count = 0;

            for (int num: nums) {
                if(fr.containsKey(num)) {
                    count = fr.get(num);
                    fr.put(num, count + 1);
                } else
                    fr.put(num, 1);
            }

            List< Map.Entry<Integer, Integer> > sortedMap = new ArrayList<>(fr.entrySet());

            Collections.sort(sortedMap, new Comparator<Map.Entry<Integer, Integer>>(){
                @Override
                public int compare(Map.Entry<Integer, Integer> e1,
                                   Map.Entry<Integer, Integer> e2) {
                   return e2.getValue().compareTo(e1.getValue());
                }
            });

            int[] result = new int[k];
            for(int i = 0; i < k; i++)
                result[i] = sortedMap.get(i).getKey();

            return result;
        }
    }
}
