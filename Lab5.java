package acm_labs;

import java.util.HashSet;
import java.util.Set;

public class Lab5 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; 
        }
    }
    
    //lab5_task1
    class Solution1 {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    //lab5_task2
    class Solution2 {
        public ListNode reverseList(ListNode head) {
            ListNode current = head;
            ListNode prev = null;
            while (current != null) {
                ListNode tmp = current.next;
                current.next = prev;
                prev = current;
                current = tmp;
            }

            return prev;
        }
    }

    //lab5_task3
    class Solution3 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode result = new ListNode(0);
            ListNode head = result;

            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    head.next = l1;
                    l1 = l1.next;
                } else {
                    head.next = l2;
                    l2 = l2.next;
                }
                head = head.next;
            }

            if (l1 == null && l2 != null)
                head.next = l2;

            if (l1 != null && l2 == null)
                head.next = l1;

            return result.next;
        }
    }

    //lab5_task4
    class Solution4 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode result = new ListNode(0);
            ListNode head = result;

            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    head.next = l1;
                    l1 = l1.next;
                } else {
                    head.next = l2;
                    l2 = l2.next;
                }
                head = head.next;
            }

            if (l1 == null && l2 != null)
                head.next = l2;

            if (l1 != null && l2 == null)
                head.next = l1;

            return result.next;
        }
    }

    //lab5_task5
    class Solution5 {
        public ListNode partition(ListNode head, int x) {

            ListNode beforeHead = new ListNode(0);
            ListNode before = beforeHead;
            ListNode afterHead = new ListNode(0);
            ListNode after = afterHead;

            while (head != null) {

                if (head.val < x) {
                    before.next = head;
                    before = before.next;
                } else {
                    after.next = head;
                    after = after.next;
                }

                head = head.next;
            }

            after.next = null;
            before.next = afterHead.next;

            return beforeHead.next;
        }
    }

    //lab5_task6
    public class Solution6 {
        
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            Set<ListNode> nodes = new HashSet<>();

            ListNode curA = headA;
            while (curA != null) {
                nodes.add(curA);
                curA = curA.next;
            }

            if (nodes.isEmpty())
                return null;

            ListNode curB = headB;
            while (curB != null) {
                if (nodes.contains(curB))
                    return curB;

                curB = curB.next;    
            }

            return null;
        }
    }

    //lab5_task7
    class Solution7 {
    
        public ListNode reverseList(ListNode head) {
            ListNode current = head;
            ListNode prev = null;
            while (current != null) {
                ListNode tmp = current.next;
                current.next = prev;
                prev = current;
                current = tmp;
            }

            return prev;
        }

        public int getSize(ListNode head) {
            int cnt = 0;
            ListNode current = head;
            while (current != null) {
                cnt++;
                current = current.next;
            }

            return cnt;
        }


        public boolean isPalindrome(ListNode head) {

            if (head == null)
                return true;

            int size = getSize(head);
            if (size == 1)
                return true;

            ListNode current = head;
            int i = 1;
            while (i < (size + 1) / 2 + 1) {
                i++;
                current = current.next;
            }

            ListNode R = reverseList(current);
            ListNode L = head;
            i = 1;

            while (i <= size / 2) {
                if (L.val != R.val)
                    return false;
                L = L.next;
                R = R.next;
                i++;
            }

            return true;
        }
    }
    
    //lab5_task8
    class Solution8 {
        public ListNode sortList(ListNode head) {
            if(head == null || head.next == null)
                return head;

            ListNode tmp = head;
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                tmp = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            tmp.next = null;

            ListNode left_side = sortList(head);
            ListNode right_side = sortList(slow);

            return merge(left_side, right_side);
        } 

        public ListNode merge(ListNode l1, ListNode l2) {

            ListNode sorted_tmp = new ListNode(0);
            ListNode current = sorted_tmp;

            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    current.next = l1;
                    l1 = l1.next;
                } else {
                    current.next = l2;
                    l2 = l2.next;
                }

                current = current.next;
            }

            if (l1 != null) {
                current.next = l1;
                l1 = l1.next;
            }

            if (l2 != null) {
                current.next = l2;
                l2 = l2.next;
            }

            return sorted_tmp.next;
        }
    }
}
