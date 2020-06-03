package June2020_Challenge;

class ListNode
{
	int val;
	ListNode next;
	
	
	ListNode(int x)
	{
		val = x;
	}
	
	
}

public class DeleteNode {
	
public void deleteNode(ListNode node) {
        
        node.val = node.next.val;
        node.next = node.next.next;
        
        
    }

	public static void main(String[] args) {
		
		   
        

	}

}
