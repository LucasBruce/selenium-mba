package br.com.mbaiesp.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Aula1 {
	@Test
	public void testeUm() {
		System.out.println("\t\tTeste um");
	}
	@Test
	public void testeDois() {
		System.out.println("\t\tTeste dois");
	}
	
	@Before
	public void antesDeCadaTeste(){
		System.out.println("\tAntes do teste");
	}
	@After
	public void depoisDeCadaTeste(){
		System.out.println("\tdepois do teste");
	}
	
	@BeforeClass
	public static void antesDeCadaClass(){
		System.out.println("Antes da classe");
	}
	@AfterClass
	public static void depoisDeCadaClass(){
		System.out.println("depois da classe");
	}
}
