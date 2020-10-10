package acm_labs;

import java.util.*;

public class Lab4 {
    
    //lab4_task1
    class SimpleStack {
        private int arr[];
        private int size;
        
        public SimpleStack(int size) {
            arr = new int[size];
            this.size = 0;
        }
        
        public void push(int v) {
            arr[size++] = v;
            System.out.println("ok");
        }
        
        public void pop() {
            if (size > 0)
                System.out.println(arr[--size]);
            
            System.out.println("error");
        }
        
        public void back() {
            if (size > 0)
                System.out.println(arr[size-1]);
            
            System.out.println("error");;
        }
        
        public int size() {
            
            return size;
        }
        
        public void clear() {
            size = 0;
            System.out.println("ok");
        }
        
        public void exit() {
            System.out.println("bye");
        }
    }
    public class Solution1 {
        public  void simpleStack() {
            SimpleStack st = new SimpleStack(110);
            Scanner in = new Scanner(System.in);
            while(true) {
                String s = in.next();
                if (s.equals("push")) {
                    int n = in.nextInt();
                    st.push(n);
                }
                else if (s.equals("pop")) {
                    st.pop();
                }
                else if (s.equals("back")) {
                    st.back();
                }
                else if (s.equals("size")) {
                    System.out.println(st.size());
                }
                else if (s.equals("clear")) {
                    st.clear();
                } else {
                    st.exit();
                    break;
                }
            }
            in.close();
        }
    }
    
    //lab4_task2
    class Queue {
        private int arr[];
        private int size;
        
        public Queue(int size) {
            arr = new int[size];
            this.size = 0;
        }
        
        public void push(int v) {
            arr[size++] = v;
            System.out.println("ok");
        }
        
        public void pop() {
            if (size > 0) {
                System.out.println(arr[0]);
                for(int i = 1; i < size; i++)
                    arr[i - 1] = arr[i];
                
                arr[size] = arr[--size];
            } else
                System.out.println("error");
        }
        
        public void front() {
            if (size > 0)
                System.out.println(arr[0]);
            else
                System.out.println("error");;
        }
        
        public int size() {
            return size;
        }
        
        public void clear() {
            size = 0;
            System.out.println("ok");
        }
        
        public void exit() {
            System.out.println("bye");
        }
    }
    public class Solution2 {
        public  void simpleQueue() {
          
            Queue q = new Queue(1000);
            Scanner in = new Scanner(System.in);

            while(true) {

                String s = in.next();
                if (s.equals("push")) {
                    int n = in.nextInt();
                    q.push(n);
                }
                else if (s.equals("pop")) {
                    q.pop();
                }
                else if (s.equals("front")) {
                    q.front();
                }
                else if (s.equals("size")) {
                    System.out.println(q.size());
                }
                else if (s.equals("clear")) {
                    q.clear();
                } else {
                    q.exit();
                    break;
                }
            }

            in.close();
        } 
    }

    //lab4_task3
    class Deque {
        private int arr[];
        private int size;
        
        public Deque(int size) {
            arr = new int[size];
            this.size = 0;
        }
        
        public void push_back(int v) {
            arr[size++] = v;
            System.out.println("ok");
        }
        
        public void push_front(int v) {
            arr[size] = arr[size++];
            for(int i = 0; i < size; i++)
                arr[i + 1] = arr[i];
            arr[0] = v;
            System.out.println("ok");
        }
        
        public void pop_front() {
            
            if (size > 0) {
                System.out.println(arr[0]);
                for(int i = 1; i < size; i++)
                    arr[i - 1] = arr[i];
                arr[size] = arr[--size];
            } else
                System.out.println("error");
        }
        
        public void pop_back() {
            
            if (size > 0) {
                System.out.println(arr[--size]);
            } else
                System.out.println("error");
        }
        
        public void front() {
            if (size > 0)
                System.out.println(arr[0]);
            else
                System.out.println("error");;
        }
        public void back() {
            if (size > 0)
                System.out.println(arr[size - 1]);
            else
                System.out.println("error");;
        }
        
        public int size() {
            return size;
        }
        
        public void clear() {
            
            size = 0;
            System.out.println("ok");
        }
        
        public void exit() {
            System.out.println("bye");
        }
    }
    //
    public class Solution3 {
        
        public  void simpleDeque() {
            Deque dq = new Deque(1000);
            Scanner in = new Scanner(System.in);
            
            while(true) {
                String s = in.next();
                if (s.equals("push_back")) {
                    int n = in.nextInt();
                    dq.push_back(n);
                }
                
                else if (s.equals("push_front")) {
                    int n = in.nextInt();
                    dq.push_front(n);
                }
                else if (s.equals("pop_back")) {
                    dq.pop_back();
                }
                else if (s.equals("pop_front")) {
                    dq.pop_front();
                }
                else if (s.equals("front")) {
                    dq.front();
                }
                else if (s.equals("back")) {
                    dq.back();
                }
                else if (s.equals("size")) {
                    System.out.println(dq.size());
                }
                else if (s.equals("clear")) {
                    dq.clear();
                } else {
                    dq.exit();
                    break;
                }
            }
            
            in.close();
        }
    }
    
    //lab4_task4
    class Solution4 {
        public boolean isValid(String s) {
            boolean result = true;
            Stack<Character> checking = new Stack();
            for(char c:s.toCharArray()){
                if(c=='('){
                    checking.push(')');
                }
                else if(c=='{'){
                    checking.push('}');
                }
                else if(c=='['){
                    checking.push(']');
                }
                else if(checking.isEmpty()||checking.pop()!=c){
                    result = false;
                }
            }
            if (result){
                result = checking.isEmpty();
            }
            return result;
        }
    }
    
    //lab4_task5
    public class Solution5 {
    
        public  ArrayList<Integer> insertToMid(ArrayList<Integer> arr, int x) { 
            int i; 

            ArrayList<Integer> newarr = new ArrayList<>(); 

            for (i = 0; i < arr.size() + 1; i++) { 
                if (i < (arr.size() + 1) / 2) 
                    newarr.add(i, arr.get(i)); 
                else if (i == (arr.size() + 1) / 2) 
                    newarr.add(i, x); 
                else
                    newarr.add(i, arr.get(i - 1)); 
            } 
            return newarr; 
        }
        //
      public void GoblinsAndShamans() {
          Scanner in = new Scanner(System.in);

          int n = in.nextInt();
          String[] strs = new String[n + 1];
          for(int i = 0; i <= n; i++) {
              String str = in.nextLine();
              strs[i] = str;
          }

          int gone = 0;

          ArrayList<Integer> queueArr = new ArrayList<>();

          int i = 0;
          for (String s: strs) {
              if(s.contains("+")) {
                  queueArr.add(i, i + 1);
                  i++;
              } else if (s.contains("*")) {
                  queueArr = insertToMid(queueArr, i + 1);
                  i++;
              } else if (s.contains("-")) {
                  gone++;
              }
          }

          ArrayList<Integer> shamaned = new ArrayList<>();
          int j = 0;
          while (gone != 0) {
              shamaned.add(queueArr.get(j));
              gone--;
              j++;
          }

          System.out.println(shamaned);

      }

    }
    
    //lab4_task6
    class MinStack {

        private class Node {
            int val;
            int minVal;
            Node next;

            Node (int val, Node next) {
                this.val = val;
                this.next = next;
            }

            public void setMinVal(int minVal) {
                this.minVal = minVal;
            }

            public int getMinVal() {
                return this.minVal;
            }

        }

        private Node top;

        public MinStack() {
            top = null;
        }

        public void push(int x) {
            Node newNode = new Node(x, null);
            if(top == null || getMin() > x) {
                newNode.setMinVal(x);
            } else {
                newNode.setMinVal(getMin());
            }
            newNode.next = top;
            top = newNode;
        }

        public void pop() {
            top = top.next;
        }

        public int top() {
            return top.val;
        }

        public int getMin() {
            return top.getMinVal();
        }
    }

    //lab4_task7
    class Solution7 {
        public boolean backspaceCompare(String S, String T) {
            Stack<Character> stack1 = new Stack<>();
            Stack<Character> stack2 = new Stack<>();

            for(int i = 0; i < S.length(); i++) {
                if (S.charAt(i) != '#')
                    stack1.push(S.charAt(i));
                else if (!stack1.empty() && S.charAt(i) == '#')
                    stack1.pop();
            }

            for(int i = 0; i < T.length(); i++) {
                if (T.charAt(i) != '#')
                    stack2.push(T.charAt(i));
                else if (!stack2.empty() && T.charAt(i) == '#')
                    stack2.pop();
            }

            String res1 = "";
            String res2 = "";

            while (!stack1.empty()) {
                res1 += stack1.pop();
            }

            while (!stack2.empty()) {
                res2 += stack2.pop();
            }

              if(res1.equals(res2))
                  return true;
            return false;
        }
    }

    //lab4_task8
    class Solution8 {
    
        int toInt(String s) {
            int res = 0, i = 0;
            boolean sign = true;
            if (s.charAt(0) == '-') {
                sign = false;
                i++;
            }
            while (i < s.length()) {
                res = res * 10 + (s.charAt(i) - '0');
                i++;
            }
            if (!sign)
                res = -res;
            return res;
        }

        public int evalRPN(String[] tokens) {

            Stack<Integer> st = new Stack<>();

            for (String s: tokens) {
                switch (s) {
                  case "+":
                      {
                          int a = st.pop();
                          int b = st.pop();
                          st.push(a + b);
                          break;
                      }
                  case "*":
                      {
                          int a = st.pop();
                          int b = st.pop();
                          st.push(a * b);
                          break;
                      }
                  case "-":
                      {
                          int a = st.pop();
                          int b = st.pop();
                          st.push(b - a);
                          break;
                      }
                  case "/":
                      {
                          int a = st.pop();
                          int b = st.pop();
                          st.push(b / a);
                          break;
                      }
                  default:
                      int x = toInt(s);
                      st.push(x);
                      break;
              }
            }

            return st.pop();
        }
    }
}

