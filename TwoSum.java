/**
Question：
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/

/**
O(n) complexity
*/
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        assert(len >= 2); // 判断数据是否合法 Judge whether the length of the array is legal.
        int[] result = new int[2]; // 记录最后的结果 Record the final result.
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); // 用于插入、查找 Used for insert and lookup at the same time.
        
        for(int i = 0; i < len; i++) {
            if(!map.containsKey(numbers[i])) { // 新数据则插入 Insert the <target-number, i>
                map.put(target - numbers[i], i);
            }
           else{ // 使用else，不用if判断，找到则返回 Use if rather than else-if for time saving,  
                 //for if the better way to move it out of for loop.
                int index = map.get(numbers[i]);
                result[0] = index + 1; // 下标大小关系直接确定 The index must be the smaller than i.
                result[1] = i + 1;
                break; // 退出循环，返回结果 Exit the for loop and return the result.
            }
        }
        return result;
    }
}
