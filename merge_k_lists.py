# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:

    #k = len(lists)
    #n = total number of nodes in all linked lists
    #O(log(k) * n)
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if len(lists) == 0:
            return None

        def mergeLists(lists, start, end):
            if start == end:
                return lists[end]
            mid = int(start + (end - start) / 2)
            first = mergeLists(lists, start, mid)
            second = mergeLists(lists, mid + 1, end)
            return merge(first, second)

        def merge(first, second):
            if first is None:
                return second
            if second is None:
                return first
            if first.val < second.val:
                first.next = merge(first.next, second)
                return first
            else:
                second.next = merge(second.next, first)
                return second

        return mergeLists(lists, 0, len(lists) - 1)