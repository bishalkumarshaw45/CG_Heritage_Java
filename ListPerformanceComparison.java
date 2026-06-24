import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPerformanceComparison {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 10000; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        long arrayAccessTime = measureAccessTime(arrayList);
        long linkedAccessTime = measureAccessTime(linkedList);

        long arrayInsertTime = measureInsertAtZero(arrayList);
        long linkedInsertTime = measureInsertAtZero(linkedList);

        long arrayDeleteTime = measureDeleteAtZero(arrayList);
        long linkedDeleteTime = measureDeleteAtZero(linkedList);

        System.out.println("ArrayList access time: " + arrayAccessTime + " ms");
        System.out.println("LinkedList access time: " + linkedAccessTime + " ms");
        System.out.println();
        System.out.println("ArrayList insert at index 0 time: " + arrayInsertTime + " ms");
        System.out.println("LinkedList insert at index 0 time: " + linkedInsertTime + " ms");
        System.out.println();
        System.out.println("ArrayList delete at index 0 time: " + arrayDeleteTime + " ms");
        System.out.println("LinkedList delete at index 0 time: " + linkedDeleteTime + " ms");

        System.out.println();
        System.out.println("Comment: ArrayList is faster for indexed access because it stores elements in a contiguous array and can jump directly to index 5000.");
        System.out.println("LinkedList is typically faster for insert/delete at the beginning because it only updates node references, while ArrayList must shift many elements.");
    }

    private static long measureAccessTime(List<Integer> list) {
        long start = System.currentTimeMillis();
        list.get(5000);
        return System.currentTimeMillis() - start;
    }

    private static long measureInsertAtZero(List<Integer> list) {
        long start = System.currentTimeMillis();
        list.add(0, -1);
        long elapsed = System.currentTimeMillis() - start;
        list.remove(0);
        return elapsed;
    }

    private static long measureDeleteAtZero(List<Integer> list) {
        list.add(0, -1);
        long start = System.currentTimeMillis();
        list.remove(0);
        return System.currentTimeMillis() - start;
    }
}
