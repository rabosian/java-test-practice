import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MergeNames {
    public static String[] uniqueNames(String[] names1, String[] names2) {
        String[] merged = new String[names1.length + names2.length];
        System.arraycopy(names1, 0, merged, 0, names1.length);
        System.arraycopy(names2, 0, merged, names1.length, names2.length);

        Set<String> mySet = new HashSet<String>(Arrays.asList(merged));
        String[] newArray = mySet.toArray(new String[0]);
        
        return newArray;
    }

    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2)));
        // should print Ava, Emma, Olivia, Sophia
    }
}
