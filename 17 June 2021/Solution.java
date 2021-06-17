class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {

        int l = 0;
        int r = 0;
        int ans = 0;
        int windowSize = 0;
        while (r < nums.length){

            if (nums[r] >= left && nums[r] <= right){
                windowSize = r-l + 1;
            }
            else if (nums[r] > right){
                l = r+1;
                windowSize = 0;
            }

            ans += windowSize;
            r++;
        }

        return ans;
    }
}
