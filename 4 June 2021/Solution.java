class Solution {
    public int openLock(String[] deadends, String target) {

        // convert to hashset for ease of use
        HashSet<String> deadEnds = new HashSet<>(Arrays.asList(deadends));

        // taking visited hashset
        HashSet<String> visited = new HashSet<>();

        // initialize the queue
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");

        // initialize moves
        int moves = 0;

        // add neighbours while queue is not empty
        while(!queue.isEmpty()){
            int size = queue.size();

            while (size != 0){

                String currentPosition = queue.poll();

                // check if current position is in deadends or is already visited
                if (deadEnds.contains(currentPosition) || visited.contains(currentPosition)){
                    size--;
                    continue;
                }

                // add to visited if not already visited
                visited.add(currentPosition);

                // check if current position is the ans
                if (currentPosition.equals(target)) return moves;

                // add to the queue all the neighbours of current position
                StringBuilder sb = new StringBuilder(currentPosition);
                for (int i = 0; i < 4; i++){
                    char wheelValue = sb.charAt(i);

                    String s1 = sb.substring(0,i) + (wheelValue == '9' ? 0 : wheelValue - '0' + 1)
                        + sb.substring(i+1);

                    String s2 = sb.substring(0,i) + (wheelValue == '0' ? 9 : wheelValue - '0' - 1)
                        + sb.substring(i+1);

                    // System.out.println(s1 + "\n" + s2 + "\n");

                    // add the neighbours to the queue
                    if (!visited.contains(s1) && !deadEnds.contains(s1)){
                        queue.add(s1);
                    }
                    if (!visited.contains(s2) && !deadEnds.contains(s2)){
                        queue.add(s2);
                    }

                }

                size--;
            }

            moves++;
        }

        return -1;
    }
}
