public class Budget {
    private String yearMonth;
    private int amount=0;

    public Budget(String ym, int amount) {
        this.yearMonth = ym;
        this.amount = amount;
    }

    public String getYearMonth() {
        return yearMonth;
    }

    public int getAmount() {
        return amount;
    }
}
