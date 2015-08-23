/*
Climbing Stairs
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/
// SOL 1 first we can think about using DFS recursive method. But may cause time limited error.
// 由于递归的层数太多，需要的内存指数级递增。这也是递归的弊端。而且n越大弊端表现的越明显。
// time T(n) = T(n - 1) + T(n - 2) = T(n - 2) + T(n - 3) + T(n - 3) + T(n - 4) = ... = O(1.618^n), space O(N)
public class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        
        if (n == 2) {
            return 2;
        }
        
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
// SOL 2 Iteration
// 有重复子问题
// 思路：爬楼梯就是裴波那契数列
// 斐波那契数列：0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
// 注：此时a1=0，a2=1，an=a(n-1)+a(n-2)（n>=2,n∈N*）
// 即：裴波那契数列的第n项的值是第n阶楼梯的爬法的种类数
// time O(N) space O(N)
public class Solution {
    public int climbStairs(int n) {
        int a = 0;
        int b = 1;
        int sum = 0;
        
        for (int i = 1; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }
}
// SOL 3 tail recursive
// 2 more spaces, but dont to store middle stacks.
// time T(n) = T(n - 1) = T(n - 2) = ... so O(N)
climStairs(int n, int ret1, int re2) {
    if (n == 0) {
        return ret1;
    }
    
    return climStairs(n - 1, ret2, ret1 + ret2);
}
