package LinkList;

/**
 * Created by AKHIL on 08-Apr-16.
 */
class Node {
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class LLHasCycle {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = head.next.next;
        System.out.println("Loop Length of Cycle is:"+ListLengthOfLoop(head));
        //printList(head);
        boolean hasCycle= HasCycle(head);
        System.out.println("LinkList has cycle: " +hasCycle);
    }

    private static int ListLengthOfLoop(Node head) {
        if(head==null)
            return 0;
        Node first = head;
        Node second = head;
        while(first!=null && second!=null){
            first = first.next;
            second = second.next;
            if(first != null){
                first = first.next;
            }
//            System.out.println("First Data:"+first.data);
//            System.out.println("Second Data:"+second.data);
            if(first == second){
                System.out.println("The loop detects that it has cycle at node:" + first.data);
                second = head;
                break;
            }
        }
        int count = 1 ;
        while(first != second){
            first = first.next;
            second = second.next;
            count+=2;
        }
        System.out.println("The loop starts cycle at node:" + first.data);
        return count;
    }

    static void printList(Node head){
        if(head == null)
            return;
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    static boolean HasCycle(Node head) {
        Node fast, slow;
        slow = fast = head;
        while (fast != null && slow != null) {
            fast = fast.next;
            slow = slow.next;
            if (fast != null) {
                fast = fast.next;
            }
            if (fast == slow)
                return true;
        }
        return false;
    }
}

