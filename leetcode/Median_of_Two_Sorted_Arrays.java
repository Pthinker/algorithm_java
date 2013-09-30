There are two sorted arrays A and B of size m and n respectively. Find the median of 
the two sorted arrays. The overall run time complexity should be O(log(m+n)).


// O(m+n)
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
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

public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = A.length;
        int n = B.length;
        int median1 = (m + n) / 2 + 1;
        int median2 = (m + n - 1) / 2 + 1;
        return (findKth(A, 0, m, B, 0, n, median1) + findKth(A, 0, m, B, 0, n,
                median2)) / 2f;
    }

    private int findKth(int a[], int as, int ae, int b[], int bs, int be, int k) {
        int m = ae - as;
        int n = be - bs;
        if (m == 0) {
            return b[bs + k - 1];
        } else if (n == 0) {
            return a[as + k - 1];
        }
        if (m == 1 && n == 1) {
            if (k == 1) {
                return Math.min(a[as], b[bs]);
            } else {
                return Math.max(a[as], b[bs]);
            }
        }
        if (k == m + n) {
            return Math.max(a[ae - 1], b[be - 1]);
        }
        float ratio = k * m * 1f / (m + n);
        int i = Math.round(m * ratio);
        i = fit(i, 0, m - 1);
        i = fit(i, k - 1 - n, k - 1);
        int j = k - 1 - i;
        if (a[as + i] > b[bs + j]) {
            return findKth(a, as, as + i, b, bs + j, be, k - j);
        } else {
            return findKth(a, as + i, ae, b, bs, bs + j, k - i);
        }
    }

    private int fit(int a, int lower, int upper) {
        if (a < lower)
            return lower;
        else if (a > upper)
            return upper;
        else
            return a;
    }
}
