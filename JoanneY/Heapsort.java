//Joanne Yang
//APCS2 PD 8
//HW42
//2014-05-22

/*****************************************************
 * Heapsort 
 * || HEAP GROWTH -> | <- Sorted Region ||
 * 1. Heapify the array to create a min heap
 * 2. Swap min number to the end of the list 
 * 3. Use divider as a placeholder to indicate where to place min number (gate between heapified/sorted region)
 * 4. Print array starting from last element
 *
 * Missing last number...
 *****************************************************/

public class Heapsort {

    public static int[] sort( int[] data ) {	
	heapify( data );
	for( int i = data.length-1; i > 0; i-- )
	    removeMin( data, i );
	return data;
    }


    //Equivalent to add method in ALHeap with slight modifications
    //Heapifies array
    private static void heapify( int[] data ) {

	for( int i = 0; i < data.length; i++ ) {
	    
	    int divider = i;
	    int addValPos = i;
	    int parentPos;

	    while( addValPos > 0 ) { //potentially swap until reach root

		//pinpoint parent
		parentPos = (addValPos-1) / 2;

		if( data[addValPos] < data[parentPos] ) { //addVal < parent
		    swap( data, addValPos, parentPos );
		    addValPos = parentPos;
		}
		else
		    break;
	    }
	}
    }


    //Equivalent to removeMin method in ALHeap with slight modifications
    //Sorted region on the right
    public static void removeMin( int[] data, int divider ) {

	//store root value for return at end of fxn
	int retVal = data[0];

	//store val about to be swapped into root
	int foo = data[ divider ];

	//swap last (rightmost, deepest) leaf with root
	swap( data, 0, divider );

	// walk the now-out-of-place root node down the tree...
	int pos = 0;
	int minChildPos;

	while( pos < divider ) {

	    //choose child w/ min value, or check for child
	    minChildPos = minChildPos(data, divider, pos);

	    //if no children, then i've walked far enough
	    if ( minChildPos == -1 ) 
		break;
	    //if i am less than my least child, then i've walked far enough
	    else if ( foo <= data[minChildPos] ) 
		break;
	    //if i am > least child, swap with that child
	    else {
		swap( data, pos, minChildPos );
		pos = minChildPos;
	    }
	}
    }


    private static int minChildPos( int[] data, int divider, int pos ) {
	int retVal;
	int lc = 2*pos + 1; //index of left child
	int rc = 2*pos + 2; //index of right child

	//pos is not in the array or pos is a leaf position
	if ( pos < 0 || pos >= divider || lc >= divider )
	    retVal = -1;
	//if no right child, then left child is only option for min
	else if ( rc >= divider )
	    retVal = lc;
	//have 2 children, so compare to find least 
	else if ( data[lc] < data[rc] )
	    retVal = lc;
	else
	    retVal = rc;
	return retVal;
    }


    private static void swap( int[] data, int pos1, int pos2 ) {
	int tmp = data[pos1];
	data[pos1] = data[pos2];
	data[pos2] = tmp;
    }


    public static void printArr( int[] a ) {
	for( int i = a.length-1; i > 0; i-- )
	    System.out.print( a[i] + " " );
	System.out.println();
    }

    
    public static void main( String[] args ) {
	int[] arr = {2, 4, 6, 8, 10, 1, 3, 5, 7, 9};
        printArr( sort( arr ) );
    }

}
