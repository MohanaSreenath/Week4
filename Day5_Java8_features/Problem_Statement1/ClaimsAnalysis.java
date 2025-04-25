import java.util.stream.Collectors;

class Claim {
    private String policyNumber;
    private double claimAmount;
    private String status;

    public Claim(String policyNumber, double claimAmount, String status) {
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.status = status;
    }

    public String getPolicyNumber() { return policyNumber; }
    public double getClaimAmount() { return claimAmount; }
    public String getStatus() { return status; }

    public String toString() { return policyNumber + " - $" + claimAmount; }
}

public class ClaimsAnalysis {
    public static void main(String[] args) {
        List<Claim> claims = List.of(
                new Claim("POL001", 7000, "Approved"),
                new Claim("POL002", 4000, "Rejected"),
                new Claim("POL003", 9000, "Approved"),
                new Claim("POL001", 3000, "Approved"),
                new Claim("POL003", 2000, "Approved")
        );

        Map<String, Double> totalClaimsByPolicy = claims.stream()
                .filter(c -> c.getStatus().equals("Approved") && c.getClaimAmount() > 5000)
                .collect(Collectors.groupingBy(Claim::getPolicyNumber, 
                        Collectors.summingDouble(Claim::getClaimAmount)));

        System.out.println("Total Claim Amounts by Policy:");
        totalClaimsByPolicy.forEach((policy, amount) -> System.out.println(policy + ": $" + amount));
    }
}