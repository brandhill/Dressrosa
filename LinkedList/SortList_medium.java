/*
Sort List
Sort a linked list in O(n log n) time using constant space complexity.
*/
/*
our question is to sort whole list, different with binary search, which is to find one target in O(log n) time, 
        c if n = 1,
T(n) = { 
        2T(n / 2) + cn if n > 1,
T(n) = 2T(n / 2) + cn
     = 2(2T(n / 4) + cn / 2) + cn = 4(T / 4) + 2n
     ...
     = nT(1) + logn * n
that is, O(n log n)
为什么不用QuickSort? 因为对于链表随机访问太耗时, 而heap sort不可行
*/
/*
 0 1 2 3
 2 8 1 5
 pivot = 2
 i = 0 j = 3
 <- j--
 0 1 2 3
 1 8 2 5
 i = 0 j = 2
 -> i++
 0 1 2 3
 1 2 8 5
 i = 1 j = 2 at this time j = i + 1, move on
 {1} 2 {8 5}
 pivot = 1
 ...
 pivot = 8
 ...
 {1} 2 {5 8}
快速排序是找出一个元素(理论上可以随便找一个)作为基准(pivot), 然后对数组进行分区操作, 使基准左边元素的值都不大于基准值, 基准右边的元素值都不小于基准值, 如此作为基准的元素调整到排序后的正确位置,
最优情况下, Partition每次都划分得很均匀, 如果排序n个关键字, 其递归树的深度就为logn + 1, 即仅需递归logn次, 需要时间为T(n)的话, 第一次Partiation应该是需要对整个数组扫描一遍, 做n次比较。然后, 获得的枢轴将数组一分为二, 那么各自还需要T(n / 2)的时间(注意是最好情况，所以平分两半)。于是不断地划分下去, 我们就有了下面的不等式推断,
T(1) = 0,
T(n) <= 2T(n / 2) + n
T(n) <= 2(2T(n / 4) + n / 2) + n =  4T(n / 4) + 2n
...
T(n) <= nT(1) + logn * n = O(n log n)
最坏情况是每次划分选取的基准都是当前无序区中关键字最小(或最大)的记录, 划分的结果是基准左边的子区间为空(或右边的子区间为空), 而划分所得的另一个非空的子区间中记录数目, 仅仅比划分前的无序区中记录个数减少一个。时间复杂度为O(n^2)
需要执行n - 1次递归调用, 且第i次划分需要经过n - i次关键字的比较才能找到第i个记录, 也就是枢轴的位置, 比较次数
(n - 1) + (n - 2) + ... + 1 = n * (n - 1) / 2
关键字的比较和交换是跳跃进行的, 快速排序是一种不稳定的排序方法
*/
