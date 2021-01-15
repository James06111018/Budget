import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Accounting implements BudgetRepo{

    private List<Budget> mList = new ArrayList<>();
    private BigDecimal result;

    public void setBudgets(List<Budget> list) {
        mList = list;
    }

    public BigDecimal totalAmount(String start, String end) {

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate startDate = LocalDate.parse(start, df);
        LocalDate endDate = LocalDate.parse(end, df);

        int length = startDate.lengthOfMonth();

        int days = Period.between(startDate, endDate).getDays() + 1;

//        System.out.println(">>>"+length+"---"+days);


        result = BigDecimal.valueOf(0);

        List<Budget> list = getAll();



        list.stream().forEach(action->{
//            action.getYearMonth();
//            System.out.println(">>"+action.getAmount());
            result = BigDecimal.valueOf(action.getAmount() / length * days);
        });

        return result;
    }

    @Override
    public List<Budget> getAll() {
        return mList;
    }
}
