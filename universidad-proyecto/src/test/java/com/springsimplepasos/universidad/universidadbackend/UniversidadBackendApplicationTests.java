package com.springsimplepasos.universidad.universidadbackend;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/** Nota: Se debe utilizar una base en memoria para probar los repositorios,
 * ya que asi se hebita el uso de una base real de la aplicacion
 * */
@SpringBootApplication
class UniversidadBackendApplicationTests {

	Calculadora calculadora = new Calculadora();

	@Test
	@DisplayName("Suma de valorA y valorB")
	void sumaDeValores() {

		//given: El armado del contexto que se va a necesitar, o pre-condicion.
		int valorA = 3;
		int valorB = 2;

		//when: La accion que se realizara, lo que queremos probar.
		int expectativa = calculadora.sumar(valorA, valorB);

		//then: Validar que sea correcto lo que queremos comprobar.
		int resultadoEsperado = 5;
		assertThat(expectativa).isEqualTo(resultadoEsperado);
	}

	@Test
	@DisplayName("Test deprecado")
	@Disabled("Test deprecado")
	void testDesactivado() {

	}

	class Calculadora{
		int sumar(int valor_a, int valor_b) {
			return valor_a + valor_b;
		}
	}

}
