class Solution {
    public int maxResult(int[] nums, int k) {

        // initializing the dp array
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        // initalizing max heap
        PriorityQueue<Node> maxHeap = new PriorityQueue<>((Node n1, Node n2) -> n2.value - n1.value);
        maxHeap.add(new Node(nums[0],0));

        // filling dp array
        for (int i = 1; i < nums.length; i++){

            // checking if we are jumping k or less steps only
            while (!maxHeap.isEmpty() && maxHeap.peek().index < i-k){
                maxHeap.remove();
            }

            // adding the max score of the last ans to our dp array
            dp[i] = nums[i] + maxHeap.peek().value;

            // adding current answer to dp table
            maxHeap.add(new Node(dp[i],i));
        }

        return dp[dp.length - 1];
    }
}

class Node{
    int value;
    int index;

    Node(int value, int index){
        this.value = value;
        this.index = index;
    }
}
