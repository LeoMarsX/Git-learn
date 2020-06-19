public class Fib {
    public static void main(String[] args) {
        for(int i=1;i<=200;i++){
            System.out.println(Fibonacci(i));
        }
    }
    static int Fibonacci(int x){
        if(x==1){
            return 1;
        }
        if(x==2){
            return 1;
        }
        return Fibonacci(x-1)+Fibonacci(x-2);
    }
}
