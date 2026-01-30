# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        cur = head
        count = 0
        while cur is not None:
            count += 1
            cur = cur.next

        index = count - n
        if index == 0:
            head = head.next
            return head

        counter = 0
        cur = head
        prev = None
        while cur is not None:
            if counter == index:
                prev.next = prev.next.next

            counter += 1
            prev = cur
            cur = cur.next

        return head