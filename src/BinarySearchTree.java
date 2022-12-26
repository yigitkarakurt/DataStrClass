public class BinarySearchTree<T extends Comparable> {
    private TNode<T> root;


    //Deneme Kodlarım

    public void inOrderDeneme(){
        inOrderDeneme(root);
        System.out.println();
    }
    public void inOrderDeneme(TNode<T> currentRoot){
        if (currentRoot != null){
            inOrderDeneme(currentRoot.left);
            System.out.println(currentRoot.value + " ");
            inOrderDeneme(currentRoot.right);
        }
    }

    public void preorderDeneme(){
        preorderDeneme(root);
        System.out.println();
    }
    public void preorderDeneme(TNode<T> currentRoot){
        if (currentRoot != null){
            System.out.println(currentRoot.value + " ");
            preorderDeneme(currentRoot.left);
            preorderDeneme(currentRoot.right);
        }
    }

    public void postorderDeneme(){
        postorderDeneme(root);
        System.out.println("");
    }
    public void postorderDeneme(TNode<T> currentRoot){
        if (currentRoot != null){
            postorderDeneme(currentRoot.left);
            postorderDeneme(currentRoot.right);
            System.out.println(currentRoot.value + " ");
        }
    }

    public boolean searchDeneme(T val){
        if (root == null){
            return false;
        }else{
            TNode<T> iterator = root;
            while(iterator != null){
                if (val.compareTo(iterator.value) == 0){
                    return true;
                }else if (val.compareTo(iterator.value) == 1){
                    iterator = iterator.right;
                }else if (val.compareTo(iterator.value) == -1){
                    iterator = iterator.left;
                }
            }
            return false;
        }




    }

    public void insertDeneme(T val){
        if (root==null){
            root = new TNode<>(val);
        }else{
            TNode<T> iterator = root;
            while(iterator!=null){
                if (iterator.compareTo(val) == 1){
                    if (iterator.left == null){
                        iterator.left = new TNode<>(val);
                        return;
                    }else{
                        iterator = iterator.left;
                    }
                }else{
                    if (iterator.right == null){
                        iterator.right = new TNode<>(val);
                        return;
                    }else{
                        iterator = iterator.right;
                    }
                }
            }
        }
    }

    //Hocanın Kodları

    public void insert(T val){
        if(root==null){
            root=new TNode<T>(val);
        }else{
            TNode<T> iterator=root;
            while(iterator!=null){
                if(iterator.value.compareTo(val)==1){
                    if(iterator.left==null){
                        iterator.left=new TNode<>(val);
                        return;
                    }else{
                        iterator=iterator.left;
                    }
                }else{
                    if(iterator.right==null){
                        iterator.right=new TNode<>(val);
                        return;
                    }else{
                        iterator=iterator.right;
                    }
                }
            }
        }
    }

    public void inorder(){
        inorder(root);
        System.out.println();
    }
    public void inorder(TNode<T> currentRoot){
        if(currentRoot!=null){
            inorder(currentRoot.left);
            System.out.print(currentRoot +" ");
            inorder(currentRoot.right);
        }
    }

    public void preorder(){
        preorder(root);
        System.out.println();
    }
    public void preorder(TNode<T> currentRoot){
        if(currentRoot!=null){
            System.out.print(currentRoot +" ");
            preorder(currentRoot.left);
            preorder(currentRoot.right);
        }
    }

    public void postorder(){
        postorder(root);
        System.out.println();
    }
    public void postorder(TNode<T> currentRoot){
        if(currentRoot!=null){
            postorder(currentRoot.left);
            postorder(currentRoot.right);
            System.out.print(currentRoot +" ");

        }
    }
    public void insertRecursively(T val){
        root = insertRecursively(root, val);
    }
    public TNode<T> insertRecursively(TNode<T> currentRoot, T val){
        if(currentRoot==null){
            return new TNode<T>(val);
        }else if( currentRoot.value.compareTo(val)==1  ){
            currentRoot.left=insertRecursively(currentRoot.left, val);
        }else{
            currentRoot.right=insertRecursively(currentRoot.right, val);
        }
        return currentRoot;
    }
    public boolean search(T val){
        TNode<T> iterator=root;
        while(iterator!=null){
            if(iterator.value.compareTo(val)==0){
                return true;
            }else if(iterator.value.compareTo(val)==1){
                iterator=iterator.left;
            }else{
                iterator=iterator.right;
            }
        }
        return false;
    }
    public boolean searchRecursively(T val){
        return searchRecursively(root, val);
    }
    public boolean searchRecursively(TNode<T> currentRoot, T val){
        if(currentRoot==null){
            return false;
        }else if (currentRoot.value.compareTo(val)==0){
            return true;
        }else if (currentRoot.value.compareTo(val)==1){
            return searchRecursively(currentRoot.left, val);
        }else{
            return searchRecursively(currentRoot.right, val);
        }
    }

    public int findMin() {
        int min = 0;
        if (root != null) {
            TNode<T> iterator = root;
            while (iterator.left != null) {
                iterator = iterator.left;
            }
            min = (int) iterator.value;
        }
        return min;

    }

    public int findMax(){
        int max = 0;
        if (root != null){
            TNode<T> iterator = root;
            while(iterator.right != null){
                iterator = iterator.right;
            }
            max = (int) iterator.value;
        }
        return max;
    }

    public void swapMinAndMax(){
        T min,max ;


        if (root != null) {
            TNode<T> iterator = root;
            while (iterator.left != null) {
                iterator = iterator.left;
            }
            min = iterator.value;

            TNode<T> iterator2 = root;
            while(iterator2.right != null){
                iterator2 = iterator2.right;
            }
            max = iterator2.value;

            iterator.value = max;
            iterator2.value = min;
        }






    }












}