import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    // use hashmap O(N)
    public static int[] findTwoSum(int[] list, int sum) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for(int i=0;i<list.length;i++) {
            int finish = sum - list[i]; // finish: list[i]와 더해서 sum이 되는 값
            if (numMap.containsKey(finish)) { // 그 값이 hashmap에 있으면 return
                return new int[] { numMap.get(finish), i};
            } else { // 없으면 hashmap에 저장
                numMap.put(list[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 3, 1, 3, 7, 5, 9 }, 10);
        if(indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }
}
