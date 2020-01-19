package patterns.cursach.censorshipstrategy;

public class DeleteStrategy implements CensorshipStrategy {


    @Override
    public String replace(String word) {

        return "---";
    }
}
