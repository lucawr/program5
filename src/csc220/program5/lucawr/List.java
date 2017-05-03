package csc220.program5.lucawr;

import csc220.list.AddIterator;
import csc220.list.Node;
/*
  5/3/17 CSC220
  Wil Luca
  Description: Usng Prof. Webers List class as a base this List class was created. The
  only edits that were added to the original class were to the remove and addBeforeNext
  methods. This class contains the list of points for the game character to follow
  and allows that list to be manipulated with the two perviously mention methods and 
  extends to the other List class in te csc220.list packaged. The addBeforeNext method
  first checks to see if here is a next node in the list or it throws and error. Otherwise
  it creates a temporary node that is inserted after prevNode and then liked to
  nextNode. The remove method sets prevNode equal to null, eliminating the node that
  the character is on, but this is after the list is completed with by either creating
  a tmpNode that links the node before prevNode and nextNode if the previou node is 
  not on the first node nor null already. Otherwise prevNode is moved down the list,
  first becomes the same value as the new prevNode and prevNode is eliminated by being
  set to null.

Acknowledgments: Seth Rhodes and Andy Jones for helping me fine tune the remove
and addBeforeNext methode. Andy helped a lot with the first if statement.
 */ 

public class List<E> extends csc220.list.List<E> { 
       
   @Override
   public AddIterator<E> addIterator(){return new ListAddIterator<>();}
   
   
   //  This nested class replaces the one in csc220.list.List
   protected class ListAddIterator<T extends E> extends csc220.list.List<E>.ListAddIterator<E> {
       
       private static final boolean DEBUGGING = true;
         Node<E> currentNode;
        protected Node<E> prevNode = null;
        
        @Override
        public E next() {
            prevNode= nextNode;
            return super.next();
        }

        // For debugging purposes.
        private void printNodes(String s) {
            if (!DEBUGGING)
                return;
            System.out.print(s);
            if (prevNode != null) {
                System.out.print("--previous data = " + prevNode.data);
            }
            if (nextNode != null) {
                System.out.print("--next data = " + nextNode.data);               
            }
            System.out.println("");
        }
        
        @Override 
        public void addBeforeNext(E e) {
            if(!hasNext()){ //test to see if anything can even be added before next
                throw new Error("No Such Element");
            }
            Node<E> tmpNode = new Node<>();
            tmpNode.data = e;       //creates new node in between prevNode and nextNode
            prevNode.next = tmpNode;    
            tmpNode.next = nextNode;
        }
        
       /**
        *
        */
       @Override
        public void remove() {

            if( prevNode != first && prevNode != null){//test to see if prevNode is in the right spot
                Node<E> tmpNode = first;
                while(tmpNode.next != prevNode){
                    tmpNode = tmpNode.next;//makes tmpNode the node before prevNode
                }
                tmpNode.next = nextNode;//relinks it so prevNode does not have to be used
            }
            else{
                prevNode = prevNode.next;//prevNode and first were equal or already null
                first = prevNode;           //reorders list so first is farther down the list.
                
            }
            prevNode = null;//eliminates data in prevNode
        }
     }
   
   
}
