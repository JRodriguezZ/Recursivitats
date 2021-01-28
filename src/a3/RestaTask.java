package a3;

import java.util.concurrent.RecursiveTask;

public class RestaTask extends RecursiveTask<Long> {
    int n1;
    int n2;

    public RestaTask(int i, int j) {
        n1 = i;
        n2 = j;
//        if (i < j) {
//            return 0;
//        } else {
//            return 1 + RestaTask(i - j, j);
//        }
    }

    public Long restaRec(int i, int j) {
        //System.out.println("rec" + n);
        if (i <= 1) return (long) i;
        RestaTask r1 = new RestaTask(i,j);
        r1.fork();
        RestaTask r2 = new RestaTask(i,j);
        r2.fork();
        return r2.join() - r1.join();
    }

    @Override
    protected Long compute() {
        if(n1 < n2){
            return 0L;
        } else {
            return restaRec(n1, n2);
        }
    }

    public static void main(String[] args) {
        int n1 = 9;
        int n2 = 3;

//        System.out.printf("S'ha restat %d vegades", RestaTask(n1, n2));

    }
}


