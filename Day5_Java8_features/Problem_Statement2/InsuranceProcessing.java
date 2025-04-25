import java.util.*;
import java.util.stream.Collectors;

class Policy {
    private String policyNumber;
    private String holderName;
    private double premiumAmount;

    public Policy(String policyNumber, String holderName, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() { return policyNumber; }
    public String getHolderName() { return holderName; }
    public double getPremiumAmount() { return premiumAmount; }

    public String toString() { return policyNumber + " - " + holderName + " - $" + premiumAmount; }
}

public class InsuranceProcessing {
    public static void main(String[] args) {
        List<Policy> policies = List.of(
                new Policy("P001", "Alice", 1300),
                new Policy("P002", "Bob", 800),
                new Policy("P003", "Charlie", 1500),
                new Policy("P004", "David", 2200),
                new Policy("P005", "Eve", 1700),
                new Policy("P006", "Smith", 1900),
                new Policy("P007", "Alex", 2100),
                new Policy("P008", "Michael", 950),
                new Policy("P009", "Sophia", 1750)
        );

        // 1. Filter Policies by Premium Amount
        List<Policy> highPremiumPolicies = policies.stream()
                .filter(p -> p.getPremiumAmount() > 1200)
                .collect(Collectors.toList());

        // 2. Sort Policies by Holder Name
        List<Policy> sortedPolicies = policies.stream()
                .sorted(Comparator.comparing(Policy::getHolderName))
                .collect(Collectors.toList());

        // 3. Compute Total Premium
        double totalPremium = policies.stream()
                .mapToDouble(Policy::getPremiumAmount)
                .sum();

        // 4. Print Policy Details
        policies.forEach(System.out::println);

        // 5. Filter Policies by Premium Range ($1000 - $2000)
        List<Policy> premiumRangePolicies = policies.stream()
                .filter(p -> p.getPremiumAmount() >= 1000 && p.getPremiumAmount() <= 2000)
                .collect(Collectors.toList());

        // 6. Find Policy with Highest Premium
        Optional<Policy> highestPremiumPolicy = policies.stream()
                .max(Comparator.comparingDouble(Policy::getPremiumAmount));

        // 7. Group Policies by Holder Name Initial
        Map<Character, List<Policy>> groupedByInitial = policies.stream()
                .collect(Collectors.groupingBy(p -> p.getHolderName().charAt(0)));

        // 8. Compute Average Premium
        double avgPremium = policies.stream()
                .mapToDouble(Policy::getPremiumAmount)
                .average().orElse(0);

        // 9. Sort Policies by Premium and Print
        policies.stream()
                .sorted(Comparator.comparingDouble(Policy::getPremiumAmount))
                .forEach(System.out::println);

        // 10. Check If Any Policy Exceeds $2000
        boolean anyHighPremium = policies.stream()
                .anyMatch(p -> p.getPremiumAmount() > 2000);

        // 11. Count Policies for Each Premium Range
        Map<String, Long> policyCountsByRange = policies.stream()
                .collect(Collectors.groupingBy(p -> {
                    if (p.getPremiumAmount() <= 1000) return "0-$1000";
                    else if (p.getPremiumAmount() <= 2000) return "$1001-$2000";
                    else return ">$2000";
                }, Collectors.counting()));

        // 12. Extract Unique Holder Names
        Set<String> uniqueHolderNames = policies.stream()
                .map(Policy::getHolderName)
                .collect(Collectors.toSet());

        // 13. Find Policies by Holder Name Substring
        List<Policy> matchingPolicies = policies.stream()
                .filter(p -> p.getHolderName().contains("Smith"))
                .collect(Collectors.toList());

        // 14. Create a Map of Policy Numbers to Premium Amounts
        Map<String, Double> policyPremiumMap = policies.stream()
                .collect(Collectors.toMap(Policy::getPolicyNumber, Policy::getPremiumAmount));

        // 15. Finding the Most Frequent Words in a Text Corpus
        String text = "Java is great. Java is powerful. Java is fun. Python is also great. Python is cool.";
        List<String> words = Arrays.stream(text.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+"))
                .collect(Collectors.toList());
        Map<String, Long> wordCounts = words.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        List<Map.Entry<String, Long>> topWords = wordCounts.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .collect(Collectors.toList());

        // 16. Find the Second Most Repeated Word
        Optional<Map.Entry<String, Long>> secondMostRepeated = wordCounts.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .skip(1)
                .findFirst();

        // Output Results
        System.out.println("\nHigh Premium Policies (> $1200): " + highPremiumPolicies);
        System.out.println("\nSorted Policies by Holder Name:");
        sortedPolicies.forEach(System.out::println);
        System.out.println("\nTotal Premium Amount: $" + totalPremium);
        System.out.println("\nPolicies with Premium between $1000-$2000: " + premiumRangePolicies);
        System.out.println("\nPolicy with Highest Premium: " + highestPremiumPolicy.orElse(null));
        System.out.println("\nGrouped Policies by Holder Name Initial:");
        groupedByInitial.forEach((initial, list) -> System.out.println(initial + ": " + list));
        System.out.println("\nAverage Premium Amount: $" + avgPremium);
        System.out.println("\nAny Policy Exceeds $2000? " + anyHighPremium);
        System.out.println("\nPolicy Counts by Premium Range: " + policyCountsByRange);
        System.out.println("\nUnique Holder Names: " + uniqueHolderNames);
        System.out.println("\nMatching Policies (Holder contains 'Smith'): " + matchingPolicies);
        System.out.println("\nPolicy Numbers to Premium Amounts: " + policyPremiumMap);
        System.out.println("\nTop 5 Most Frequent Words:");
        topWords.forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
        System.out.println("\nSecond Most Frequent Word: " + secondMostRepeated.orElse(null));
    }
}