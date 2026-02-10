import java.util.*;

class Pessoa {
    private String nome;
    private String cpf;

    public Pessoa() {}

    public Pessoa(String nome, String cpf) {
        setNome(nome);
        setCpf(cpf);
    }

    public void setNome(String nome) {
        if (nome != null) this.nome = nome;
    }
    
    public void setCpf(String cpf) {
        if (cpf != null) this.cpf = cpf;
    }
    
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public boolean isObjetoCompleto() {
        return nome != null && cpf != null;
    }

    public static String classifica(Pessoa[] pessoas) {
        int countPessoasComuns = 0;
        int countProfessores = 0;
        int countAlunos = 0;

        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Professor) {
                countProfessores++;
            } else if (pessoa instanceof Aluno) {
                countAlunos++;
            } else {
                countPessoasComuns++;
            }
        }

        return "Pessoas comuns: " + countPessoasComuns + " - Professores: " + countProfessores + " - Alunos: " + countAlunos;
    }

    public String toString() {
        if (isObjetoCompleto() ) return nome + " - CPF: " + cpf;
        return "null";
    }
}


class Aluno extends Pessoa {
    private String matricula;
    private int anoIngresso;
    private int semestreIngresso;
    private String curso;

    public Aluno() {}

    public Aluno(String nome, String cpf, String matricula, int anoIngresso, int semestreIngresso, String curso) {
        super(nome, cpf);
        setMatricula(matricula);
        setAnoIngresso(anoIngresso);
        setSemestreIngresso(semestreIngresso);
        setCurso(curso);
    }

    public void setMatricula(String matricula) {
        if (matricula != null) this.matricula = matricula;
    }

    public void setAnoIngresso(int anoIngresso) {
        this.anoIngresso = anoIngresso;
    }

    public void setSemestreIngresso(int semestreIngresso) {
        if (semestreIngresso == 1 || semestreIngresso == 2) this.semestreIngresso = semestreIngresso;
    }

    public String getMatricula() {
        return matricula;
    }
    
    public int getSemestreIngresso() {
        return semestreIngresso;
    }
    
    public void setCurso(String curso) {
        if (curso != null) this.curso = curso;
    }
    
    public int getAnoIngresso() {
        return anoIngresso;
    }
    
    public String getCurso() {
        return curso;
    }

    public boolean isObjetoCompleto() {
        return super.isObjetoCompleto() && matricula != null && anoIngresso > 0 && semestreIngresso > 0;
    }

    public String toString() {
        if (isObjetoCompleto() ) return getNome() + " - Matricula: " + matricula;
        return "";
    }
}


class Professor extends Pessoa {
    private String area;
    private ArrayList<Turma> turmas = new ArrayList<>();

    public Professor() {}

    public Professor(String nome, String cpf, String area) {
        super(nome, cpf);
        setArea(area);
    }

    public void setArea(String area) {
        if (area != null) this.area = area;
    }
    
    public void setTurmas(ArrayList<Turma> turmas) {
        this.turmas = turmas;
    }
    
    public String getArea() {
        return area;
    }

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public void addTurma(Turma turma) {
        turmas.add(turma);
    }

    public boolean isObjetoCompleto() {
        return super.isObjetoCompleto() && area != null;
    }

    public String toString() {
        if (isObjetoCompleto() ) return "Prof(a): " + getNome() + " - Area: " + area;
        return "null";
    }
}

class Turma {
    private String disciplina;
    private ArrayList<Aluno> alunos = new ArrayList<>();
    private Professor professor;

    public Turma() {}

    public Turma(String disciplina, Professor professor) {
        this.disciplina = disciplina;
        if (professor != null && professor.isObjetoCompleto()) {
            this.professor = professor;
            professor.addTurma(this);
        }
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    
    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }
    
    public void setProfessor(Professor professor) {
        if (professor != null && professor.isObjetoCompleto()) {
            this.professor = professor;
        }
    }
    
    public String getDisciplina() {
        return disciplina;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void addAluno(Aluno aluno) {
        if (aluno != null && aluno.isObjetoCompleto()) {
            alunos.add(aluno);
        }
    }

    public String toString() {
        return "Disciplina: " + disciplina + ", Professor: " + (professor != null ? professor.getNome() : "null");
    }
}


class Curso {
    private String nome;
    private ArrayList<Turma> turmas;
    private Professor coordenador;
    
    public Curso () {}
    
    public Curso (String nome, ArrayList<Turma> turmas, Professor coordenador) {
        setNome(nome);
        setTurmas(turmas);
        setCoordenador(coordenador);
    }
    
    public void setNome (String nome) {
        if (nome != null) this.nome = nome;
    }
    
    public void setTurmas( ArrayList<Turma> turmas) {
        this.turmas = turmas;
    }
    
    public void setCoordenador(Professor coordenador) {
        if (coordenador != null && coordenador.isObjetoCompleto()) this.coordenador = coordenador;
    }
    
    public String getNome() {
        return nome;
    }
    
    public ArrayList<Turma> getTurmas() {
        return turmas;
    }
    
    public Professor getCoordenador() {
        return coordenador;
    }
    
    //listaAlunos
    public String listaAlunos() {
        String alunos = "";
        for (Turma t : getTurmas()) {
            for (Aluno a : t.getAlunos() ){
                alunos += a.getNome()+ " ";
            }
            alunos += "\n";
        }
        return alunos;
    }
    
    //listaProfessores
    public String listaProfessores() {
        String professores = "";
        for (Turma t : getTurmas()) {
            professores += t.getProfessor().getNome()+ "\n";
        }
        return professores;    
    }
    
    //getTotalAlunos
    public int getTotalAlunos() {
        int totalAlunos = 0;
        for (Turma t : getTurmas()) {
            totalAlunos += t.getAlunos().size();
        }
        return totalAlunos;
    }
    
    //getTotalProfessores
    public int getTotalProfessores() {
        int totalProfessores = 0;
        for (Turma t : getTurmas()) {
            totalProfessores ++;
        }
        return totalProfessores;
    }
}