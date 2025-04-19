import java.util.*;

class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    public String toString() {
        return policyNumber + " - " + policyholderName + " - " + coverageType + " - $" + premiumAmount + " - Expiry: " + expiryDate;
    }
}

public class InsurancePolicySystem {
    public static void main(String[] args) {
        Set<Policy> hashSet = new HashSet<>();
        Set<Policy> linkedHashSet = new LinkedHashSet<>();
        Set<Policy> treeSet = new TreeSet<>();

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 10);
        Policy p1 = new Policy("P001", "Alice", cal.getTime(), "Health", 1200);

        cal.add(Calendar.DAY_OF_YEAR, 15);
        Policy p2 = new Policy("P002", "Bob", cal.getTime(), "Auto", 800);

        cal.add(Calendar.DAY_OF_YEAR, 40);
        Policy p3 = new Policy("P003", "Charlie", cal.getTime(), "Home", 1500);

        hashSet.add(p1);
        hashSet.add(p2);
        hashSet.add(p3);

        linkedHashSet.add(p1);
        linkedHashSet.add(p2);
        linkedHashSet.add(p3);

        treeSet.add(p1);
        treeSet.add(p2);
        treeSet.add(p3);

        System.out.println("All Unique Policies (HashSet): " + hashSet);
        System.out.println("Policies in Insertion Order (LinkedHashSet): " + linkedHashSet);
        System.out.println("Policies Sorted by Expiry Date (TreeSet): " + treeSet);
    }
}