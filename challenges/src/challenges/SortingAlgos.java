package challenges;

public class SortingAlgos {
	
	private int[] nums;
	
	public SortingAlgos()
	{

	}
	
	public int[] GetArray()
	{
		return this.nums;
	}
	
	public void SetArray(int[] nums)
	{
		this.nums = nums;
	}
	
	public void RunQuickSort()
	{
		if (nums != null) 
		{
			quickSort(0, nums.length - 1);
		}
		else
		{
			throw new NullPointerException("Cannot run quick sort on a null array");
		}
	}
	
	public void RunMergeSort()
	{
		if (nums != null)
		{
			mergeSort(nums, 0, nums.length - 1);
		}
		else
		{
			throw new NullPointerException("Cannot run quick sort on a null array");
		}	
	}
	
	public void PrintArray()
	{
		if (nums != null) 
		{
			for (int i = 0; i < nums.length; i++)
			{
				if (i == 0) System.out.print("{");
				if (i != nums.length - 1 )
				{
					System.out.print(nums[i] + ", ");
				}
				else
				{
					System.out.println(nums[i] + "}");
				}
			}
		}
		else
		{
			throw new NullPointerException("Cannot print a null array");
		}
	}
	
	// sorting below
	
	private void mergeSort(int[] array, int left, int right)
	{
		// only recurse if left is less than right
		if (left < right)
		{
			int middle = left + (right - left) / 2;
			
			// mergeSort both halves of array
			mergeSort(array, left, middle);
			mergeSort(array, middle + 1, right);
			
			// merge the two arrays together
			merge(array, left, middle, right);
		}
	}
	
	private void merge(int[] array, int left, int middle, int right) {
		// temporary arrays
		int leftArraySize = middle - left + 1;
		int rightArraySize = right - middle;
		
		int[] leftArray = new int[leftArraySize];
		int[] rightArray = new int[rightArraySize];
		
		// fill the temp arrays
		for (int i = 0; i < leftArraySize; i++)
		{
			leftArray[i] = array[left + i];
		}
		for (int j = 0; j < rightArraySize; j++)
		{
			rightArray[j] = array[middle + 1 + j];
		}
		
		// merge the temp arrays
		int i = 0, j = 0, k = left;
		while (i < leftArraySize && j < rightArraySize)
		{
			if (leftArray[i] <= rightArray[j])
			{
				array[k] = leftArray[i++];
			}
			else
			{
				array[k] = rightArray[j++];
			}
			k++;
		}
		
		// copy any remaining elements into array
		while (i < leftArraySize) array[k++] = leftArray[i++];
		while (j < rightArraySize) array[k++] = rightArray[j++];
		
	}

	// initial call should have 0 & length - 1 as input
	private void quickSort(int low, int high)
	{
		// grab pivot (middle of current pass), set temp partition vars
		int i = low;
		int j = high;
		int pivot = nums[low + (high - low) / 2];
		
		// partition
		while (i <= j)
		{
			// find value left of pivot greater & right of pivot less than
			while (nums[i] < pivot) i++;
			while (nums[j] > pivot) j--;
			
			// then swap if i is still to the left of j
			if (i <= j)
			{
				swap(i, j);
				// move on to the next vals for the next level of recursion
				i++;
				j--;
			}
		}
		
		// recurse (continue if the original starting points have not been reached)
		if (low < j) quickSort(low, j);
		if (i < high) quickSort(i, high);
		
	}
	
	private void swap(int i, int j)
	{
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
