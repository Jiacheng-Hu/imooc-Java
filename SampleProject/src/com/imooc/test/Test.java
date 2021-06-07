package com.imooc.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.imooc.model.Product;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Product iPhone = new Product(123, "iPhone", "telephone", 4888);
		Product iPad = new Product(234, "iPad", "computer", 5088);
		Product mac = new Product(345, "MacBook", "computer", 10688);
		Product watch = new Product(456, "Apple Watch", "watch", 4799);
		
		System.out.println("Apple系列产品信息：");
		
		try {
			FileOutputStream fos = new FileOutputStream("product.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(iPhone);
			oos.writeObject(iPad);
			oos.writeObject(mac);
			oos.writeObject(watch);
			oos.writeObject(null);
			oos.flush();
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileInputStream fis = new FileInputStream("product.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			try {
				Product product = null;
				while((product = (Product) ois.readObject()) != null) {
					System.out.println(product);
				}
				ois.close();
				fis.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
