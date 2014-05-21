//Joanne Yang
//APCS2 PD 8
//HW42
//2014-05-21

/*
/*****************************************************
 * Best case scenario: array of Integers are already sorted
 * In both cases, the runtime is O(nlogn) because regardless of list,
 * add(Integer) and removeMin() methods are used for each element.
 *****************************************************/

public class Heapsort {

    public static Integer[] sort( Integer[] data ) {
	
	heapify( data );

	Integer[] newData = new Integer[data.length];
	for( int i = 0; i < newData.length; i++ ) {
	    newData[i] = remove( data );
	}

	/* ***Original code***
	ALHeap pile = new ALHeap();
	for( Integer d: data )
	    pile.add(d);
	System.out.println( pile.toString() );
	
	Integer[] newData = new Integer[data.length];
	for( int i = 0; i < newData.length; i++ )
	    newData[i] = pile.removeMin();
	*/

	return newData;
    }


    //Equivalent to add method in ALHeap with slight modifications
    //Heapifies array
    private static void heapify( Integer[] data ) {

	for( int i = 0; i < data.length; i++ ) {
	    
	    int addValPos = i;
	    int parentPos;

	    while( addValPos > 0 ) { //potentially swap until reach root

		//pinpoint parent
		parentPos = (addValPos-1) / 2;

		if( data[addValPos].compareTo( data[parentPos] ) < 0 ) { //addVal < parent

		    //swap
		    int tmp = data[addValPos];
		    data[addValPos] = data[parentPos];
		    data[parentPos] = tmp;

		    addValPos = parentPos;
		}
		else
		    break;
	    }
	}
    }


    public static void printArr( Integer[] a ) {
	for( Integer i: a )
	    System.out.print( i + " " );
	System.out.println();
    }

    
    public static void main( String[] args ) {
	Integer[] arr = {2, 4, 6, 8, 10, 1, 3, 5, 7, 9};
        printArr( sort( arr ) );
    }

}
