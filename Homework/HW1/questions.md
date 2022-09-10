Algoritim write up

    function leftChild(i){
        return 2(i) + 1;
    }
    function rightChild(){
        return 2(i) + 2;
    }

    function buildHeap(list){
        empty heap of size list.length
        n = list.length
        for i in n -1
        Add key
        return heap
    }


    function heapsort(list){
        H = buildHeap()
        n = list.length
        for i in to n-1 do
            list[i] = get_min()
    }

    function heapifyDown(h , i ){
        n = h.length-1 ;
        while (leftChild(i) <= n) and (h[i] >h(leftchild(i)) and (rightChild(i) >= n) and (h[i] >h(rightchild(i)))
        if (rightchild(i) < n) or H[leftchild(i)] < [RightChild ()]){
            j = leftChild(i)
        }else{
            j = rightChild(i)
        }
        swap nodes h[i] and h[j]
        i = j
    }

    function heapifyup(){
        while(i > 0) and (h[i] < H(Parent(i)))){
            swap h[i] and H[parent]
            i = parent(i)
        }
    }
    function getRoot(){
        return heap[0]
    }
    function add_Key(h, key){
        h.length++
        h[h.length-1] = key
        heapify-up (h , h.length -1)

    }
    function extractMax(){
        max = h[0]
        h[0] = h[h.length -1]
        h.length --
        heapifyDown(H, 0)
        return Max
    }
    function isEmpty(){
        return heap.length == 0 ? true : false
    }
    function addKey(value){
        h.length++
        h[h.length -1 ] = key
        heapifyUp(H, H.length-1)
    }

    function checkplanters(list planters, list empty planters){
        planters = buildHeap()
        emptyPlanters = buildHeap()

        while !planters.isempty(){
            if (plant.getRoot() < emptyPlanters.getRoot()){
                spot  = planters.extract_max()
                emptyPlanters.addKey(spot)
            }else{
                print "NO"
            }
        }
        print "YES"
    }
