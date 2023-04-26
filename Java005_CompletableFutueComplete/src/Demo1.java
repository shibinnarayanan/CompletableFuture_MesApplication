import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Logger;

public class Demo1 {

	private static Logger logger = Logger.getLogger("MyLog");

	public static void main(String[] args) {

		System.out.println("Main started");
		test("Shibin");
		test("Swetha");
		test("Sayujya");
		test("Sayu");
		System.out.println("Main finished");
	}

	private static void test(String input) {

		ExecutorService exeService = Executors.newCachedThreadPool();

		CompletableFuture.supplyAsync(() -> input, exeService).thenApplyAsync(concateString).thenAcceptAsync(doPrint);
		CompletableFuture
				.runAsync(new Demo1().doPrintNumbers);

	}

	private static Function<String, String> concateString = Demo1::stringJoining;

	private static Consumer<String> doPrint = Demo1::doPrintName;

	private static String stringJoining(String name) {
//		System.out.println("String joining started");
		try {
			TimeUnit.SECONDS.sleep(5);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("String joining ended");
		return "Hello " + name;
	}

	private static void doPrintName(String fullName) {
		System.out.println(fullName + "  thred name -> " + Thread.currentThread().getName());
	}

	Runnable doPrintNumbers = ()->
	{
		for(int i=0;i<5;i++)
		{
			System.out.println(i+ "  running on thread " + Thread.currentThread().getName());
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};

}
