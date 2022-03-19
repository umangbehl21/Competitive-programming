package hardlevel;
public class BringThemTogetherMinSwap {                     
        // Function for finding maximum and value pair
        public static int minSwap (int arr[], int n, int k) {    //Dry run
           int count = 0;                                        //2,7,9,5,8,7,4
           for(int i = 0;i < n;i++)    //finding the favourable elements  which is less than k in the array by incrementing count
           {
              if(arr[i] <= k)
              {
                  count++;
              }
           }
           int bad = 0;  
           for(int i = 0;i<count;i++)  //now if there are 3 favourable elements our window size will be three and we will check for the unfavourable elements(which are greater than k) in that window
           {
               if(arr[i] > k)  
               {
                  bad++; 
               }
           }
           int ans = bad;  //initialising ans with the total number of bad elements in first window
           for(int i = 0,j = count;j < n;i++,j++)
           {
               if(arr[i] > k)   //now if we are shifting window one step ahead from the 0th index we will check whether the element on that index is unfavourable if it is unfavourable we will decrement one bad element 
               {
                   bad--;
               }
               if(arr[j] > k)  //now if we are adding new element in our window and that element is unfavorable we will increment the count
               {
                   bad++;
               }
               ans = Math.min(ans,bad); //after adding and decreasing bad element in every new window we will check minimum bad elements present in a particular window and initialise ans to it
           }
        return ans;
        }
        
        
    }
    
