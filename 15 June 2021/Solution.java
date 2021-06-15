class Solution {

    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) return false;

        int sum = 0;
        for(int matchstick : matchsticks) sum += matchstick;
        int side = sum / 4;

        if (sum % 4 != 0) return false;

        return helper(0,matchsticks,new int[]{side, side, side, side});
    }

    public boolean helper(int i, int[] matchsticks, int[] sides){

        if (i == matchsticks.length){
            if (sides[0] == 0 && sides[1] == 0 && sides[2] == 0 && sides[3] == 0) return true;

            return false;
        }

        for (int j = 0; j < sides.length; j++){
            if (matchsticks[i] > sides[j]) continue;

            sides[j] -= matchsticks[i];
            if (helper(i+1, matchsticks, sides)) return true;
            sides[j] += matchsticks[i];
        }

        return false;
    }

}
