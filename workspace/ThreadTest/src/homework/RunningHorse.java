package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RunningHorse {

	static int strRank = 1;

	public static void main(String[] args) {
		List<Horse2> list = new ArrayList<>();

		list.add(new Horse2("1번말"));
		list.add(new Horse2("2번말"));
		list.add(new Horse2("3번말"));
		list.add(new Horse2("4번말"));
		list.add(new Horse2("5번말"));
		list.add(new Horse2("6번말"));
		list.add(new Horse2("7번말"));
		list.add(new Horse2("8번말"));
		list.add(new Horse2("9번말"));
		list.add(new Horse2("10번말"));

		for (Horse2 horse : list) {
			horse.start();
		}

		for (Horse2 hs : list) {
			try {
				hs.join();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		
		Collections.sort(list);
		System.out.println("경기끝 ....");
		System.out.println("======================================================");
		System.out.println();
		System.out.println(" 경기 결과 ");

		for (Horse2 horse : list) {
			System.out.println(horse.getHorseName() + " " + horse.getRank() + "등");
		}
	}
}

class Horse2 extends Thread implements Comparable<Horse2>{
   private String horseName;
   int rank;
   
   public Horse2(String horseName) {
      this.horseName = horseName;
   }
   
   public String getHorseName() {
      return horseName;
   }

   public void setHorseName(String name) {
      this.horseName = name;
   }

   public int getRank() {
      return rank;
   }

   public void setRank(int rank) {
      this.rank = rank;
   }

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
			System.out.println(horseName + " : ");
			for (int j = 0; j < i; j++) {
				System.out.print("-");
			}
			System.out.print(">");

			for (int j = 49; j > i; j--) {
				System.out.print("-");
			}

			System.out.println();
			
			try {
				Thread.sleep((int) (Math.random() * 500));
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println(horseName + " 끝");

		setRank(RunningHorse.strRank);
		RunningHorse.strRank++;
	}

	@Override
	public int compareTo(Horse2 hor) {
		if (rank > hor.getRank()) {
			return 1;
		} else {
			return -1;
		}
	}
}