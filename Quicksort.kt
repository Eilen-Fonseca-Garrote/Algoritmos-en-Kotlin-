fun main() {
    val arr = intArrayOf(10, 54, 73, 42, 
                         15, 32, 17, 22);
    QuickSort(arr)
    println(arr.toList())
}

fun QuickSort(arr: IntArray, 
              lt: Int = 0, 
              rt: Int = arr.size) {
    var (l, r) = Pair(lt, rt-1)
    val size = rt - lt
    if(size > 1) {
        val rn = (0 until size).random()
        val pivot = arr[rn + l]
        while(l < r) {
            while((arr[r] > pivot) and 
                  (r > l))
                r--
            while((arr[l] < pivot)
                  and (l <= r))
                l++
            if(l < r) {
                // swapping:
                arr[l] = arr[r].also {
                    arr[r] = arr[l]
                };
                l++
            }
        }
        
        QuickSort(arr, lt, l)
        QuickSort(arr, r, rt)
    }
}
