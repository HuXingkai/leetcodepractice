package com.company;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(-1);
        ListNode tail = listNode;
        int tar = 0;
        while (l1 != null && l2 != null) {
            int num = l1.val + l2.val + tar;
            if (num >= 10) {
                num -= 10;
                tar = 1;
            } else tar = 0;

            tail.next = new ListNode(num);
            l1 = l1.next;
            l2 = l2.next;
            tail=tail.next;
        }
        while (l1 != null) {
            int num = l1.val + tar;
            if (num >= 10) {
                num -= 10;
                tar = 1;
            } else tar = 0;
            tail.next = new ListNode(num);
            l1 = l1.next;
            tail=tail.next;
        }
        while (l2 != null) {
            int num = l2.val + tar;
            if (num >= 10) {
                num -= 10;
                tar = 1;
            } else tar = 0;
            tail.next = new ListNode(num);
            l2 = l2.next;
            tail=tail.next;
        }
        if (tar == 1) {
            tail.next = new ListNode(1);
        }
        return listNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode ans=new AddTwoNumbers().addTwoNumbers(l1,l2);
        System.out.println(ans);

    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}