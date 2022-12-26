public class HuffmanTree {

    private HuffmanNode root;

    public HuffmanTree(HuffmanList list){
        root = list.popHead();

        while (list.count() > 0){
            HuffmanNode node = list.popHead();

            String parentSymbol = node.symbol + root.symbol;
            float parentFrequency = node.frequency + root.frequency;

            HuffmanNode parentNode = new HuffmanNode(parentSymbol, parentFrequency);

            parentNode.right = node;
            parentNode.left = root;

            root = parentNode;
        }
    }

    public String decode(String encodedSymbol){

        String decodedSymbol = "";

        for (int i = 0; i < encodedSymbol.length(); i++) {

            char current = encodedSymbol.charAt(i);
            HuffmanNode iterator = root;

            if (current == '0'){
                iterator = iterator.left;
            }
            if (current == '1'){
                iterator = iterator.right;
            }
            if (iterator.symbol.length() == 1){
                decodedSymbol += iterator.symbol;
                iterator = root;
            }


        }



        return decodedSymbol;
    }

    public String encode(String symbol){

        if (symbol.length() == 0){
            return "";
        }

        String encodedSymbol = "";
        HuffmanNode iterator = root;


        for (int i = 0; i < symbol.length(); i++) {
            String current = String.valueOf(symbol.charAt(i));

            while (iterator != null) {

                if (iterator.symbol.equalsIgnoreCase(current)){
                    break;
                }

                if (iterator.left != null && iterator.left.symbol.contains(current)){
                    encodedSymbol += "0";
                    iterator = iterator.left;
                }else{
                    encodedSymbol += "1";
                    iterator = iterator.right;
                }
            }
        }


        return encodedSymbol;
    }



}
