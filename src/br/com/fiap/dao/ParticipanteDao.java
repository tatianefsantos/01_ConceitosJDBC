package br.com.fiap.dao;

import java.sql.Statement;
import java.util.Set;

import br.com.fiap.entity.Participante;

public class ParticipanteDao extends Dao<Participante> {

	public void incluir(Participante participante) throws Exception {
		try {
			cn = criarConexao();
			String sql = "INSERT INTO PARTICIPANTES (IDEVENTO,NOME,EMAIL) VALUES (?,?,?)";
			
			stmt = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, participante.getIdEvento());
			stmt.setString(2, participante.getNome());
			stmt.setString(3, participante.getEmail());
			stmt.execute();

			rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				participante.setId(rs.getInt(1));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			cn.close();
			if (stmt != null)
				stmt.close();
			if (rs != null)
				rs.close();
		}
	}

	public Participante buscar(int id) throws Exception {
		Participante participante = null;

		try {
			cn = criarConexao();
			String sql = "SELECT idEvento, nome, email FROM participantes WHERE idParticipante=?";
			stmt = cn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				participante = new Participante(rs.getInt("idEvento"), rs.getString("nome"), rs.getString("email"));
				participante.setId(id);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			cn.close();
			if (stmt != null)
				stmt.close();
			if (rs != null)
				rs.close();
		}

		return participante;
	}

	public Set<Participante> listar(int... param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
