package csc220.program5.lucawr;

import csc220.list.AddIterator;
import csc220.list.Node;

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
            if(!hasNext()){
                throw new Error("No Such Element");
            }
            Node<E> tmpNode = new Node<>();
            tmpNode.data = e;
            prevNode.next = tmpNode;
            tmpNode.next = nextNode;
        }
        
       /**
        *
        */
       @Override
        public void remove() {

            if( prevNode != first && prevNode != null){
                Node<E> tmp = first;
                while(tmp.next != prevNode){
                    tmp = tmp.next;
                }
                tmp.next = nextNode;
            }
            else{
                prevNode = prevNode.next;
                first = prevNode;
                
            }
            prevNode = null;
        }
     }
   
   
}
