#include <iostream>
#include <cstdlib>
#include <cstring>

using namespace std;

const int MAX = 100;

class Data
{
private:
    int dia;
    int mes;
    int ano;

public:
    Data()
    {
        setData(0, 0, 0);
    }
    Data(int dia, int mes, int ano)
    {
        setData(dia, mes, ano);
    }
    auto setDia(int dia) -> bool
    {
        bool sucesso = false;
        if (dia >= 0 && dia <= 31)
        {
            this->dia = dia;
            sucesso = true;
        }
        return sucesso;
    }
    auto setMes(int mes) -> bool
    {
        bool sucesso = false;
        if (mes >= 0 && mes <= 12)
        {
            this->mes = mes;
            sucesso = true;
        }
        return sucesso;
    }
    auto setAno(int ano) -> bool
    {
        bool sucesso = false;
        if (ano >= -200000 && ano <= 200000)
        {
            this->ano = ano;
            sucesso = true;
        }
        return sucesso;
    }

    auto setData(int dia, int mes, int ano) -> bool
    {
        return setDia(dia) && setMes(mes) && setAno(ano);
    }
    auto getDia() -> int
    {
        return this->dia;
    }
    auto getMes() -> int
    {
        return this->mes;
    }
    auto getAno() -> int
    {
        return this->ano;
    }
    void escrevaData()
    {
        cout << getDia() << " " << getMes() << " " << getAno() << endl;
    }
    void leiaData()
    {
        int dia, mes, ano;
        cin >> dia >> mes >> ano;
        this->setData(dia, mes, ano);
    }
};
class Aluno
{
private:
    string nome;
    Data nascimento;
    static int qtd;

public:
    Aluno()
    {
        setNome("none");
        setNascimento(0, 0, 0);
        Aluno::addQtd();
    }
    Aluno(string nome)
    {
        setNome(nome);
        setNascimento(0, 0, 0);
        Aluno::addQtd();
    }
    Aluno(string nome, int dia, int mes, int ano)
    {
        setNome(nome);
        setNascimento(dia, mes, ano);
        Aluno::addQtd();
    }
    virtual ~Aluno()
    {
        cout << "Aluno " << this->getNome() << " removido" ;
        Aluno::subQtd();
    }
    void setNome(string nome)
    {
        this->nome = nome;
    }
    void setNascimento(int dia, int mes, int ano)
    {
        nascimento.setData(dia, mes, ano);
    }
    auto getNome() -> string
    {
        return this->nome;
    }
    auto getMes() -> int
    {
        return nascimento.getMes();
    }
    static void addQtd()
    {
        qtd++;
    }
    static void subQtd()
    {
        qtd--;
    }
    static auto getQtd() -> int
    {
        return qtd;
    }
    virtual auto getID() -> int = 0;

    void leData()
    {
        nascimento.leiaData();
    }
    void escreveData()
    {
        nascimento.escrevaData();
    }
    virtual void leiaAluno()
    {
        string nome;
        printf("\nNome: ");
        cin >> nome;
        this->setNome(nome);
        printf("\nNascimento: ");
        this->leData();
    }
    virtual void escrevaAluno()
    {
        cout << " - Nome: " << this->getNome();
        printf("\nNascimento: ");
        this->escreveData();
    }
};
class Regular : public Aluno
{

private:
    int ID = 1;
    string matricula;

public:
    Regular()
    {
        this->setMatricula("none");
    }
    Regular(string nome, string matricula, int dia, int mes, int ano) : Aluno(nome, dia, mes, ano)
    {
        this->setMatricula(matricula);
    }
    ~Regular() override = default;
    void setMatricula(string matricula)
    {
        this->matricula = matricula;
    }
    auto getMatricula() -> string
    {
        return this->matricula;
    }
    auto getID() -> int override
    {
        return this->ID;
    }
    void leiaAluno() override
    {
        string nome;
        string matricula;
        printf("\nNome: ");
        cin >> nome;
        this->setNome(nome);
        cout << "\nMatricula: ";
        cin >> matricula;
        this->setMatricula(matricula);
        printf("\nNascimento: ");
        this->leData();
    }
    void escrevaAluno() override
    {
        cout << " - Nome: " << this->getNome();
        cout << "\nMatricula: " << this->getMatricula();
        printf("\nNascimento: ");
        this->escreveData();
    }
};
class Intercambista : public Aluno
{
private:
    int ID = 2;

public:
    Intercambista() = default;
    Intercambista(string nome, int dia, int mes, int ano) : Aluno(nome, dia, mes, ano)
    {
    }
    ~Intercambista() override = default;
    auto getID() -> int override
    {
        return this->ID;
    }
};

auto menu() -> int;
void criaAluno(Aluno **alunos);
auto menuListaAluno() -> int;
void listaAlunos(Aluno **alunos, int ID);
void listaAniversario(Aluno **alunos);
void removeAluno(Aluno **alunos);

int Aluno::qtd = -1;

auto main() -> int
{
    Aluno *alunos[MAX];

    int x = 1;
    int opcao;
    int opcaoMenu2;
    do
    {
        opcao = menu();
        switch (opcao)
        {
        case 0:
            cout << "\nObrigado !\n";
            break;
        case 1:
            try
            {
                alunos[Aluno::getQtd()] = new Regular;
            }
            catch (const std::bad_alloc &e)
            {
                std::cerr << "Erro ao criar aluno, falta de memória" << e.what() << '\n';
                break;
            }
            criaAluno(alunos);
            break;
        case 2:
            try
            {
                alunos[Aluno::getQtd()] = new Intercambista;
            }
            catch (const std::bad_alloc &e)
            {
                std::cerr << "Erro ao criar aluno, falta de memória" << e.what() << '\n';
                break;
            }
            criaAluno(alunos);
            break;
        case 3:
            do
            {
                opcaoMenu2 = menuListaAluno();
                if (opcaoMenu2 == 0)
                {
                    cout << "\nMenu Anterior\n";
                }
                else if (opcaoMenu2 == 1)
                {
                    listaAlunos(alunos, 1);
                }
                else if (opcaoMenu2 == 2)
                {
                    listaAlunos(alunos, 2);
                }
                else if (opcaoMenu2 == 3)
                {
                    listaAlunos(alunos, 0);
                }

            } while (opcaoMenu2 != 0);
            break;
        case 4:
            listaAniversario(alunos);
            break;
        case 5:
            removeAluno(alunos);
            break;
        }
    } while (opcao != 0);

    return 0;
}

auto menu() -> int
{

    int opcao;
    bool ERRO;
    cout << "\nMenu de opcoes";
    cout << "\n0 - Sair";
    cout << "\n1 - Cadastrar aluno regular";
    cout << "\n2 - Cadastrar aluno intercambista";
    cout << "\n3 - Listar alunos";
    cout << "\n4 - Aniversariantes do mes";
    cout << "\n5 - Remover Aluno";
    do
    {
        cout << "\nSua opcao: ";
        cin >> opcao;
        ERRO = (opcao < 0) || (opcao > 5);
        if (ERRO)
            cout << "\nOpcao nao prevista";
    } while (ERRO);
    return opcao;
}

auto menuListaAluno() -> int
{
    int opcao;
    bool ERRO;
    cout << "\nMenu de opcoes";
    cout << "\n0 - Retornar ao menu anterior";
    cout << "\n1 - Listar alunos regulares";
    cout << "\n2 - Listar alunos intercambistas";
    cout << "\n3 - Listar todos os alunos";
    do
    {
        cout << "\nSua opcao: ";
        cin >> opcao;
        ERRO = (opcao < 0) || (opcao > 3);
        if (ERRO)
            cout << "\nOpcao nao prevista";
    } while (ERRO);
    return opcao;
}

void criaAluno(Aluno **alunos)
{

    alunos[Aluno::getQtd()]->leiaAluno();
}

void listaAlunos(Aluno **alunos, int ID)
{

    if (ID == 0)
    {
        for (int i = 0; i <= Aluno::getQtd(); i++)
        {
            cout << endl
                 << i + 1;
            alunos[i]->escrevaAluno();
            if (alunos[i]->getID() == 1)
            {
                cout << "Regular";
            }
            else
            {
                cout << "Intercambista";
            }
        }
    }
    else
    {
        for (int i = 0; i <= Aluno::getQtd(); i++)
        {
            if (alunos[i]->getID() == ID)
            {
                cout << endl
                     << i + 1;
                alunos[i]->escrevaAluno();
            }
        }
    }
}

void removeAluno(Aluno **alunos)
{

    int id;
    cout << "Digite o id do aluno a ser removido: ";
    cin >> id;
    if (id > Aluno::getQtd()+1 || id <= 0)
    {
        std::cout << "Aluno não existe" << std::endl;
    }
    else
    {
        id = id - 1;
        delete alunos[id];
        for (int i = id; i < Aluno::getQtd()+1; i++)
        {
            alunos[i] = alunos[i + 1];
        }
    }
}

void listaAniversario(Aluno **alunos)
{

    int mes;
    cout << "Digite o mês que voce deseja ver os aniversariantes: ";
    cin >> mes;
    for (int i = 0; i < Aluno::getQtd() + 1; i++)
    {
        if (alunos[i]->getMes() == mes)
        {
            cout << i + 1;
            alunos[i]->escrevaAluno();
        }
    }
}