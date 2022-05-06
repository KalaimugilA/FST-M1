package activities;

public class Activity2 {

    public static void main(String[] args) {

        int[] array = {10, 77, 10, 54, -11, 10};
int sum=0;
        for ( int a=0; a< array.length; a++)
        {
      if(array[a] ==10)
      {

          sum+=array[a];
      }

        }

        System.out.println("Result :  " + sum);

    }

}
