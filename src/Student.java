public class Student implements Comparable {

    private int number;
    private String name;
    private int math ;
    private int data;

    private double average;

    public Student(int number, String name, int math, int data) {
        this.number = number;
        this.name = name;
        this.math = math;
        this.data = data;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String toString(){
        return this.number + " " + this.name + " " + this.math + " " + this.data;
    }

    //average of data and math grade
    @Override
    public int compareTo(Object o) {
        Student a = ((Student) o) ;
        average = ((double)(math + data) / 2);

        if (this.average == a.average){
            return 0;
        }else if(this.average > a.average){
            return 1;
        }else{
            return -1;
        }
    }

}
