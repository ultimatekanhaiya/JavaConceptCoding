package java_lang;

public class FinalVsImmutable {

    public static void main(String[] args) {

        final StringBuffer sb = new StringBuffer("hello");
        sb.append(" world");
        System.out.println(sb);

        final int a = 10;

        // a = a + 10;

        // sb = new StringBuffer("Test");
    }

}
