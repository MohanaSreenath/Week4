package Bridgelabz.Generics;

import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    private String roleName;

    public JobRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }
}

class Resume<T extends JobRole> {
    private String candidateName;
    private T jobRole;

    public Resume(String candidateName, T jobRole) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public T getJobRole() {
        return jobRole;
    }
}

class ResumeScreeningSystem {
    private List<Resume<? extends JobRole>> resumes = new ArrayList<>();

    public void addResume(Resume<? extends JobRole> resume) {
        resumes.add(resume);
    }

    public List<Resume<? extends JobRole>> getResumes() {
        return resumes;
    }

    public static void displayResumes(List<? extends JobRole> jobRoles) {
        for (JobRole role : jobRoles) {
            System.out.println("Processing resumes for: " + role.getRoleName());
        }
    }
}

public class Resume {
    public static void main(String[] args) {
        ResumeScreeningSystem system = new ResumeScreeningSystem();

        Resume<SoftwareEngineer> seResume = new Resume<>("Alice", new SoftwareEngineer());
        Resume<DataScientist> dsResume = new Resume<>("Bob", new DataScientist());
        Resume<ProductManager> pmResume = new Resume<>("Charlie", new ProductManager());

        system.addResume(seResume);
        system.addResume(dsResume);
        system.addResume(pmResume);

        System.out.println("Resumes in the system:");
        for (Resume<? extends JobRole> resume : system.getResumes()) {
            System.out.println(resume.getCandidateName() + " applied for " + resume.getJobRole().getRoleName());
        }
    }
}