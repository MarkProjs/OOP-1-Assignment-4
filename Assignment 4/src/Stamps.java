//----------------------------------------------------------------
// Assignment 4
// Written by: Mark Benedict Agluba, 40294956
// For COMP 248 Section S - Fall 2024
//----------------------------------------------------------------

public class Stamps {
    // Static constants for stamp values
    public static final int CATEGORY_A = 2;
    public static final int CATEGORY_B = 5;
    public static final int CATEGORY_C = 10;
    public static final int CATEGORY_D = 15;
    public static final int CATEGORY_E = 20;

    private int category_A;
    private int category_B;
    private int category_C;
    private int category_D;
    private int category_E;

    public Stamps() {
        this.category_A = 0;
        this.category_B = 0;
        this.category_C = 0;
        this.category_D = 0;
        this.category_E = 0;
    }

    public Stamps(int category_A, 
    int category_B, 
    int category_C, 
    int category_D, 
    int category_E) {
        this.category_A = category_A;
        this.category_B = category_B;
        this.category_C = category_C;
        this.category_D = category_D;
        this.category_E = category_E;
    }

    public Stamps(Stamps original) {
        this.category_A = original.category_A;
        this.category_B = original.category_B;
        this.category_C = original.category_C;
        this.category_D = original.category_D;
        this.category_E = original.category_E;
    }

    public int getCategoryA() {
        return category_A;
    }

    public int getCategoryB() {
        return category_B;
    }

    public int getCategoryC() {
        return category_C;
    }

    public int getCategoryD() {
        return category_D;
    }

    public int getCategoryE() {
        return category_E;
    }

    public void setCategoryA(int categoryA) {
        this.category_A = categoryA;
    }

    public void setCategoryB(int categoryB) {
        this.category_B = categoryB;
    }

    public void setCategoryC(int categoryC) {
        this.category_C = categoryC;
    }

    public void setCategoryD(int categoryD) {
        this.category_D = categoryD;
    }

    public void setCategoryE(int categoryE) {
        this.category_E = categoryE;
    }

    public void addStamps(int increaseCategoryA, 
    int increaseCategoryB, 
    int increaseCategoryC, 
    int increaseCategoryD, 
    int increaseCategoryE) {
        this.category_A += increaseCategoryA;
        this.category_B += increaseCategoryB;
        this.category_C += increaseCategoryC;
        this.category_D += increaseCategoryD;
        this.category_E += increaseCategoryE;
    }

    public int StampsTotal() {
        return ((this.category_A * CATEGORY_A) + 
        (this.category_B * CATEGORY_B) + 
        (this.category_C * CATEGORY_C) + 
        (this.category_D * CATEGORY_D) + 
        (this.category_E * CATEGORY_E));
    }
    @Override
    public String toString() {
        return "Category A: " + this.category_A + "\n" +
        "Category B: " + this.category_B + "\n" +
        "Category C: " + this.category_C + "\n" +
        "Category D: " + this.category_D + "\n" +
        "Category E: " + this.category_E + "\n";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Stamps other = (Stamps) obj;
        return this.category_A == other.category_A &&
            this.category_B == other.category_B &&
            this.category_C == other.category_C &&
            this.category_D == other.category_D &&
            this.category_E == other.category_E;
    }
}