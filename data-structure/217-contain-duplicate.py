'''
Challenge
https://leetcode.com/problems/contains-duplicate/

Given an integer array nums,
return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true

Example 2:
Input: nums = [1,2,3,4]
Output: false
'''

from typing import List


def containsDuplicate(nums: List[int]) -> bool:
    is_duplicated = False
    for idx, num in enumerate(nums):
        for num2 in nums[idx + 1:]:
            if num == num2:
                is_duplicated = True
                break
    return is_duplicated


print(containsDuplicate(nums=[1, 2, 3, 4, 1, 5]))
