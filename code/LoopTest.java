enum Size {SMALL,MEDIUM,LARGE,EXTRA_LARGE};
public class LoopTest {
	public static void main(String[] args) {
		int i = 0;
		switch (i) {
		case 0:
			System.out.println(0);
			break;
		case 1:
			System.out.println(1);
			break;
		case 2:
			System.out.println(2);
			break;
			
		default:
			break;
		}
		
		
		Size k = Size.EXTRA_LARGE;
		switch (k) {
		case EXTRA_LARGE:
			System.out.println(0);
			break;
		case LARGE:
			System.out.println(1);
			break;
		case SMALL:
			System.out.println(2);
			break;
			
		default:
			break;
		}
		
	}
}