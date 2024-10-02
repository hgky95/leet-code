# Odd Even Linked List

## Problem Description

Given the head of a singly linked list, reorder it by grouping all nodes with odd indices together followed by all nodes with even indices. Return the reordered list.

**Note:**
- The first node is considered odd, the second node even, and so on.
- Maintain the relative order within both odd and even groups.
- Solve the problem using O(1) extra space complexity and O(n) time complexity.

## Examples

### Example 1:

**Input:** `head = [1,2,3,4,5]`  
**Output:** `[1,3,5,2,4]`

### Example 2:

**Input:** `head = [2,1,3,5,6,4,7]`  
**Output:** `[2,3,6,7,1,5,4]`

## Constraints

- Number of nodes: `0 ≤ n ≤ 10^4`
- Node values: `-10^6 ≤ Node.val ≤ 10^6`