package com.example.bai2;

public class Staff {
    private final String staffId;
    private final String fullName;
    private final String birthDate;
    private final double salary;

    public Staff(String staffId, String fullName, String birthDate, double salary) {
        this.staffId = staffId;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.salary = salary;
    }

    public String getStaffId() {
        return staffId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public double getSalary() {
        return salary;
    }
}
