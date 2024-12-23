//----------------------------------------------------------------
// Assignment 4
// Written by: Mark Benedict Agluba, 40294956
// For COMP 248 Section S - Fall 2024
//----------------------------------------------------------------

public class Registry {
    private Stamps stamps;
    private Label[] labels;

    public Registry() {
        this.stamps = new Stamps();
        this.labels = new Label[0];
    }

    public Registry(Stamps stamps, Label[] otherLabels) {
        if (otherLabels == null) {
            this.stamps = stamps;
            this.labels = new Label[0];
        } else {
            this.stamps = stamps;
            this.labels = new Label[otherLabels.length];
            for( int i = 0 ; i < otherLabels.length; i++) {
                this.labels[i] = new Label(otherLabels[i]);
            }
        }

    }
    //Comapare the value of the stamps
    public boolean compareValueStamps(Registry other) {
        return this.stamps.StampsTotal() == other.stamps.StampsTotal();
    }
    //Compare the amount of stamps
    public boolean compareStamps(Registry other) {
        return this.stamps.equals(other.stamps);
    }

    //Return the total amount of stamps
    public int shipmentStamps() {
        return this.stamps.StampsTotal();
    }

    //Return the number of labels
    public int numberOfLabels() {
        return this.labels.length;
    }

    //Add a new label
    public int addLabel(Label newLabel) {
        if (newLabel == null) {
            return this.labels.length; // Do nothing if the label is null
        }

        Label[] updatedLabels = new Label[this.labels.length + 1];
        for(int i = 0; i < this.labels.length; i++) {
            updatedLabels[i] = this.labels[i];
        }
        updatedLabels[this.labels.length] = new Label(newLabel);
        this.labels = updatedLabels;
        return this.labels.length;
    }

    //Remove a label
    public boolean removeLabel(int indexofLabelToRemove) {
        if (indexofLabelToRemove < 0 || indexofLabelToRemove >= this.labels.length) {
            return false;
        }
        Label[] updatedLabels = new Label[this.labels.length - 1];
        for(int i = 0; i < indexofLabelToRemove; i++) {
            updatedLabels[i] = this.labels[i];
        }
        for(int i = indexofLabelToRemove; i < this.labels.length - 1; i++) {
            updatedLabels[i] = this.labels[i + 1];
        }
        this.labels = updatedLabels;
        return true;
    }

    //Update the expiry date
    public void updateExpiryDate(int indexofLabelToRemove, int newDay, int newMonth) {
        this.labels[indexofLabelToRemove].setDay(newDay);
        this.labels[indexofLabelToRemove].setMonth(newMonth);
    }

    //Add stamps
    public int addShipmentStamps(int categoryA, int categoryB, int categoryC, int categoryD, int categoryE) {
        this.stamps.addStamps(categoryA, categoryB, categoryC, categoryD, categoryE);
        return this.stamps.StampsTotal();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Registry other = (Registry) obj;
        if (this.labels.length == 0 && other.labels.length == 0) {
            return true;
        } else {
            return this.stamps.StampsTotal() == other.stamps.StampsTotal() &&
            this.labels.length == other.labels.length;
        }
    }

    @Override
    public String toString() {
        String registry = stampsBreakdown();
        registry += "Stamps: " +"\n"+this.stamps + "\n";
        registry += "Labels: " + "\n";
        if (this.labels.length == 0) {
            registry += "No Labels" + "\n";
        }else {
            for (int i = 0; i < this.labels.length; i++) {
                registry += this.labels[i] + "\n";
            }
        }
        return registry;
    }

    //Breakdown of stamps
    public String stampsBreakdown() {
        return Integer.toString(this.stamps.getCategoryA()) + " x $2 + " + 
        Integer.toString(this.stamps.getCategoryB()) + " x $5 + " + 
        Integer.toString(this.stamps.getCategoryC()) + " x $10 + " + 
        Integer.toString(this.stamps.getCategoryD()) + " x $15 + " + 
        Integer.toString(this.stamps.getCategoryE()) + " x $20" + "\n";
    }

}
