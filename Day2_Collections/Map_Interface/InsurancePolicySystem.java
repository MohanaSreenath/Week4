import java.util.*;

class Policy {
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

    public String getPolicyholderName() {
        return policyholderName;
    }

    public String toString() {
        return policyNumber + " - " + policyholderName + " - " + coverageType + " - $" + premiumAmount + " - Expiry: " + expiryDate;
    }
}

public class InsurancePolicySystem {
    private Map<String, Policy> hashMap = new HashMap<>();
    private Map<String, Policy> linkedHashMap = new LinkedHashMap<>();
    private Map<Date, Policy> treeMap = new TreeMap<>();

    public void addPolicy(Policy policy) {
        hashMap.put(policy.getPolicyNumber(), policy);
        linkedHashMap.put(policy.getPolicyNumber(), policy);
        treeMap.put(policy.getExpiryDate(), policy);
    }

    public Policy getPolicy(String policyNumber) {
        return hashMap.get(policyNumber);
    }

    public void listPoliciesExpiringSoon() {
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.DAY_OF_YEAR, 30);
        Date threshold = cal.getTime();

        for (Policy policy : treeMap.values()) {
            if (policy.getExpiryDate().before(threshold)) {
                System.out.println(policy);
            }
        }
    }

    public void listPoliciesByHolder(String name) {
        for (Policy policy : hashMap.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(name)) {
                System.out.println(policy);
            }
        }
    }

    public static void main(String[] args) {
        InsurancePolicySystem system = new InsurancePolicySystem();
        Calendar cal = Calendar.getInstance();

        cal.add(Calendar.DAY_OF_YEAR, 10);
        system.addPolicy(new Policy("P001", "Alice", cal.getTime(), "Health", 1200));

        cal.add(Calendar.DAY_OF_YEAR, 15);
        system.addPolicy(new Policy("P002", "Bob", cal.getTime(), "Auto", 800));

        system.listPoliciesExpiringSoon();
        system.listPoliciesByHolder("Alice");
    }
}