class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> geneBank = new HashSet<>(Arrays.asList(bank));
        if (!geneBank.contains(endGene)) return -1;

        char[] genes = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(startGene);
        visited.add(startGene);
        int mutations = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(endGene)) return mutations;

                char[] currArray = current.toCharArray();
                for (int j = 0; j < currArray.length; j++) {
                    char original = currArray[j];
                    for (char g : genes) {
                        if (g == original) continue;
                        currArray[j] = g;
                        String mutated = new String(currArray);
                        if (geneBank.contains(mutated) && !visited.contains(mutated)) {
                            queue.offer(mutated);
                            visited.add(mutated);
                        }
                    }
                    currArray[j] = original; // restore
                }
            }
            mutations++;
        }

        return -1;
    }
}
