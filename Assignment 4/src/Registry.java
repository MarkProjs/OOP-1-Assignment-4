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

    public boolean compareStamps(Registry other) {
        return this.stamps.equals(other.stamps);
    }

    public boolean compareValueStamps(Registry other) {
        return this.stamps.StampsTotal() == other.stamps.StampsTotal();
    }

}
