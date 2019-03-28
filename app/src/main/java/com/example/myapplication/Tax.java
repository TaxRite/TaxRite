package com.example.myapplication;

import java.io.Serializable;

public class Tax implements Serializable {
    private Double hours;
    private Double rate;
    private Double PRSI;
    private Double gross;
    private Double paye;
    private Double usc;
    private Double netpay;
    private Double taxCredit;
    private Double healthInsurance;
    private Double unionSubs;
    private Double overTime;
    private Double taxablePay;

    //overloaded constructor
    public Tax(Double hours, Double rate, Double PRSI, Double gross, Double pay, Double usc, Double netpay, String firstname, String surname, String dob, String id, String address, String ppsnumber, Double taxCredit, Double taxablePay, Double overTime, Double healthInsurance, Double unionSubs) {

        this.hours = hours;
        this.rate = rate;
        this.PRSI = PRSI;
        this.gross = gross;
        this.paye = pay;
        this.usc = usc;
        this.netpay = netpay;
        this.taxCredit = taxCredit;
        this.healthInsurance = healthInsurance;
        this.unionSubs = unionSubs;
        this.overTime = overTime;
        this.taxablePay = taxablePay;

    }
//default constractor

    public Tax() {
        //set initial valuees too zero
        hours = 0.0;
        rate = 0.0;
        PRSI = 0.0;
        gross = 0.0;
        netpay = 0.0;
        usc = 0.0;
        taxCredit = 0.0;
        healthInsurance = 0.0;
        unionSubs = 0.0;
        taxablePay = 0.0;
        overTime = 0.0;
        paye = 0.0;
    }


    public Double gross() {
        return gross = hours * rate;// create formula to calculate gross

    }
    public Double gross1() {
        Double gross1;
        return gross1=gross *4.0;// create formula to calculate gross

    }
    public Double gross2() {
        Double gross2;
        return gross2= gross*52.0;// create formula to calculate gross

    }

    public Double taxablePay() {
        return taxablePay = gross + overTime;// create formula to calculate taxable pay
    }
    public Double taxablePay1() {
        return (taxablePay) *4;// create formula to calculate taxable pay

    }
    public Double taxablePay2() {
        return taxablePay *4*12;// create formula to calculate taxable pay
    }
    public Double prsi() {

        return PRSI = taxablePay * 0.04;// create formula to calculate prsi

    }
    public Double prsi1() {

        return PRSI*4;

    }
    public Double prsi2() {

        return PRSI*52;

    }

    public Double usc() {// create formula to caculate usc
        if (taxablePay <= 231) {
            usc = taxablePay * 0.01;
        } else if (taxablePay > 359 && taxablePay <= 1347) {
            usc = (((taxablePay - 359) * 0.055) + 6.15);
        } else {
            usc = ((taxablePay - 1337) * 0.07) + (6.15 + 54.34);
        }
        return usc;
    }
    public Double usc1() {// create formula to caculate usc
        if (taxablePay <= 231) {
            usc = taxablePay * 0.01;
        } else if (taxablePay > 359 && taxablePay <= 1347) {
            usc = (((taxablePay - 359) * 0.055) + 6.15);
        } else {
            usc = ((taxablePay - 1337) * 0.07) + (6.15 + 54.34);
        }
        return usc*4;
    }
    public Double usc2() {// create formula to caculate usc
        if (taxablePay <= 231) {
            usc = taxablePay * 0.01;
        } else if (taxablePay > 359 && taxablePay <= 1347) {
            usc = (((taxablePay - 359) * 0.055) + 6.15);
        } else {
            usc = ((taxablePay - 1337) * 0.07) + (6.15 + 54.34);
        }


        return usc*52;
    }

    public Double paye() {// create formula to calculate pay
        if (taxablePay <= 650) {
            paye = taxablePay * 0.2;
        } else if (taxablePay > 650) {
            paye = ((taxablePay - 650) * 0.4) + 130;
        }
        return paye;
    }
    public Double paye1() {// create formula to calculate pay

        return paye*4;
    }
    public Double paye2() {// create formula to calculate pay

        return paye*52;
    }

    public Double netpay() {// craete formula to calculate netpay

        netpay = taxablePay - (paye - taxCredit + PRSI + usc + unionSubs + healthInsurance);

        return netpay;
    }
    public Double netpay1() {// create formula to calculate netpay
        Double netpay1;

        return netpay1= netpay*4;
    }
    public Double netpay2() {// create formula to calculate netpay
        Double netpay2;

        return netpay2= netpay*52;
    }

    //setter and getters
    public void setHours(Double hours) {
        this.hours = hours;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public void setGross(Double gross) {
        this.gross = gross;
    }

    public Double getOverTime() {
        return overTime;
    }

    public Double getTaxablePay() {
        return taxablePay;
    }

    public void setOverTime(Double overTime) {
        this.overTime = overTime;
    }

    public void setTaxablePay(Double taxablePay) {
        this.taxablePay = taxablePay;
    }

    public void setPRSI(Double PRSI) {
        this.PRSI = PRSI;
    }

    public Double getPRSI() {
        return PRSI;
    }

    public Double getPaye() {
        return paye;
    }

    public Double getUsc() {
        return usc;
    }

    public Double getNetpay() {
        return netpay;
    }

    public Double getTaxCredit() {
        return taxCredit;
    }

    public Double getHealthInsurance() {
        return healthInsurance;
    }

    public Double getUnionSubs() {
        return unionSubs;
    }

    public void setPaye(Double pay) {
        this.paye = paye;
    }

    public void setUsc(Double usc) {
        this.usc = usc;
    }

    public void setNetpay(Double netpay) {
        this.netpay = netpay;
    }

    public void setTaxCredit(Double taxCredit) {
        this.taxCredit = taxCredit;
    }

    public void setHealthInsurance(Double healthInsurance) {
        this.healthInsurance = healthInsurance;
    }

    public void setUnionSubs(Double unionSubs) {
        this.unionSubs = unionSubs;
    }

    public Double getHours() {
        return hours;
    }

    public Double getRate() {
        return rate;
    }

    public Double getGross() {
        return gross;
    }
    public String weekly() {
        // return  "\n hours: " + hours + "\n rate: " + rate + "\n prsi:" + PRSI + "\n usc: " + usc + "\n taxCredit: " + taxCredit + "\n health insurance: " + healthInsurance + "\n union subs: " + unionSubs + "\n";// create method called employeed details that enherits the parameters of base class
        return  "\n Gross pay: " + gross() + "" + "\n Taxable pay: " + taxablePay()+ "" + "\n PRSI: " + prsi()+ "" + "\n USC: " + usc() + "" + "\n PAYE: " + paye()+ "" + "\n Net pay: " + netpay();
    }
    public String monthly() {
        return  "\n Gross pay: " + gross1() + "" + "\n Taxable pay: " + taxablePay1()+ "" + "\n PRSI: " + prsi1()+ "" + "\n USC: " + usc1() + "" + "\n PAYE: " + paye1()+ "" + "\n Net pay: " + netpay1();
    }
    public String annual() {
        return  "\n Gross pay: " + gross2() + "" + "\n Taxable pay: " + taxablePay2()+ "" + "\n PRSI: " + prsi2()+ "" + "\n USC: " + usc2() + "" + "\n PAYE: " + paye2()+ "" + "\n Net pay: " + netpay2();
    }
}
