package 二叉堆;

/**
 * 分最大堆和最小堆(每个节点都小于等于它的子节点)
 * 主要操作：sink(下沉)和swim(上浮)，用以维护二叉堆的性质。
 * 应用：
 * 1. 堆排序
 * 2. 优先级队列(Priority Queue)
 * 
 * 二叉堆与二叉树的关系：
 * 二叉堆其实就是一种特殊的二叉树(完全二叉树)，只不过存储在数组里。
 * 一般的链表二叉树，我们操作节点的指针，而在数组里，我们把数组索引作为指针。
 * 
 * 
 * 回顾：完全二叉树的一些特性
 * 索引i的规律(n是元素数量)
 * 1>. 如果i = 0, 它是根节点
 * 2>. 如果i > 0, 它的父节点的索引为floor((i-1)/2)
 * 
 * 如果2i + 1 <= n-1, 它的左子节点为2i + 1
 * 如果2i + 1 > n-1, 它没有左子节点
 * 如果2i + 2 <= n-1, 它的右子节点为2i + 2
 * 如果2i + 2 > n-1, 它没有右子节点
 * @author ran
 *
 */

public class BinaryHeap_01 <Key extends Comparable<Key>>{

	// 存储元素的数组
	private Key[] pq;
	
	// 当前Priority Queue中的元素个数
	private int N = 0;
	
	public void MaxPQ(int cap) {
		// 索引0不用，所以多分配一个空间
		pq = (Key[]) new Comparable[cap + 1];
	}
	
	// 返回当前队列中的最大元素
	public Key max() {
		return pq[1];
	}
	// 父节点的索引
	int parent(int root) {
		return root / 2;
	}
	
	// 左子节点的索引
	int left(int root) {
		return root * 2;
	}
	
	// 右子节点的索引
	int right(int root) {
		return root * 2 + 1;
	}
	
	
	private boolean less(int i, int j) {
		return i < j;
	}
	
	private void exch(int i, int j) {
		int temp = i;
		i = j;
		j = temp;
	}
	// 上浮第k个元素，以维护最大堆性质
	private void swim(int k) {
		// 如果浮到堆顶，就不能再上浮了
		while (k > 1 && less(parent(k), k)) {
			// 如果第k个元素比上层大
			exch(parent(k), k);
			// k 替换父节点
			k = parent(k);
		}
	}
	
	// 下沉第k个元素，以维护最大堆性质
	private void sink(int k) {
		// 如果沉到堆底，就沉不下去了(为叶子节点) 100为数组元素数量
		while (left(k) <= 100) {
			// 先假设左边节点较大
			int older = left(k);
			// 如果右边节点存在，比较大小
			if (right(k) <= 100 && less(older, right(k))) {
				older = right(k);
			}
			// 节点k比左右节点都大，不用下沉
			if (less(older, k)) {
				break;
			}
			// 否则，不符合最大堆性质，下沉k节点
			exch(older, k);
			k = older;
		}
	}
	
	/**
	 * insert实现
	 * insert方法先把要插入的元素添加到堆底的最后，然后让其上浮到正确位置
	 */
	public void insert(Key e) {
		N++;
		pq[N] = e;
		swim(N);
	}
	
	/**
	 * delMax实现
	 * 互换堆顶元素A和堆底最后的元素B。然后删除A，最后将B下沉(sink)到正确位置
	 */
	public Key delMax() {
		// 最大堆的堆顶就是最大元素
		Key max = pq[1];
		// 将最大元素与最后元素互换
		exch(1, N);
		pq[N] = null;
		N--;
		sink(1);
		return max;
	}
}
/**
 * 二叉堆的巧妙之处：
 * 数组的第一个索引0空着不用，
 * 那么把arr[1]作为整棵树的根的话，每个节点的父节点和左右孩子的索引
 * 都可以通过简单的运算得到。
 */

/**
 * 总结：
 * 至此，一个优先级队列就实现了，插入和删除元素的时间复杂度为O(logK), k为二叉堆中的元素。
 * 时间主要花费在sink或者swim上。而不管是上浮还是下沉，最多也就是树的高度。也就是log级别。
 * 优先级队列是基于二叉堆实现的：
 * 主要操作是插入和删除：
 * 插入：insert先将元素添加到最后，元素个数+1.将最后的这个元素上浮到正确位置
 * 删除：调换头尾两个元素，将尾部元素删除，将新的头部元素下沉到正确位置。
 * 二叉树。牛皮的
 */
