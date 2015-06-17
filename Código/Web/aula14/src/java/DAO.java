
/**
 *
 * @author Leo
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class DAO {

    private final String URL = "jdbc:mysql://localhost/pgmc",
            NOME = "root", SENHA = "";

    private Connection con;
    private Statement comando;

    public void apagar(String nome) throws SQLException,ClassNotFoundException {
        conectar();

        comando.executeUpdate("DELETE FROM aluno WHERE nome = '" + nome + "';");

        fechar();

    }

    public Vector<Aluno> buscarTodos() throws SQLException,ClassNotFoundException {
        conectar();
        Vector<Aluno> resultados = new Vector<Aluno>();
        ResultSet rs;

        rs = comando.executeQuery("SELECT * FROM aluno");
        while (rs.next()) {
            Aluno temp = new Aluno();
            // pega todos os atributos da pessoa               
            temp.setNome(rs.getString("nome"));
            temp.setMatricula(rs.getString("matricula"));
            temp.setNivel(rs.getString("nivel"));
            temp.setEntrada(rs.getDate("entrada"));
            temp.setBolsa(rs.getString("bolsa"));
            resultados.add(temp);
        }
        fechar();
        return resultados;  

    }

    public void atualizar(Aluno aluno)throws SQLException,ClassNotFoundException {
        conectar();
        String com = "UPDATE aluno SET bolsa = '" + aluno.getBolsa()
                + "', matricula =" + aluno.getMatricula() + ", nivel = '"
                + aluno.getNivel() + "', entrada ='" + aluno.getEntrada()
                + "' WHERE  nome = '" + aluno.getNome() + "';";
        System.out.println("Atualizada!");
        try {
            comando.executeUpdate(com);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fechar();
        }
    }

    public Vector<Aluno> buscar(String nome) throws SQLException,ClassNotFoundException {
        conectar();
        Vector<Aluno> resultados = new Vector<Aluno>();
        ResultSet rs;

        rs = comando.executeQuery("SELECT * FROM aluno WHERE nome LIKE '"
                + nome + "%'");
        while (rs.next()) {
            Aluno temp = new Aluno();
            // pega todos os atributos da pessoa  
            temp.setMatricula(rs.getString("matricula"));
            temp.setNome(rs.getString("nome"));
            temp.setNivel(rs.getString("nivel"));
            temp.setEntrada(rs.getDate("entrada"));
            temp.setBolsa(rs.getString("bolsa"));
            resultados.add(temp);
        }
        fechar();
        return resultados;

    }

    public void insere(Aluno aluno) throws SQLException,ClassNotFoundException {
        conectar();

        comando.executeUpdate("INSERT INTO aluno VALUES('"
                + aluno.getNome() + "', '" + aluno.getMatricula() + "',"
                + aluno.getNivel() + ",'" + aluno.getEntrada() + "','"
                + aluno.getBolsa() + "')");
        System.out.println("Inserida!");

        fechar();

    }

    private void conectar() throws ClassNotFoundException, SQLException {

        con = ConFactory.conexao(URL, NOME, SENHA, ConFactory.MYSQL);
        comando = con.createStatement();
        System.out.println("Conectado!");

    }

    private void fechar() throws SQLException {

        comando.close();
        con.close();
        System.out.println("Conexão Fechada");

    }

    /*private void imprimeErro(String msg, String msgErro) {
     JOptionPane.showMessageDialog(null, msg, "Erro crítico", 0);
     System.err.println(msg);
     System.out.println(msgErro);
     System.exit(0);
     }*/
}
