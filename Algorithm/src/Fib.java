public class Fib {
    public static void main(String[] args) {

        for(int i=1;i<=200;i++){
            System.out.println(Fibonacci.of(i));
        }
    }
    static class Fibonacci{
         static int of(int x){
            if(x==1){
                return 1;
            }
            if(x==2){
                return 1;
            }
            return of(x-1)+of(x-2);
        }
    }

}
