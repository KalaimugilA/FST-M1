package activities;

 class customException extends Exception {
     private String message = null;

     public customException(String s) {
         this.message = s;

     }

     @Override
     public String getMessage() {
         return message;
     }
 }

public class Activity8 {
                public static void main(String[] args){
                    try{
                        Activity8.exceptionTest("Will print  to console");
                        Activity8.exceptionTest(null);

                    }
                    catch(customException e){
                        System.out.println("Inside catch block" + e.getMessage());

                    }


                }

                static void exceptionTest(String s) throws customException
                {
                    if (s== null)
                    {
                       throw  new customException("String is null");
                    }
                    else{

                      System.out.println(s);
                    }


                }

}
