import java.util.Set;

public class SetSubset {

    public static <T> boolean isSubset(Set<T> subset, Set<T> superset) {
        return superset.containsAll(subset);
    }

    public static void main(String[] args) {
        Set<Integer> set1 = Set.of(2, 3);
        Set<Integer> set2 = Set.of(1, 2, 3, 4);

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println("Is Set1 a Subset of Set2: " + isSubset(set1, set2));
    }
}