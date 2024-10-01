# 2095. Delete the Middle Node of a Linked List

## Problem Description

You are given the head of a linked list. Your task is to delete the middle node and return the head of the modified linked list.

The middle node of a linked list with size n is defined as the ⌊n / 2⌋th node from the start, using 0-based indexing. Here, ⌊x⌋ denotes the largest integer less than or equal to x.

For example:
- For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.

## Examples

### Example 1

**Input:** head = [1,3,4,7,1,2,6]
**Output:** [1,3,4,1,2,6]

**Explanation:**
- The linked list has 7 nodes.
- Node 3 (value 7) is the middle node.
- After removing this node, we return the modified list.

### Example 2

**Input:** head = [1,2,3,4]
**Output:** [1,2,4]

**Explanation:**
- The linked list has 4 nodes.
- Node 2 (value 3) is the middle node.
- We return the list after removing this node.

### Example 3

**Input:** head = [2,1]
**Output:**

**Explanation:**
- The linked list has 2 nodes.
- Node 1 (value 1) is the middle node.
- After removal, only node 0 (value 2) remains.

## Constraints

- The number of nodes in the list is in the range [1, 10^5].
- 1 ≤ Node.val ≤ 10^5

## Notes

- Remember to handle edge cases, such as lists with only one or two nodes.
- Consider using the fast and slow pointer technique for an efficient solution.

Citations:
[1] https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/?envType=study-plan-v2&envId=leetcode-75