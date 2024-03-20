package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);

		Integer[] productPriceList1 = { 10, 20, 30, 40, 50, 60 };
		Integer[] productPriceList2 = { 10, 20, 30, 40, 50, 50, 60 };
		Integer[] productPriceList3 = { 10, 20, 30, 40, 40, 50, 60, 60 };
		Integer[] productPriceList4 = { 10, 20, 30, 40, 50, 50, 50, 60 };
		Integer[] productPriceList5 = { 10, 20, 30, 40, 40, 50, 60, 60 };
		Integer[] productPriceList6 = { 5, 5, 10, 20, 30, 40, 50, 50, 50, 60 };
//		getDiscounts(productPriceList6);
		
		for (Integer[] productPriceList : Arrays.asList(productPriceList1, productPriceList2, productPriceList3,
				productPriceList4, productPriceList5, productPriceList6)) {
			getDiscounts(productPriceList);
		}
		
	}

	static void add(Integer[] productPriceList, int size, List<Integer> array, int index) {
		if (index < size) {
			array.add(productPriceList[index]);
		}
	}

	static void getDiscounts(Integer[] productPriceList) {

		List<Integer> payableItems = new ArrayList<>();
		List<Integer> discountedItems = new ArrayList<>();
		Arrays.sort(productPriceList, Comparator.reverseOrder());
		int i = 1;
		while (i < productPriceList.length) {
			if (productPriceList[i - 1] == productPriceList[i]) {
				payableItems.add(productPriceList[i - 1]);
				payableItems.add(productPriceList[i]);
				add(productPriceList, productPriceList.length, discountedItems, i + 1);
				add(productPriceList, productPriceList.length, discountedItems, i + 2);
				i += 4;
			} else {
				payableItems.add(productPriceList[i - 1]);
				discountedItems.add(productPriceList[i]);
				i += 2;
			}
		}
		// add last element for odd number arrays
		if (productPriceList.length % 2 != 0) {
			payableItems.add(productPriceList[productPriceList.length - 1]);
		}
			System.out.println("Product Prices List:" + Arrays.asList(productPriceList));
			System.out.println("Payable items:" + payableItems);
			System.out.println("Discounted Items:" + discountedItems);
		}
	}


