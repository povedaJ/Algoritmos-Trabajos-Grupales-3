package domain;

public class Recursive {
    public double mcd(int x, int y) {
     if(y==0)return x;

     return mcd(y,x%y);
    }

    public int ackerman(int m, int n){
        if(m==0){return n+1;}
        else if (n==0 ) return ackerman(m-1,1);
        else return ackerman(m-1,ackerman(m,n-1));
    }
    public int min(int a[], int index,int value) {
        if(index !=a.length){
            if (a[index]<value){
        value=min(a,index+1,a[index]);
        }else {
                value=min(a,index+1,value);
            }
        }
        return value;
    }
}//end