public class Solution08 {
    public static void drawLine(byte[] screen, int w, int x1, int x2, int y){
        int start = y * w / 8 + x1 / 8;
        int end = y * w / 8 + x2 / 8;

        byte mask=0;
        for (int i=x1%8; i<8; i++){
            mask = (byte) (mask << 1);
            mask++;
        }
        screen[start] = (byte) (screen[start] | mask);

        mask = (byte) 0b11111111;
        for (int i=start+1; i<end; i++){
            screen[i] = (byte) (screen[i] | mask);
        }

        mask = 0;
        for (int i=0; i<=x2%8; i++){
            mask = (byte) (mask << (byte)1);
            mask++;
        }
        screen[end] = (byte) (screen[end] | mask);

        return;
    }
}