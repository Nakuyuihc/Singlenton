package leetcode;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.List;

public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        List<Integer> a = Arrays.asList(1,2,3);
        List<Integer> b = Arrays.asList(4,5,6,7);
        addTwoNumbers.addTwoNumbers(a,b);
        addTwoNumbers.addTwoNumbers1(a,b);
    }

    public void addTwoNumbers(List<Integer> a,List<Integer> b){
        int i = 0;
        int j = 0;
        for(int k = 0 ; k < a.size(); k++){
            i += a.get(k) * Math.pow(10,k);
        }
        for(int k = 0 ; k < b.size(); k++){
            j += b.get(k) * Math.pow(10,k);
        }
        System.out.println(i + j);
        String[] c = String.valueOf(i + j).split("");
        CollectionUtils.reverseArray(c);
        System.out.println(Arrays.toString(c));
    }

    public void addTwoNumbers1(List<Integer> a,List<Integer> b){
        int i = 0;
        int j = 0;
        int length = a.size() > b.size()? a.size() :b.size();
        for(int k = 0 ; k < length; k++){
            if(a.size() > k) {
                i += a.get(k) * Math.pow(10,k);
            }
            if(b.size() > k) {
                j += b.get(k) * Math.pow(10,k);
            }
        }
        System.out.println(i + j);
        String[] c = String.valueOf(i + j).split("");
        CollectionUtils.reverseArray(c);
        System.out.println(Arrays.toString(c));
    }

/*    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }*/
}
