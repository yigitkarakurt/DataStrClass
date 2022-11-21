import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class DoublyLinkedList<T extends Comparable>{
    DNode <T> head;
    DNode<T> top;

    public DNode<T> createNode(T val){
        return new DNode<T>(val);
    }

    public void addFront(T val){
        DNode<T> newNode = createNode(val);

        if(head==null){
            head = newNode;

        }else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public int size(){
        DNode<T> iterator = head;
        int count = 0;
        while (iterator != null){
            count++;
            iterator = iterator.next;

        }
        return count;
    }

    public void addEnd(T val){
        DNode<T> newNode = createNode(val);
        if(head == null){
            addFront(val);
        }else{
            DNode<T> iterator = head;
            while(iterator.next != null){
                iterator = iterator.next;
            }
            iterator.next = newNode;
            newNode.prev = iterator;
        }
    }

    public void addToEnd(T val){
        DNode<T> newNode = new DNode<>(val);
        DNode<T> iterator = top;
        while(iterator != null){

            top = newNode;

        }

    }

    public void addRightAfterHead(T val){
        if (head == null){
            head = createNode(val);
        }else{
            DNode<T> newNode = createNode(val);
            newNode.next = head.next;
            head.next = newNode;
            newNode.prev = head;
            newNode.next.prev = newNode;
        }
    }

    public int search(T val){
        int nodeCounter = 0;
        if (head == null){
            return nodeCounter;
        }
        DNode<T> iterator = head;
        while (iterator != null){

            if (iterator.value.compareTo(val) == 0){
                nodeCounter++;
                return nodeCounter;
            }
            iterator = iterator.next;
        }

        return nodeCounter;
    }


    public void delete(T val){

        DNode<T> iterator = head, prev = head;

        if (head.value.compareTo(val) == 0) {
            head.next.prev = null;
            head = head.next;


        }
        if(iterator != null) {
            while(iterator.value.compareTo(val) != 0){
                prev = iterator;
                iterator = iterator.next;
            }
            if (iterator.value.compareTo(val) == 0){
                prev.next = iterator.next;
                if (iterator.next != null){
                    iterator.next.prev = prev;
                }

            }
        }




    }

    public void delete2(T val){

        DNode<T> iterator = head;

        if (head.value.compareTo(val) == 0) {
            head = head.next;
            if (head!=null){
                head.prev = null;
            }
            return;
        }

        if(iterator != null) {
            while(iterator.value.compareTo(val) != 0){
                iterator = iterator.next;
            }

            if (iterator.value.compareTo(val) == 0){
                iterator.prev.next = iterator.next;

                if (iterator.next!=null){
                    iterator.next.prev = iterator.prev;
                }

            }
        }




    }

    public void deleteFromFront() {
        if (head != null) {
            if (head.next == null) {
                head = null;
            } else {
                head = head.next;
                head.prev = null;
            }
        }
    }

    public void display(){
        DNode<T> iterator = head;
        while(iterator != null){
            System.out.println(iterator.value);
            iterator = iterator.next;
        }
    }

    public T getValue(int index) {
        int counter = 0;
        DNode<T> iterator = head;

        while (iterator != null) {

            if (index == counter) {
                return iterator.value;
            }
            counter++;
            iterator = iterator.next;
        }
        return iterator.value;
    }

    public int getIndex(String value) {
        int indexCounter = 0;
        DNode<T> iterator = head;

        while (iterator != null) {
            indexCounter++;
            String iteratorString = String.valueOf(iterator.value);

            if (iteratorString.equalsIgnoreCase(value)) {

                return indexCounter;

            }

            iterator = iterator.next;

        }
        return indexCounter;


    }

    public void txtToDoublyLL() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("students.txt")); //read the txt file
        //sc.useDelimiter(" ");   //sets the delimiter pattern
        while (sc.hasNext())  //returns a boolean value
        {
            int valueNum = Integer.parseInt(sc.next());
            String valueName = sc.next();
            int valuePhysic = Integer.parseInt(sc.next());
            int valueData = Integer.parseInt(sc.next());

            Student s1 = new Student(valueNum, valueName,valuePhysic,valueData);
            this.addEnd((T) s1);

        }
        sc.close();  //closes the scanner
    }

    public void q1displayLL() throws FileNotFoundException {
        DoublyLinkedList<T> dlist1 = new DoublyLinkedList<>();
        Scanner sc = new Scanner(new File("students.txt")); //read the txt file
        //sc.useDelimiter(" ");   //sets the delimiter pattern
        while (sc.hasNext())  //returns a boolean value
        {
            int valueNum = Integer.parseInt(sc.next());
            String valueName = sc.next();
            int valuePhysic = Integer.parseInt(sc.next());
            int valueData = Integer.parseInt(sc.next());

            Student s1 = new Student(valueNum, valueName,valuePhysic,valueData);
            dlist1.addEnd((T) s1);

        }
        sc.close();  //closes the scanner

        dlist1.display();
    }

    public void q2sortStudentsByAverage(){
        DoublyLinkedList<T> dList2 = new DoublyLinkedList<>();

        if (head == null){
            return;
        }

        int size = this.size();

        DNode<T> iterator = head, prev = head;
        for (int j = 0; j < size; j++) {
            T max = head.value;
            iterator = head;
            prev = head;
            while(iterator != null){

                if (iterator.value.compareTo(max) == 1){
                    max = iterator.value;
                }

                prev = iterator;
                iterator = iterator.next;
            }
            this.delete(max);
            dList2.addEnd(max);

        }

        for (int i = 0; i < size; i++) {
            this.addEnd(dList2.getValue(i));

        }
        display();

    }

    public void q3sortData() {
        DoublyLinkedList<T> dList2 = new DoublyLinkedList<>();

        if (head == null){
            return;
        }
        int size = this.size();

        DNode<T> iterator = head, prev = head;
        for (int j = 0; j < size; j++) {
            Student max = (Student) head.value;
            iterator = head;
            prev = head;
            while(iterator != null){

                Student a = (Student) iterator.value;
                if (a.getData() > max.getData()){
                    max = (Student) iterator.value;
                }
                prev = iterator;
                iterator = iterator.next;
            }
            this.delete((T) max);
            dList2.addEnd((T) max);
        }

        for (int i = 0; i < size; i++) {
            this.addEnd(dList2.getValue(i));
        }

        iterator = head;
        while(iterator != null){
            Student a = (Student) iterator.value;
            System.out.println(a.getName());
            iterator = iterator.next;
        }
    }

    public void q4mathAverage(){

        DoublyLinkedList<T> dList2 = new DoublyLinkedList<>();

        if (head == null){
            return;
        }
        int size = this.size();

        DNode<T> iterator = head, prev = head;
        int total = 0;

        while(iterator != null){

            Student a = (Student) iterator.value;

            total += a.getMath();

            prev = iterator;
            iterator = iterator.next;
        }

        double mathAverage = (double)total/size;
        System.out.println("Math Grade Average : " + mathAverage);

    }

    public void q5lowestData(){
        DoublyLinkedList<T> dList2 = new DoublyLinkedList<>();

        if (head == null){
            return;
        }
        int size = this.size();

        DNode<T> iterator = head, prev = head;
        Student min = (Student) head.value;
        for (int j = 0; j < size; j++) {

            iterator = head;
            prev = head;
            while(iterator != null){

                Student a = (Student) iterator.value;
                if (a.getData() <= min.getData()){
                    min = (Student) iterator.value;



                }
                prev = iterator;
                iterator = iterator.next;
            }
        }
        dList2.addEnd((T)min);
        for (int j = 0; j < size; j++) {

            iterator = head;
            prev = head;
            while(iterator != null){

                Student a = (Student) iterator.value;
                if (a.getData() == min.getData()){
                    min = (Student) iterator.value;
                    if (dList2.search((T)min) == 0){
                        dList2.addEnd((T)min);
                    }

                }
                prev = iterator;
                iterator = iterator.next;
            }
        }
        System.out.println("Student(s) With The Lowest Grade In Data Structures : ");

        iterator = dList2.head;
        while(iterator != null){
            Student a = (Student) iterator.value;
            System.out.println(a.getName());
            iterator = iterator.next;
        }

    }

    public void q6deleteStudentById(){
        boolean isFound = false;
        DNode<T> iterator = head,prev = head;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the student number that you want to delete");
        int studentNum = scanner.nextInt();

        if (head == null){
            return ;
        }

        while (iterator != null){
            Student a = (Student) iterator.value;

            if (a.getNumber() == studentNum){
                this.delete((T)a);
                System.out.println(a.getName() + " successfully deleted.");
                isFound = true;
                return;
            }
            prev = iterator;
            iterator = iterator.next;
        }

        if (!isFound){
            System.out.println("The student you are looking for was not found");
        }
    }

    public void q7addStudent(){
        DNode<T> iterator = head;
        Scanner scanner = new Scanner(System.in);
        int number;
        String name;
        int math;
        int data;

        System.out.println("Please enter the student's number : ");
        number = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the student's name : ");
        name = scanner.nextLine();
        System.out.println("Please enter the student's math grade : ");
        math = scanner.nextInt();
        System.out.println("Please enter the student's data grade : ");
        data = scanner.nextInt();
        Student s1 = new Student(number,name,math,data);
        this.addEnd((T) s1);

        if (search((T)s1) != 0){
            System.out.println("Student added successfully");
        }else{
            System.out.println("The student could not be added");
        }
    }

    public void q8studentCount(){

        System.out.println("Number of students : " + size());
    }

    public void q9successfulStudents(){
        DoublyLinkedList<T> mathList = new DoublyLinkedList<>();
        DoublyLinkedList<T> dataList = new DoublyLinkedList<>();
        DNode<T> iterator = head;
        int mathTotal = 0;
        int dataTotal = 0;

        while(iterator != null){
            Student a = (Student) iterator.value;
            dataTotal += a.getData();
            mathTotal += a.getMath();
            iterator =  iterator.next;
        }
        iterator = head;
        double dataAverage = ((double)dataTotal/size());
        double mathAverage = ((double)mathTotal/size());

        while(iterator != null){
            Student a = (Student) iterator.value;
            if (a.getData() > dataAverage){
                dataList.addEnd((T)a);
            }
            if (a.getMath() > mathAverage){
                mathList.addEnd((T)a);
            }
            iterator = iterator.next;
        }

        System.out.println("Successful Students For Math : ");
        iterator = mathList.head;
        while(iterator != null){
            Student a = (Student) iterator.value;
            System.out.println(a.getNumber() + " " + a.getName() + " " + a.getMath());
            iterator = iterator.next;
        }

        System.out.println("Successful Students For Data : ");
        iterator = dataList.head;
        while(iterator != null){
            Student a = (Student) iterator.value;
            System.out.println(a.getNumber() + " " + a.getName() + " " + a.getData());
            iterator = iterator.next;
        }







    }

    public void startMenu() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        txtToDoublyLL();
        while(true){

            System.out.println("---\n" + "Select The Operation You Want To Do");
            String menu = "***********\n"+
                          "Display The Inital LinkedList Content Press 1\n"+
                          "Display The Current LinkedList Content Press 2\n"+
                          "Display The Students Sorted By Their Overall Average Press 3\n"+
                          "Display The Student Names Sorted By Their Data Str. Grades Press 4\n"+
                          "Display The Math Average Press 5\n"+
                          "Display The Student(s) Who Has The Lowest Data Str. Grade Press 6\n"+
                          "Delete The Student By ID Press 7\n"+
                          "Add New Student Press 8\n"+
                          "Display The Student Count Press 9\n"+
                          "Display Successful Student Press 10\n"+
                          "Quit Press 0\n"+
                          "***********";

            System.out.println(menu);
            int input = scanner.nextInt();
            if (input == 1) {
                q1displayLL();
            } else if (input == 2) {
                display();
            } else if (input == 3) {
                q2sortStudentsByAverage();
            } else if (input == 4) {
                q3sortData();
            } else if (input == 5) {
                q4mathAverage();
            } else if (input == 6) {
                q5lowestData();
            } else if (input == 7) {
                q6deleteStudentById();
            } else if (input == 8) {
                q7addStudent();
            } else if (input == 9) {
                q8studentCount();
            }else if (input == 10){
                q9successfulStudents();
            } else if (input == 0) {
                break;
            } else {
                System.out.println("Wrong!");
            }

        }
    }




}