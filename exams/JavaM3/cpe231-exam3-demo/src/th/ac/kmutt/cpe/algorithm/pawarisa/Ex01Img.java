package th.ac.kmutt.cpe.algorithm.pawarisa;
import java.util.Scanner;
import th.ac.kmutt.cpe.algorithm.pawarisa.image.*;


public class Ex01Img {
    public static Image brighten(Image inputImg, int value) {
        int h = inputImg.getHeight();
        int w = inputImg.getWidth();

        Image resultImg = new Image(h,w);

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int newVal = Math.min(255, inputImg.getPixels(y,x) + value);
                resultImg.setPixels(y, x, newVal);
            }
        }
        return resultImg;
    }

    public static Image darken(Image inputImg, int value) {
        int h = inputImg.getHeight();
        int w = inputImg.getWidth();

        Image resultImg = new Image(h, w);
        for(int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int newVal = Math.max(0, inputImg.getPixels(y, x) - value);
                resultImg.setPixels(y, x, newVal);
            }
        }
        return resultImg;
    }
    
    public static void main(String[] args) {
        Image myImg = new Image("src/th/ac/kmutt/cpe/algorithm/pawarisa/image/Bee.png");
        Scanner sc = new Scanner(System.in);

        System.out.println("Brighten how much?: ");
        int bright = sc.nextInt();
        System.out.println("Darken how much?: ");
        int dark = sc.nextInt();
        
        Image b = brighten(myImg, bright);
        Image d = darken(myImg, dark);
        b.export("Brighten.png");
        d.export("Darken.png");
        // myImg.export("Bee_Copy.png");
        sc.close();
    }
}
