import java.util.ArrayList;
import java.util.List;

class Pessoa {
    private String nome;
    private String cpf;
    private boolean isObjetoCompleto;

    public Pessoa(){
        
    }
    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.isObjetoCompleto = true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome != null){
            this.nome = nome;
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if(cpf!= null){
           this.cpf = cpf;
        }
    }

    public boolean isObjetoCompleto() {
        return isObjetoCompleto;
    }

    public void setObjetoCompleto(boolean isObjetoCompleto) {
        this.isObjetoCompleto = isObjetoCompleto;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", CPF: " + cpf;
    }

    static String classifica(Pessoa[] pessoas) {
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
}

class Aluno extends Pessoa {
    private String matricula;
    private int anoIngresso;
    private int semestreIngresso;
    private String curso;

    public Aluno(){
        
    }
    public Aluno(String nome, String cpf, String matricula, int anoIngresso, int semestreIngresso, String curso) {
        super(nome, cpf);
        this.matricula = matricula;
        this.anoIngresso = anoIngresso;
        this.semestreIngresso = semestreIngresso;
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getAnoIngresso() {
        return anoIngresso;
    }

    public void setAnoIngresso(int anoIngresso) {
        this.anoIngresso = anoIngresso;
    }

    public int getSemestreIngresso() {
        return semestreIngresso;
    }

    public void setSemestreIngresso(int semestreIngresso) {
        this.semestreIngresso = semestreIngresso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "";
    }
}

class Professor extends Pessoa {
    private String area;
    private List<Turma> turmas;

    public Professor(){
        
    }
    public Professor(String nome, String cpf, String area) {
        super(nome, cpf);
        this.area = area;
        this.turmas = new ArrayList<>();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    @Override
    public String toString() {
        return "Prof(a): " + getNome()+" - Area: " + area;
    }
}

class Turma {
    private String disciplina;
    private List<Aluno> alunos;
    private Professor professor;

    public Turma(String disciplina, Professor professor) {
        if (professor.isObjetoCompleto()) {
            this.professor = professor;
            this.disciplina = disciplina;
            this.alunos = new ArrayList<>();
            professor.getTurmas().add(this);
        }
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        if (professor.isObjetoCompleto()) {
            this.professor = professor;
        }
    }

    public void addAluno(Aluno aluno) {
        if (aluno.isObjetoCompleto()) {
            this.alunos.add(aluno);
        }
    }

    @Override
    public String toString() {
        return "Disciplina: " + disciplina + ", Professor: " + professor.getNome();
    }
}