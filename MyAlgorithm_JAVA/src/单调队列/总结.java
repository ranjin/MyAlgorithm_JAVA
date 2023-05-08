package 单调队列;

// https://www.cnblogs.com/renkexz/p/13771960.html
import java.util.LinkedList;

/**
 * java中的LinkedList： 是Queue的实现类，是双向链表
 * @author ranjin
 *
 */
public class 总结 {

	// class MonotonicQueue
	// 双链表，支持头部和尾部增删元素
	// 维护其中的元素自尾部到头部单调递增
	// 普通队列：先进先出
	// 队列的获取跟删除：queue.pollFirst(); 删除头部元素, queue.pollLast(): 删除尾部元素
	public static class MonotonicQueue {
		private LinkedList<Integer> maxq = new LinkedList<>();
		// 入队：在队尾加入元素n，维护maxQ的单调性质 需要将前面比自己小的元素删除
		// 队尾 - 队头
		void push(int n) {
			while (!maxq.isEmpty() && maxq.getLast() < n) {
				maxq.pollLast();
			}
			maxq.addLast(n);
		}
		
		// 返回单调队列的最大元素,就是队头元素
		int max() {
			return maxq.getFirst();
		}
		// 出队：删除队头元素
		void pop(int n) {
			// 我们想删除的队头元素n可能已经不存在了，所以需要判断。
			if (n == maxq.getFirst()) {
				maxq.pollFirst();
			}
		}
	}
}
