import java.util.*;

public class VotingSystem {
    private Map<String, Integer> hashMap = new HashMap<>();
    private Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
    private Map<String, Integer> treeMap = new TreeMap<>();

    public void vote(String candidate) {
        hashMap.put(candidate, hashMap.getOrDefault(candidate, 0) + 1);
        linkedHashMap.put(candidate, linkedHashMap.getOrDefault(candidate, 0) + 1);
        treeMap.put(candidate, treeMap.getOrDefault(candidate, 0) + 1);
    }

    public void displaySortedResults() {
        System.out.println("Sorted Results: " + treeMap);
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        system.vote("Alice");
        system.vote("Bob");
        system.vote("Alice");

        system.displaySortedResults();
    }
}