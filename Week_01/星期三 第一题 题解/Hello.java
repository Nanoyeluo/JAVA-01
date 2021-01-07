/**
 * @author Nano
 * @ClassName Hello
 * @Description TODO
 * @Date 2021/1/7 15:27
 * @Version 1.0
 **/
public class Hello {
    private boolean a = true;
    protected byte b = 1;
    final short c = 255;
    public char d = 'a';
    int e = 144;

    public static void main(String[] args) {
        float  f = 121.1f;
        double g = 333.3d;
        double v = f * g;
        double v1 = f + g;
        double v2 = f / g;
        double v3 = f - g;
        long x = 1312L;
        for (int i = 0; i < 3; i++) {
            if(i == 1){
                x = 3333L;
            }

        }
    }
}
