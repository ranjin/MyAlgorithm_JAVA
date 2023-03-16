package 查找和排序;

/**
 * 实质：快速排序就是不断寻找分割点的过程。
 * 使得分割点的左边所有的元素小于分割点，右边的元素总是大于分割点。
 * 实质其实也就是二叉树的前序遍历。
 * 如果把快速快速看作是一个构造二叉搜索树的过程。那么会出现一种极端情况：
 * 为了避免出现极端情况，需要引入随机性。
 * 时间复杂度：O(N*longN),空间复杂度：O(logN)
 * 极端情况下：时间复杂度：O(N^2), 空间复杂度：O(longN)
 * 是不稳定算法
 */
public class 快速排序 {
	int[] array;
	// [begin, end)
	public void sort(int begin, int end) {
		// 临界case：至少需要有2个元素
		if (end - begin < 2) {
			return;
		}	
		// begin元素的复制 pivot为分割点
		int middle = pivotIndex(begin, end);
		sort(begin, middle);
		sort(middle + 1, end);
	}
	
	// 寻找分割点
	public int pivotIndex(int begin, int end) {
		int pivot = array[begin];
		end--;	// end指向最后一个元素
		while (begin < end) {
			while (begin < end) {
				// 默认从右向左
				if (array[end] > pivot) {
					end--;
				} else {
					array[begin] = array[end];
					begin++;
					break;
				}
			}
			while (begin < end) {
				// 调换方向，从左向右
				if (array[begin] < pivot) {
					begin++;
				} else {
					array[end] = array[begin];
					end--;
					break;
				}
			}
		}
		array[begin] = pivot;
		return begin;
	}
}
