package vo;

import util.DeliveryType;


public class ExpenseAndDateVO {
    private String city1;
    private String city2;
    private String wrapper;
    private String days;
    private String volume;
    private DeliveryType deliveryType;
    private String expenseOfWrap;
    private String expenseOfTransport;
    private String expense;

    public ExpenseAndDateVO(String city1,String city2,String wrapper,String volume,String days
            ,DeliveryType deliveryType,String expenseOfWrap,String expenseOfTransport,String expense){
        this.city1=city1;
        this.city2=city2;
        this.wrapper=wrapper;
        this.volume=volume;
        this.days=days;
        this.deliveryType=deliveryType;
        this.expenseOfWrap=expenseOfWrap;
        this.expenseOfTransport=expenseOfTransport;
        this.expense=expense;
    }

    public String getCity1(){
        return this.city1;
    }

    public void setCity1(String city1){
        this.city1=city1;
    }

    public String getCity2(){
        return this.city2;
    }

    public void setCity2(String city2){
        this.city2=city2;
    }

    public String getWrapper(){
        return this.wrapper;
    }

    public DeliveryType getDeliveryType(){
        return this.deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType){
        this.deliveryType=deliveryType;
    }

    public void setWrapper(String wrapper){
        this.wrapper=wrapper;
    }

    public String getDays(){
        return this.days;
    }

    public void setDays(String days){
        this.days=days;
    }

    public String getExpenseOfWrap(){
        return this.expenseOfWrap;
    }

    public void setExpenseOfWrap(String expenseOfWrap){
        this.expenseOfWrap=expenseOfWrap;
    }

    public String getExpenseOfTransport(){
        return expenseOfTransport;
    }

    public void setExpenseOfTransport(String expenseOfTransport){
        this.expenseOfTransport=expenseOfTransport;
    }

    public String getExpense(){
        return this.expense;
    }

    public void setExpense(String expense){
        this.expense=expense;
    }

    public String getVolume(){
        return this.volume;
    }

    public void setVolume(String volume){
        this.volume=volume;
    }
}