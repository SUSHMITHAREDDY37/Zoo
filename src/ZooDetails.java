import java.util.InputMismatchException;
import java.util.Scanner;

public class ZooDetails {
	public static Zoo userInput() {
		Scanner input = new Scanner(System.in);
		System.out.println(" enter Zoo id");
		int zooid = input.nextInt();
		System.out.println("enter Zoo Location:");
		String zoolocation = input.next();
		System.out.println("enter Number of animals in zoo");
		int numofanimals = input.nextInt();
		Zoo z = new Zoo();
		z.setZooId(zooid);
		z.setZooLocation(zoolocation);
		z.setNumOfAnimals(numofanimals);
		return z;

	}

	public static Animal auserInput() {
		Scanner input = new Scanner(System.in);
		System.out.println(" enter animal id");
		int aid = input.nextInt();
		System.out.println("enter animal age:");
		int aage = input.nextInt();
		System.out.println("enter animal weight");
		int aweight = input.nextInt();
		System.out.println("enter animal category");
		String acategory = input.next();
		System.out.println("enter zoo id");
		int zooId = input.nextInt();
		Animal an = new Animal();
		an.setAid(aid);
		an.setAage(aage);
		an.setAweight(aweight);
		an.setAcategory(acategory);
		an.setZooId(zooId);

		return an;
	}

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int a = 0;
		System.out.println("1.zoo table \n 2. animal table 0. Exit \n enter your choice");
		try {
			a = s.nextInt();
		} catch (InputMismatchException e) {
			e.getMessage();
		}

		if (a == 1) {
			ZooOperations zo = new ZooOperations();
			Scanner input = new Scanner(System.in);
			int x = 0;
			while (true) {
				System.out.println("1.add \n 2. update \n3. retrieve\n  4. delete\n 0. Exit \n enter your choice");
				try {
					x = input.nextInt();
				} catch (InputMismatchException e) {
					e.getMessage();
				}

				if (x == 1) {
					Zoo z = userInput();
					zo.add(z);

				} else if (x == 2) {
					Zoo z = userInput();
					zo.update(z);

				} else if (x == 3) {
					zo.retrieve();
				} else if (x == 4) {
					System.out.println("enter emp id:");
					Scanner in = new Scanner(System.in);
					int id = in.nextInt();
					Zoo e = new Zoo();
					e.setZooId(id);
					zo.delete(e);
				} else {
					System.exit(0);
				}

			}

		}
		if (a == 2) {

			AnimalOperations ao = new AnimalOperations();
			Scanner input = new Scanner(System.in);
			int x = 0;
			while (true) {
				System.out.println(
						"1.insert \n 2. update \n3. retrieve\n  4. delete\n 5. twotables \n 0. Exit \n enter your choice");
				try {
					x = input.nextInt();
				} catch (InputMismatchException e) {
					e.getMessage();
				}

				if (x == 1) {
					Animal aobj = auserInput();
					ao.add(aobj);

				} else if (x == 2) {
					Animal aobj = auserInput();
					ao.update(aobj);

				} else if (x == 3) {
					ao.retrieve();
				} else if (x == 4) {
					System.out.println("enter emp id:");
					Scanner in = new Scanner(System.in);
					int id = in.nextInt();
					Animal aobj = new Animal();
					aobj.setZooId(id);
					ao.delete(aobj);
				} else if (x == 5) {
					ao.twotables();
				} else {
					System.exit(0);
				}

			}

		}
	}
}
