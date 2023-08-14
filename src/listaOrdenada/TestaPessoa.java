package listaOrdenada;

import java.time.LocalDate;
import java.time.Month;
import java.util.Set;
import java.util.TreeSet;

public class TestaPessoa {
    public static void main(String[] args) {
        
        Set<Pessoa> lista = new TreeSet<Pessoa>(new Pessoa()){{
            add(new Pessoa("Henrique", LocalDate.of(1997,Month.APRIL, 25), 125000));
            add(new Pessoa("Mateus", LocalDate.of(1981, Month.AUGUST, 19), 25000));
            add(new Pessoa("Marcos", LocalDate.of(1973, Month.DECEMBER, 14), 35000));
            add(new Pessoa("Lucas", LocalDate.of(1973, Month.NOVEMBER, 2), 45000));
            add(new Pessoa("João", LocalDate.of(1981, Month.JANUARY, 21), 15000));
            add(new Pessoa("Paulo", LocalDate.of(1980, Month.JULY, 15), 5000));
            add(new Pessoa("Pedro", LocalDate.of(1950, Month.FEBRUARY, 24), 55000));
            add(new Pessoa("Mateus", LocalDate.of(1991, Month.OCTOBER, 3), 75000));
            add(new Pessoa("Lucas", LocalDate.of(2000, Month.MARCH, 1), 29000));
            add(new Pessoa("Mateus", LocalDate.of(1981, Month.AUGUST, 19), 28000));
        }};
        
        lista.forEach(System.out::println);
        
    }
}
