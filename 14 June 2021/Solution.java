class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {

        // sort the array
        Arrays.sort(boxTypes, (int[] box1, int[] box2) -> box2[1] - box1[1]);

        int ans = 0;
        int spaceLeft = truckSize;
        for (int i = 0; i < boxTypes.length; i++){

            // check if there's enough space left for all of the boxes of type i to be
            // placed in the truck
            if (spaceLeft - boxTypes[i][0] >= 0){
                ans += boxTypes[i][0] * boxTypes[i][1];
            }

            // if space unavailable, then fill until truck is full
            else{
                ans += spaceLeft * boxTypes[i][1];
                break;
            }

            spaceLeft -= boxTypes[i][0];
        }

        return ans;
    }
}
