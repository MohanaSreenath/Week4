class PolicyHolder {
    private int holderId;
    private String name;
    private int age;
    private String policyType;
    private double premiumAmount;

    public PolicyHolder(int holderId, String name, int age, String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }

    public int getHolderId() { return holderId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getPolicyType() { return policyType; }
    public double getPremiumAmount() { return premiumAmount; }
    public double getRiskScore() { return premiumAmount / age; }
}

public class RiskAssessment1 {
    public static void main(String[] args) {
        List<PolicyHolder> holders = List.of(
                new PolicyHolder(1, "Alice", 65, "Life", 30000),
                new PolicyHolder(2, "Bob", 70, "Life", 25000),
                new PolicyHolder(3, "Charlie", 55, "Health", 15000)
        );

        List<PolicyHolder> highRiskHolders = holders.stream()
                .filter(h -> h.getPolicyType().equals("Life") && h.getAge() > 60)
                .sorted(Comparator.comparingDouble(PolicyHolder::getRiskScore).reversed())
                .collect(Collectors.toList());

        System.out.println("High Risk Policy Holders:");
        highRiskHolders.forEach(h -> System.out.println(h.getName() + " - Risk Score: " + h.getRiskScore()));
    }
}