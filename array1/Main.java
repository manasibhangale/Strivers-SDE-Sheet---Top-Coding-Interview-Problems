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
public class Main {
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