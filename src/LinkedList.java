import java.io.*;
import java.util.*;

public class LinkedList<T extends Comparable> {
    private Node<T> head;

    public Node<T> createNode(T val) {
        return new Node<T>(val);
    }

    public void addHeadVize(T val){
        Node<T> newNode = new Node<>(val);
        Node<T> iterator = head;

        if (head == null){
            newNode.next = null;
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;

        }

    }

    public void addHead2(T val){
        Node<T> newNode = new Node<>(val);

        if (head != null){
            newNode.next = head;
            head = newNode;
        }else{
            head = newNode;
        }
    }

    public void addEndVize(T val){
        Node<T> newNode = new Node<>(val);
        Node<T> iterator = head;
        if(head == null){
            newNode.next = head;
            head = newNode;
        }else {
            while (iterator.next != null) {
                iterator = iterator.next;
            }
            iterator.next = newNode;
        }

    }

    public void addEndVize2(T val){
        Node<T> newNode = new Node<>(val);
        Node<T> iterator = head;

        if (head==null){
            head = newNode;
        }else{
            while(iterator.next != null){
                iterator = iterator.next;
            }
            iterator.next = newNode;
        }
    }

    public void deleteNode(T val){
        Node<T> iterator = head, prev = head;

        if (head.value.compareTo(val)==0){
            head= head.next;
            return;
        }

        while(iterator != null){
            if (iterator.value.compareTo(val) == 0 && iterator.next != null){
                prev.next = iterator.next;
            }else if(iterator.value.compareTo(val) == 0 ){
                prev.next = null;
            }
            prev = iterator;
            iterator = iterator.next;
        }
    }

    public void sortSelectionVize(){
        Node<T> iterator= head, iterator2 = null;
        T temp;

        if (head== null){
            return;
        }else{
            while(iterator!=null){
                iterator2 = iterator.next;

                while (iterator2!=null){

                    if (iterator.value.compareTo(iterator2.value) == 1){
                        temp = iterator.value;
                        iterator.value = iterator2.value;
                        iterator2.value = temp;
                    }
                    iterator2 = iterator2.next;

                }
                iterator = iterator.next;
            }
        }
    }

    public void selectionSort(){
        if (head == null){
            return;
        }

        Node<T> iterator = head,iterator2 = null;


        while(iterator != null){
            iterator2 = iterator.next;

            while(iterator2 != null){

                if ((int)iterator2.value < (int)iterator.value){

                    T temp = iterator.value;
                    iterator.value = iterator2.value;
                    iterator2.value = temp;


                }


                iterator2 = iterator2.next;
            }

            iterator = iterator.next;
        }
    }

    public void addFront(T val) {
        Node<T> newNode = createNode(val);
        newNode.next = head;
        head = newNode;

    }

    public int size() {
        Node<T> iterator = head;
        int count = 0;
        while (iterator != null) {
            iterator = iterator.next;
            count++;
        }
        return count;

    }

    public T findmax(){
        if (head == null){
            return null;
        }
        Node<T> iterator = head;
        T max = head.value;


        while(iterator != null){
            if (iterator.value.compareTo(max) == 1){
                max = iterator.value;
            }
            iterator = iterator.next;
        }
        return max;
    }

    public T findMax2(){
        Node<T> iterator = head;
        T max = head.value;

        if (head == null){
            return null;
        }
        while(iterator!=null){

            if (iterator.value.compareTo(max) == 1){
                max = iterator.value;
            }
            iterator = iterator.next;
        }
        return max;
    }
    public void addEnd(T val) {
        if (head == null) {
            addFront(val);
        } else {
            Node<T> iterator = head;
            while (iterator.next != null) {
                iterator = iterator.next;
            }
            iterator.next = createNode(val);
        }
    }

    public void addRightAfterHead(T val) {
        if (head == null) {
            //addFront(val);
            head = createNode(val);
        } else {
            Node<T> newNode = createNode(val);//new Node(val);
            newNode.next = head.next;
            head.next = newNode;
        }

    }

    public int search(T val) {
        int nodeCounter = 0;
        if (head == null)
            return nodeCounter;
        Node<T> iterator = head;
        while(iterator!=null){
            if(iterator.value.compareTo(val)==0){
                nodeCounter++;
                return nodeCounter;
            }
            iterator= iterator.next;
        }
        return nodeCounter;
    }

    public boolean searchRecursive(T val, Node<T> tempHead){
        if(tempHead == null )
            return false;
        if(tempHead.value.compareTo(val)==0)
            return true;
        else
            return searchRecursive(val,tempHead.next);
    }

    public boolean searchRecursive(T val){
        return searchRecursive(val,head);
    }

    public void delete (T val){

        if(head.value.compareTo(val) == 0)
            head= head.next;
        Node<T> iterator = head, prev = head;

        while(iterator.value.compareTo(val)!= 0 && iterator.next!=null){
            prev= iterator;
            iterator = iterator.next;
        }

        if (iterator.value.compareTo(val) == 0){
            prev.next= iterator.next;
        }

    }

    public void display() {
        Node<T> iterator = head;
        while (iterator != null) {
            System.out.println(iterator);
            iterator = iterator.next;

        }
    }

    public void removeDuplicatesFromArrayList(List<Integer> arr){
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size(); j++) {
                if (i != j){
                    if (arr.get(i).intValue() == arr.get(j).intValue()) {
                        //System.out.println(i + ". eleman " + j + ". elemana eşitse sil");
                        arr.remove(j);
                    }
                }
            }
        }
    }

    public void readTxtFileAndAddToLinkedList(LinkedList linkedList) throws IOException {
        //read the txt file
        BufferedReader br = new BufferedReader(new FileReader("Source.txt"));
        String line;
        String[] values = {};

        //split from comma to comma
        while ((line = br.readLine()) != null) {
            values = line.split(",");
        }
        br.close();


        //convert string numbers to int numbers
        int[] values2 = new int[values.length];
        int que = 0;
        for (String i : values){
            int j = Integer.parseInt(i);
            values2[que] = j;
            que++;
        }
        //values2 is the new list that we will use

        //I used arraylist methods
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < values2.length; i++) {

            arr.add(values2[i]);

        }

        removeDuplicatesFromArrayList(arr);

        //added arraylist elements to linkedlist
        for (int i : arr){
            linkedList.addEnd(i);
        }

        //linkedList.display();
    }

    public void searchValuesInLinkedList(LinkedList linkedList) throws IOException {
        //read the txt file
        BufferedReader br = new BufferedReader(new FileReader("Search.txt"));
        String line;
        String[] values = {};

        //split from comma to comma
        while ((line = br.readLine()) != null) {
            values = line.split(",");
        }
        br.close();

        //convert string numbers to int numbers
        //my new array is "values2"
        int[] values2 = new int[values.length];
        int que = 0;
        for (String i : values){
            int j = Integer.parseInt(i);
            values2[que] = j;
            que++;
        }

        //if findIt equals to 0, couldn't find the value[elements]
        int counter = 0;
        int total = 0;
        for (int elements : values2){
            if ((counter = linkedList.search(elements)) != 0){
                total += counter;
                System.out.println("Bu eleman(" + elements + ") linkedListte var!");

            }
        }
        System.out.println(total + " kere node'lara erişim sağlandı");


    }

    public void bringTheSearchedToBeginOfLinkedList(LinkedList linkedList) throws IOException{
//read the txt file
        BufferedReader br = new BufferedReader(new FileReader("Source.txt"));
        String line;
        String[] values = {};

        //split from comma to comma
        while ((line = br.readLine()) != null) {
            values = line.split(",");
        }
        br.close();


        //convert string numbers to int numbers
        int[] values2 = new int[values.length];
        int que = 0;
        for (String i : values){
            int j = Integer.parseInt(i);
            values2[que] = j;
            que++;
        }
        //values2 is the new list that we will use

        //I used arraylist methods
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < values2.length; i++) {

            arr.add(values2[i]);

        }
        //added arraylist elements to linkedlist
        for (int i : arr){
            linkedList.addEnd(i);
        }

    }


    public void huffmanHW() throws FileNotFoundException {

        //Read the file
        Scanner scanner = new Scanner(new File("letter.txt"));
        String text = scanner.nextLine();
        Node<T> iterator = head;

        // Metnin karakterlerini sayar
        for (char ch1 : text.toCharArray()) {
            iterator = head;
            boolean found = false;

            //Boşlukları saymıyor
            if (ch1 != ' ') {

                while (iterator != null) {
                    if (iterator.ch == ch1) {
                        iterator.freq++;
                        found = true;
                        break;
                    }
                    iterator = iterator.next;
                }

                //Eğer o harf ilk defa okunuyorsa yeni node oluşturuyor
                if (!found) {
                    Node<T> newNode = new Node<>(1, ch1);
                    Node<T> iterator1 = head;

                    if (head==null){
                        head = newNode;
                    }else{
                        while(iterator1.next != null){
                            iterator1 = iterator1.next;
                        }
                        iterator1.next = newNode;
                    }
                }
            }
        }


        //Sort by frequency

        // If the list is empty, there's nothing to do.
        if (head== null){
            return;
        }

        //Finding the node that we want

        //Higher to lower
        /*
        iterator= head;
        Node<T> prev = head;
        int size = this.size();

        for (int i = 0; i < size; i++) {
            int minFreq = head.freq;
            iterator = head;
            prev = head;

            while (iterator != null) {
                int a = iterator.freq;
                if (a < minFreq){
                    prev.next = iterator.next;
                    iterator.next = head;
                    head = iterator;
                }
                prev = iterator;
                iterator = iterator.next;
            }
        }

        */

        //Lower to higher
        iterator = head;
        Node<T> iterator2 = head;
        int tempFreq;
        char tempCh;

        while(iterator!=null){
            iterator2 = iterator.next;
            while(iterator2!=null){
                if (iterator.freq > iterator2.freq){
                    //freq transfer
                    tempFreq = iterator.freq;
                    iterator.freq = iterator2.freq;
                    iterator2.freq = tempFreq;

                    //char transfer
                    tempCh = iterator.ch;
                    iterator.ch = iterator2.ch;
                    iterator2.ch = tempCh;
                }
                iterator2 = iterator2.next;
            }
            iterator = iterator.next;
        }


        //Prints linked list
        iterator = head;
        while (iterator != null) {
            System.out.println(iterator.ch + " : " + iterator.freq);
            iterator = iterator.next;

        }
    }



}
