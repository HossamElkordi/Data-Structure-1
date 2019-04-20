package eg.edu.alexu.csd.datastructure.linkedList.cs10_cs24;

public class PolynomialSolver implements IPolynomialSolver {

	sLinkedList A;
	sLinkedList B;
	sLinkedList C;
	sLinkedList R;
	
	public sLinkedList identify (char poly) {
		switch (poly) {
			case 'A': return A;
			case 'B': return B;
			case 'C': return C;
			case 'R': return R;
			default: throw new IllegalArgumentException("Enter a valid poly name");
		}
	}
	
	public static void  bubblesort2d(int a[][]){
        int temp;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length-1-i;j++){
                if(a[j][1]<a[j+1][1]){
                    temp=a[j][0];a[j][0]=a[j+1][0];a[j+1][0]=temp;
                    temp=a[j][1];a[j][1]=a[j+1][1];a[j+1][1]=temp;
                }
                else if(a[j][1]==a[j+1][1]){
                    if(a[j][0]<a[j+1][0]){
                        temp=a[j][0];a[j][0]=a[j+1][0];a[j+1][0]=temp;
                        temp=a[j][1];a[j][1]=a[j+1][1];a[j+1][1]=temp;
                    }
                }
            }
        }
    }
	
	public String print(char poly){
        String s1=new String(),output=new String();
        sLinkedList target;
        if(poly=='R'){target=R;}
        else{target=identify(poly);}
        if(target==null){throw new IllegalArgumentException("polonominal "+poly+" is null");}
        if(target.head==null){throw new IllegalArgumentException("polonominal "+poly+" is null");}
        else{int[]temp;
            for(int i=0;i<target.size();i++){
             temp=(int[])target.get(i);
             if (temp[1] != 0 && temp[1] != 1 && temp[0] != 1) {
            	 s1=+temp[0]+"X^"+temp[1];
             }else if (temp[1] == 0){
            	 s1=""+temp[0]; 
             }else if (temp[1] == 1 && temp[0] != 1){
            	 s1=+temp[0]+"X";
             }else if (temp[1] == 1 && temp[0] == 1){
            	 s1="X";
             }else {
            	 s1=s1+"X^"+temp[1];
             }
             if (temp[0] < 0 && i != 0) {
        		 output=output.substring(0, output.length()-1);
        	 }
             if (i != target.size()-1) {
            	 output=output+s1+"+";
             }else {
            	 output=output+s1;
             }
            }
        }
        return output;
    }
	
	 public int[][] add(char poly1, char poly2){
        sLinkedList target1=identify(poly1);
        sLinkedList target2 = identify(poly2);
        if (target1.head == null || target2.head == null || target1 == null || target2 == null) {
            throw new IllegalArgumentException("one of poly1 or poly2 is null");
        }
        int[][] result=new int[target1.size()+target2.size()][2];
        int size=0;
        int temp1[],temp2[];
        for(int i=0;i<target1.size();i++){
            temp1=(int[])target1.get(i);
            result[size][0]=temp1[0];
            result[size][1]=temp1[1];
            for(int j=0;j<target2.size();j++){
                temp2=(int[])target2.get(j);
                if(temp2[1]==temp1[1]){result[size][0]+=temp2[0];}
            }
            size++;
        }
        int flag;
        for(int i=0;i<target2.size();i++){flag=0;
            temp1=(int[])target2.get(i);
            for(int j=0;j<size;j++){
                if(temp1[1]==result[j][1]){flag=1;}
            }
            if(flag==0){result[size]=temp1;size++;}
        }
        int[][] output=new int[size][2];
        for(int i=0;i<size;i++){
            output[i]=result[i];
        }
        bubblesort2d(output);
        R = new sLinkedList();
        for(int i=0;i<output.length;i++){
            R.add(output[i]);
        }
        return output;
    }
	
	 public int[][] subtract(char poly1, char poly2){
        sLinkedList target1 = identify(poly1);
        sLinkedList target2 = identify(poly2);
        if (target1.head == null || target2.head == null || target1 == null || target2 == null) {
            throw new IllegalArgumentException("one of poly1 or poly2 is null");
        }
        int[][] result=new int[target1.size()+target2.size()][2];
        int size=0;
        int temp1[],temp2[];
        for(int i=0;i<target1.size();i++){
            temp1=(int[])target1.get(i);
            result[size][0]=temp1[0];
            result[size][1]=temp1[1];
            for(int j=0;j<target2.size();j++){
                temp2=(int[])target2.get(j);
                if(temp2[1]==temp1[1]){result[size][0]-=temp2[0];}
            }
            size++;
        }
        int flag;
        for(int i=0;i<target2.size();i++){flag=0;
            temp1=(int[])target2.get(i);
            for(int j=0;j<size;j++){
                if(temp1[1]==result[j][1]){flag=1;}
            }
            if(flag==0){temp1[0]*=-1;result[size]=temp1;size++;}
        }
        int[][] output=new int[size][2];
        for(int i=0;i<size;i++){
            output[i]=result[i];
        }
        bubblesort2d(output);
        R = new sLinkedList();
        for(int i=0;i<output.length;i++){
            R.add(output[i]);
        }
        return output;
    }
	
	public void setPolynomial(char poly, int[][] terms){
		if (terms.length == 0 || terms[0].length == 0) {
			throw new IllegalArgumentException("Enter valid terms");
		}
	    sLinkedList target = new sLinkedList();
	    bubblesort2d(terms);
	    for(int i=0;i<terms.length;i++){
	       target.add(terms[i]);
	    }
	    switch (poly) {
	   		case'A' : A = target; break;
	   		case'B' : B = target; break;
	   		case'C' : C = target; break;
	   		default : throw new IllegalArgumentException("Enter a valid poly name");
	    }
   }
	
	public float evaluatePolynomial(char poly, float value) {
		float result = 0;
		sLinkedList list = identify(poly);
		if (list.head == null || list == null) {
        	throw new IllegalArgumentException("polonominal "+poly+" is null");
        }
		for (int i = 0; i<list.size(); i++) {
			int[] d = (int[])list.get(i);
			if (d[1] < 0 && value == 0) {
				throw new ArithmeticException("The denominator is zero the answer is infinity");
			}
			result += (float)d[0]*(float)Math.pow((double)value,d[1]);
		}
		
		return result;
	}
	
	public int[][] multiply(char poly1, char poly2) {
		sLinkedList list1 = identify(poly1);
		int size1 = list1.size();
		sLinkedList list2 = identify(poly2);
		int size2 = list2.size();
		if (list1.head == null || list2.head == null || list1 == null || list2 == null) {
        	throw new IllegalArgumentException("one of poly1 or poly2 is null");
        }
		int[][] tempResult = new int[size1*size2][2];
		int x = 0;
		for (int i = 0; i<size1; i++) {
			int[] d1 = (int[]) list1.get(i);
			for (int j = 0; j<size2; j++) {
				int[] d2 = (int[]) list2.get(j);
				tempResult[x][0] = d1[0] * d2[0];
				tempResult[x][1] = d1[1] + d2[1];
				x++;
			}
		}
		x = 0;
		int[] pows = new int[tempResult.length];
		for (int i = 0; i<pows.length; i++) {
			if (i == 0) {
				pows[x++] = tempResult[i][1];
			}
			boolean exist = false;
			for (int j = 0; j<x; j++) {
				if (tempResult[i][1] == pows[j]) {
					exist = true;
					break;
				}
			}
			if (!exist) {
				pows[x++] = tempResult[i][1];
			}
		}
		int[][] finalResult = new int[x][2];
		for (int i = 0; i<finalResult.length; i++) {
			finalResult[i][1] = pows[i];
			for (int j = 0; j<tempResult.length; j++) {
				if (tempResult[j][1] == pows[i]) {
					finalResult[i][0] += tempResult[j][0];
				}
			}
		}
		bubblesort2d(finalResult);
		R = new sLinkedList();
		for (int i = 0; i<finalResult.length; i++) {
			R.add(finalResult[i]);
		}
		return finalResult;
	}
	
	public void clearPolynomial(char poly) {
		sLinkedList target = identify(poly);
		target.clear();
	}
}
