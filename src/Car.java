public class Car implements Comparable {
    private String make;
    private String model;
    private int horsePower;

    public Car(String make, String model, int horsePower){
        this.make = make;
        this.model = model;
        this.horsePower = horsePower;
    }

    @Override
    public int compareTo(Object o) {
        Car c = ((Car)o);

        if (this.horsePower == c.horsePower){
            return 0;
        }else if(this.horsePower > c.horsePower){
            return 1;
        }else{
            return -1;
        }
    }

    public String toString(){
        return this.make + " " + this.model + " Horsepower is...: " + this.horsePower;
    }
}
