public class ShakerSort extends Sorting{
    public void sort(int array[]) {
        int buff;
        int left=0;
        int right=array.length-1;
        do {
            for (int i=left; i<right;i++) {
                if (array[i]>array[i+1]) {
                    buff = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buff;
                }
            }
            right--;
            for (int i=right; i>left; i--) {
                if (array[i]<array[i-1]) {
                    buff = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = buff;
                }
            }
            left++;
        } while (left <right);
    }
}

