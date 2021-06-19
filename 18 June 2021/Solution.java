class NumArray {

    SegmentTreeNode root = null;
    public NumArray(int[] nums) {
        root = buildTree(nums, 0 , nums.length - 1);
    }

    public SegmentTreeNode buildTree(int[] nums, int start, int end){

        SegmentTreeNode root = new SegmentTreeNode(start, end);

        if (start == end){
            root.sum = nums[start];
            return root;
        }

        int mid = start + (end - start) / 2;  // (start + end)/2
        root.left = buildTree(nums, start, mid);
        root.right = buildTree(nums, mid+1, end);
        root.sum = root.left.sum + root.right.sum;

        return root;
    }

    public void update(int index, int val) {
        updateHelper(root, index, val);
    }

    public void updateHelper(SegmentTreeNode root, int index, int val){

        if (root.start == root.end){
            root.sum = val;
            return;
        }

        int mid = root.start + (root.end - root.start) / 2;

        if (index <= mid) updateHelper(root.left, index, val);
        else updateHelper(root.right, index, val);

        root.sum = root.left.sum + root.right.sum;
    }

    public int sumRange(int left, int right) {
        return calculateSum(root, left, right);
    }

    public int calculateSum(SegmentTreeNode root, int from, int to){

        if (root.start == from && root.end == to) return root.sum;

        int mid = root.start + (root.end - root.start) / 2;

        if (to <= mid) return calculateSum(root.left, from, to);

        else if (from > mid) return calculateSum(root.right, from, to);

        else return calculateSum(root.left, from, mid) + calculateSum(root.right, mid+1, to);
    }
}

public class SegmentTreeNode{
    int start,end;
    SegmentTreeNode left, right;
    int sum;

    SegmentTreeNode(int start, int end){
        this.start = start;
        this.end = end;
        this.left = null;
        this.right = null;
        this.sum = 0;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
