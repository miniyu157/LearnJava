package com.klxpiao.learn.LearnCollection;

public class LearnDeque {
    public static void main(String[] args) {
        /*
        	                Queue	                Deque
        添加元素到队尾	    add(E e) / offer(E e)	addLast(E e) / offerLast(E e)
        取队首元素并删除	    E remove() / E poll()	E removeFirst() / E pollFirst()
        取队首元素但不删除	E element() / E peek()	E getFirst() / E peekFirst()
        添加元素到队首	    无	                    addFirst(E e) / offerFirst(E e)
        取队尾元素并删除	    无	                    E removeLast() / E pollLast()
        取队尾元素但不删除	无	                    E getLast() / E peekLast()


        Queue提供的add()/offer()方法在Deque中也可以使用，但是，使用Deque，最好不要调用offer()，而是调用offerLast()：
        因此，使用Deque，推荐总是明确调用offerLast()/offerFirst()或者pollFirst()/pollLast()方法。

        */


    }
}
