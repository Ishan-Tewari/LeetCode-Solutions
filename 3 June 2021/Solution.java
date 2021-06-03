class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        ArrayList<Integer> hDiff = new ArrayList<>();
        ArrayList<Integer> vDiff = new ArrayList<>();

        hDiff.add(horizontalCuts[0] - 0);
        vDiff.add(verticalCuts[0] - 0);


        for (int i = 0; i < horizontalCuts.length - 1; i++){
            hDiff.add(horizontalCuts[i+1] - horizontalCuts[i]);
        }
        hDiff.add(h - horizontalCuts[horizontalCuts.length - 1]);

        for (int i = 0; i < verticalCuts.length - 1; i++){
            vDiff.add(verticalCuts[i+1] - verticalCuts[i]);
        }
        vDiff.add(w - verticalCuts[verticalCuts.length - 1]);

        long maxH = 0;
        long maxV = 0;

        for (int diff : hDiff){
            maxH = Math.max(diff,maxH);
        }
        for (int diff : vDiff){
            maxV = Math.max(diff,maxV);
        }

        long M = 1000000007;
        return (int)((maxH * maxV) % M);
    }
}
