/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projrectangle;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Solanid
 */
public class Rectangle {

    private int width;
    private int height;
    private String border;
    private boolean fill = false;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setBorder(String border) {
        this.border = border;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getBorder() {
        return border;
    }

    public boolean getFill() {
        return fill;
    }

    public float calcDiagonal() {
        return (float) Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
    }

    public int calcArea() {
        return width * height;
    }

    public int calcCirc() {
        return 2 * width + 2 * height;
    }

    public void about() {
        System.out.println("\nwidth: " + width + " height: " + height);
        System.out.println("border: " + border + " fill: " + fill);
    }

    public void show() {
        int i, j;
        if (fill == true) {
            for (i = 0; i < height; i++) {
                for (j = 0; j < width; j++) {
                    System.out.print("x ");
                }
                System.out.println("");
            }
        } else {
            for (i = 0; i < height; i++) {
                for (j = 0; j < width; j++) {
                    if (i == 0 || i == height - 1) {
                        System.out.print("x ");
                    } else if (j == 0 || j == width - 1) {
                        System.out.print("x ");
                    } else {
                        System.out.print("  ");
                    }
                }
                System.out.println("");
            }
        }
    }

    public boolean isSquare() {
        return width == height;
    }

    public void enlarge() {
        width *= 2;
        height *= 2;
    }

    public void decrease() {
        width = Math.round((float) width / 2);
        height = Math.round((float) height / 2);
    }

    // konstruktor triedy metoda, ktora sa spusti pri vytvoreni objektu - new
    // PARAMETRICKY konstruktor
    public Rectangle(int a, int b) {  //nazov metody je rovnaaky ako nazov triedy
        width = a;           // nikdy ju nevolame, ona sa zavola sama
        height = b;           // nastavy defaultne hodnoty
        border = "solid";
        fill = false;
    }

    // BEZPARAMETRICKY konstruktor - pouziva sa aby sme inicializovali premenne
    //                               v danej triede
    // ak mam viac konstruktorov to sa nazyva overloading
    public Rectangle() {
        this(0,0);
        /*width = 0;
        height = 0;
        border = "solid";
        fill = false;*/
    }

    // mozeme mat metody s roznymi nazvami ale musia prijmat ine typi premennych
    // da sa to aj v C
    /* java ma garbage collector je ze sam maze premenne aj premenne typu objekt, 
        takze sa nemusime starat o ramku */
    public void show(char c) {
        int i, j;
        if (fill == true) {
            for (i = 0; i < height; i++) {
                for (j = 0; j < width; j++) {
                    System.out.print(c + " ");
                }
                System.out.println("");
            }
        } else {
            for (i = 0; i < height; i++) {
                for (j = 0; j < width; j++) {
                    if (i == 0 || i == height - 1) {
                        System.out.print(c + " ");
                    } else if (j == 0 || j == width - 1) {
                        System.out.print(c + " ");
                    } else {
                        System.out.print("  ");
                    }
                }
                System.out.println("");
            }
        }
    }

    public void swap() {
        height = width + height;
        width = height - width;
        height = height - width;
    }

    public void random() {
        Random rnd = new Random();
        width = rnd.nextInt(12) + 3;
        do {
            height = rnd.nextInt(12) + 3;
        } while (width == height);
    }

    public void random(int from, int to) {
        if (from >= to) {
            System.out.println("Incorret parameters in method random.");
            return;
        }
        Random rnd = new Random();
        width = rnd.nextInt(to - from) + from;
        do {
            height = rnd.nextInt(to - from + 1) + from;
        } while (width == height);
    }

    public void convertToSquare() {
        if (width < height) {
            height = width;
        } else {
            width = height;
        }
    }

    public void enlarge(int coeff) {
        if (coeff > 1) {
            width *= coeff;
            height *= coeff;
        }
    }
    // pouzivat refactor na mazanie a premenuvavanie premennych
    public boolean compare(Rectangle otherRectangle) {
        if(this.width == otherRectangle.getWidth() && 
                this.height == otherRectangle.getHeight() &&
                this.border == otherRectangle.getBorder()&&
                this.fill == otherRectangle.getFill())
            return true;
        else
            return false;
    }
    public boolean compareByArea(Rectangle otherRectangle) {
        return this.calcArea() == otherRectangle.calcArea();
    }
    
    public String whatIsTheTime() {
        Date actualDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("DD.MM.YY HH:mm");
        
        return dateFormat.format(actualDate);
    }
    
}
