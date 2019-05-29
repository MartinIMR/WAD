package mx.ipn.escom.wad.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "acceso")
public class Acceso {
	@Id
	@SequenceGenerator(name = "accesso_id_acceso_seq", sequenceName = "acceso_id_acceso_seq", allocationSize = 1)
	@GeneratedValue(generator = "acceso_id_acceso_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_accesso")
	private Integer id;
	@Column(name = "nu_intentos")
	private Integer intentos;
	@Column(name = "fh_ufallido")
	private Date ultimoFallido;
	@Column(name = "fh_bloqueo")
	private Date bloqueo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIntentos() {
		return intentos;
	}

	public void setIntentos(Integer intentos) {
		this.intentos = intentos;
	}

	public Date getUltimoFallido() {
		return ultimoFallido;
	}

	public void setUltimoFallido(Date ultimoFallido) {
		this.ultimoFallido = ultimoFallido;
	}

	public Date getBloqueo() {
		return bloqueo;
	}

	public void setBloqueo(Date bloqueo) {
		this.bloqueo = bloqueo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Acceso other = (Acceso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
