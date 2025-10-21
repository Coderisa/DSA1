class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // Min-heap: sort by frequency ascending, then lexicographically descending
        PriorityQueue<String> heap = new PriorityQueue<>((a, b) -> {
            int freqCompare = freqMap.get(a) - freqMap.get(b);
            if (freqCompare == 0) {
                return b.compareTo(a); // reverse lexicographical for min-heap
            }
            return freqCompare;
        });

        for (String word : freqMap.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll(); // remove least frequent or lexicographically largest
            }
        }

        // Build result in reverse order
        LinkedList<String> result = new LinkedList<>();
        while (!heap.isEmpty()) {
            result.addFirst(heap.poll());
        }

        return result;
    }
}
