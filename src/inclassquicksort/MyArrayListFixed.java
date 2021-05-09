/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inclassquicksort;

/**
 *
 * @author Maximiliano Herrera
 */
public class MyArrayListFixed<E> extends MyArrayList<E> {

    public MyArrayListFixed(boolean debug) {
        super(debug);
    }

    @Override
    protected int partition(int start, int end) {
        print("partition(start: " + start + ", end: " + end + ")");
        
        int down = end;
        E pivot = get(start);
        int up = start;

        print("up: " + up + ", down: " + end + ", pivot: " + pivot);
        
        while (up < down) {
            up++;
            
            while (up < end && ((Comparable) get(up)).compareTo((Comparable) pivot) < 0) {
                up++;
            }          
            
            while (down > start && (((Comparable) get(down)).compareTo((Comparable) pivot) >= 0)) {
                down--;
            }
            if (up < down) {             
                E elemUp = get(up);
                set(up, get(down));
                set(down, elemUp);
            }
        }
     
        set(start, get(down));      
        set(down, pivot);

        print("result partition(start: " + start + ", end: " + end + "): " + this);
      
        return down;
    }

}
