public class SelectionSort extends Sorting{

    public void sort(int []arr){
        int min = arr.length-1;
        int left = 0;

        while (left < arr.length){
            for (int i = left; i < arr.length; i++) {
                if (arr[i] < arr[min])
                    min = i;
            }

            int t = arr[min];
            arr[min] = arr[left];
            arr[left] = t;

            left++;
            min = arr.length - 1;
        }
    }
}

