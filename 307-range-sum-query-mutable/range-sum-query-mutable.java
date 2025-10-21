class NumArray {
    private int[] tree;
    private int[] nums;
    private int n;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.tree = new int[4 * n]; // Segment tree size
        buildTree(0, 0, n - 1);
    }

    private void buildTree(int node, int start, int end) {
        if (start == end) {
            tree[node] = nums[start];
        } else {
            int mid = (start + end) / 2;
            buildTree(2 * node + 1, start, mid);
            buildTree(2 * node + 2, mid + 1, end);
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    public void update(int index, int val) {
        updateTree(0, 0, n - 1, index, val);
    }

    private void updateTree(int node, int start, int end, int idx, int val) {
        if (start == end) {
            nums[idx] = val;
            tree[node] = val;
        } else {
            int mid = (start + end) / 2;
            if (idx <= mid) {
                updateTree(2 * node + 1, start, mid, idx, val);
            } else {
                updateTree(2 * node + 2, mid + 1, end, idx, val);
            }
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    public int sumRange(int left, int right) {
        return queryTree(0, 0, n - 1, left, right);
    }

    private int queryTree(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return 0; // No overlap
        }
        if (l <= start && end <= r) {
            return tree[node]; // Total overlap
        }
        int mid = (start + end) / 2;
        int leftSum = queryTree(2 * node + 1, start, mid, l, r);
        int rightSum = queryTree(2 * node + 2, mid + 1, end, l, r);
        return leftSum + rightSum;
    }
}
