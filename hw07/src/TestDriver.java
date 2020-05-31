
public class TestDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LSPath entity1 = new LSPath4107056006_1();
		int[][] array = {{0,1},
						{1,2},
						{1,3},
						{2,1},
						{2,4},
						{3,1},
						{3,4},
						{4,2},
						{4,3}};
		int ans = entity1.Ans(array);
		System.out.println("ans is:"+ans);
	}

}
