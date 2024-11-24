public class Label {
    private String type;
    private int iD;
    private int day;
    private int month;

    public Label() {
        this.type = "";
        this.iD = 0;
        this.day = 0;
        this.month = 0;
    }

    public Label(String type, int iD, int day, int month) {
        this.type = type;
        this.iD = iD;

        if (day < 1 || day > 31) {
            this.day = 0;
        } else {
            this.day = day;
        }

        if (month < 1 || month > 12) {
            this.month = 0;
        } else {
            this.month = month;
        }
    }

    public Label(Label other) {
        this.type = other.type;
        this.iD = other.iD;
        this.day = other.day;
        this.month = other.month;
    }

    public String getType() {
        return this.type;
    }

    public int getID() {
        return this.iD;
    }   

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public void setDay(int day) {
        if (day < 1 || day > 31) {
            this.day = 0;
        } else {
            this.day = day;
        }
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            this.month = 0;
        } else {
            this.month = month;
        }
    }

    @Override
    public String toString() {
        return "Type: " + this.type + "\n" +
        "ID: " + this.iD + "\n" +
        "Expiry date: " + String.format("%02d", this.day)+"/"+String.format("%02d", this.month);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Label other = (Label) obj;
        return this.type.equals(other.type) &&
               this.iD == other.iD &&
               this.day == other.day &&
               this.month == other.month;
    }
}
