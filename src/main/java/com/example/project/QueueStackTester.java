package com.example.project;

public class QueueStackTester {
    public static <T> void split(Queue<T> q, Queue<T> oq, Queue<T> eq)
    {
        if (oq.length() + eq.length() == q.length())
            return;
        
        T tmp = q.serve();
        q.enqueue(tmp);
        if ((oq.length() + eq.length()) % 2 == 0)
            oq.enqueue(tmp);
        else
            eq.enqueue(tmp);
        split(q, oq, eq);
    }
    public static <T> void remove(LinkedPQ<T> pq, int p)
    {
        T[] dataArr = (T[]) new Object[pq.length()];
        int[] prioArr = new int[pq.length()];
        int count = 0;
        while (pq.length() != 0) {
            PQElement<T> tmp = pq.serve();
            if (tmp.p >= p) {
                dataArr[count] = tmp.data;
                prioArr[count] = tmp.p;
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
            pq.enqueue(dataArr[i], prioArr[i]);
        }
    }
    public static <T> boolean search(Stack<T> st, T e)
    {
        if (st.empty())
            return false;
        
        T tmp = st.pop();
        if (tmp == e) {
            st.push(tmp);
            return true;
        }
        boolean result = search(st, e);
        st.push(tmp);
        return result;
    }
}