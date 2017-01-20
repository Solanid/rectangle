/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projrectangle;

import enumeration.Material;
import java.util.Random;

/**
 *
 * @author Solanid
 */
public class ProjRectangle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Rectangle rect1 = new Rectangle();
        rect1.setWidth(8);
        rect1.setHeight(5);
        System.out.println("Width is: " + rect1.getWidth() + "\nHeight is: " + rect1.getHeight());
        System.out.println("Diagonal is: " + rect1.calcDiagonal() + "\nArea is: " + rect1.calcArea() + "\nCircumference is: " + rect1.calcArea());

        Rectangle rect2 = new Rectangle();
        rect2.setWidth(9);
        rect2.setHeight(7);
        rect2.swap();
        rect2.setFill(false);
        rect2.decrease();
        rect2.random(5, 10);
        System.out.println("Area is: " + rect2.calcArea() + "\nCircumference of Rect2 is: " + rect2.calcCirc());
        rect2.about();
        rect2.convertToSquare();
        rect2.show('@');

        Rectangle rect3 = new Rectangle(8, 5);
        System.out.println(rect1.compareByArea(rect2));

        Rectangle[] rectArray = new Rectangle[100];
        int i;
        int num1, num2;
        Random rnd = new Random();
        for (i = 0; i < 100; i++) {
            num1 = rnd.nextInt(18) + 3;
            num2 = rnd.nextInt(18) + 3;
            rectArray[i] = new Rectangle(num1, num2);
            if (rectArray[i].isSquare()) {
                rectArray[i].about();
            }
        }
        Cuboid cub1 = new Cuboid();
        cub1.setWidth(15);
        cub1.setHeight(22);
        cub1.setLength(12);
        System.out.println("Volume of the cube is: " + cub1.calcVolume());
        System.out.println("Surface of the cube is: " + cub1.calcSurface());
        Cuboid cub2 = new Cuboid(1,1,1);
        cub2.calcArea();

        Object obj;
        System.out.println(cub1.toString()); // akeho typu je premenna a na konci napise Hash Code
        // wait(); // pozastavy nejaky program
        // notify(); // opat spusti nejaky program
        System.out.println("Weight of cube2 is: "+cub2.calcWeight(Material.GOLD));
        System.out.println("Date is: "+cub2.whatIsTheTime());
        
    }
}
