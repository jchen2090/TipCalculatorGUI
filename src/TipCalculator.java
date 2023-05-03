public class TipCalculator
{

    //Attributes should be bill, tip percentage, number of people.
    private double bill;
    private int tipPercentage;
    private int numberOfPeople;

    public TipCalculator(double bill, int tipPercentage, int numberOfPeople)
    {
        this.bill = bill;
        this.tipPercentage = tipPercentage;
        this.numberOfPeople = numberOfPeople;
    }

    //getters and setters for all three attributes
    public double getBill() {return bill;}
    public int getTip() {return tipPercentage;}
    public int getNumberOfPeople() {return numberOfPeople;}
    public void setBill(double newBill) {bill = newBill;}
    public void setTipPercentage(int newPercent) {tipPercentage = newPercent;}
    public void setNumberOfPeople(int newNumberOfPeople) {numberOfPeople = newNumberOfPeople;}

    //calculate the tip
    public double calculateTip()
    {
        return bill*tipPercentage/100.0;
    }

    //calculate total bill
    public double totalBill()
    {
        return bill + calculateTip();
    }

    //calculate tip per person
    public double tipPerPerson()
    {
        return calculateTip()/numberOfPeople;
    }

    //Total per person
    public double totalPerPerson()
    {
        return bill/numberOfPeople + tipPerPerson();
    }
}
