import java.util.Arrays;

public class TesMyList {
    public static void main(String[] args) {
        MyList<Double> myList = new MyList<Double>();
        myList.add(0,1.0);
        myList.add(1,30.0);
        myList.add(2,2.0);
        myList.add(3,10.0);

        for(int i=0; i<myList.getSize();i++){
            System.out.println(myList.get(i));
        }
        int size=myList.getSize();
        System.out.println("myList size= "+size);
        myList.remove(1);
        System.out.println("After remove: ");
        for(int i=0; i<myList.getSize();i++){
            System.out.println(myList.get(i));
        }

        MyList<Integer> myList1 = (MyList<Integer>) myList.clone();// ep kieu tuong minh tu double ve integer;
        System.out.println("clone of myList: ");
        for(int i=0; i<myList1.getSize();i++){
            System.out.println(myList1.get(i));
        }

        System.out.println(myList.contains(10.0));
        System.out.println(myList.indexOf(2.0));
        System.out.println(myList.isAddable(2.0));
        myList.clear();
        for(int i=0; i<myList.getSize();i++){
            System.out.println(myList.get(i));
        }

    }

}
