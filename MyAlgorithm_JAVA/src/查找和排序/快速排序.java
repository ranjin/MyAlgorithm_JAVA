package 查找和排序;

/**
 * 本质：不断的将每个元素都转换成轴点元素的过程。即：二叉树的前序遍历。
 * 使得分割点的左边所有的元素小于分割点，右边的元素总是大于分割点。
 * 
 * 如果把快速快速看作是一个构造二叉搜索树的过程。那么会出现一种极端情况：
 * 为了避免出现极端情况，需要引入随机性。
 * 时间复杂度：O(N*logN),空间复杂度：O(logN)
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
		int middle = findPartition(begin, end);
		sort(begin, middle);
		sort(middle + 1, end);
	}
	
	// 寻找分割点
	public int findPartition(int begin, int end) {
		// 备份轴点元素，后面会进行覆盖操作
		int partition = array[begin];
		end--;	// end指向最后一个元素
		while (begin < end) {
			while (begin < end) {
				// 默认从右向左
				if (array[end] > partition) {
					end--;
				} else {
					// 直接覆盖begin位置,begin往右,此时调换方向，从左往右扫描
					array[begin] = array[end];
					begin++;
					break;
				}
			}
			while (begin < end) {
				// 调换方向，从左向右
				if (array[begin] < partition) {
					begin++;
				} else {
					array[end] = array[begin];
					end--;
					break;
				}
			}
		}
		array[begin] = partition; // 备份
		return begin;
	}
}
