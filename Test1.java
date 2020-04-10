假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。
class Solution {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>=nums[left]){
                if(target>=nums[left]&&target<=nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else {
                if(target>=nums[mid]&&target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }
}

编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：

每行的元素从左到右升序排列。
每列的元素从上到下升序排列。
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        if(row==0) return false;
        int col=matrix[0].length;
        if(col==0) return false;
        int i=0;
        int j=col-1;
        while(i<row&&j>=0){
            if(matrix[i][j]==target){
                return true;
            }else if(matrix[i][j]>target){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
}

给出一个区间的集合，请合并所有重叠的区间。
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int i=0;
        int n=intervals.length;
        while(i<n){
            int left=intervals[i][0];
            int right=intervals[i][1];
            while(i<n-1&&right>=intervals[i+1][0]){
                right=Math.max(right,intervals[i+1][1]);
                i++;
            }
            list.add(new int[]{left,right});
            i++;
        }
        return list.toArray(new int[list.size()][2]);
    }
}

给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> queue=new PriorityQueue<>(
            new Comparator<Integer>(){
                public int compare(Integer a,Integer b){
                    return map.get(a)-map.get(b);
                }
            }
        );
        for(int i:map.keySet()){
            queue.offer(i);
            if(queue.size()>k){
                queue.poll();
            }
        }
        LinkedList<Integer> res=new LinkedList<>();
        while(!queue.isEmpty()){
            res.addFirst(queue.poll());
        }
        return res;
    }
}

