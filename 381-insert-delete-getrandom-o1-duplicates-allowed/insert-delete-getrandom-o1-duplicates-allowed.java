import java.util.*;

class RandomizedCollection {
    private List<Integer> nums;
    private Map<Integer, Set<Integer>> valToIndices;
    private Random rand;

    public RandomizedCollection() {
        nums = new ArrayList<>();
        valToIndices = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        boolean notPresent = !valToIndices.containsKey(val);
        valToIndices.putIfAbsent(val, new HashSet<>());
        valToIndices.get(val).add(nums.size());
        nums.add(val);
        return notPresent;
    }

    public boolean remove(int val) {
        if (!valToIndices.containsKey(val) || valToIndices.get(val).isEmpty()) return false;

        // Get an index of the val to remove
        int indexToRemove = valToIndices.get(val).iterator().next();
        valToIndices.get(val).remove(indexToRemove);

        int lastIndex = nums.size() - 1;
        int lastVal = nums.get(lastIndex);

        // Swap with last element if not removing the last one
        if (indexToRemove != lastIndex) {
            nums.set(indexToRemove, lastVal);
            valToIndices.get(lastVal).remove(lastIndex);
            valToIndices.get(lastVal).add(indexToRemove);
        }

        nums.remove(lastIndex);

        // Clean up map if no more indices
        if (valToIndices.get(val).isEmpty()) {
            valToIndices.remove(val);
        }

        return true;
    }

    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
