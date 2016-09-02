import java.util.*;
public class ai {
	
	public static void printMatrix(String s){
		for (int i = 0; i < s.length(); i++) {
			if (i%3==0){
				System.out.println();
			}
			System.out.print(s.charAt(i) + " ");
		}
		System.out.println();
	}

	public static int tilesDisplaced(String s){
		int count = 0;
		String ele = "123456780";
		for (int i = 0; i < 9; i++){
			if ((s.charAt(i) != '0') && (s.charAt(i) != ele.charAt(i))){
				count++;
			}
		}
		return (-1)*count;
	}
	public static ArrayList<Integer> getIndex(int index){
		ArrayList<Integer> indexes = new ArrayList<>();
		switch(index){
		case 0: indexes.add(1);indexes.add(3);break;
		case 1: indexes.add(0);indexes.add(4);indexes.add(2);break;
		case 2: indexes.add(1);indexes.add(5);break;
		case 3: indexes.add(0);indexes.add(4);indexes.add(6);break;
		case 4: indexes.add(1);indexes.add(3);indexes.add(5);indexes.add(7);break;
		case 5: indexes.add(2);indexes.add(4);indexes.add(8);break;
		case 6: indexes.add(3);indexes.add(7);break;
		case 7: indexes.add(4);indexes.add(6);indexes.add(8);break;
		case 8: indexes.add(5);indexes.add(7);break;
 		}
		
		return (indexes);
	}
	public static ArrayList<String> getNeighbour(String current){
		int index=111;
		for (int i = 0; i < 9; i++) {
			if (current.charAt(i) == '0'){
				index = i;
				break;
			}
		}
		ArrayList<Integer> indexes = new ArrayList<>();
		indexes = getIndex(index);
		ArrayList<String> n = new ArrayList<>();
		for (int i = 0; i < indexes.size(); i++) {
			char[] arr = current.toCharArray();
			char temp = arr[indexes.get(i)];
			arr[index] = temp;
			arr[indexes.get(i)] = '0';
			n.add(new String(arr));
		}
		return (n);
	}
	public static void printCollection(Collection<String> c){
        Iterator<String> it = c.iterator();
        while ( it.hasNext() ){
            printMatrix(it.next());
        }
 
    }

	public static int simulation(String start){
		ArrayList<String> neighbours = new ArrayList<>();
		int count=0;
		int flag;
		System.out.println("Start State :");
		printMatrix(start);
		System.out.println("Optimal Path : ");
		printMatrix(start);
		System.out.println();
		while(true)
		{  
		int t=tilesDisplaced(start);
		neighbours = getNeighbour(start);
		flag=0;
		for(String n : neighbours){
			if(tilesDisplaced(n) >t){
				start=n;
				printMatrix(n);
				flag=1;
				count++;
			}
			System.out.println();
			if (flag==1)
				break;
		}
		
		System.out.println();
		if(flag==0)
			break;
		}	
		String goal="123456780";
		if(start.equals(goal))
			return count;
		else 
			return 0;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the matrix in String format : ");
		String start = sc.nextLine();
		int moves = simulation(start);
		if(moves!=0){
			System.out.println("success");
			System.out.println("Optimal Cost of Path : " + moves);
			System.out.println("Number of explored path : " + moves);
		}
		else
			System.out.println("failure");
		System.out.println("Goal State : ");
		printMatrix("123456780");
	}
}


