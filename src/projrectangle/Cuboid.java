/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projrectangle;

import enumeration.Material;

/**
 *
 * @author Solanid
 */
public class Cuboid extends Rectangle {

    private int length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int calcVolume() {
        return length * getWidth() * getHeight();
    }

    public int calcSurface() {
        return (length * getHeight() + getWidth() * getHeight() + getWidth() * length) * 2;
    }

    public Cuboid(int l, int h, int w) {
        super(w, h);  // super zavolame a posleme hodnoty konstruktory nadtriedy (musime to napisat v prvom riadku)
        length = l;
    }

    public Cuboid() {

    }

    @Override  // vsetko co zacina @ je informacia pre kompilator, v tomto 
    //pripade ze sme vytvorili schvalne premennu s rovnakym nazvom ako sme us zdedili
    public int calcArea() {
        System.out.println("Not supported method.");
        return -1;
    }

    @Override
    public int calcCirc() {
        System.out.println("Not supported method.");
        return -1;
    }

    @Override
    public float calcDiagonal() {
        return (float) Math.sqrt(Math.pow(getWidth(), 2) + Math.pow(getHeight(), 2) + Math.pow(length, 2));
    }
    
    public int calcWeight(int density) {
        return calcVolume()*density;
    }
    
    public int calcWeight(Material type) {
        switch(type){
            case ALUMINIUM: return calcVolume()*2700;
            case GOLD: return calcVolume()*19290;
            case LEAD: return calcVolume()*11340;
            case WOOD: return calcVolume()*600;
            case POLYSTYRENE: return calcVolume()*1050;
            default: return 0;
        }
    }
}
