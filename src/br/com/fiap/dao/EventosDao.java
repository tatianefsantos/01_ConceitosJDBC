package br.com.fiap.dao;

import java.sql.Date;
import java.sql.Statement;
import java.util.Set;

import br.com.fiap.entity.Evento;
import br.com.fiap.entity.Participante;

public class EventosDao extends Dao<Evento> {

	public void incluir(Evento evento) throws Exception {
		
		try {
			cn = criarConexao();
			stmt = cn.prepareStatement("INSERT INTO EVENTOS (DESCRICAO, DATA, RESPONSAVEL) VALUES (?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, evento.getDescricao());
			stmt.setDate(2, new Date(evento.getData().getTime()));
			stmt.setString(2, evento.getResponsavel());
			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			while (rs.next()) {
				evento.setId(rs.getInt(1));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			cn.close();
			if (stmt != null)
				stmt.close();
		}
	}

	public Evento buscar(int id) throws Exception {
		Evento evento = null;
		Set<Participante> participantes;
		ParticipanteDao participanteDao = new ParticipanteDao();

		try {
			participantes = participanteDao.listar(id);
			cn = criarConexao();
			String sql = "SELECT descricao, data, responsavel FROM eventos WHERE idEvento=?";
			stmt = cn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				evento = new Evento(rs.getString("descricao"), rs.getDate("data"), rs.getString("responsavel"), participantes);
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

		return evento;
	}

	public Set<Evento> listar(int... param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
