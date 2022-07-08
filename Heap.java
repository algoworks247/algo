// 813
public class Heap{
    public static int[] arr= int[]{2,3,10,5};
    int value;
    Heap left;
    Heap right;
    
    public static Heap createNode(int arrIndex){
        Heap heap = new Heap();
        heap.value=arr[arrIndex];
        
        if(arr.length-arrIndex>=1){
            Heap left = createNode(arrIndex+1);
            heapify(left,heap);    
            heap.left=left;
        }
        
        if(arr.length-arrIndex>=2){
            Heap right = createNode(arrIndex+2);
            heapify(right,heap);
        }
        
        
        heap.right=right;
        
        return heap;
    }
    
    public static void heapify(Heap newNode,Heap parentNode){
        if(newNode.value<parentNode.value)
            swapValues(newNode,parentNode);
    }
    
    public static void swapValues(Heap newNode,Heap parentNode){
        parentNode.value = parentNode.value+newNode.value;
        newNode.value    = parentNode.value-newNode.value;
        parentNode.value = parentNode.value-newNode.value;
    }
    
    public static void main(String[] args){
        Heap heap= createNode(0);
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
}
