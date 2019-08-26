import java.util.Random;
import java.util.Scanner;

class Sorting {

    public int[] randCreate(int N){
        Random rand = new Random();
        int []arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = rand.nextInt(100);
        }
        return arr;
    }

    public int[]  randCreate(int N,int maxValue){
        Random rand = new Random();
        int []arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = rand.nextInt(maxValue);
        }
        return arr;
    }

    public int[] create() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int N = scn.nextInt();
        int[] arr = new int[N];
        System.out.println("Enter elements of array: ");
        for (int i = 0; i < N; i++) {
            System.out.print("\nA[" + i + "]" + " = ");
            arr[i] = scn.nextInt();
        }
        return arr;
    }

    public void print(int []arr){
        for(int i: arr)
            System.out.print(i+" ");
        System.out.println();
    }

    public String toString(int []arr){
        String string = "";
        for (int i : arr){
            string = string + i + " ";
        }
        return string;
    }

    public String  test(int arr[]){
        if (arr == null){
            System.out.println("Массив пуст");
            return "Массив пуст";
        }
        long t1 = System.nanoTime();
        sort(arr,0,arr.length-1);
        sort(arr);
        long t2 = System.nanoTime();
        String string =" Time = "+((t2-t1))*0.000000001+" seconds";
       // System.out.println(string);
        return string;
    }

    public void sort(int []arr){}

    public void sort(int []arr, int l, int r){}
}
