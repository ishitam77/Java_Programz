/*Create a class called Complex for performing arithmetic with complex numbers. Complex numbers
have the form realPart + imaginaryPart * i; where i is the imaginary unit.
Write a program to test your class. Use floating-point variables to represent the private data of the class.
Provide a constructor that enables an object of this class to be initialized when it’s declared. Provide a
no-argument constructor with default values in case no initializers are provided. Provide public methods
that perform the following operations:
a) Add two Complex numbers: The real parts are added together and the imaginary parts are added
together.
b) Subtract two Complex numbers: The real part of the right operand is subtracted from the real part of
the left operand, and the imaginary part of the right operand is subtracted from the imaginary part of
the left operand.
c) Print Complex numbers in the form (realPart, imaginaryPart). */
class Complex {
private double real, imaginary;

    public Complex(double real, double imaginary){
		this.real = real;
		this.imaginary = imaginary;
	}
	
    public Complex(){
      this(0.0,0.0);
  }
  
    public double real (){
    return real;
  }
  
    public double imaginary (){
    return imaginary;
  }

    public void real (double real){
    this.real = real;
  }

    public void imaginary (double imaginary){
    this.imaginary = imaginary;
  }
	
    public Complex Add(Complex obj1, Complex obj2){
		Complex obj = new Complex();
		obj.real = obj1.real + obj2.real;
		obj.imaginary = obj1.imaginary + obj2.imaginary;
		return obj;
	}
	
    public Complex Subtract(Complex obj1, Complex obj2){
		Complex obj = new Complex();
		obj.real = obj2.real - obj1.real;
		obj.imaginary = obj2.imaginary - obj1.imaginary;
		return obj;
	}

	public static void main(String[] args)
	{

		Complex ob1 = new Complex(1.7, 2.1);
		System.out.println("Complex number 1: " +  Math.round(ob1.real) + " + " + Math.round(ob1.imaginary)+"i");
		Complex ob2 = new Complex(3.9, 5.3);
		System.out.println("Complex number 2: " +  Math.round(ob2.real) + " + " + Math.round(ob2.imaginary)+"i");

		Complex ob3 = new Complex();
		ob3 = ob3.Add(ob1,ob2);
        System.out.println("Addition of complex number: " + Math.round(ob3.real) + " + " + Math.round(ob3.imaginary)+"i");
		
        Complex ob4 = new Complex();
		ob4 = ob4.Subtract(ob1, ob2);
        System.out.println("Subtraction of complex number: " +  Math.round(ob4.real) + " + " + Math.round(ob4.imaginary)+"i");
	}
}
