package activities;


 abstract class Book {

    String title;

      abstract void setTile(String s);

    public String getTile()
    {
        return title;
    }

}

  class MyBook extends Book
        { public void setTile(String s)
        {
            title =s;
        }}

public class Activity5 {
    public static void main(String[] args) {


        MyBook newNovel = new MyBook();
        newNovel.setTile("Tamil");
        System.out.println("The tile is :" + newNovel.getTile());
    }

}


