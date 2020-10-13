package tree;

public class RangeSumQueryMutable {
    private interface Merger<E> {
        E merge(E left, E right);
    }

    private class SegmentTree<E> {

        private final E[] data;
        private final E[] tree;
        private final Merger<E> merger;

        public SegmentTree(E[] arr, Merger<E> merger){
            this.merger = merger;
            data = (E[])new Object[arr.length];
            for (int i = 0; i < arr.length; i++) {
                data[i] = arr[i];
            }
            tree = (E[]) new Object[4 * arr.length];
            buildSegmentTree(0, 0, data.length - 1);


        }

        /**
         * 在treeIndex的位置创建表示区间[l...r]的线段树
         * @param treeIndex
         * @param l
         * @param r
         */
        private void buildSegmentTree(int treeIndex, int l, int r){
            if(l == r){
                tree[treeIndex] = data[l];
                return;
            }

            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);

            int mid = l + (r - l) / 2;  //不使用mid = (l + r) / 2 的原因是防止l+r溢出
            buildSegmentTree(leftTreeIndex, l, mid);
            buildSegmentTree(rightTreeIndex, mid + 1, r);

            // tree[treeIndex] = tree[leftTreeIndex] + tree[rightTreeIndex]; 这里tree[treeIndex]的值取决于业务场景，根据业务场景，自由组合逻辑。这里+号报错的原因是E类型不一定实现了加法
            // 通过一个Merger接口来实现逻辑
            tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
        }

        public int getSize(){
            return data.length;
        }

        public E get(int index){
            return data[index];
        }

        public int leftChild(int index){
            return 2 * index + 1;
        }

        public int rightChild(int index){
            return 2 * index + 2;
        }

        public E query(int queryL, int queryR){
            return query(0, 0, data.length - 1, queryL, queryR);
        }

        /**
         * 在以treeIndex为根节点的线段树[l...r]中，查找[queryL...queryR]的值
         * @param treeIndex
         * @param l
         * @param r
         * @param queryL
         * @param queryR
         * @return
         */
        private E query(int treeIndex, int l, int r, int queryL, int queryR){
            if(l == queryL && r == queryR)
                return tree[treeIndex];

            int mid = l + (r - l) / 2;
            int leftIndex = leftChild(treeIndex);
            int rightIndex = rightChild(treeIndex);
            if(queryL >= mid + 1)
                return query(rightIndex, mid + 1, r, queryL, queryR);
            else if(queryR <= mid)
                return query(leftIndex, l, mid, queryL, queryR);

            return merger.merge(query(leftIndex, l, mid, queryL, mid), query(rightIndex, mid + 1, r, mid + 1, queryR));
        }

        public void set(int index, E e){
            data[index] = e;
            set(0, 0, data.length - 1, index, e);
            // 另外一种思路：
            // 计算出更新后index节点的值与更新前index节点的差值
            // 将差值传到递归函数中，只要是线段树节点的区间中包含更新节点的index，就把线段树中该节点的值加上差值即可。

        }

        /**
         * 在以treeIndex为根结点的线段树[l...r]中，更新index的值
         * @param treeIndex
         * @param l
         * @param r
         * @param index
         * @param e
         */
        private void set(int treeIndex, int l, int r, int index, E e){
            if(l == r){
                tree[treeIndex] = e;
                return;
            }

            int mid = l + (r - l) / 2;
            int leftIndex = leftChild(treeIndex);
            int rightIndex = rightChild(treeIndex);

            if(index >= mid + 1){
                set(rightIndex, mid + 1, r, index, e);
            }else{
                set(leftIndex, l, mid, index, e);
            }

            tree[treeIndex] = merger.merge(tree[leftIndex], tree[rightIndex]);
        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            res.append("[");
            for (int i = 0; i < tree.length; i++) {
                if(tree[i] != null)
                    res.append(tree[i]);
                else
                    res.append("null");
                if(i != tree.length - 1)
                    res.append(", ");
                else
                    res.append("]");
            }
            return res.toString();
        }
    }

    class NumArray {
        private SegmentTree<Integer> segTree;
        public NumArray(int[] nums) {
            if(nums.length > 0){
                Integer[] data = new Integer[nums.length];
                for (int i = 0; i < nums.length; i++) {
                    data[i] = nums[i];
                }
                segTree = new SegmentTree<Integer>(data, (a, b) -> a + b);
            }

        }
        public void update(int i, int val) {
            if(segTree != null){
                segTree.set(i, val);
            }
        }

        public int sumRange(int i, int j) {
            if(segTree == null)
                return 0;
            return segTree.query(i, j);

        }
    }
//    class NumArray {
//        private int[] data;
//        private int[] sum;
//
//        public NumArray(int[] nums) {
//            data = new int[nums.length];
//            sum = new int[nums.length + 1];
//            for (int i = 0; i < nums.length; i++) {
//                data[i] = nums[i];
//            }
//            sum[0] = 0;
//            for (int i = 1; i < sum.length; i++) {
//                sum[i] = data[i - 1] + sum[i - 1];
//            }
//
//        }
//
//        public void update(int i, int val) {
//            int diff = val - data[i];
//            data[i] = val;
//            for (i = i + 1; i < sum.length; i++) {
//                sum[i] += diff;
//            }
//        }
//
//        public int sumRange(int i, int j) {
//            return sum[j + 1] - sum[i];
//        }
//    }
}
