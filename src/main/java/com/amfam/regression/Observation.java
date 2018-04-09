package com.amfam.regression;

/**
 *
 */
public class Observation {

    private Double clas;
    private Double thickness;
    private Double size;
    private Double shape;
    private Double madh;
    private Double epsize;
    private Double bnuc;
    private Double bchrom;
    private Double nNuc;
    private Double mit;

    public Observation(Double clas, Double thickness, Double size, Double shape,
                       Double madh, Double epsize, Double bnuc, Double bchrom, Double nNuc, Double mit) {
        this.clas = clas;
        this.thickness = thickness;
        this.size = size;
        this.shape = shape;
        this.madh = madh;
        this.epsize = epsize;
        this.bnuc = bnuc;
        this.bchrom = bchrom;
        this.nNuc = nNuc;
        this.mit = mit;
    }

    public Double getClas() {
        return clas;
    }

    public void setClas(Double clas) {
        this.clas = clas;
    }

    public Double getThickness() {
        return thickness;
    }

    public void setThickness(Double thickness) {
        this.thickness = thickness;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Double getShape() {
        return shape;
    }

    public void setShape(Double shape) {
        this.shape = shape;
    }

    public Double getMadh() {
        return madh;
    }

    public void setMadh(Double madh) {
        this.madh = madh;
    }

    public Double getEpsize() {
        return epsize;
    }

    public void setEpsize(Double epsize) {
        this.epsize = epsize;
    }

    public Double getBnuc() {
        return bnuc;
    }

    public void setBnuc(Double bnuc) {
        this.bnuc = bnuc;
    }

    public Double getBchrom() {
        return bchrom;
    }

    public void setBchrom(Double bchrom) {
        this.bchrom = bchrom;
    }

    public Double getnNuc() {
        return nNuc;
    }

    public void setnNuc(Double nNuc) {
        this.nNuc = nNuc;
    }

    public Double getMit() {
        return mit;
    }

    public void setMit(Double mit) {
        this.mit = mit;
    }
}
