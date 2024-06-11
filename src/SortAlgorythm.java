public class SortAlgorythm{

    public static void runAlgorythm(String algorythm, SortArray sortArray) throws InterruptedException {

        switch (algorythm) {
            case "Bubble Sort":
                bubbleSort(sortArray.array, sortArray);
                break;
            case "Merge Sort":
                mergeSort(sortArray.array,0,SortArray.size-1, sortArray);    
                break;
            case "Insertion Sort":
                insertionSort(sortArray.array, sortArray);
                break;
            case "Selection Sort":
                selectionSort(sortArray.array, sortArray); 
                break; 
            case "Cocktail Sort":
                cocktailSort(sortArray.array, sortArray);   
                break;
            default:
                break;
        }
    }


    public static void bubbleSort (float[] array, SortArray sortArray) throws InterruptedException {

        while (sortArray.iterator < SortArray.size - 1) {
            while (sortArray.currentIndex < SortArray.size - sortArray.iterator - 1) {
                if (array[sortArray.currentIndex] > array[sortArray.currentIndex + 1]) {
                    sortArray.swap(sortArray.currentIndex, sortArray.currentIndex + 1);
                }
                sortArray.currentIndex ++;
            }
            sortArray.currentIndex = 0;
            sortArray.iterator ++;
        }

    }

    public static void insertionSort (float[] array, SortArray sortArray) throws InterruptedException {
        
        for(sortArray.currentIndex = 1; sortArray.currentIndex < SortArray.size; sortArray.currentIndex++){
            sortArray.iterator = sortArray.currentIndex;

            while(sortArray.iterator > 0 && array[sortArray.iterator] < array[sortArray.iterator-1]){
                sortArray.swap(sortArray.iterator, sortArray.iterator-1);
                sortArray.iterator--;

            }

        }
        sortArray.currentIndex = 0;
        sortArray.iterator = 0;
        }


        public static void selectionSort (float[] array, SortArray sortArray) throws InterruptedException {

            int minIndex = 0;

            while(sortArray.currentIndex < SortArray.size-1){
                minIndex = sortArray.currentIndex;
                sortArray.iterator = sortArray.currentIndex;

                while(sortArray.iterator<SortArray.size-1){
                    sortArray.iterator++;

                    if(array[sortArray.iterator]<array[minIndex]){
                        minIndex = sortArray.iterator;
                    }

                    sortArray.repaint();
                    Thread.sleep(1);
                }

                sortArray.swap(minIndex, sortArray.currentIndex);
                sortArray.currentIndex++;
            }


            sortArray.currentIndex = 0;
            sortArray.iterator = 0;
        }

        public static void merge(float array[], int l, int m, int r, SortArray sortArray) throws InterruptedException {
        {

            int n1 = m - l + 1;
            int n2 = r - m;

            float L[] = new float[n1];
            float R[] = new float[n2];

            for (int i = 0; i < n1; ++i)
                L[i] = array[l + i];
            for (int j = 0; j < n2; ++j)
                R[j] = array[m + 1 + j];
    

            int i = 0, j = 0;

            int k = l;
            while (i < n1 && j < n2) {
                sortArray.repaint();
                Thread.sleep(1);

                if (L[i] <= R[j]) { 
                    array[k] = L[i];
                    i++;
                }
                else {
                    array[k] = R[j];
                    j++;
                }
                k++;
            }

            while (i < n1) {
                sortArray.repaint();
                Thread.sleep(1);
                array[k] = L[i];
                i++;
                k++;
            }
    
            while (j < n2) {
                sortArray.repaint();
                Thread.sleep(1);
                array[k] = R[j];
                j++;
                k++;
            }
        }
    }
    
        public static void mergeSort(float array[], int l, int r, SortArray sortArray) throws InterruptedException {
            if (l < r) {
                sortArray.repaint();
                Thread.sleep(1);

                int m = l + (r - l) / 2;
    
                mergeSort(array, l, m, sortArray);
                mergeSort(array, m + 1, r, sortArray);
    
                merge(array, l, m, r, sortArray);
            }
        }

        public static void cocktailSort(float a[], SortArray sortArray) throws InterruptedException {

        boolean swapped = true;
        int start = 0;
        int end = a.length;
 
        while (swapped == true) 
        {
            swapped = false;
 
            for (int i = start; i < end - 1; ++i) 
            {
                if (a[i] > a[i + 1]) {
                    sortArray.swap(i, i + 1);
                    swapped = true;
                }
            }
 
            if (swapped == false)
                break;
 
            swapped = false;

            end = end - 1;
 
            for (int i = end - 1; i >= start; i--) 
            {
                if (a[i] > a[i + 1]) 
                {
                    sortArray.swap(i, i + 1);
                    swapped = true;
                }
            }
 
            start = start + 1;
        }
    }




}
 
