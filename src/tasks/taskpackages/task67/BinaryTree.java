package tasks.taskpackages.task67;

public class BinaryTree<T extends Comparable> {

    private Node<T> root;

    public T getTop() {
        return root.obj;
    }

    public boolean isEmpty(){
        return root==null;
    }

    public void add(T obj){
        if(root == null){
            root = new Node<T>(obj);
        }else{
            root.add(obj);
        }
    }

    public void delete(){
        if (root == null) throw new NullPointerException("Binary Tree root is null");
        else{
            if(root.mLeft == null){
                if(root.mRight == null){
                    root = null;
                }else{
                    root = root.mRight;
                }
            }else{
                if(root.mLeft.mRight == null){
                    root.mLeft.mRight = root.mRight;
                    root = root.mLeft;
                }else{
                    Node<T> nextNode = root.mLeft.mRight;
                    while(nextNode.mRight.mRight != null) nextNode = nextNode.mRight;
                    Node<T> lastNode = nextNode.mRight;
                    nextNode.mRight = null;

                    lastNode.mRight = root.mRight;
                    lastNode.mLeft = root.mLeft;
                    root = lastNode;
                }
            }
        }
    }


/*
    public Comparable delete(int number)throws NullPointerException {
        if (root == null) throw new NullPointerException();
    }
    public boolean delete(int number){

    }
*/

    static class Node<T extends Comparable>{
        Node<T> mRight;
        Node<T> mLeft;
        T obj;

        public T getObj() {
            return obj;
        }

        public Node<T> getReft() {
            final Node<T> node = mLeft;
            return node;
        }

        public Node<T> getRight() {
            return mRight;
        }

        public Node(Node<T> other){
            this.obj = other.obj;
            this.mRight = other.mRight;
            this.mLeft = other.mLeft;
        }

        private Node(T obj){
            this.obj = obj;
        }

        private void add(T inserted){
            Node<T> nodeToInsert = null;
            if(obj.compareTo(inserted)<0){ //this is less
                if(mRight != null){ mRight.add(inserted);
                }else{
                    mRight = new Node<T>(inserted);
                }
            }else{//this is equal or more
                if(mLeft != null){ mLeft.add(inserted);
                }else{
                    mLeft = new Node<T>(inserted);
                }
            }
        }
    }

}
