import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Demo {

	public static void main(String[] args) {

		CompletableFuture<?> cf = new CompletableFuture<>().runAsync(() -> {

			for (int i = 0; i < 100; i++) {
				System.out.println(i);
				try {
					TimeUnit.SECONDS.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		);

		cf.completedFuture("Completed");
		System.out.println("Completion status "+cf.isDone());
	}

}
