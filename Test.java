给定一个字符串，逐个翻转字符串中的每个单词。
class Solution {
    public String reverseWords(String s) {
        char[] c=s.toCharArray();
        String tmp=trim(c);
        char[] chars=tmp.toCharArray();
        int left=0;
        for(int j=0;j<=chars.length;j++){
            if(j==chars.length||chars[j]==' '){
                reverse(chars,left,j-1);
                left=j+1;
            }
        }
        reverse(chars,0,chars.length-1);
        return new String(chars);
    }
    private void reverse(char[] chars,int left,int right){
        while(left<right){
            char tmp=chars[left];
            chars[left++]=chars[right];
            chars[right--]=tmp;
        }
    }
    private String trim(char[] c){
        int i=0;
        StringBuilder sb=new StringBuilder();
        while(i<c.length){
            while(i!=c.length&&c[i]==' '){
                i++;
            }
            while(i!=c.length&&c[i]!=' '){
                sb.append(c[i++]);
            }
            while(i!=c.length&&c[i]==' '){
                i++;
            }
            if(i!=c.length){
                sb.append(" ");
            }
        }
         return new String(sb);
    }
}


给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

注意:
不能使用代码库中的排序函数来解决这道题。
class Solution {
    public void sortColors(int[] nums) {
        int p0=0;
        int p2=nums.length-1;
        int cur=0;
        while(cur<=p2){
            if(nums[cur]==0){
                int t=nums[cur];
                nums[cur++]=nums[p0];
                nums[p0++]=t;
            }else if(nums[cur]==2){
                int t=nums[cur];
                nums[cur]=nums[p2];
                nums[p2--]=t;
            }else{
                cur++;
            }
        }
    }
}

在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
class Solution {
    private int res;
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums,0,nums.length-1,k);
        return res;
    }
    private void quickSort(int[] nums,int left,int right,int k){
        if(left>right){
            return;
        }
        int p=partition(nums,left,right);
        if(p==k-1){
            res=nums[p];
            return;
        }else if(p>k-1){
            quickSort(nums,left,p-1,k);
        }else{
            quickSort(nums,p+1,right,k);
        }
    }
    private int partition(int[] nums,int left,int right){
        int pivot=nums[left];
        int i=left;
        int j=right;
        while(i<j){
            while(i<j&&nums[j]<=pivot){
                j--;
            }
            nums[i]=nums[j];
            while(i<j&&nums[i]>=pivot){
                i++;
            }
            nums[j]=nums[i];
        }
        nums[i]=pivot;
        return i;
    }
}

峰值元素是指其值大于左右相邻值的元素。

给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。

数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。

你可以假设 nums[-1] = nums[n] = -∞。
class Solution {
    public int findPeakElement(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<nums[mid+1]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }
}

给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res=new int[]{-1,-1};
        if(nums.length==0) return res;
        //右区间
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid=left+(right-left+1)/2;
            if(nums[mid]>target){
                right=mid-1;
            }else{
                left=mid;
            }
        }
        if(nums[left]!=target) return res;
        res[1]=left;
        //左区间
        left=0;
        right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        res[0]=left;
        return res;
    }
}

