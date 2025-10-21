class Solution {
    private Map<Integer, Integer> freqMap = new HashMap<>();
    private int maxFreq = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        postOrder(root);

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == maxFreq) {
                result.add(entry.getKey());
            }
        }

        // Convert list to array
        int[] resArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resArray[i] = result.get(i);
        }
        return resArray;
    }

    private int postOrder(TreeNode node) {
        if (node == null) return 0;

        int leftSum = postOrder(node.left);
        int rightSum = postOrder(node.right);
        int totalSum = node.val + leftSum + rightSum;

        int count = freqMap.getOrDefault(totalSum, 0) + 1;
        freqMap.put(totalSum, count);
        maxFreq = Math.max(maxFreq, count);

        return totalSum;
    }
}
