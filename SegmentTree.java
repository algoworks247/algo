public class SegmentTree {
    public static void main(String args[]) {
      int[] array = new int[]{1,2,3};
      Node parent = Node.createNode(0,array.length-1,array);
      Node.print(parent);
    }
    

}

class Node{
    int value;
    Node left;
    Node right;

    public Node(int value,Node left, Node right){
        this.value=value;
        this.left=left;
        this.right=right;
    }
    
    public static void print(Node node){
        if(node != null){
            print(node.value);
            if(node.left!=null)
                print(node.left);
            if(node.right!=null)
                print(node.right);
        }
    }
    
    public static void print(Object obj){
        System.out.print(obj);
    }
    
    public static void ln(){
        System.out.println();
    }

    public static Node createNode(int leftIndex,int rightIndex,int[] array){
        Node left = null;
        Node right = null;
        
        if((rightIndex-leftIndex)>1){
            int mid = deduceMid(leftIndex,rightIndex);
            left = createNode(leftIndex,mid,array);
            right = createNode(mid+1,rightIndex,array);
        }
        else if (rightIndex-leftIndex==1){
            left = createNode(leftIndex,leftIndex,array);
            right= createNode(rightIndex,rightIndex,array);
        }
        
        int sum = getSum(leftIndex,rightIndex,array);
        return new Node(sum,left,right);
    }
    
    private static int deduceMid(int leftIndex,int rightIndex){
        int n = rightIndex-leftIndex+1;
        if(n%2==0)
            return (n/2);
        else
            return (n/2)-1;
    }
    
    private static int getSum(int leftIndex,int rightIndex,int[] array){
        int sum = 0;
        for(int i=leftIndex;i<=rightIndex;i++){
            sum=sum+array[i];
        }
        return sum;
    }
}
