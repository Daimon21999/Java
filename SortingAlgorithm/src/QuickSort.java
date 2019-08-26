import java.util.*;
//import java.util.Random;
import java.io.File;
public class QuickSort extends Sorting{

	public  int partition(int []arr, int l, int r){
		int t;
		int pivot = arr[(l+r)/2];
		while(l<=r){
			while(arr[l]<pivot)
				l++;
			while(arr[r]>pivot)
				r--;
			if(l<=r){
				t = arr[l];
				arr[l] = arr[r];
				arr[r] = t;
				l++;
				r--;
			}
		}
		return l;
	}

	public  void sort(int []arr, int l, int  r){
		if(l >= r)
			return;
		int index = partition(arr, l, r);
		if(l < index-1)
			sort(arr, l, index-1);
		if(r>index)
			sort(arr, index, r);
	}


}
