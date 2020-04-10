编写一个算法来判断一个数 n 是不是快乐数。

「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。

如果 n 是快乐数就返回 True ；不是，则返回 False 。
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet<>();
        while(n!=1){
            int m=0;
            while(n!=0){
                m+=(int)Math.pow(n%10,2);
                n/=10;
            }
            if(set.contains(m)){
                return false;
            }
            set.add(m);
            n=m;
        }
        return true;
    }
}

给定一个Excel表格中的列名称，返回其相应的列序号。
class Solution {
    public int titleToNumber(String s) {
        int sum=0;
        int i=0;
        int len=s.length();
        while(i<len){
            int n=s.charAt(i)-'A'+1;
            sum+=n*Math.pow(26,len-i-1);
            i++;
        }
        return sum;
    }
}

给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

返回被除数 dividend 除以除数 divisor 得到的商。

整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE&&divisor==-1){
            return Integer.MAX_VALUE;
        }
        int sum=0;
        long a=Math.abs((long)dividend);
        long b=Math.abs((long)divisor);
        for(int i=31;i>=0;i--){
            if(a>=(b<<i)){
                sum+=1<<i;
                a-=(b<<i);
            }
        }
        return (dividend^divisor)>=0?sum:-sum;
    }
}

给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。

然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。

你需要计算完成所有任务所需要的最短时间。
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] arr=new int[26];
        for(char c:tasks){
            arr[c-'A']++;
        }
        Arrays.sort(arr);
        int maxcount=1;
        for(int i=24;i>=0;i--){
            if(arr[i]!=arr[25]){
                break;
            }
            maxcount++;
        }
        int a=(arr[25]-1)*(n+1)+maxcount;
        int b=tasks.length;
        return a>b?a:b;
    }
}

