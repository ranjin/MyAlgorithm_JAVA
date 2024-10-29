package 查找和排序;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import 链表.LeeCode21_合并两个有序的链表.ListNode;


public class SortTest {

	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) {
			this.val = val;
		}
	}
	
	// 归并排序
	public void mergeSort(int[] nums, int begin, int end) {
	
		if (end - begin < 2) {
			return;
		}
		
		int mid = (end + begin) >> 1;
		
		mergeSort(nums, begin, mid);

		mergeSort(nums, begin, end);
		
		merge(nums, begin, mid, end);

	}
	
	
	// [1]  target: 1
    public int countTarget(int[] scores, int target) {
    	int left = 0, right = scores.length;
    	
    	int count = 0;
    	

    	for (int i = left; i < right; i++) {
			if (target == scores[i]) {
				count++;
				continue;
			}
		}
    	return count;

    	
    }
	public static void merge(int[] nums, int begin, int mid, int end) {
		// 备份左边数组
		
		int[] leftArr = new int[nums.length >> 1];
		
		int li = 0, le = mid - begin;
		int ri = mid, re = end;
		
		int ai = begin;
		
		for (int i = li; i < le; i++) {
			leftArr[i] = nums[begin + i];
		}
		
		while (li < le) {
			if (ri < re && leftArr[li] > nums[ri]) {
				nums[ai] = nums[ri];
				ai++;
				ri++;
			} else {
				nums[ai] = leftArr[li];
				li++;
				ai++;
			}
		}
	}
	// 快排，不断寻找轴节点的过程, 前序遍历
	public void quickSort(int[] array, int begin, int end) {
		if (end - begin < 2) {
			return;
		}
		
		int middle = findPartition(array, begin, end);
		
		quickSort(array, begin, middle);
		quickSort(array, middle + 1, end);
	}
	
	public static int findPartition(int[] array, int begin, int end) {
		int partition = array[begin];
		end--;
		// 默认从右向左
		
		
		while (end < begin) {
			while (end < begin) {
				if (array[end] > partition) {
					end--;
				} else {
					// array[end] <= 
					array[begin] = partition;
					begin++;
					break;
				}
			}
			
			while (end < begin) {
				if (array[begin] < partition) {
					begin++;
				} else {
					// array[end] <= 
					array[end] = partition;
					end--;
					break;
				}
			}
		}
		array[begin] = partition;
		return begin;
	}
	
	/**
	 * 合并两个有序链表
	 * 1 -> 2 -> 3
	 * 2 -> 3 -> 4
	 */
	
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    	if (list1 == null) {
			return list2;
		}
    	
    	if (list2 == null) {
			return list1;
		}
    	
    	ListNode dummy = new ListNode(-1);
    	
    	ListNode p = dummy;
    	ListNode p1 = list1, p2 = list2;
    	
    	while (p1 != null && p2 != null) {
			if (p1.val > p2.val) {
				p.next = p2;
				p2 = p2.next;
			} else {
				p.next = p1;
				p1 = p1.next;		
			}
			p = p.next;
		}
    	if (p1 == null) {
			p.next = p2;
		} 
    	
    	if (p2 == null) {
			p.next = p1;
		}
    	
    	
    	return dummy.next;
    	
    }


}