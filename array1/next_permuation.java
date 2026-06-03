/*
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
  */
import java.util.*;

// Solution class
class next_permutation {
    
    // Function to find next permutation
    public void nextPermutation(int[] nums) {
        int index = -1;

        // Find first decreasing element from right
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // If array is in descending order
        if (index == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        // Find next greater element and swap
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                swap(nums, i, index);
                break;
            }
        }

        // Reverse the remaining part
        reverse(nums, index + 1, nums.length - 1);
    }

    // Reverse helper
    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    // Swap helper
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

// Main class
public class next_permuation {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        Solution sol = new Solution();
        sol.nextPermutation(nums);

        System.out.print("Next Permutation: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
/*
### Next Permutation Algorithm (Short and Detailed)

1. **Find the Pivot**

   * Traverse from right to left.
   * Find the first index `i` such that:

     ```java
     nums[i] < nums[i + 1]
     ```
   * Store it in `index`.

2. **Check if Pivot Exists**

   * If no such index is found (`index == -1`):

     * The array is in descending order.
     * Reverse the entire array and return.

3. **Find Next Greater Element**

   * Traverse from the end of the array.
   * Find the first element greater than `nums[index]`.

4. **Swap**

   * Swap the pivot element with the element found in Step 3.

5. **Reverse the Suffix**

   * Reverse the subarray from `index + 1` to `n - 1`.
   * This makes the remaining part the smallest possible arrangement.

6. **Return Result**

   * The array now contains the next lexicographically greater permutation.

### Example

```java
nums = [1, 2, 3]
```

* Pivot = `2`
* Next greater element = `3`
* Swap → `[1, 3, 2]`
* Reverse suffix → `[1, 3, 2]`

**Output:**

```java
[1, 3, 2]
```

### Complexity

* **Time Complexity:** `O(N)`
* **Space Complexity:** `O(1)`
 */