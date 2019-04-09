package com.example.myapplication;

public class Entitlements extends Tax {
    int dependencies;
    int age;

    public Entitlements(Double weeklyexpenses, int age, Double hours, Double rate, Double PRSI, Double gross, Double pay, Double usc, Double netpay, String firstname, String surname, String dob, String id, String address, String ppsnumber, Double taxCredit, Double taxablePay, Double overTime, Double healthInsurance, Double unionSubs) {
        super(hours, rate, PRSI, gross, pay, usc, netpay, firstname, surname, dob, id, address, ppsnumber, taxCredit, taxablePay, overTime, healthInsurance, unionSubs);
        this.dependencies = dependencies;
        this.age = age;
    }

    public Entitlements() {
        this.dependencies = 0;
        this.age = 0;
    }

    public void setDependencies(int dependencies) {
        this.dependencies = dependencies;
    }

	public int  getDependencies(){return age;}

    public void setAge(int age) {
        this.age = age;
    }
    

    public int getAge() {
        return age;
    }


}
