
public class BubbleSort extends Sorting{


    public void sort(int []arr){
        for(int j = 0; j < arr.length-1; j++){
            for(int i = 0; i < arr.length-1; i++){
                if(arr[i] > arr[i+1]){
                    int t = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = t;
                }
            }
        }
    }
}
