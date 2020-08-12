package top.putop.mi;

public class Test {

    public static void main(String[] args){

        String t = "aaa%2$sccc%1$ssd";
        System.out.println(String.format(t,"dddd","bbb"));
    }

}
