public class Registry {
    private Stamps stamps;
    private Label[] labels;

    public Registry() {
        this.stamps = new Stamps();
        this.labels = new Label[0];
    }

    public Registry(Stamps stamps, Label[] labels) {
        this.stamps = stamps;
        if (labels != null) {
            for( int i = 0 ; i < labels.length ; i++) {
                this.labels[i] = new Label(labels[i]);
            }
        } else {
            this.labels = null;
        }
    }

    public boolean compareValueStamps(Registry other) {
        return this.stamps.StampsTotal() == other.stamps.StampsTotal();
    }
    public boolean compareStamps(Registry other) {
        return this.stamps.equals(other.stamps);
    }

    public int shipmentStamps() {
        return this.stamps.StampsTotal();
    }

    public int numberOfLabels() {
        return this.labels.length;
    }

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

    public boolean removeLabel(Label labelToRemove) {
        if (this.labels == null || this.labels.length == 0 || labelToRemove == null) {
            return false; // No labels to remove or invalid input
        }

        int indexofLabelToRemove = -1;
        for (int i = 0; i < this.labels.length; i++) {
            if (this.labels[i].equals(labelToRemove)) {
                indexofLabelToRemove = i;
                break;
            }
        }
        if (indexofLabelToRemove == -1) {
            return false; // Label not found
        }

        Label[] updatedLabels = new Label[this.labels.length - 1];
        for (int i = 0, j = 0; i < this.labels.length; i++) {
            if (i != indexofLabelToRemove) {
                updatedLabels[j++] = this.labels[i];
            }
        }
        this.labels = updatedLabels;
        return true;
    }

    public void updateExpiryDate(Label labelToUpdate, int newDay, int newMonth) {
        for (int i = 0; i < this.labels.length; i++) {
            if (this.labels[i].equals(labelToUpdate)) {
                this.labels[i].setDay(newDay);
                this.labels[i].setMonth(newMonth);
                break;
            }
        }
    }

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
        return this.stamps.StampsTotal() == other.stamps.StampsTotal() &&
            this.labels.length == other.labels.length;
    }

    @Override
    public String toString() {
        String registry = "";
        registry += "Stamps: " + this.stamps + "\n";
        registry += "Labels: " + "\n";
        for (int i = 0; i < this.labels.length; i++) {
            if(this.labels[i] == null) {
                registry += "No prepaid labels" + "\n";
            } else {
                registry += this.labels[i] + "\n";
            }
        }
        return registry;
    }

    public String stampsBreakdown() {
        return this.stamps.getCategoryA() + " x $2 + " + 
        this.stamps.getCategoryB() + " x $5 + " + 
        this.stamps.getCategoryC() + " x $10 + " + 
        this.stamps.getCategoryD() + " x $15 + " + 
        this.stamps.getCategoryE() + " x $20";
    }

}
