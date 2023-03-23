/*Develop an interface with two methods namely, add and multiply for addition and multiplication of
mathematical objects such as vectors and matrices. Develop a class Vector that implements the
interface with necessary data members. Develop another class Matrix that implements the interface
with necessary data members. Develop a class containing the main method and show the computation
of the sum of two vectors and their scalar product and the sum of two matrices and the product of the
matrices. [*/

import java.util.*;

interface Objects {
    Objects add(Objects obj);
    Objects multiply(Objects obj);
}

class Matrix implements Objects {
    public int rows;
    public int cols;
    public double[][] matrix;


    public Matrix(double[][] matrix) {
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        this.matrix = matrix;
    }
    public Objects add(Objects other) {
    Matrix m= (Matrix) other;
    double res[][]=new double[rows][cols];
    for (int i=0; i<rows; i++) {
    for (int j=0; j<cols; j++) {
            res[i][j] = matrix[i][j] + m.matrix[i][j];
        }
    }
        return new Matrix(res);
}

    public Objects multiply(Objects obj){
    Matrix m= (Matrix) obj;
    double res[][]=new double[rows][cols];
    for (int i=0; i<rows; i++) {
        for (int j=0; j<m.cols; j++) {
            double sum=0;
            for (int k=0; k<cols; k++) {
                sum=sum + (matrix[i][k] * m.matrix[k][j]);
                       }
                    res[i][j] = sum;
         }
    }
                return new Matrix(res);
    }
}

class Vector implements Objects {
    public double vector[];

    public Vector(double vector[]) {
        this.vector = vector;
    }

    public Objects add(Objects obj1) {
    Vector vectr= (Vector) obj1;
    double res[]=new double[vector.length];
        for (int i=0; i<vector.length; i++) {
        res[i] =vector[i] +vectr.vector[i];
    }
    return new Vector(res);
}

public Objects multiply(Objects obj2){
    Vector v= (Vector) obj2;
    double sum=0;
    for (int i=0; i<vector.length; i++) {
        sum=sum + (vector[i] * v.vector[i]);
    }
    return new Vector(new double[] {sum});
}
}

public class Driver {
    public static void main(String[] args) {
        Matrix mat1=new Matrix(new double[][] {{11, 10},{13, 20}});
        Matrix mat2=new Matrix(new double[][] {{13, 12},{10, 15}});
        Vector vec1=new Vector(new double[] {2, 5, 4});
        Vector vec2=new Vector(new double[] {1, 3, 9});

        System.out.println("------For Matrices-------");
        System.out.println("Matrix1: "+Arrays.deepToString(mat1.matrix));
        System.out.println("Matrix2: "+Arrays.deepToString(mat2.matrix));
        Matrix mat3= (Matrix) mat1.add(mat2);
        System.out.println("Addition: "+Arrays.deepToString(mat3.matrix));
        Matrix mat4= (Matrix) mat1.multiply(mat2);
        System.out.println("Multiplication: "+Arrays.deepToString(mat4.matrix));

        System.out.println("--------For Vectors--------");
        System.out.println("Vector1: "+Arrays.toString(vec1.vector));
        System.out.println("Vector2: "+Arrays.toString(vec2.vector));
        Vector vec3= (Vector) vec1.add(vec2);
        System.out.println("Addition: "+Arrays.toString(vec3.vector));
        Vector vec4= (Vector) vec1.multiply(vec2);
        System.out.println("Multiplication: "+Arrays.toString(vec4.vector));
    }
}
