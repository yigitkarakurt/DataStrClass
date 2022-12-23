import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class HuffmanHW<T extends Comparable> {

    private TNode<T> root;

    public void findFreq(String letter){



    }

    public String encode(String symbol) {

        if (Objects.equals(symbol, "")){
            return "";
        }

        String encodedSymbol = "";

        for (int i = 0; i < symbol.length(); i++) {
            String character = String.valueOf(symbol.charAt(i));
            TNode<T> iterator = root;

            while(iterator != null) {
                if (iterator.symbol.compareTo(character) == 0){
                    break;
                }

                if (iterator.left != null && iterator.left.symbol.contains(character)){
                    encodedSymbol += "0";
                    iterator = iterator.left;
                }else{
                    encodedSymbol += ("1");
                    iterator = iterator.right;
                }
            }
        }

        return encodedSymbol;
    }

    public String decode() {
        String decodedSymbol = "";



        return decodedSymbol;
    }

    public static void main (String[]args){

        HuffmanHW<String> huffman = new HuffmanHW<>();

        System.out.println(huffman.encode("yigit"));


    }

}


