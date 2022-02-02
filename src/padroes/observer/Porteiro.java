package padroes.observer;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class Porteiro 
{
	private List <ObservadorChegadaAniversariante> observadores = new ArrayList<>();
	
	public void registrarObservador(ObservadorChegadaAniversariante observador)
	{
		this.observadores.add(observador);  
	}
	
	public void monitorar()
	{
		Scanner entrada = new Scanner(System.in);
		String valor = "";
		while(!"sair".equalsIgnoreCase(valor))
		{
			System.out.print("Aniversariante cehgou?");
			valor = entrada.nextLine();
			
			if("sim".equalsIgnoreCase(valor))
			{
				EventoChegadaAniversariante evento = new EventoChegadaAniversariante(new Date());
				this.observadores.stream().forEach(observador -> observador.chegou(evento));
				valor = "sair";
			}
			else
			{
				System.out.println("Alarme falso.");
			}
		}
	}
	
	
}
