

/*
Problem statement: Given an array arr[] of size N, You have to print the arrangement of the array such that upon performing following operations on that arrangement, an increasing order is obtained as the output:

 Take the first (0th index) element, remove it from the array and print it.
If there are elements left in the array, move the next top element to the end of the array.
Repeat the above steps until array is not empty.
Input:
First line of input contains a single integer T which denotes the number of test cases. First line of each test case contains a single integer N which denotes the size of the array. Second line of each test case contains N space separated integers denoting values of the array.

Output:
For each test case , print the newly arranged array .
Your Task:
Complete the function arrangement() which accepts given array as parameter and returns such array when we perform given operations on it , an increasing order of integers is obtained.
Constraints:
1 <= T <= 100
1 <= N <= 104
1 <= Arr[i] <= 105
Example:
Input:
2
4
7 5 2 4 
7
4 4 5 1 7 2 8 
Output:
2 5 4 7 
1 7 2 5 4 8 4 
Explanation:
Test Case 1: Performing operations on [ 2 5 4 7 ] , we got [2 4 5 7 ] which is in increasing order.
 
*/


class Sol
{
    static public int[] arrangement(int[] arr) 
    {
        // code here.
        int n = arr.length;
        Arrays.sort(arr);
        Queue<Integer> que = new LinkedList<>(); 

        for(int i =n-1;i>=0;i--){
            if(que.isEmpty()){
               que.offer(arr[i]); 
            }else if(i!=0){
                 que.offer(arr[i]);
                 int a= que.poll();
                 que.offer(a);
            }else{
                que.offer(arr[i]);
            }
        }
        int[] arr1 = new int[n];
        for(int i=n-1;i>=0;i--){
            arr1[i]=que.poll();
        }
        
        return arr1;
        
    }
}

/*
the solution is based on the reverse programing with a execution time of  3 sec and o(n) , output is achieved by retracing the expected result to yeild the expected output.
We haave used aa queue to maintain the insertion ordr  and store the data. for example we have 
1 7 2 5 4 8 4       // 1 is poped
  7 2 5 4 8 4       // 7 is moved to last of the queue
  2 5 4 8 4 7       // again 2 is poped from it
    5 4 8 4 7
    4 8 4 7 5
      8 4 7 5
      4 7 5 8
        7 5 8
        5 8 7
          8 7
          7 8
            8


*/



