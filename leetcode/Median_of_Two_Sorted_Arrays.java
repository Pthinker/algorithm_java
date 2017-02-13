4. Median of Two Sorted Arrays

There are two sorted arrays nums1 and nums2 of size m and n respectively.
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5


// O(m+n)
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int[] tmp = new int[A.length + B.length];
        int i = 0;
        int j = 0;
        int index = 0;
        while(i<A.length && j<B.length) {
            if(A[i] <= B[j]) {
                tmp[index++] = A[i++];
            } else {
                tmp[index++] = B[j++];
            }
        }
        while(i<A.length) {
            tmp[index++] = A[i++];
        }
        while(j<B.length) {
            tmp[index++] = B[j++];
        }
        
        if(tmp.length % 2 == 0)
            return (tmp[tmp.length/2-1] + tmp[tmp.length/2]) / 2.0;
        else
            return tmp[tmp.length/2];
    }
}

////////////////////////////////////////////////////////////////////////////////

//O(log(min(m,n)))
//https://segmentfault.com/a/1190000002988010
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int k = (m + n) / 2;
        if((m+n)%2==0){
            return (findKth(nums1,nums2,0,0,m,n,k)+findKth(nums1,nums2,0,0,m,n,k+1))/2;
        } else {
            return findKth(nums1,nums2,0,0,m,n,k+1);
        }
    }
    
    private double findKth(int[] arr1, int[] arr2, int start1, int start2, int len1, int len2, int k){
        // 保证arr1是较短的数组
        if(len1>len2){
            return findKth(arr2,arr1,start2,start1,len2,len1,k);
        }
        if(len1==0){
            return arr2[start2 + k - 1];
        }
        if(k==1){
            return Math.min(arr1[start1],arr2[start2]);
        }
        int p1 = Math.min(k/2,len1) ;
        int p2 = k - p1;
        if(arr1[start1 + p1-1]<arr2[start2 + p2-1]){
            return findKth(arr1,arr2,start1 + p1,start2,len1-p1,len2,k-p1);
        } else if(arr1[start1 + p1-1]>arr2[start2 + p2-1]){
            return findKth(arr1,arr2,start1,start2 + p2,len1,len2-p2,k-p2);
        } else {
            return arr1[start1 + p1-1];
        }
    }
}
