public class RationalNumber extends RealNumber
{
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    super((double)nume/deno);
    if (deno == 0){
      numerator = 0;
      denominator = 1;
    }
    else{
      numerator = nume;
      denominator = deno;
    }
    this.reduce();
  }

  //public double getValue(){
    //return other.getValue();
  //}

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    RationalNumber num = new RationalNumber(denominator, numerator);
    return num;
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    if (other.getNumerator() == numerator && other.getDenominator() == denominator){
      return true;
    }
    return false;
  }


  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    int num = numerator;
    int den = denominator;
    if (denominator < 0){
      num = num * -1;
      den = den * -1;
    }
    if (denominator == 1){
      return "" + num;
    }
    return "" + num + "/" + den;
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    if (b != 0) {
      return gcd(b, a%b);
    }
    return a;
  }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    int thegcd = gcd(numerator, denominator);
    numerator = numerator / thegcd;
    denominator = denominator / thegcd;
  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    RationalNumber num = new RationalNumber(
    other.getNumerator() * this.getNumerator(),
    other.getDenominator() * this.getDenominator());
    return num;
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    return this.multiply(other.reciprocal());
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    RationalNumber num = new RationalNumber(
    this.getNumerator() * other.getDenominator() +
    this.getDenominator() * other.getNumerator(),
    this.getDenominator() * other.getDenominator());
    return num;
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    RationalNumber num = new RationalNumber(
    this.getNumerator() * other.getDenominator() -
    this.getDenominator() * other.getNumerator(),
    this.getDenominator() * other.getDenominator());
    return num;
  }
}
