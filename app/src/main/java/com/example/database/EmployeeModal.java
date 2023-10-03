package com.example.database;

public class EmployeeModal {

        private String empName;
        private String empDepartment;
        private String empLoginId;
        private String empPassword;
        private String empId;

        // creating getter and setter methods


    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDepartment() {
        return empDepartment;
    }

    public void setEmpDepartment(String empDepartment) {
        this.empDepartment = empDepartment;
    }

    public String getEmpLoginId() {
        return empLoginId;
    }

    public void setEmpLoginId(String empLoginId) {
        this.empLoginId = empLoginId;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String courseId) {
        this.empId = courseId;
    }

    // constructor
        public EmployeeModal(
                String empName,
                           String empDepartment,
                           String empLoginId,
                           String empPassword)
        {

            this.empName = empName;
            this.empDepartment = empDepartment;
            this.empLoginId = empLoginId;
            this.empPassword = empPassword;
        }
    }


