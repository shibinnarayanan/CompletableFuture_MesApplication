package com.svv.test;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;

public class OrderStart {
	
	public static void main(String[] args) {
		
		startOrder("V400123");
		startOrder("V400223");
		startOrder("V400323");
	}

	private static void startOrder(String variant) {
		
		ExecutorService exeService = Executors.newFixedThreadPool(10);
		
		CompletableFuture.supplyAsync(()->variant,exeService)
		.thenApplyAsync(new OrderStart().fetchOrderFunction,exeService)
		.thenApplyAsync(new OrderStart().generateSerialNumber,exeService)
		.thenAcceptAsync(new OrderStart().generateBuildSheet,exeService);

	}
	
	Function<String,Order> fetchOrderFunction = (variant)->
	{
		return new Order();
	};
	
	Function<Order,Order> generateSerialNumber = (order)->
	{
		String serialaNumber = "";
		return order;
	};
	
	Consumer<Order> generateBuildSheet = (order) ->
	{
		CompletableFuture.supplyAsync(()->order)
		.thenAccept(new OrderStart().sendMail);
	};

	
	Consumer<Order> sendMail = (order) ->
	{
		//do generte buildsheet
	};

}

