package eg.edu.alexu.csd.datastructure.linkedList.cs10_cs24;

public class dLinkedList {
	  public dNode head;
	  public void add(int index,Object a){
	      if(head==null&&index==0){
	           dNode n=new dNode();
	           n.data=a;
	           n.next=null;
	           head=n;
	      }
	       else if(index==0){
	          dNode n=new dNode();
	          n.data=a;
	          n.next=head;
	           head.prev=n;
	           head=n;
	      }
	      else if(index!=0){
	          int i=0;
	          dNode n=head;
	           while(n.next!=null){i++;n=n.next;}
	          if(index>i+1){throw new IllegalArgumentException("Cannot add a node at an index that does not exist");}
	          else{
	               dNode b=new dNode();
	               b.data=a;
	               n=head;
	               for(i=0;i<index-1;i++){n=n.next;}
	               b.prev=n;
	              b.next=n.next;
	              n.next=b;
	          }
	      }
	  }
	      public void add(Object a){
	      dNode n=head;
	      if(n==null){head=new dNode();n=head;n.data=a;head.next=null;}
	      else{
	          while(n.next!=null){n=n.next;}
	          dNode b=new dNode();
	          b.data=a;
	          b.prev=n;
	          b.next=null;
	          n.next=b;
	      }
	      }
	      public Object get(int index){
	      dNode n=head;
	      int i=0;
	      while (n.next!=null){i++;n=n.next;}
	      if(index>i){throw new IllegalArgumentException("Cannot get a node at an index that does not exist");
	      }
	      n=head;
	      for( i=0;i<index;i++){
	          n=n.next;

	      }
	      return n.data;
	      }
	      public void set(int index, Object element){
	          dNode n=head;
	          int i=0;
	          while (n.next!=null){i++;n=n.next;}
	          if(index>i){throw new IllegalArgumentException("Cannot get a node at an index that does not exist");
	          }
	          n=head;
	          for( i=0;i<index;i++){
	              n=n.next;

	          }
	          n.data=element;
	      }

	      public void clear(){
	      dNode n=head,b;
	      while(n.next!=null){n=n.next;}
	      while(n.prev!=null){b=n;n=n.prev;b.prev=null;n.next=null;}
	      head=null;
	      }
	      public boolean isEmpty(){
	      if(head==null){return true;}
	      else{return false;}
	      }
	      public void remove(int index){
	      dNode n=head;
	      int i=0;
	      while (n.next!=null){i++;n=n.next;}
	      if(index>i){throw new IllegalArgumentException("Cannot get a node at an index that does not exist"); }
	      n=head;
	      for(i=0;i<index;i++){
	          n=n.next;
	      }
	      if(n==head){head=head.next;head.prev.next=null;head.prev=null;}
	      else {dNode v=n.prev;v.next=n.next;if(n.next!=null){n.next.prev=v;n.next=null;n.prev=null;}}


	      }
	      public int size(){
	      int i=0;
	      dNode n=head;
	      while(n.next!=null){n=n.next;i++;}
	      i++;
	      return i;
	      }
	      public dLinkedList sublist(int fromIndex, int toIndex){
	      int i;
	      dLinkedList a=new dLinkedList();
	      dNode n=head;
	      int j=0;
	      for(i=0;i<fromIndex;i++){n=n.next;j=i;}

	      System.out.println("#"+j);
	      while(j<=toIndex){a.add(n.data);n=n.next;j++;}
	      return a;
	      }
	      public boolean contains(Object o){
	      dNode n=head;
	      while(n.next!=null){
	          if(n.data==o){return true;}
	          n=n.next;
	      }
	      if(n!=null&&n.data==o){return true;}
	      return false;
	      }

}
