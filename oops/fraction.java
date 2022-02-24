package oops;

public class fraction {
    private int denominator;
    private int numerator;
    public fraction(int numerator,int denominator) throws zerodenominatorexception   
    {                                                                              //throws exception if denominator is entered zero
     if(denominator == 0)
     {
        throw new zerodenominatorexception(); 
     }
     this.denominator = denominator;
     this.numerator = numerator;
     simplify();
    }
    public void setdenominator(int denominator)
    {
      if(denominator == 0)
      {
          return;
      }
      this.denominator = denominator;
      simplify();
    }
    public void setnumerator(int numerator) 
    {
       this.numerator = numerator;
       simplify();  
    }
    public int getdenominator()
    {
        return denominator;
    }
    public int getnumerator()
    {
        return numerator;
    }
    public void simplify()
    {
        int gcd = 1;
        int smallest = Math.min(denominator, numerator); //(12/6) minimum is 6
        for(int i = 2;i<=smallest;i++) //loop will run till 6 because 6 can also be the the greatest common divisor 
        {
           if(i % numerator == 0 && i % denominator == 0) 
           {
               gcd = i;   
           }
        }
        denominator = denominator/gcd; 
        numerator = numerator/gcd;

    }
    public void print()
    {
        if(denominator == 0)
        {
            System.out.println(denominator);
        }
        else
        {
            System.out.println(numerator+"/"+denominator);
        }
    }
    public void add(fraction f2) //f2 is of fraction type as it has data fields of numerator and denominator
    {
      this.numerator = this.numerator * f2.denominator + f2.numerator * this.denominator;  //this.numerator is referring to cureent object and it will add another fraction in it 
      this.denominator = this.denominator * f2.denominator;
      simplify();
    }
    public void multiply(fraction f2)
    {
    this.numerator = this.numerator * f2.numerator;
    this.denominator = this.denominator * f2.numerator;
    simplify();
    }
    public static fraction add(fraction f1,fraction f2) throws zerodenominatorexception  //we are returning a new fraction so return type is fraction 
    {
        int newnumerator = f1.numerator * f2.denominator + f2.numerator * f1.denominator;
        int newdenominator = f1.denominator * f2.denominator;
        fraction f = new fraction(newnumerator, newdenominator);
        return f;
    }

}
class fractionuse 
{
    public static void main(String[] args) throws zerodenominatorexception {
        fraction f1 = new fraction(12,6);
        System.out.println("value of f1 is");
        f1.print(); //check the value of f1 here
        fraction f2 = new fraction(13,5);
        System.out.println("value of f2 is");
        f2.print();
        f1.add(f2);
        System.out.println("added f2 in f1 "); 
        f1.print(); //now check it again it will be different because now f1 will add f2 in itself
        System.out.println("value of f2 will remain same");
        f2.print(); // f2 value will remain same 
        fraction f = fraction.add(f1, f2); //as add function is static we must access it from the class name
        System.out.println("new fraction");
        f.print();
        f1.multiply(f2);
        f1.print(); // now f1 value will be updated as it is multiplying f2 in it
    }
    
}
