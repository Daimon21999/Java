public class HeapSort extends Sorting{


    public void buildHip(int A[])
    {
        int n = A.length;
        for(int i=(n-1)/2;i>=0;i--)
            heapify(A,i,n);
    }
    public void heapify(int A[],int i,int n1)
    {
        int left = (2*i)+1;
        int right = left+1;
        int largest = i;
        if(left <= n1-1 && A[left] > A[largest])
            largest = left;
        if (right <= n1-1 && A[right] > A[largest])
            largest = right;
        if (largest != i){

            int t = A[i];
            A[i] = A[largest];
            A[largest] = t;


            heapify(A,largest,n1);
        }
    }
    public void sort(int A[]) {
        buildHip(A);
        int n = A.length;
        int n1 = n;
        for (int i = n - 1; i >= 0; i--) {

            int t = A[0];
            A[0] = A[i];
            A[i] = t;

            heapify(A, 0, i);
        }
    }
}
