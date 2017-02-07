package org.roan.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MainUsingOptional {

	public static void main(String[] args) {
		
		List<Double> result = new ArrayList<>();
		
		ThreadLocalRandom.current()
			.doubles(10_000).boxed()
			.forEach(
				d -> NewMath.inv(d)
						.ifPresent(
								inv -> NewMath.sqrt(inv)
										.ifPresent(
												sqrt -> result.add(sqrt)
										)
								)
			);
		
		System.out.println("# result = " + result.size());
	}
	
}
