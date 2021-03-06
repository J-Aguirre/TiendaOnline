package pe.edu.ucsp.oms.repository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import pe.edu.ucsp.oms.domain.Payment;
import pe.edu.ucsp.oms.repository.PaymentDao;


@Repository
public class JdbcPaymentDao extends JdbcGenericDao<Payment, Long> implements PaymentDao{

	
	private final PaymentMapper mapper = new PaymentMapper();
	
	@Override
	public void update(Payment payment) {
			
	}

	@Override
	public List<Payment> filterByIdUser(Long idUser) {
		String sql = "SELECT * FROM " + getTableName() + " WHERE id_user LIKE :idUser";
	    SqlParameterSource namedParameters = new MapSqlParameterSource("id_user",idUser);
	    return jdbcTemplate.query(sql, getRowMapper(), namedParameters);
	}

	@Override
	public List<Payment> filterByIdContent(Long idContent) {
		String sql = "SELECT * FROM " + getTableName() + " WHERE id_content LIKE :idContent";
	    SqlParameterSource namedParameters = new MapSqlParameterSource("id_content",idContent);
	    return jdbcTemplate.query(sql, getRowMapper(), namedParameters);
	}

	@Override
	protected SimpleJdbcInsert createJdbcInsert() {
		return new SimpleJdbcInsert(jdbcTemplate.getDataSource())
		.withTableName(getTableName());
	}

	@Override
	protected RowMapper<Payment> getRowMapper() {
		return mapper;
	}

	@Override
	protected String getTableName() {
		return Payment.TABLE_NAME;
	}
	
	
	public static class PaymentMapper implements RowMapper<Payment> {
		public Payment mapRow(ResultSet rs, int rowNum) throws SQLException {
			Payment payment = new Payment();
			payment.setIdContent(rs.getLong("id_content"));
			payment.setIdUser(rs.getLong("id_user"));
			return payment;
		}
	}

}
