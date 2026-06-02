/*Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 

Constraints:

1 <= numRows <= 30*/
import java.util.*;
class pascals_triangle{
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> triangle= new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> row= new ArrayList<>(Collections.nCopies(i+1,1));
            for(int j=1;j<i;j++){
                row.set(j,triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j));
            }
            triangle.add(row);
        }
        return triangle;
    }
}
/*
ascal's Triangle (LeetCode 118) – Short Algorithm
Create an empty 2D list triangle.
For each row i from 0 to numRows - 1:
Create a row of size i + 1 filled with 1s.

For each middle element j (1 to i - 1):

row.set(j,
    triangle.get(i-1).get(j-1)
    + triangle.get(i-1).get(j));
Add the row to triangle.
Return triangle.
Key Idea
First and last elements are always 1.
Middle element = Upper Left + Upper Right.
 */