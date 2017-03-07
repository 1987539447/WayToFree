package com.github.siemen.generics;

import java.time.LocalDate;


/**
 * Created by Zhan on 2017/3/7 0007.
 * <T>
 * <T extends xx>
 * <?>
 * <? extends xx>
 * <? super xxx>
 */
public class PairTest {

    public static void main(String[] args) {
        Manager ceo = new Manager("Jack",8000,2015,12,01);
        Manager cfo = new Manager("Rose",6000,2015,12,01);
        Pair<Manager> buddies = new Pair<>(ceo,cfo);
        printBuddies(buddies);

        ceo.setBounus(10000);
        cfo.setBounus(5000);
        Manager[] managers = {ceo,cfo};
        Pair<Employee> result = new Pair<>();
        minmaxBounus(managers,result);
        System.out.println("--the first--"+result.getFirst().getName()+"--the second --"+result.getSecond().getName());
        maxminBounus(managers,result);
        System.out.println("--the first--"+result.getFirst().getName()+"--the second --"+result.getSecond().getName());

    }

    public static void minmaxBounus(Manager[] managers, Pair<? super Manager> result) {
        if(managers == null || managers.length ==0){
            return;
        }
        Manager min = managers[0];
        Manager max = managers[0];
        for (int i = 1; i < managers.length; i++) {
            if(min.getBounus()>managers[i].getBounus()){
                min = managers[i];
            }
            if(max.getBounus()<managers[i].getBounus()){
                max = managers[i];
            }
        }
        result.setFirst(min);
        result.setSecond(max);

    }

    public static void maxminBounus(Manager[] managers, Pair<? super Manager> result){
        minmaxBounus(managers,result);
        PairAlg.swap(result);
    }

    public  static  void printBuddies(Pair<? extends Employee> buddies){
        Employee first = buddies.getFirst();
        Employee second = buddies.getSecond();
        System.out.println(first.getName()+" and "+second.getName()+" are buddies");
    }


}

class PairAlg{

    public boolean hasNull(Pair<?> pair){
        return pair.getFirst() == null || pair.getSecond() == null;
    }

    public static void swap(Pair<?> pair){
        swapHelper(pair);
    }

    public static <T> void swapHelper(Pair<T> pair){
        T temp = pair.getFirst();
        pair.setFirst(pair.getSecond());
        pair.setSecond(temp);
    }

}

class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;
    public Employee(String name,double salary,int year,int month,int day){
        this.name = name;
        this.salary = salary;
        this.hireDay =  LocalDate.of(year,month,day);
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent/100;
        salary += raise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }
}
class Manager extends Employee{
    private double bounus;
    public Manager(String name,double salary,int year,int month,int day){
        super(name, salary, year, month, day);
        this.bounus = 0;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bounus;
    }

    public double getBounus() {
        return bounus;
    }

    public void setBounus(double bounus) {
        this.bounus = bounus;
    }
}
