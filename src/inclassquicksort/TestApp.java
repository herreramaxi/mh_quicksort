/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inclassquicksort;

/**
 *
 * @author EThornbury
 */
public class TestApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                MyArrayList<Integer> list = new MyArrayList<Integer>(false);

//         list.add(new Integer(0));
//        list.add(new Integer(58));
//        list.add(new Integer(86));
//        list.add(new Integer(15));
//        list.add(new Integer(6));
//        list.add(new Integer(87));
//        list.add(new Integer(99));
//        list.add(new Integer(35));
//        list.add(new Integer(4));
        list.add(new Integer(99));
        list.add(new Integer(6));
        list.add(new Integer(86));
        list.add(new Integer(15));
        list.add(new Integer(9));
        list.add(new Integer(35));
        list.add(new Integer(87));
        list.add(new Integer(1));

        System.out.println("The elements are: " + list.toString());

        MyArrayList<Integer> cloned = (MyArrayList<Integer>) list.clone();

        cloned.quickSort(0, cloned.size() - 1);

        System.out.println("The elements after Quick sort are: " + cloned.toString());

        
//        // TODO code application logic here
//        MyArrayList<Integer> list = new MyArrayList<Integer>(false);
//
//        list.add(new Integer(4));
//        list.add(new Integer(87));
//        list.add(new Integer(58));
//        list.add(new Integer(35));
//
//        System.out.println("The elements are: " + list.toString());
//
//        list.quickSort(0, list.size() - 1);
//
//        System.out.println("The elements after Quick sort are: " + list.toString());
//        
//          MyArrayListFixed<Integer> list2 = new MyArrayListFixed<Integer>(false);
//
//        list2.add(new Integer(4));
//        list2.add(new Integer(87));
//        list2.add(new Integer(58));
//        list2.add(new Integer(35));
//
//        System.out.println("The elements are: " + list2.toString());
//
//        list2.quickSort(0, list2.size() - 1);
//
//        System.out.println("The elements after Quick sort are: " + list2.toString());
    }

}
