class MyCalendar$Brute {
    int n = 0;
    int[] st = new int[1000];
    int[] en = new int[1000];

    public MyCalendar$Brute() {
    }

    public boolean book(int start, int end) {
        for (int i = 0; i < n; i++)
            if ((start <= en[i] && start >= st[i]) || (end - 1 >= st[i] && end - 1 <= en[i]) || end - start <= 0
                    || (start <= st[i] && end - 1 >= en[i]) || (start >= st[i] && end - 1 <= en[i]))
                return false;

        st[n] = start;
        en[n] = end - 1;
        n++;
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such: MyCalendar
 * obj = new MyCalendar(); boolean param_1 = obj.book(start,end);
 */