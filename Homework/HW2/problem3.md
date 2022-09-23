    # problem #3

    function merge(leftArray, rightArray){
        create list c to hold the output array
        int leftcursor = 0;
        int rightcursor = 0;
        count = 0
        for(int i = 0;  i < c.length; i++ ){
            if leftArray[leftcursor] > rightArray[rightcursor]){
                count += calculated weight
                rightcursor += 1
            } else{
                count += calculated weight
                leftcursor += 1
            }
        }
        i = 0
        j = 0
        k = 0
        while(i < leftArray.size() && j < rightArray.size()){
            if leftArray[i]<= rightArray[j]{
                finalArray[k] = i;
                i++;
            else{
                finalArray[k] = j;
                j++
            }
            k++;
        }
            return final array
        }
    }

    function mergeSort(array numbers, int n){
        if (n == 1){
            return numbers
        }

        middle = Math.floor((n - 1)/2)
        a = [starting_index.. , middle]
        b = [middle, numbers.length -1]

        left , leftcount = mergeSort(a, a.length);
        right, rightcount = mergeSort(b, b.length);
        merged , count = merge(a , b)
        return count
    }
