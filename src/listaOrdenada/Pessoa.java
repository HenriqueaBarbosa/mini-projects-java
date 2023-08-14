package listaOrdenada;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

public class Pessoa implements Comparator<Pessoa>{
    private String nome;
    private LocalDate nascimento;
    private Integer salario;

    public Pessoa() {}
    public Pessoa(String nome, LocalDate nascimento, Integer salario) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        LocalDate hoje = LocalDate.now();
        return (int) nascimento.until(hoje, ChronoUnit.YEARS);
    }

    public String getNascimento() {
        DateTimeFormatter brasil = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataDeNascimento = nascimento.format(brasil);
        return dataDeNascimento;
    }
    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public Integer getSalario() {
        return salario;
    }
    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "-Nome: " + getNome() + "\n Idade: " + getIdade() + "\n Nascimento: " + getNascimento() + "\n Salário: " + getSalario();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((nascimento == null) ? 0 : nascimento.hashCode());
        result = prime * result + ((salario == null) ? 0 : salario.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pessoa other = (Pessoa) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (nascimento == null) {
            if (other.nascimento != null)
                return false;
        } else if (!nascimento.equals(other.nascimento))
            return false;
        if (salario == null) {
            if (other.salario != null)
                return false;
        } else if (!salario.equals(other.salario))
            return false;
        return true;
    }

    @Override
    public int compare(Pessoa o1, Pessoa o2) {
        int nome = o1.getNome().compareToIgnoreCase(o2.getNome()); if(nome != 0) return nome;
        int idade = o1.getIdade().compareTo(o2.getIdade()); if(idade != 0) return idade;
        int nascimento = o1.getNascimento().compareTo(o2.getNascimento()); if(nascimento != 0) return nascimento;
        return o1.getSalario().compareTo(o2.salario);
    }            
}