package csc220.program5.lucawr;

import csc220.list.AddIterator;
import csc220.list.Node;

public class List<E> extends csc220.list.List<E> { 
       
   @Override
   public AddIterator<E> addIterator(){return new ListAddIterator<>();}
   
   
   //  This nested class replaces the one in csc220.list.List
   protected class ListAddIterator<T extends E> extends csc220.list.List<E>.ListAddIterator<E> {
       
       private static final boolean DEBUGGING = true;
      
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
            if(first == null){
                first.data = e;
                first.next = nextNode;
        
            }else{
                Node tmpNode = nextNode;
                nextNode.data = e;
                nextNode.next = nextNode;
            }
        }
        
        @Override
        public void remove() {
            if(first != null){
                prevNode = first;
                while(prevNode.next != last){
                    prevNode = prevNode.next;
                }
                
            }
        }
     }
   
   
}
